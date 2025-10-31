package com.example.lumi.Servlet.Ingrediente;

import com.example.lumi.DAO.AlergiaDAO;
import com.example.lumi.DAO.IngredienteDAO;
import com.example.lumi.Model.Alergia;
import com.example.lumi.Model.Ingrediente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns={"/cadastro-ingrediente", "/adicionar-ingrediente"})
public class ServletAdicionarIngrediente extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        if (caminho.equals("/cadastro-ingrediente")) {
            // buscando as alergias para colocar no dropdown
            AlergiaDAO alergiaDAO = new AlergiaDAO();
            List<Alergia> listaAlergia = alergiaDAO.buscarNomeAlergia();

            request.setAttribute("alergias-lista", listaAlergia); // setando a lista de alergia como atributo

            request.getRequestDispatcher("WEB-INF/view/cadastro_ingredientes.jsp").forward(request, response); // redirecionando para a página
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IngredienteDAO ingredienteDAO = new IngredienteDAO();
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        if (caminho.equals("/adicionar-ingrediente")) {
            // recebendo os parâmetros do form
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");

            Alergia alergia;
            List<Alergia> listaAlergias = new ArrayList<>();
            for (int i = 1; i < 1000; i++) {
                if (request.getParameter("alergia-"+i) != null) {
                    alergia = new Alergia(request.getParameter("alergia-"+i));
                } else {
                    break;
                }
                listaAlergias.add(alergia);
            }

            // instanciando o objeto
            Ingrediente ingrediente = new Ingrediente(id, nome, descricao);

            // alterando o ingrediente
            int retornoInsercao = ingredienteDAO.inserirIngrediente(ingrediente);
            if (retornoInsercao == 0 || retornoInsercao == -1) {
                request.setAttribute("mensagemErro", "Não foi possível inserir o ingrediente");
                request.getRequestDispatcher("WEB-INF/view/erro,jsp").forward(request, response);
            }

            // redirecionando para a página de ingrediente novamente
            response.sendRedirect("ingredientes");

        }
    }
}

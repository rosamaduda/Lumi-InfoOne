package com.example.lumi.Servlet.Ingrediente;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.lumi.DAO.AlergiaDAO;
import com.example.lumi.DAO.AlergiaIngredienteDAO;
import com.example.lumi.DAO.IngredienteDAO;
import com.example.lumi.Model.Alergia;
import com.example.lumi.Model.Ingrediente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/cadastro-ingrediente", "/adicionar-ingrediente"})
public class ServletAdicionarIngrediente extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        if (caminho.equals("/cadastro-ingrediente")) {
            // buscando as alergias para colocar no dropdown
            AlergiaDAO alergiaDAO = new AlergiaDAO();
            alergiaDAO = new AlergiaDAO();
            List<Alergia> listaAlergia = alergiaDAO.buscarNomeAlergia();

            request.setAttribute("alergias-lista", listaAlergia); // setando a lista de alergia como atributo

            request.getRequestDispatcher("WEB-INF/view/cadastro_ingredientes.jsp").forward(request, response); // redirecionando para a página
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IngredienteDAO ingredienteDAO = new IngredienteDAO();
        AlergiaDAO alergiaDAO = new AlergiaDAO();
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        if (caminho.equals("/adicionar-ingrediente")) {
            // recebendo os parâmetros do form
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
            Ingrediente ingrediente = new Ingrediente(nome, descricao);

            // inserindo o ingrediente
            int retornoInsercao = ingredienteDAO.inserirIngrediente(ingrediente);
            if (retornoInsercao == 0 || retornoInsercao == -1) {
                request.setAttribute("mensagemErro", "Não foi possível inserir o ingrediente");
                request.getRequestDispatcher("WEB-INF/view/erro,jsp").forward(request, response);
            }

            // recebendo o id do ingrediente inserido
            int idIngrediente = ingredienteDAO.buscarIdIngrediente();

            // Pega as alergias escolhidas do formulário
            List<Integer> idAlergias = new ArrayList<>();
            for (int i = 1; i < 1000; i++){
                String nomeAlergia = request.getParameter("alergia-" + i);
                if (nomeAlergia != null && !nomeAlergia.isEmpty()){
                    int idAlergia = alergiaDAO.buscarIdAlergia(nomeAlergia);
                    idAlergias.add(idAlergia);
                } else{
                    break;
                }
            }

            // Adicionando relação
            if (!idAlergias.isEmpty()){
                AlergiaIngredienteDAO alergiaIngredienteDAO = new AlergiaIngredienteDAO();
                for (int i = 0; i < idAlergias.size(); i++){
                    int idAlergia = idAlergias.get(i);
                    alergiaIngredienteDAO.inserirAlergiaIngrediente(idIngrediente, idAlergia);
                }
            }

            // redirecionando para a página de ingrediente novamente
            response.sendRedirect("ingredientes");
        }
    }
}

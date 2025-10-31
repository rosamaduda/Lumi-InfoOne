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
            // Faz lista de alergias
             AlergiaDAO alergiaDAO = new AlergiaDAO();
            List<Alergia> alergiasOp = alergiaDAO.buscarAlergia();
            request.setAttribute("alergias-lista", alergiasOp);
            request.getRequestDispatcher("WEB-INF/view/cadastro_ingredientes.jsp").forward(request, response); // redirecionando para a página
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IngredienteDAO ingredienteDAO = new IngredienteDAO();
        String caminho = request.getServletPath(); // recebendo o caminho do usuário


        if (caminho.equals("/alterar-ingrediente")) {
            // recebendo os parâmetros do form
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");

            // instanciando o objeto
            Ingrediente ingrediente = new Ingrediente(id, nome, descricao);

            // alterando o ingrediente
            ingredienteDAO.alterarIngrediente(ingrediente);

                // Pega as alergias escolhidas do formulário
                List<Integer> idAlergias = new ArrayList<>();
                for (int i = 0; i < 1000; i++){
                    String idAlergiaStr = request.getParameter("alergia-" + i);
                    if (idAlergiaStr != null && !idAlergiaStr.isEmpty()){
                        idAlergias.add(Integer.parseInt(idAlergiaStr));
                    } else{
                        break;
                    }
                }
    
                // Adicionando relação
                if (!idAlergias.isEmpty()){
                    AlergiaIngredienteDAO alergiaIngredienteDAO = new AlergiaIngredienteDAO();
                    for (int i = 0; i < idAlergias.size(); i++){
                        int idAlergia = idAlergias.get(i);
                        alergiaIngredienteDAO.inserirAlergiaIngrediente(id, idAlergia);
                    }
                }

            // redirecionando para a página de ingrediente novamente
            response.sendRedirect("ingredientes");

        }
    }
}

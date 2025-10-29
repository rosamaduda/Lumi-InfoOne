package com.example.lumi.Servlet.Ingrediente;

import com.example.lumi.DAO.IngredienteDAO;
import com.example.lumi.Model.Ingrediente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns={"/cadastro-ingrediente", "/adicionar-ingrediente"})
public class ServletAdicionarIngrediente extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        if (caminho.equals("/cadastro-ingrediente")) {
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

            // redirecionando para a página de ingrediente novamente
            response.sendRedirect("ingredientes");

        }
    }
}

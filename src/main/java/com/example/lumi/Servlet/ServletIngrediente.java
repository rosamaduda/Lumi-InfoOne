package com.example.lumi.Servlet;

import com.example.lumi.DAO.IngredienteDAO;
import com.example.lumi.Model.Ingrediente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns={"/cadastro-ingrediente", "/adicionar-ingrediente", "/alterar-ingrediente"})
public class ServletIngrediente extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath();
        if (caminho.equals("/cadastro-ingrediente")) {
            request.getRequestDispatcher("WEB-INF/view/cadastro_ingredientes.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        if (caminho.equals("/adicionar-ingrediente")) {
            // recebendo os parâmetros do form
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");

            // instanciando o objeto de Ingrediente e IngredienteDAO
            Ingrediente ingrediente = new Ingrediente(nome, descricao);
            IngredienteDAO ingredienteDAO = new IngredienteDAO();

            // adicionando o ingrediente
            ingredienteDAO.inserirIngrediente(ingrediente);

            // redirecionando para a página de ingrediente novamente
            response.sendRedirect("ingredientes");
        }
    }
}

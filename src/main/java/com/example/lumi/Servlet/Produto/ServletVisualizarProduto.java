package com.example.lumi.Servlet.Produto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/produtos")
public class ServletVisualizarProduto extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // redirecionando para a página de produtos
        request.getRequestDispatcher("WEB-INF/view/produtos.jsp").forward(request, response);
    }
}

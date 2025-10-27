package com.example.lumi.Servlet.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/alteracao-cliente", "/alterar-cliente"})
public class ServletEditarCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        if (caminho.equals("/alteracao-cliente")) {
            request.getRequestDispatcher("WEB-INF/view/editar_cliente.jsp").forward(request, response); // redirecionando para a página de edição
        }
    }
}

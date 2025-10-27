package com.example.lumi.Servlet.Cliente;

import com.example.lumi.DAO.ClienteDAO;
import com.example.lumi.Model.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/clientes")
public class ServletVisualizarCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDAO clienteDAO = new ClienteDAO();

        // buscando as informações do cliente
        List<Cliente> clienteLista = clienteDAO.buscarCliente();
        request.setAttribute("lista-clientes", clienteLista);

        // redirecionando para a página de cliente
        request.getRequestDispatcher("WEB-INF/view/cliente.jsp").forward(request, response);
    }
}

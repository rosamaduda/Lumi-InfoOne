package com.example.lumi.Servlet.Cliente;

import com.example.lumi.DAO.AvaliacaoDAO;
import com.example.lumi.DAO.ClienteAlergiaDAO;
import com.example.lumi.DAO.ClienteDAO;
import com.example.lumi.DAO.FavoritosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/exclusao-cliente")
public class ServletExcluirCliente extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDAO clienteDAO = new ClienteDAO();

        // instanciando os objetos de tabelas que recebem a FK do cliente
        AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
        ClienteAlergiaDAO clienteAlergiaDAO = new ClienteAlergiaDAO();
        FavoritosDAO favoritosDAO = new FavoritosDAO();

        // deletando os campos com a FK do cliente
        String emailCliente = request.getParameter("emailCliente");
        avaliacaoDAO.removerAvaliacao(emailCliente);
        clienteAlergiaDAO.deletarClienteAlergia(emailCliente);
        favoritosDAO.deletarFavorito(emailCliente);

        // deletando o cliente
        clienteDAO.deletarCliente(emailCliente);

        // redirecionando para a página do cliente
        response.sendRedirect("clientes");
    }
}

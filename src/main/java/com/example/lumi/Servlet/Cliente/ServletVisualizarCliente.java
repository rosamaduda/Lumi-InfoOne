package com.example.lumi.Servlet.Cliente;

import com.example.lumi.DAO.ClienteDAO;
import com.example.lumi.Model.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@WebServlet(urlPatterns = {"/clientes", "/filtro-cliente"})
public class ServletVisualizarCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDAO clienteDAO = new ClienteDAO();
        String caminho = request.getServletPath(); // recebendo o caminho do usuário
        List<Cliente> clienteLista = new ArrayList<>();

        // buscando as informações aqui para quando entrar na hora página as informações já estiverem carregadas
        if (caminho.equals("/clientes")) {
            // buscando as informações do cliente
            clienteLista = clienteDAO.buscarCliente();
        } else {
            // recebendo o valor do filtro e da barra de pesquisa
            String filtro = request.getParameter("filtro");
            String pesquisa = request.getParameter("pesquisa");

            // setando as informações para aparecerem a partir da informação da página
            request.setAttribute("filtro-selecionado", filtro);
            request.setAttribute("pesquisa-anterior", pesquisa);

            // buscando as informações aqui depenendendo do filtro
            if (filtro.equals("Todos")) {
                clienteLista = clienteDAO.buscarCliente();
            } else if (filtro.equals("UF")) {
                clienteLista = clienteDAO.buscarClientePorUF(pesquisa);
            } else {
                clienteLista = clienteDAO.buscarClientePorCidade(pesquisa);
            }
        }

        // setando a lista como atributo
        request.setAttribute("clientes-lista", clienteLista);

        // redirecionando para a página de cliente
        request.getRequestDispatcher("WEB-INF/view/cliente.jsp").forward(request, response);
    }
}

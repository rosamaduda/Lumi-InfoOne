package com.example.lumi.Servlet;

import com.example.lumi.DAO.*;
import com.example.lumi.Model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/portal", "/clientes", "/favoritos", "/avaliacoes", "/site"})
public class ServletTrocaPaginas extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        if (caminho.equals("/ingredientes")) {
            // instanciando o objeto da classe IngredienteDAO para ter acesso ao método de buscar
            IngredienteDAO ingredienteDAO = new IngredienteDAO();

            // buscando as informações aqui para quando entrar na hora página as informações já estiverem carregadas
            List<Ingrediente> listaIngredientes = ingredienteDAO.buscarIngrediente();
            request.setAttribute("ingredientes-lista", listaIngredientes);

            // redirecionando do portal para a página de ingrediente
            request.getRequestDispatcher("WEB-INF/view/ingredientes.jsp").forward(request, response);
        } else if (caminho.equals("/alergias")) {
            // instanciando o objeto da classe AlergiaDAO para ter acesso ao método de buscar
            AlergiaDAO alergiaDAO = new AlergiaDAO();

            // buscando as informações aqui para quando entrar na hora página as informações já estiverem carregadas
            List<Alergia> listaAlergias = alergiaDAO.buscarAlergia();
            request.setAttribute("alergias-lista", listaAlergias);

            // redirecionando do portal para a página de alergias
            request.getRequestDispatcher("WEB-INF/view/alergias.jsp").forward(request, response);
        } else if (caminho.equals("/clientes")) {
            // instanciando o objeto da classe clienteDAO para ter acesso ao método de buscar
            ClienteDAO clienteDAO = new ClienteDAO();

            // buscando as informações aqui para quando entrar na hora página as informações já estiverem carregadas
            List<Cliente> listaCLientes = clienteDAO.buscarCliente();
            request.setAttribute("clientes-lista", listaCLientes);

            // redirecionando do portal para a página de cliente
            request.getRequestDispatcher("WEB-INF/view/cliente.jsp").forward(request, response);
        } else if (caminho.equals("/industrias")) {
            // instanciando o objeto da classe IndustriaDAO para ter acesso ao método de buscar
            IndustriaDAO industriaDAO = new IndustriaDAO();

            // buscando as informações aqui para quando entrar na hora página as informações já estiverem carregadas
            List<Industria> listaIndustrias = industriaDAO.buscarIndustria();
            request.setAttribute("industrias-lista", listaIndustrias);

            // redirecionando do portal para a página de industria
            request.getRequestDispatcher("WEB-INF/view/industria.jsp").forward(request, response);
        } else if (caminho.equals("/favoritos")) {
            // instanciando o objeto da classe x para ter acesso ao método de buscar


            // buscando as informações aqui para quando entrar na hora página as informações já estiverem carregadas

            // redirecionando do portal para a página de favorito
            request.getRequestDispatcher("WEB-INF/view/favoritos.jsp").forward(request, response);
        } else if (caminho.equals("/avaliacoes")) {
            // instanciando o objeto da classe x para ter acesso ao método de buscar


            // buscando as informações aqui para quando entrar na hora página as informações já estiverem carregadas


            // redirecionando do portal para a página de avaliações
            request.getRequestDispatcher("WEB-INF/view/avaliacoes.jsp").forward(request, response);
        } else if (caminho.equals("/portal")) {
            // instanciando o objeto da classe x para ter acesso ao método de buscar


            // buscando as informações aqui para quando entrar na hora página as informações já estiverem carregadas


            // redirecionando do portal para a página do portal
            request.getRequestDispatcher("WEB-INF/view/portal.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("index.html").forward(request, response); // redirecionando para a landing page
        }
    }
}

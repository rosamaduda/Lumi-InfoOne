package com.example.lumi.Servlet;

import com.example.lumi.DAO.ClienteDAO;
import com.example.lumi.Model.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet (urlPatterns = {"/cadastro-cliente"})
public class ServletCliente extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        String caminho = request.getServletPath();

        if (caminho.equals("/cadastro-cliente")) {
            request.getRequestDispatcher("WEB-INF/view/cadastro_cliente.jsp").forward(request, response); // redirecionando para a página de cadastro
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        String caminho = request.getServletPath();

        if (caminho.equals("/cadastro-cliente")) {
            String email = request.getParameter("email").trim();
            String cpf = request.getParameter("cpf").replaceAll("[^0-9]","").trim();
            String cep = request.getParameter("cep").replaceAll("[^0-9]","").trim();
            String telefone = request.getParameter("telefone").replaceAll("[^0-9]","").trim();
            if (!email.matches("^[A-Za-z0-9]{1,}@[A-Za-z0-9]{1,}")) {
                request.setAttribute("mensagemErro", "E-mail inválido");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
            } else if (!cpf.matches("^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}$")){
                request.setAttribute("mensagemErro", "CPF inválido");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
            } else if (!cep.matches("^[0-9]{5}\\-{0,1}[0-9]{3}$")) {
                request.setAttribute("mensagemErro", "CEP inválido");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
            } else if (!telefone.matches("^\\({0,1}[0-9]{2}\\){0,1} {0,1}[0-9]{5}\\-{0,1}[0-9]{4}$")) {
                request.setAttribute("mensagemErro", "Telefone inválido");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
            } else {
                String nome = request.getParameter("nome").trim();
                String sobrenome = request.getParameter("sobrenome").trim();
                double peso = Double.parseDouble(request.getParameter("peso"));
                double altura = Double.parseDouble(request.getParameter("altura"));
                String senha = request.getParameter("senha").trim();
                String cidade = request.getParameter("cidade").trim();
            }





        }
    }
}

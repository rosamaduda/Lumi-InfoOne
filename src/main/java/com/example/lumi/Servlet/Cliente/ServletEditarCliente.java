package com.example.lumi.Servlet.Cliente;

import com.example.lumi.DAO.ClienteDAO;
import com.example.lumi.Model.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = {"/alteracao-cliente", "/alterar-cliente"})
public class ServletEditarCliente extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDAO clienteDAO = new ClienteDAO();
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        if (caminho.equals("/alteracao-cliente")) {
            // recebendo o email do cliente que será alterado
            String emailCliente = request.getParameter("emailCliente");

            // setando o email no model
            Cliente cliente = new Cliente(emailCliente);

            // buscando as informações a partir do email
            cliente = clienteDAO.buscarCliente(emailCliente);

            // setando os atributos
            request.setAttribute("email", cliente.getEmail());
            request.setAttribute("cpf", cliente.getCpf());
            request.setAttribute("nome", cliente.getNome());
            request.setAttribute("sobrenome", cliente.getNomeSobrenome());
            request.setAttribute("data-nascimento", cliente.getDataNascimento());
            request.setAttribute("senha", cliente.getSenha());
            request.setAttribute("altura", cliente.getAltura());
            request.setAttribute("peso", cliente.getPeso());
            request.setAttribute("diabetes", cliente.getDiabetes());
            request.setAttribute("pressao-alta", cliente.isPressaoAlta());
            request.setAttribute("colesterol-alto", cliente.isColesterolAlto());
            request.setAttribute("telefone", cliente.getTelefone());
            request.setAttribute("uf", cliente.getEnderecoUf());
            request.setAttribute("cidade", cliente.getEnderecoCidade());
            request.setAttribute("cep", cliente.getEnderecoCep());

            // redirecionando para a página de edição
            request.getRequestDispatcher("WEB-INF/view/editar_cliente.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDAO clienteDAO = new ClienteDAO();
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        if (caminho.equals("/alterar-cliente")) {
            // recebendo os parâmetros do form e fazendo a verificação de formato com regex quando necessário
            String cpf = request.getParameter("cpf");
            if (!cpf.matches("^[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}-?[0-9]{2}$")) {
                request.setAttribute("mensagemErro", "CPF inválido");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
            }
            String nome = request.getParameter("nome");
            String sobrenome = request.getParameter("sobrenome");
            double peso = Double.parseDouble(request.getParameter("peso"));
            double altura = Double.parseDouble(request.getParameter("altura"));
            boolean pressaoAlta = Boolean.parseBoolean(request.getParameter("hta"));
            boolean colesterolAlto = Boolean.parseBoolean(request.getParameter("colesterol"));
            String diabetes = request.getParameter("diabetes");
            LocalDate dataNascimento = LocalDate.parse(request.getParameter("data"));
            String email = request.getParameter("e-mail");
            if (!email.matches("^[A-Za-z0-9.]{1,}@[A-Za-z]{1,}\\.[A-Za-z.]{1,}$"))  {
                request.setAttribute("mensagemErro", "E-mail inválido");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
            }
            String telefone = request.getParameter("telefone");
            if (!telefone.matches("^\\(?[0-9]{2}\\)? ?[0-9]{5}-?[0-9]{4}$")) {
                request.setAttribute("mensagemErro", "Telefone inválido");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
            }
            String senha = request.getParameter("senha");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String cep = request.getParameter("cep");
            if (!cep.matches("^[0-9]{5}-?[0-9]{3}$")) {
                request.setAttribute("mensagemErro", "CEP inválido");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
            }

            // instanciando o objeto
            Cliente cliente = new Cliente(email, cpf, nome, sobrenome, dataNascimento, senha, altura, peso, diabetes, pressaoAlta, colesterolAlto, telefone, estado, cidade, cep);

            // alterando o cliente
            clienteDAO.alterarCliente(cliente);

            // redirecionando para a página de cliente
            response.sendRedirect("clientes");
        }
    }
}

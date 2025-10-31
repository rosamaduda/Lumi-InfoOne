package com.example.lumi.Servlet.Cliente;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.lumi.DAO.AlergiaDAO;
import com.example.lumi.DAO.ClienteAlergiaDAO;
import com.example.lumi.DAO.ClienteDAO;
import com.example.lumi.Model.Alergia;
import com.example.lumi.Model.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/cadastro-cliente", "/adicionar-cliente"})
public class ServletAdicionarCliente extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        if (caminho.equals("/cadastro-cliente")) {
            // Faz uma lista de alergias
            AlergiaDAO alergiaDAO = new AlergiaDAO();
            List<Alergia> alergiasOp = alergiaDAO.buscarAlergia();
            request.setAttribute("alergias-lista", alergiasOp);
            request.getRequestDispatcher("WEB-INF/view/cadastro_cliente.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDAO clienteDAO = new ClienteDAO();
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        if (caminho.equals("/adicionar-cliente")) {
            // recebendo os parâmetros do form e fazendo a verificação de formato com regex quando necessário
            String cpf = request.getParameter("cpf").replaceAll("[^0-9]","");
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
            String telefone = request.getParameter("telefone").replaceAll("[^0-9]","");
            if (!telefone.matches("^\\(?[0-9]{2}\\)? ?[0-9]{5}-?[0-9]{4}$")) {
                request.setAttribute("mensagemErro", "Telefone inválido");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
            }
            String senha = request.getParameter("senha");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String cep = request.getParameter("cep").replaceAll("[^0-9]","");
            if (!cep.matches("^[0-9]{5}-?[0-9]{3}$")) {
                request.setAttribute("mensagemErro", "CEP inválido");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
            }

            // instanciando o objeto
            Cliente cliente = new Cliente(email, cpf, nome, sobrenome, dataNascimento, senha, altura, peso, diabetes, pressaoAlta, colesterolAlto, telefone, estado, cidade, cep);

            // adicionando o cliente
            int retornoInsercao = clienteDAO.inserirCliente(cliente);
            if (retornoInsercao == -1 || retornoInsercao == 0) {
                request.setAttribute("mensagemErro", "Não foi possível inserir o cliente");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
            }
          
            // Pega as alergias escolhidas do formulário
            List<Integer> idAlergias = new ArrayList<>();
            for (int i = 0; i < 1000; i++){
                String idAlergiaStr = request.getParameter("alergia-" + i);
                if (idAlergiaStr != null && !idAlergiaStr.isEmpty()){
                    idAlergias.add(Integer.parseInt(idAlergiaStr));
                } else{
                    break;
                }
            }

            // Adicionando relação
            if (!idAlergias.isEmpty()){
                ClienteAlergiaDAO clienteAlergiaDAO = new ClienteAlergiaDAO();
                for (int i = 0; i < idAlergias.size(); i++){
                    int idAlergia = idAlergias.get(i);
                    clienteAlergiaDAO.inserirClienteAlergia(email, idAlergia);
                }
            }

            // redirecionando para a página do cliente
            response.sendRedirect("clientes");
        }
    }
}


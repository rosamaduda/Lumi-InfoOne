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
import com.example.lumi.Model.ClienteAlergia;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/alteracao-cliente", "/alterar-cliente"})
public class ServletEditarCliente extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath();
        ClienteDAO clienteDAO = new ClienteDAO();

        if (caminho.equals("/alteracao-cliente")) {
            String emailCliente = request.getParameter("emailCliente");

            // buscar cliente pelo email
            Cliente cliente = clienteDAO.buscarCliente(emailCliente);

            // buscar alergias do cliente
            ClienteAlergiaDAO clienteAlergiaDAO = new ClienteAlergiaDAO();
            List<ClienteAlergia> listaIdAlergias = clienteAlergiaDAO.buscaClienteAlergia(emailCliente);
            
            // pega as alergias selecionadas pelo cliente
            AlergiaDAO alergiaDAO = new AlergiaDAO();
            List<String> listaAlergias = new ArrayList<>();
            for (int i = 0; i < listaIdAlergias.size(); i++) {
                List<Alergia> alergiasDoCliente = alergiaDAO.buscarNomeAlergia(listaIdAlergias.get(i).getIdAlergia());
                if (alergiasDoCliente != null && !alergiasDoCliente.isEmpty()) {
                    for (int j = 0; j < alergiasDoCliente.size(); j++) {
                        listaAlergias.add(alergiasDoCliente.get(j).getNome()); 
                    }
                }
            }
            // pega todas as alergias do bd
            List<Alergia> alergias = alergiaDAO.buscarAlergia();
            List<String> todasAlergias = new ArrayList<>();
            for (int i = 0; i < alergias.size(); i++){
                todasAlergias.add(alergias.get(i).getNome());
            }

            // setando atributos
            request.setAttribute("e-mail", cliente.getEmail());
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
            request.setAttribute("alergiasLista", listaAlergias);
            request.setAttribute("todas-alergias", todasAlergias);

            request.getRequestDispatcher("WEB-INF/view/editar_cliente.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath();
        ClienteDAO clienteDAO = new ClienteDAO();

        if (caminho.equals("/alterar-cliente")) {
            String cpf = request.getParameter("cpf");
            if (!cpf.matches("^[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}-?[0-9]{2}$")) {
                request.setAttribute("mensagemErro", "CPF inválido");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
                return;
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
                return;
            }

            String telefone = request.getParameter("telefone");
            if (!telefone.matches("^\\(?[0-9]{2}\\)? ?[0-9]{5}-?[0-9]{4}$")) {
                request.setAttribute("mensagemErro", "Telefone inválido");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
                return;
            }

            String senha = request.getParameter("senha");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String cep = request.getParameter("cep");
            if (!cep.matches("^[0-9]{5}-?[0-9]{3}$")) {
                request.setAttribute("mensagemErro", "CEP inválido");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
                return;
            }

            // deleta alergias antigas e inserir novas
            ClienteAlergiaDAO clienteAlergiaDAO = new ClienteAlergiaDAO();
            clienteAlergiaDAO.deletarClienteAlergia(email);

            request.getParameterMap().forEach((key, value) -> {
                if (key.startsWith("alergia-")) {
                    String alergiaNome = request.getParameter(key).trim();
                    if (!alergiaNome.isEmpty()) {
                        AlergiaDAO alergiaDAO = new AlergiaDAO();
                        int idAlergia = alergiaDAO.buscarIdAlergia(alergiaNome);
                        clienteAlergiaDAO.inserirClienteAlergia(email, idAlergia);
                    }
                }
            });

            // cria objeto cliente
            Cliente cliente = new Cliente(email, cpf, nome, sobrenome, dataNascimento, senha, altura, peso, diabetes, pressaoAlta, colesterolAlto, telefone, estado, cidade, cep);

            // altera cliente
            int retornoAlteracao = clienteDAO.alterarCliente(cliente);
            if (retornoAlteracao == 0 || retornoAlteracao == -1) {
                request.setAttribute("mensagemErro", "Não foi possível alterar o cliente");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
                return;
            }

            // redireciona
            response.sendRedirect("clientes");
        }
    }
}

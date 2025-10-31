package com.example.lumi.Servlet.Cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.lumi.DAO.ClienteAlergiaDAO;
import com.example.lumi.DAO.ClienteDAO;
import com.example.lumi.Model.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/clientes", "/filtro-cliente"})
public class ServletVisualizarCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // Instanciando os objetos
        ClienteDAO clienteDAO = new ClienteDAO();
        ClienteAlergiaDAO clienteAlergiaDAO = new ClienteAlergiaDAO();

        String caminho = request.getServletPath(); // recebendo o caminho do usuário
        List<Cliente> clienteLista = new ArrayList<>();
        List<List> alergiasLista = new ArrayList<>();  

        // buscando as informações aqui para quando entrar na hora página as informações já estiverem carregadas
        if (caminho.equals("/clientes")) {
            // buscando as informações do cliente
            clienteLista = clienteDAO.buscarCliente();
            
            for (int i = 0; i < clienteLista.size(); i++){
                String emailCliente = clienteLista.get(i).getEmail();
                alergiasLista.add(clienteAlergiaDAO.buscarAlergiasPorEmail(emailCliente));
    
            }
    
        } else {
            // recebendo o valor do filtro e da barra de pesquisa
            String filtro = request.getParameter("filtro");
            String pesquisa = request.getParameter("pesquisa");

            // setando as informações para aparecerem a partir da informação da página
            request.setAttribute("filtro-selecionado", filtro);
            request.setAttribute("pesquisa-anterior", pesquisa);

            // buscando as informações aqui dependendo do filtro
            if (filtro.equals("Todos")) {
                clienteLista = clienteDAO.buscarCliente();

                for (int i = 0; i < clienteLista.size(); i++){
                    String emailCliente = clienteLista.get(i).getEmail();
                    alergiasLista.add(clienteAlergiaDAO.buscarAlergiasPorEmail(emailCliente));
        
                }
            } else if (filtro.equals("UF")) {
                clienteLista = clienteDAO.buscarClientePorUF(pesquisa);

                for (int i = 0; i < clienteLista.size(); i++){
                    String emailCliente = clienteLista.get(i).getEmail();
                    alergiasLista.add(clienteAlergiaDAO.buscarAlergiasPorEmail(emailCliente));
        
                }        
            } else if (filtro.equals("Cidade")){
                clienteLista = clienteDAO.buscarClientePorCidade(pesquisa);

                for (int i = 0; i < clienteLista.size(); i++){
                    String emailCliente = clienteLista.get(i).getEmail();
                    alergiasLista.add(clienteAlergiaDAO.buscarAlergiasPorEmail(emailCliente));
        
                }        
            } else {
                clienteLista = clienteDAO.buscarClientePorNomeCompleto(pesquisa);

                for (int i = 0; i < clienteLista.size(); i++){
                    String emailCliente = clienteLista.get(i).getEmail();
                    alergiasLista.add(clienteAlergiaDAO.buscarAlergiasPorEmail(emailCliente));
        
                }        
            }
        }

        // setando a lista como atributo
        request.setAttribute("clientes-lista", clienteLista);
        request.setAttribute("alergias-lista", alergiasLista);

        // redirecionando para a página de cliente
        request.getRequestDispatcher("WEB-INF/view/cliente.jsp").forward(request, response);
    }
}

package com.example.lumi.Servlet.Ingrediente;

import com.example.lumi.DAO.IngredienteDAO;
import com.example.lumi.Model.Ingrediente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/alteracao-ingrediente", "/alterar-ingrediente"})
public class ServletEditarIngrediente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IngredienteDAO ingredienteDAO = new IngredienteDAO();
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        if (caminho.equals("/alteracao-ingrediente")) {
            // recebendo o ID do ingrediente que será alterado
            int idIngrediente = Integer.parseInt(request.getParameter("idIngrediente"));

            // setando o id no model
            Ingrediente ingrediente = new Ingrediente(idIngrediente);

            // buscando as informações do id para poder setar como atributos
            ingrediente = ingredienteDAO.buscarIngrediente(ingrediente);

            // setando os atributos
            request.setAttribute("idIngrediente", ingrediente.getId());
            request.setAttribute("nomeIngrediente", ingrediente.getNome());
            request.setAttribute("descricaoIngrediente", ingrediente.getDescricao());

            request.getRequestDispatcher("WEB-INF/view/editar_ingredientes.jsp").forward(request, response); // redirecionando para a página de editar
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IngredienteDAO ingredienteDAO = new IngredienteDAO();
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        if (caminho.equals("/alterar-ingrediente")) {
            // recebendo os parâmetros do form
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");

            // instanciando o objeto
            Ingrediente ingrediente = new Ingrediente(id, nome, descricao);

            // alterando o ingrediente
            ingredienteDAO.alterarIngrediente(ingrediente);

            // redirecionando para a página de ingrediente novamente
            response.sendRedirect("ingredientes");
        }
    }
}

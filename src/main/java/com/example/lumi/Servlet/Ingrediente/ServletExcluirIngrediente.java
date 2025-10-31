package com.example.lumi.Servlet.Ingrediente;

import com.example.lumi.DAO.AlergiaIngredienteDAO;
import com.example.lumi.DAO.IngredienteDAO;
import com.example.lumi.DAO.ProdutoIngredienteDAO;
import com.example.lumi.Model.Ingrediente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/exclusao-ingrediente")
public class ServletExcluirIngrediente extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IngredienteDAO ingredienteDAO = new IngredienteDAO();
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        // instanciando objetos de tabelas que precisam ter campos deletados por causa das fks
        ProdutoIngredienteDAO produtoIngredienteDAO = new ProdutoIngredienteDAO();
        AlergiaIngredienteDAO alergiaIngredienteDAO = new AlergiaIngredienteDAO();

        // recebendo o ID da alergia que será removida
        int idIngrediente = Integer.parseInt(request.getParameter("idIngrediente"));

        // removendo os campos que possuem o id
        alergiaIngredienteDAO.removerIngredienteAlergia(idIngrediente);
        produtoIngredienteDAO.removerProdutoIngrediente(idIngrediente);
        ingredienteDAO.removerIngrediente(idIngrediente);

        // recarregando a página
        response.sendRedirect("ingredientes");
    }
}

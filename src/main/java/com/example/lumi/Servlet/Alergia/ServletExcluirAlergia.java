package com.example.lumi.Servlet.Alergia;

import com.example.lumi.DAO.AlergiaDAO;
import com.example.lumi.DAO.AlergiaIngredienteDAO;
import com.example.lumi.DAO.ClienteAlergiaDAO;
import com.example.lumi.Model.Alergia;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/exclusao-alergia")
public class ServletExcluirAlergia extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlergiaDAO alergiaDAO = new AlergiaDAO();

        // instancioando objetos de tabelas que precisam ter campos deletados por causa das fks
        AlergiaIngredienteDAO alergiaIngredienteDAO = new AlergiaIngredienteDAO();
        ClienteAlergiaDAO clienteAlergiaDAO = new ClienteAlergiaDAO();

        // recebendo o ID da alergia que será removida
        int idAlergia = Integer.parseInt(request.getParameter("idAlergia"));

        // removendo os campos que possuem o id
        alergiaIngredienteDAO.removerAlergiaIngrediente(idAlergia);
        clienteAlergiaDAO.DeletarClienteAlergia(idAlergia);
        alergiaDAO.removerAlergia(idAlergia);

        // recarregando a página
        response.sendRedirect("alergias");
    }
}

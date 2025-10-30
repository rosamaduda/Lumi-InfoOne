package com.example.lumi.Servlet.Industria;

import com.example.lumi.DAO.IndustriaDAO;
import com.example.lumi.DAO.ProdutoDAO;
import com.example.lumi.DAO.TelefoneIndustriaDAO;
import com.example.lumi.Model.Industria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/exclusao-industria")
public class ServletExcluirIndustria extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IndustriaDAO industriaDAO = new IndustriaDAO();

        // instancioando objetos de tabelas que precisam ter campos deletados por causa das fks
        ProdutoDAO produtoDAO = new ProdutoDAO();
        TelefoneIndustriaDAO telefoneIndustriaDAO = new TelefoneIndustriaDAO();

        // recebendo o ID da alergia que será removida
        int idIndustria = Integer.parseInt(request.getParameter("idIndustria"));

        // removendo os campos que possuem o id
        produtoDAO.deletarProdutoIndustria(idIndustria);
        telefoneIndustriaDAO.deletarTelIdIndustria(idIndustria);
        industriaDAO.deletarIndustria(idIndustria);

        // recarregando a página
        response.sendRedirect("industrias");
    }
}

package com.example.lumi.Servlet.Produto;

import com.example.lumi.DAO.*;
import com.example.lumi.Model.Favorito;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/exclusao-produto")
public class ServletExcluirProduto extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        InformacaoNutricionalDAO informacaoNutricionalDAO = new InformacaoNutricionalDAO();
        AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
        FavoritosDAO favoritosDAO = new FavoritosDAO();
        ProdutoIngredienteDAO produtoIngredienteDAO = new ProdutoIngredienteDAO();

        // recebendo o código do produto que será excluido
        String codigoBarras = request.getParameter("codigoProduto");

        // recebendo o id da info. nutricional do produto
        int idInfoNutri = produtoDAO.buscarIdInfoNutri(codigoBarras);

        // excluindo tabelas que recebem FK do produto
        informacaoNutricionalDAO.deletarInfoNutri(idInfoNutri);
        avaliacaoDAO.removerAvaliacaoPorCodigo(codigoBarras);
        favoritosDAO.deletarFavoritoPorCodigo(codigoBarras);
        produtoIngredienteDAO.removerProdutoIngrediente(codigoBarras);

        // excluindo o produto
        produtoDAO.deletarProduto(codigoBarras);

        // redirecionando para a página de produto
        response.sendRedirect("produtos");
    }
}
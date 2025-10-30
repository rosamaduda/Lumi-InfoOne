package com.example.lumi.Servlet.Produto;

import com.example.lumi.DAO.InformacaoNutricionalDAO;
import com.example.lumi.DAO.ProdutoDAO;
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

        // recebendo o código do produto que será excluido
        long codigoBarras = Long.parseLong(request.getParameter("codigoProduto"));

        // recebendo o id da info. nutricional do produto
        int idInfoNutri = produtoDAO.buscarIdInfoNutri(codigoBarras);

        // excluindo a info. nutricional
        informacaoNutricionalDAO.deletarInfoNutri(idInfoNutri);

        // excluindo o produto
        produtoDAO.removerProduto(codigoBarras);

        // redirecionando para a página de produto
        response.sendRedirect("produtos");
    }
}

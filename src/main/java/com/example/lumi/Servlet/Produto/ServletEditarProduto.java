package com.example.lumi.Servlet.Produto;

import com.example.lumi.DAO.IndustriaDAO;
import com.example.lumi.DAO.InformacaoNutricionalDAO;
import com.example.lumi.DAO.ProdutoDAO;
import com.example.lumi.Model.Industria;
import com.example.lumi.Model.InformacaoNutricional;
import com.example.lumi.Model.Ingrediente;
import com.example.lumi.Model.Produto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/alteracao-produto", "/alterar-produto"})
public class ServletEditarProduto extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        // instanciando classes DAO
        ProdutoDAO produtoDAO = new ProdutoDAO();
        InformacaoNutricionalDAO informacaoNutricionalDAO = new InformacaoNutricionalDAO();
        IndustriaDAO industriaDAO = new IndustriaDAO();

        if (caminho.equals("/alteracao-produto")) {
            // buscando o nome das indústrias para o dropdown
            List<Industria> listaIndustrias = industriaDAO.buscarNomeIndustria();

            // recebendo o codigo de barras do produto que será alterado
            String codigoBarras = request.getParameter("codigoProduto");

            // setando o código de barras no model
            Produto produto = new Produto(codigoBarras);

            // buscando as informações do produto
            produto = produtoDAO.buscarProduto(produto);

            // recebendo o id da info. nutricional do produto
            int idInfoNutri = produto.getIdInfoNutri();

            // setando o id no model
            InformacaoNutricional informacaoNutricional = new InformacaoNutricional(idInfoNutri);

            // buscando as informações da info. nutricional do produto
            informacaoNutricional = informacaoNutricionalDAO.buscarInfoNutri(informacaoNutricional);

            // recebendo o id da industria para encontrar o nome
            int idIndustria = produto.getIdIndustria();

            // buscando o nome da indústria
            Industria industria = industriaDAO.buscarNomeIndustria(idIndustria);

            // setando os atributos
            request.setAttribute("codigo-barras", produto.getCodigoBarras());
            request.setAttribute("nome", produto.getNome());
            request.setAttribute("fabricante", produto.getFabricante());
            request.setAttribute("nome-industria", industria.getNome());
            request.setAttribute("descricao", produto.getDescricao());
            request.setAttribute("massa", produto.getMassa());
            request.setAttribute("idInfoNutri", informacaoNutricional.getId());
            request.setAttribute("calorias", informacaoNutricional.getValorEnergetico());
            request.setAttribute("proteinas", informacaoNutricional.getProteina());
            request.setAttribute("fibras", informacaoNutricional.getFibras());
            request.setAttribute("carboidratos", informacaoNutricional.getCarboidratos());
            request.setAttribute("sodio", informacaoNutricional.getSodio());
            request.setAttribute("gorduras-sat", informacaoNutricional.getGorduraSaturada());
            request.setAttribute("gorduras-tot", informacaoNutricional.getGordurasTotais());
            request.setAttribute("gorduras-tr", informacaoNutricional.getGorduraTrans());
            request.setAttribute("industrias-lista", listaIndustrias);

            // redirecionando o usuário para a página de edição
            request.getRequestDispatcher("WEB-INF/view/editar_produto.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        // instanciando classes DAO
        ProdutoDAO produtoDAO = new ProdutoDAO();
        InformacaoNutricionalDAO informacaoNutricionalDAO = new InformacaoNutricionalDAO();
        IndustriaDAO industriaDAO = new IndustriaDAO();

        if (caminho.equals("/alterar-produto")) {
            // recebendo os parâemetros da info. nutricional
            int idInfoNutri = Integer.parseInt(request.getParameter("idInfoNutri"));
            double calorias = Double.parseDouble(request.getParameter("calorias"));
            double proteinas = Double.parseDouble(request.getParameter("proteinas"));
            double fibras = Double.parseDouble(request.getParameter("fibras"));
            double carboidratos = Double.parseDouble(request.getParameter("carboidratos"));
            double sodio = Double.parseDouble(request.getParameter("sodio"));
            double gordurasSaturadas = Double.parseDouble(request.getParameter("gorduras-sat"));
            double gordurasTotais = Double.parseDouble(request.getParameter("gorduras-tot"));
            double gordurasTrans = Double.parseDouble(request.getParameter("gorduras-tr"));

            // instanciando o objeto da info. nutricional
            InformacaoNutricional informacaoNutricional = new InformacaoNutricional(idInfoNutri, calorias, proteinas, fibras, carboidratos, sodio, gordurasSaturadas, gordurasTrans, gordurasTotais);

            // adicionando a informação nutricional
            int retornoAlteracao = informacaoNutricionalDAO.alterarInfoNutri(informacaoNutricional);
            if (retornoAlteracao == 0 || retornoAlteracao == -1) {
                request.setAttribute("mensagemErro", "Não foi possível alterar a informação nutricional");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
            }

            // recebendo os parâmetros do produto
            String codigoBarras = request.getParameter("codigo-barras");
            String nome = request.getParameter("nome");
            String fabricante = request.getParameter("fabricante");
            String nomeIndustria = request.getParameter("industria");
            String descricao = request.getParameter("descricao");
            double massa = Double.parseDouble(request.getParameter("massa"));

            // buscando o id da indústria a partir do nome
            int idIndustria = industriaDAO.buscarIdIndustria(nomeIndustria);

            // instanciando o objeto de produto
            Produto produto = new Produto(codigoBarras, nome, fabricante, descricao, massa, idIndustria, idInfoNutri);

            // adicionando o produto
            retornoAlteracao = produtoDAO.alterarProduto(produto);
            if (retornoAlteracao == 0 || retornoAlteracao == -1) {
                request.setAttribute("mensagemErro", "Não foi possível alterar o produto");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
            }

            // redirecionando o usuário para a página do produto
            response.sendRedirect("produtos");}
    }
}
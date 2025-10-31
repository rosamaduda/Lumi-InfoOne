package com.example.lumi.Servlet.Produto;

import com.example.lumi.DAO.IndustriaDAO;
import com.example.lumi.DAO.InformacaoNutricionalDAO;
import com.example.lumi.DAO.ProdutoDAO;
import com.example.lumi.Model.Industria;
import com.example.lumi.Model.InformacaoNutricional;
import com.example.lumi.Model.Produto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/cadastro-produto", "/adicionar-produto"})
public class ServletAdicionarProduto extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        if (caminho.equals("/cadastro-produto")) {
            // buscando o nome das indústrias para o dropdown do cadastro
            IndustriaDAO industriaDAO = new IndustriaDAO();
            List<Industria> listaIndustrias = new ArrayList<>();
            listaIndustrias = industriaDAO.buscarNomeIndustria();
            request.setAttribute("industrias-lista", listaIndustrias);

            request.getRequestDispatcher("WEB-INF/view/cadastro_produto.jsp").forward(request, response); // redirecionando o usuário para a página de cadastro
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        // instanciando classes DAOs para ter acesso aos métodos de manipulação do banco
        InformacaoNutricionalDAO informacaoNutricionalDAO = new InformacaoNutricionalDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        IndustriaDAO industriaDAO = new IndustriaDAO();

        if (caminho.equals("/adicionar-produto")) {
            // recebendo os parâemetros para adicionar primeiro a info. nutricional pois produto recebe fk da tabela
            double calorias = Double.parseDouble(request.getParameter("calorias"));
            double proteinas = Double.parseDouble(request.getParameter("proteinas"));
            double fibras = Double.parseDouble(request.getParameter("fibras"));
            double carboidratos = Double.parseDouble(request.getParameter("carboidratos"));
            double sodio = Double.parseDouble(request.getParameter("sodio"));
            double gordurasSaturadas = Double.parseDouble(request.getParameter("gorduras-sat"));
            double gordurasTotais = Double.parseDouble(request.getParameter("gorduras-tot"));
            double gordurasTrans = Double.parseDouble(request.getParameter("gorduras-tr"));

            // instanciando o objeto da info. nutricional
            InformacaoNutricional informacaoNutricional = new InformacaoNutricional(calorias, proteinas, fibras, carboidratos, sodio, gordurasSaturadas, gordurasTrans, gordurasTotais);

            // adicionando a informação nutricional
            int retornoInsercao = informacaoNutricionalDAO.inserirInfoNutri(informacaoNutricional);
            if (retornoInsercao == 0 || retornoInsercao == -1) {
                request.setAttribute("mensagemErro", "Não foi possível inserir a informação nutricional");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
            }

            // buscando o id da última informação nutricional adicionada
            int idInfoNutri = informacaoNutricionalDAO.buscarIdInfoNutri();

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
            retornoInsercao = produtoDAO.inserirProduto(produto);
            if (retornoInsercao == 0 || retornoInsercao == -1) {
                request.setAttribute("mensagemErro", "Não foi possível inserir o produto");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
            }

            // redirecionando o usuário para a página do produto
            response.sendRedirect("produtos");
        }
    }
}

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

@WebServlet(urlPatterns = {"/produtos", "/filtro-produto"})
public class ServletVisualizarProduto extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        ProdutoDAO produtoDAO = new ProdutoDAO();
        IndustriaDAO industriaDAO = new IndustriaDAO();
        InformacaoNutricionalDAO informacaoNutricionalDAO = new InformacaoNutricionalDAO();

        List<Produto> listaProdutos = new ArrayList<>();
        List<Industria> listaNomeIndustria = new ArrayList<>();
        List<InformacaoNutricional> listaInfoNutri = new ArrayList<>();

        Industria industria;

        if (caminho.equals("/produtos")) {
            listaProdutos = produtoDAO.buscarProduto();
            listaInfoNutri = informacaoNutricionalDAO.buscarInfoNutri();
            for (int i = 0; i < listaProdutos.size(); i++) {
                industria = industriaDAO.buscarNomeIndustria(listaProdutos.get(i).getIdIndustria());
                listaNomeIndustria.add(industria);
            }
        } else {
            // recebendo o valor do filtro e da barra de pesquisa
            String filtro = request.getParameter("filtro");
            String pesquisa = request.getParameter("pesquisa");

            // setando as informações para aparecerem a partir da informação da página
            request.setAttribute("filtro-selecionado", filtro);
            request.setAttribute("pesquisa-anterior", pesquisa);

            // buscando as informações aqui para quando entrar na hora página as informações já estiverem carregadas
            if (filtro.equals("Todos")) {
                listaProdutos = produtoDAO.buscarProduto();
                listaInfoNutri = informacaoNutricionalDAO.buscarInfoNutri();
                for (int i = 0; i < listaProdutos.size(); i++) {
                    industria = industriaDAO.buscarNomeIndustria(listaProdutos.get(i).getIdIndustria());
                    listaNomeIndustria.add(industria);
                }
            } else if (filtro.equals("Nome")) {
                listaProdutos = produtoDAO.buscarProdutoPorNome(pesquisa);
                listaInfoNutri = informacaoNutricionalDAO.buscarInfoNutri();
                for (int i = 0; i < listaProdutos.size(); i++) {
                    industria = industriaDAO.buscarNomeIndustria(listaProdutos.get(i).getIdIndustria());
                    listaNomeIndustria.add(industria);
                }
            } else if (filtro.equals("Fabricante")) {
                listaProdutos = produtoDAO.buscarProdutoPorFabricante(pesquisa);
                listaInfoNutri = informacaoNutricionalDAO.buscarInfoNutri();
                for (int i = 0; i < listaProdutos.size(); i++) {
                    industria = industriaDAO.buscarNomeIndustria(listaProdutos.get(i).getIdIndustria());
                    listaNomeIndustria.add(industria);
                }
            } else if (filtro.equals("Indústria")){
                // recebendo o id da industria para procurar os produtos pelo nome
                int idIndustria = industriaDAO.buscarIdIndustria(pesquisa);

                // buscando o produto
                listaProdutos = produtoDAO.buscarProdutoPorIndustria(idIndustria);
                listaInfoNutri = informacaoNutricionalDAO.buscarInfoNutri();
                for (int i = 0; i < listaProdutos.size(); i++) {
                    industria = industriaDAO.buscarNomeIndustria(listaProdutos.get(i).getIdIndustria());
                    listaNomeIndustria.add(industria);
                }
            } else {
                listaProdutos = produtoDAO.buscarProdutoPorMassa(Double.parseDouble(pesquisa));
                listaInfoNutri = informacaoNutricionalDAO.buscarInfoNutri();
                for (int i = 0; i < listaProdutos.size(); i++) {
                    industria = industriaDAO.buscarNomeIndustria(listaProdutos.get(i).getIdIndustria());
                    listaNomeIndustria.add(industria);
                }
            }
        }

        // setando as listas como atributo
        request.setAttribute("produtos-lista", listaProdutos);
        request.setAttribute("nomeIndustria-lista", listaNomeIndustria);
        request.setAttribute("infoNutri-lista", listaInfoNutri);

        // redirecionando para a página de produtos
        request.getRequestDispatcher("WEB-INF/view/produtos.jsp").forward(request, response);
    }
}

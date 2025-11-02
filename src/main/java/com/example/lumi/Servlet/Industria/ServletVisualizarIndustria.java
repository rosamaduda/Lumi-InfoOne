package com.example.lumi.Servlet.Industria;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.lumi.DAO.IndustriaDAO;
import com.example.lumi.DAO.TelefoneIndustriaDAO;
import com.example.lumi.Model.Industria;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/industrias", "/filtro-industria"})
public class ServletVisualizarIndustria extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath(); // recebendo o caminho do usuário
        // instanciando o objeto da classe IndustriaDAO e TelefoneIndustriaDAO para ter acesso aos métodos de buscar
        IndustriaDAO industriaDAO = new IndustriaDAO();
        TelefoneIndustriaDAO telefoneIndustriaDAO = new TelefoneIndustriaDAO();
        List<Industria> listaIndustrias = new ArrayList<>();
        List<List> listaTelefones = new ArrayList<>();

        // buscando as informações aqui para quando entrar na página as informações já estiverem carregadas
        if (caminho.equals("/industrias")) {
            listaIndustrias = industriaDAO.buscarIndustria();
            listaTelefones = new ArrayList<>();

            for (int i = 0; i < listaIndustrias.size(); i++) {
                int idIndustria = listaIndustrias.get(i).getId();
                listaTelefones.add(telefoneIndustriaDAO.buscarTelPorIndustria(idIndustria));
            }
        } else {
            // recebendo o valor do filtro e da barra de pesquisa
            String filtro = request.getParameter("filtro");
            String pesquisa = request.getParameter("pesquisa");

            // setando as informações para aparecerem a partir da informação da página
            request.setAttribute("filtro-selecionado", filtro);
            request.setAttribute("pesquisa-anterior", pesquisa);

            // transformando a string para todas as letras minúsculas
            pesquisa = pesquisa.toLowerCase();

            // buscando as informações dependendo dos filtros
            if (filtro.equals("Nome")) {
                listaIndustrias = industriaDAO.buscarIndustriaPorNome(pesquisa);

                for (int i = 0; i < listaIndustrias.size(); i++) {
                    int idIndustria = listaIndustrias.get(i).getId();
                    listaTelefones.add(telefoneIndustriaDAO.buscarTelefone(idIndustria));
                }
            } else if (filtro.equals("Plano")) {
                listaIndustrias = industriaDAO.buscarIndustriaPorPlano(pesquisa);

                for (int i = 0; i < listaIndustrias.size(); i++) {
                    int idIndustria = listaIndustrias.get(i).getId();
                    listaTelefones.add(telefoneIndustriaDAO.buscarTelefone(idIndustria));
                }
            } else {
                listaIndustrias = industriaDAO.buscarIndustria();

                for (int i = 0; i < listaIndustrias.size(); i++) {
                    int idIndustria = listaIndustrias.get(i).getId();
                    listaTelefones.add(telefoneIndustriaDAO.buscarTelefone(idIndustria));
                }
            }
        }

        // setando as listas como atributos
        request.setAttribute("telefones-lista", listaTelefones);
        request.setAttribute("industrias-lista", listaIndustrias);

        // redirecionando do portal para a página de industria
        request.getRequestDispatcher("WEB-INF/view/industria.jsp").forward(request, response);
    }
}

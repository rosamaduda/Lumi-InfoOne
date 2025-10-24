package com.example.lumi.Servlet.Industria;

import com.example.lumi.DAO.IndustriaDAO;
import com.example.lumi.DAO.TelefoneIndustriaDAO;
import com.example.lumi.Model.Industria;
import com.example.lumi.Model.TelefoneIndustria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/industrias")
public class ServletVisualizarIndustria extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // instanciando o objeto da classe IndustriaDAO para ter acesso ao método de buscar
        IndustriaDAO industriaDAO = new IndustriaDAO();
        TelefoneIndustriaDAO telefoneIndustriaDAO = new TelefoneIndustriaDAO();

        // buscando as informações aqui para quando entrar na hora página as informações já estiverem carregadas
        List<Industria> listaIndustrias = industriaDAO.buscarIndustria();
        List<List> listaTelefones = new ArrayList<>();

        for (int i = 0; i < listaIndustrias.size(); i++) {
            int idIndustria = listaIndustrias.get(i).getId();
            listaTelefones.add(telefoneIndustriaDAO.buscarTelefone(idIndustria));
        }

        // setando as listas como atributos
        request.setAttribute("telefones-lista", listaTelefones);
        request.setAttribute("industrias-lista", listaIndustrias);

        // redirecionando do portal para a página de industria
        request.getRequestDispatcher("WEB-INF/view/industria.jsp").forward(request, response);
    }
}

package com.example.lumi.Servlet.Alergia;

import com.example.lumi.DAO.AlergiaDAO;
import com.example.lumi.Model.Alergia;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/alergias", "/filtro-alergia"})
public class ServletVisualizarAlergia extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // instanciando o objeto da classe AlergiaDAO para ter acesso ao método de buscar
        AlergiaDAO alergiaDAO = new AlergiaDAO();
        String caminho = request.getServletPath(); // recebendo o caminho do usuário
        List<Alergia> listaAlergias = new ArrayList<>();

        // buscando as informações aqui para quando entrar na hora página as informações já estiverem carregadas
        if (caminho.equals("/alergias")) {
            listaAlergias = alergiaDAO.buscarAlergia();
        } else {
            // recebendo o valor do filtro e da barra de pesquisa
            String filtro = request.getParameter("filtro");
            String pesquisa = request.getParameter("pesquisa");

            // setando as informações para aparecerem a partir da informação da página
            request.setAttribute("filtro-selecionado", filtro);
            request.setAttribute("pesquisa-anterior", pesquisa);

            // transformando a string para todas as letras minúsculas
            pesquisa = pesquisa.toLowerCase();

            // buscando as informações dependendo do filtro
            if (filtro.equals("Todos")) {
                listaAlergias = alergiaDAO.buscarAlergia();
            } else if (filtro.equals("Nome")) {
                listaAlergias = alergiaDAO.buscarAlergiaPorNome(pesquisa);
            } else {
                listaAlergias = alergiaDAO.buscarAlergiaPorAlergeno(pesquisa);
            }
        }

        // setando a lista como atributo
        request.setAttribute("alergias-lista", listaAlergias);

        // redirecionando do portal para a página de alergias
        request.getRequestDispatcher("WEB-INF/view/alergias.jsp").forward(request, response);
    }
}

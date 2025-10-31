package com.example.lumi.Servlet.Ingrediente;

import com.example.lumi.DAO.AlergiaIngredienteDAO;
import com.example.lumi.DAO.IngredienteDAO;
import com.example.lumi.Model.Ingrediente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/ingredientes", "/filtro-ingrediente"})
public class ServletVisualizarIngrediente extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // instanciando os objetos
        IngredienteDAO ingredienteDAO = new IngredienteDAO();
        AlergiaIngredienteDAO alergiaIngredienteDAO = new AlergiaIngredienteDAO();

        String caminho = request.getServletPath(); // recebendo o caminho do usuário
        List<Ingrediente> listaIngredientes = new ArrayList<>();
        List<List> listaAlergias = new ArrayList<>();

        // buscando as informações aqui para quando entrar na página as informações já estiverem carregadas
        if (caminho.equals("/ingredientes")) {
            listaIngredientes = ingredienteDAO.buscarIngrediente();

            for (int i = 0; i < listaIngredientes.size(); i++) {
                int idIngrediente = listaIngredientes.get(i).getId();
                listaAlergias.add(alergiaIngredienteDAO.buscarAlergiasPorIngrediente(idIngrediente));
            }
        } else {
            // recebendo o valor do filtro e da barra de pesquisa
            String filtro = request.getParameter("filtro");
            String pesquisa = request.getParameter("pesquisa");

            // setando as informações para aparecerem a partir da informação da página
            request.setAttribute("filtro-selecionado", filtro);
            request.setAttribute("pesquisa-anterior", pesquisa);

            // buscando as informações aqui depenendendo do filtro
            if (filtro.equals("Nome")) {
                listaIngredientes = ingredienteDAO.buscarIngredientePorNome(pesquisa);
            } else {
                listaIngredientes = ingredienteDAO.buscarIngrediente();
            }
        }

        // // setando a lista como atributo
        request.setAttribute("ingredientes-lista", listaIngredientes);
        request.setAttribute("alergias-lista", listaAlergias);

        // redirecionando do portal para a página de ingrediente
        request.getRequestDispatcher("WEB-INF/view/ingredientes.jsp").forward(request, response);
    }
}

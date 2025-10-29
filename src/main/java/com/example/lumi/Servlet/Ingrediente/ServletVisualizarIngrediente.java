package com.example.lumi.Servlet.Ingrediente;

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IngredienteDAO ingredienteDAO = new IngredienteDAO(); // instanciando o objeto da classe IngredienteDAO para ter acesso ao método de buscar
        String caminho = request.getServletPath(); // recebendo o caminho do usuário
        List<Ingrediente> listaIngredientes = new ArrayList<>();

        if (caminho.equals("/ingredientes")) {
            // buscando as informações aqui para quando entrar na hora página as informações já estiverem carregadas
            listaIngredientes = ingredienteDAO.buscarIngrediente();

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

        // redirecionando do portal para a página de ingrediente
        request.getRequestDispatcher("WEB-INF/view/ingredientes.jsp").forward(request, response);
    }
}

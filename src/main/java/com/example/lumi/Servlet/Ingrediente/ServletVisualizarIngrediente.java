package com.example.lumi.Servlet.Ingrediente;

import com.example.lumi.DAO.IngredienteDAO;
import com.example.lumi.Model.Ingrediente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/ingredientes")
public class ServletVisualizarIngrediente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // instanciando o objeto da classe IngredienteDAO para ter acesso ao método de buscar
        IngredienteDAO ingredienteDAO = new IngredienteDAO();

        // buscando as informações aqui para quando entrar na hora página as informações já estiverem carregadas
        List<Ingrediente> listaIngredientes = ingredienteDAO.buscarIngrediente();
        request.setAttribute("ingredientes-lista", listaIngredientes);

        // redirecionando do portal para a página de ingrediente
        request.getRequestDispatcher("WEB-INF/view/ingredientes.jsp").forward(request, response);
    }
}

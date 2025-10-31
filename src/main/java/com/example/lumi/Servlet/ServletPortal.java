package com.example.lumi.Servlet;

import com.example.lumi.DAO.*;
import com.example.lumi.Model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/portal")
public class ServletPortal extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // buscando 3 ingredientes
        IngredienteDAO ingredienteDAO = new IngredienteDAO();
        List<Ingrediente> listaIngredientes = ingredienteDAO.buscarIngredientePortal();
        request.setAttribute("ingredientes-lista", listaIngredientes);

        // buscando 3 alergias
        AlergiaDAO alergiaDAO = new AlergiaDAO();
        List<Alergia> listaAlergias = alergiaDAO.buscarAlergiaPortal();

        // setando a lista como atributo
        request.setAttribute("alergias-lista", listaAlergias);

        // buscando 3 clientes
        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> listaClientes = clienteDAO.buscarClientePortal();

        // setando a lista como atributo
        request.setAttribute("clientes-lista", listaClientes);

        // buscando 3 indústrias
        IndustriaDAO industriaDAO = new IndustriaDAO();
        TelefoneIndustriaDAO telefoneIndustriaDAO = new TelefoneIndustriaDAO();

        List<Industria> listaIndustrias = industriaDAO.buscarIndustriaPortal();
        List<List> listaTelefones = new ArrayList<>();

        for (int i = 0; i < listaIndustrias.size(); i++) {
            int idIndustria = listaIndustrias.get(i).getId();
            listaTelefones.add(telefoneIndustriaDAO.buscarTelefone(idIndustria));
        }

        // setando as listas como atributo
        request.setAttribute("industrias-lista", listaIndustrias);
        request.setAttribute("telefones-lista", listaTelefones);

        // buscando 3 produtos
        ProdutoDAO produtoDAO = new ProdutoDAO();
        InformacaoNutricionalDAO informacaoNutricionalDAO = new InformacaoNutricionalDAO();

        List<Produto> listaProdutos = new ArrayList<>();
        List<Industria> listaNomeIndustria = new ArrayList<>();
        List<InformacaoNutricional> listaInfoNutri = new ArrayList<>();

        listaProdutos = produtoDAO.buscarProdutoPortal();
        listaInfoNutri = informacaoNutricionalDAO.buscarInfoNutri();
        for (int i = 0; i < listaProdutos.size(); i++) {
            Industria industria = industriaDAO.buscarNomeIndustria(listaProdutos.get(i).getIdIndustria());
            listaNomeIndustria.add(industria);
        }

        // setando as listas como atributo
        request.setAttribute("produtos-lista", listaProdutos);
        request.setAttribute("nomeIndustria-lista", listaNomeIndustria);
        request.setAttribute("infoNutri-lista", listaInfoNutri);

        // redirecionando o usuário para a página do portal
        request.getRequestDispatcher("WEB-INF/view/portal.jsp").forward(request, response);
    }
}

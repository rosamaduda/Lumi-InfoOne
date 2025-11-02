package com.example.lumi.Servlet.Ingrediente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.lumi.DAO.AlergiaDAO;
import com.example.lumi.DAO.AlergiaIngredienteDAO;
import com.example.lumi.DAO.ClienteAlergiaDAO;
import com.example.lumi.DAO.IngredienteDAO;
import com.example.lumi.Model.Alergia;
import com.example.lumi.Model.AlergiaIngrediente;
import com.example.lumi.Model.Ingrediente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/alteracao-ingrediente", "/alterar-ingrediente"})
public class ServletEditarIngrediente extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IngredienteDAO ingredienteDAO = new IngredienteDAO();
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        if (caminho.equals("/alteracao-ingrediente")) {
            // recebendo o id que vai ser alterado
            int idIngrediente = Integer.parseInt(request.getParameter("idIngrediente"));

            // setando o id no model
            Ingrediente ingrediente = new Ingrediente(idIngrediente);

            // buscando as informações do id para poder setar como atributos
            ingrediente = ingredienteDAO.buscarIngrediente(ingrediente);
            AlergiaIngredienteDAO alergiaIngredienteDAO = new AlergiaIngredienteDAO();
            List<AlergiaIngrediente> listaIdAlergias = alergiaIngredienteDAO.buscarAlergiaIngrediente(idIngrediente);

            // pega as alergias selecionadas do ingrediente
            AlergiaDAO alergiaDAO = new AlergiaDAO();
            List<String> listaAlergias = new ArrayList<>();
            for (int i = 0; i < listaIdAlergias.size(); i++) {
                List<Alergia> alergiasDoIngrediente = alergiaDAO.buscarNomeAlergia(listaIdAlergias.get(i).getIdAlergia());
                if (alergiasDoIngrediente != null && !alergiasDoIngrediente.isEmpty()) {
                    for (int j = 0; j < alergiasDoIngrediente.size(); j++) {
                        listaAlergias.add(alergiasDoIngrediente.get(j).getNome());
                    }
                }
            }

            // pega todas as alergias do bd
            List<Alergia> alergias = alergiaDAO.buscarAlergia();
            List<String> todasAlergias = new ArrayList<>();
            for (int i = 0; i < alergias.size(); i++){
                todasAlergias.add(alergias.get(i).getNome());
            }

            // setando os atributos
            request.setAttribute("idIngrediente", ingrediente.getId());
            request.setAttribute("nomeIngrediente", ingrediente.getNome());
            request.setAttribute("descricaoIngrediente", ingrediente.getDescricao());
            request.setAttribute("alergiasLista", listaAlergias);
            request.setAttribute("todas-alergias", todasAlergias);

            request.getRequestDispatcher("WEB-INF/view/editar_ingredientes.jsp").forward(request, response); // redirecionando para a página de editar
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IngredienteDAO ingredienteDAO = new IngredienteDAO();
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        if (caminho.equals("/alterar-ingrediente")) {
            // recebendo os parâmetros do form
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");

            // deleta alergias antigas e inserir novas
            AlergiaIngredienteDAO alergiaIngredienteDAO = new AlergiaIngredienteDAO();
            alergiaIngredienteDAO.deletarIngredienteAlergia(id);

            request.getParameterMap().forEach((key, value) -> {
                if (key.startsWith("alergia-")) {
                    String alergiaNome = request.getParameter(key).trim();
                    if (!alergiaNome.isEmpty()) {
                        AlergiaDAO alergiaDAO = new AlergiaDAO();
                        int idAlergia = alergiaDAO.buscarIdAlergia(alergiaNome);
                        alergiaIngredienteDAO.inserirAlergiaIngrediente(id, idAlergia);
                    }
                }
            });

            // instanciando o objeto
            Ingrediente ingrediente = new Ingrediente(id, nome, descricao);

            // alterando o ingrediente
            int retornoAlteracao = ingredienteDAO.alterarIngrediente(ingrediente);
            if (retornoAlteracao == 0 || retornoAlteracao == -1) {
                request.setAttribute("mensagemErro", "Não foi possível alterar o ingrediente");
                request.getRequestDispatcher("WEB-INF/view/erro,jsp").forward(request, response);
            }

            // redirecionando para a página de ingrediente novamente
            response.sendRedirect("ingredientes");
        }
    }
}
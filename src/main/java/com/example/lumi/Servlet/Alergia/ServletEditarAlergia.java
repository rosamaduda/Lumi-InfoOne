package com.example.lumi.Servlet.Alergia;

import com.example.lumi.DAO.AlergiaDAO;
import com.example.lumi.Model.Alergia;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/alteracao-alergia", "/alterar-alergia"})
public class ServletEditarAlergia extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlergiaDAO alergiaDAO = new AlergiaDAO();
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        if (caminho.equals("/alteracao-alergia")) {
            // recebendo o ID da alergia que será alterada
            int idAlergia = Integer.parseInt(request.getParameter("idAlergia"));

            // setando o id no model
            Alergia alergia = new Alergia(idAlergia);

            // buscando as informações do id para poder setar como atributos
            alergia = alergiaDAO.buscarAlergia(alergia);

            // setando os atributos
            request.setAttribute("idAlergia", alergia.getId());
            request.setAttribute("nomeAlergia", alergia.getNome());
            request.setAttribute("descricaoAlergia", alergia.getDescricao());
            request.setAttribute("alergenoAlergia", alergia.getAlergeno());

            request.getRequestDispatcher("WEB-INF/view/editar_alergias.jsp").forward(request, response); // redirecionando para a página de editar
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlergiaDAO alergiaDAO = new AlergiaDAO();
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        if (caminho.equals("/alterar-alergia")) {
            // recebendo os parâmetros do form
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String alergeno = request.getParameter("alergeno");
            String descricao = request.getParameter("descricao");

            // setando os atributos do objeto
            Alergia alergia = new Alergia(id, nome, alergeno, descricao);

            // alterando a alergia
            int retornoAlteracao = alergiaDAO.alterarAlergia(alergia);
            if (retornoAlteracao == 0 || retornoAlteracao == -1) {
                request.setAttribute("mensagemErro", "Não foi possível alterar a alergia");
                request.getRequestDispatcher("WEB-INF/view/erro,jsp").forward(request, response);
            }

            // redirecionando para a página de alergia novamente
            response.sendRedirect("alergias");
        }
    }
}

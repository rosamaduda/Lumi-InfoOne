package com.example.lumi.Servlet.Ingrediente;

<<<<<<< HEAD
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.lumi.DAO.AlergiaDAO;
import com.example.lumi.DAO.AlergiaIngredienteDAO;
=======
import com.example.lumi.DAO.AlergiaDAO;
>>>>>>> bd9944fed420d778f0dfe78e5f8811384e25d523
import com.example.lumi.DAO.IngredienteDAO;
import com.example.lumi.Model.Alergia;
import com.example.lumi.Model.Ingrediente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

<<<<<<< HEAD
=======
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

>>>>>>> bd9944fed420d778f0dfe78e5f8811384e25d523
@WebServlet(urlPatterns={"/cadastro-ingrediente", "/adicionar-ingrediente"})
public class ServletAdicionarIngrediente extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        if (caminho.equals("/cadastro-ingrediente")) {
<<<<<<< HEAD
            // Faz lista de alergias
             AlergiaDAO alergiaDAO = new AlergiaDAO();
            List<Alergia> alergiasOp = alergiaDAO.buscarAlergia();
            request.setAttribute("alergias-lista", alergiasOp);
=======
            // buscando as alergias para colocar no dropdown
            AlergiaDAO alergiaDAO = new AlergiaDAO();
            List<Alergia> listaAlergia = alergiaDAO.buscarNomeAlergia();

            request.setAttribute("alergias-lista", listaAlergia); // setando a lista de alergia como atributo

>>>>>>> bd9944fed420d778f0dfe78e5f8811384e25d523
            request.getRequestDispatcher("WEB-INF/view/cadastro_ingredientes.jsp").forward(request, response); // redirecionando para a página
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

            Alergia alergia;
            List<Alergia> listaAlergias = new ArrayList<>();
            for (int i = 1; i < 1000; i++) {
                if (request.getParameter("alergia-"+i) != null) {
                    alergia = new Alergia(request.getParameter("alergia-"+i));
                } else {
                    break;
                }
                listaAlergias.add(alergia);
            }

            // instanciando o objeto
            Ingrediente ingrediente = new Ingrediente(id, nome, descricao);

            // alterando o ingrediente
            ingredienteDAO.alterarIngrediente(ingrediente);

                // Pega as alergias escolhidas do formulário
                List<Integer> idAlergias = new ArrayList<>();
                for (int i = 0; i < 1000; i++){
                    String idAlergiaStr = request.getParameter("alergia-" + i);
                    if (idAlergiaStr != null && !idAlergiaStr.isEmpty()){
                        idAlergias.add(Integer.parseInt(idAlergiaStr));
                    } else{
                        break;
                    }
                }
    
                // Adicionando relação
                if (!idAlergias.isEmpty()){
                    AlergiaIngredienteDAO alergiaIngredienteDAO = new AlergiaIngredienteDAO();
                    for (int i = 0; i < idAlergias.size(); i++){
                        int idAlergia = idAlergias.get(i);
                        alergiaIngredienteDAO.inserirAlergiaIngrediente(id, idAlergia);
                    }
                }

            // redirecionando para a página de ingrediente novamente
            response.sendRedirect("ingredientes");

        }
    }
}

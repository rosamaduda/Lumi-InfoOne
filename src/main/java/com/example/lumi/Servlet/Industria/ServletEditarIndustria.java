package com.example.lumi.Servlet.Industria;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.lumi.DAO.IndustriaDAO;
import com.example.lumi.DAO.PlanoDAO;
import com.example.lumi.DAO.TelefoneIndustriaDAO;
import com.example.lumi.Model.Industria;
import com.example.lumi.Model.Plano;
import com.example.lumi.Model.TelefoneIndustria;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/alteracao-industria", "/alterar-industria"})
public class ServletEditarIndustria extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath(); // recebendo o caminho do usuário
        IndustriaDAO industriaDAO = new IndustriaDAO();
      

        if (caminho.equals("/alteracao-industria")) {
            // buscando os nomes dos planos
            PlanoDAO planoDAO = new PlanoDAO();
            List<Plano> listaPlanos = planoDAO.buscarNomePlano();
            request.setAttribute("planos-lista", listaPlanos);

            int idIndustria = Integer.parseInt(request.getParameter("idIndustria")); // recebendo o ID da industria que será alterado
            Industria industria = new Industria(idIndustria); // setando o id no model
            industria = industriaDAO.buscarIndustria(industria);// buscando as informações do id para poder setar como atributos

            TelefoneIndustriaDAO telefoneDAO = new TelefoneIndustriaDAO();
            List<TelefoneIndustria> telefonesSalvos = telefoneDAO.buscarTelefone(idIndustria); // buscando os telefones

            List<String> numeroTelefones = new ArrayList<>();
            for (int i = 0; i < telefonesSalvos.size(); i++) {
                numeroTelefones.add(telefonesSalvos.get(i).getTelefone());
            }

            // setando os atributos
            request.setAttribute("idIndustria", industria.getId());
            request.setAttribute("cnpjIndustria", industria.getCnpj());
            request.setAttribute("nomeIndustria", industria.getNome());
            request.setAttribute("emailIndustria", industria.getEmail());
            request.setAttribute("objetivoIndustria", industria.getObjetivo());
            request.setAttribute("senhaIndustria", industria.getSenha());
            request.setAttribute("planoIndustria", industria.getNomePlano());
            request.setAttribute("telefonesIndustria", numeroTelefones);

            request.getRequestDispatcher("WEB-INF/view/editar_industria.jsp").forward(request, response); // redirecionando para a página de editar
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath(); // recebendo o caminho do usuário
        IndustriaDAO industriaDAO = new IndustriaDAO();

        if (caminho.equals("/alterar-industria")) {
            // recebendo os parâmetros do form
            int id = Integer.parseInt(request.getParameter("id"));
            String email = request.getParameter("e-mail").trim();
            if (!email.matches("^[A-Za-z0-9]{1,}@[A-Za-z0-9]{1,}\\.[a-z]+")) {
                request.setAttribute("mensagemErro", "E-mail inválido");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
            }
            String cnpj = request.getParameter("cnpj").replaceAll("[^0-9]","").trim();
            if (!cnpj.matches("^[0-9]{2}\\.?[0-9]{3}\\.?[0-9]{3}\\/?[0-9]{4}\\-?[0-9]{2}$")) {
                request.setAttribute("mensagemErro", "CNPJ inválido");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
            }
            String nome = request.getParameter("nome").trim();
            String objetivo = request.getParameter("objetivo").trim();
            String senha = request.getParameter("senha");
            String plano = request.getParameter("plano");
            TelefoneIndustriaDAO telefoneDAO = new TelefoneIndustriaDAO();
            telefoneDAO.deletarTelIdIndustria(id);
            request.getParameterMap().forEach((key, value) -> {
                if (key.startsWith("telefone-")) {
                    String tel = request.getParameter(key).replaceAll("[^0-9]", "");
                    if (!tel.isEmpty()) {
                        telefoneDAO.adicionarTelIndustria(new TelefoneIndustria(0, tel, id));
                    }
                }
            });

            // instanciando o objeto
            Industria industria = new Industria(id, cnpj, nome, objetivo, email, senha, plano);

            // fazendo a alteração
            int retornoAlteracao = industriaDAO.alterarIndustria(industria);
            if (retornoAlteracao == 0 || retornoAlteracao == -1) {
                request.setAttribute("mensagemErro", "Não foi possível alterar a indústria");
                request.getRequestDispatcher("WEB-INF/view/erro,jsp").forward(request, response);
            }

            // redirecionando para a página de industrias
            response.sendRedirect("industrias");
        }
    }
}

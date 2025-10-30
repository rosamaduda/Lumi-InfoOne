package com.example.lumi.DAO;

import com.example.lumi.Conexao.Conexao;
import com.example.lumi.Model.Industria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class IndustriaDAO {
    // INSERIR
    public int inserirIndustria(Industria industria) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // conectando o BD

        try {
            String instrucaoSQL = "INSERT INTO INDUSTRIA (CNPJ, NOME, OBJETIVO, EMAIL, SENHA, NOME_PLANO) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando parâmetros da instrução
            pstmt.setString(1, industria.getCnpj());
            pstmt.setString(2, industria.getNome());
            pstmt.setString(3, industria.getObjetivo());
            pstmt.setString(4, industria.getEmail());
            pstmt.setString(5, industria.getSenha());
            pstmt.setString(6, industria.getNomePlano());

            if (pstmt.executeUpdate() > 0) { // realizando a instrução e verificando o retorno
                return 1; // realizou a instrução
            } else {
                return 0; // não realizou a instrução
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
    } // inserirIndustria()

    // ALTERAR
    public int alterarCnpjIndustria(int id, String cnpj) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexao com o BD

        try {
            String instrucaoSQL = "UPDATE INDUSTRIA SET CNPJ = ? WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, cnpj);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() > 0) {
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // algum outro problema aconteceu
        } finally {
            conexao.desconectar(conn); // desconecta do BD
        }
    } // alterarCnpjIndustria()

    public int alterarNomeIndustria(int id, String nome) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // conectando o BD

        try {
            String instrucaoSQL = "UPDATE INDUSTRIA SET NOME = ? WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, nome);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() > 0) {
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // algum outro problema aconteceu
        } finally {
            conexao.desconectar(conn); // desconecta do BD
        }
    } // alterarNomeIndustria()


    public int alterarObjetivoIndustria(int id, String objetivo) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // conectando o BD

        try {
            String instrucaoSQL = "UPDATE INDUSTRIA SET OBJETIVO = ? WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, objetivo);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() > 0) {
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // algum outro problema aconteceu
        } finally {
            conexao.desconectar(conn); // desconecta do BD
        }
    } // alterarDescricaoIndustria()


    public int alterarEmailIndustria(int id, String email) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexao com o BD

        try {
            String instrucaoSQL = "UPDATE INDUSTRIA SET EMAIL = ? WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, email);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() > 0) {
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // algum outro problema aconteceu
        } finally {
            conexao.desconectar(conn); // desconecta do BD
        }
    } // alterarEmailIndustria()

    public int alterarPlanoIndustria(int id, String nomePlano) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "UPDATE INDUSTRIA SET NOME_PLANO = ? WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, nomePlano);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() > 0) {
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectando do BD
        }
    } // alterarPlanoIndustria()

    public int alterarIndustria(Industria industria) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "UPDATE INDUSTRIA SET CNPJ = ?, NOME = ?, OBJETIVO = ?, EMAIL = ?, SENHA = ?, NOME_PLANO = ? WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando parâmetros da instrução
            pstmt.setString(1, industria.getCnpj());
            pstmt.setString(2, industria.getNome());
            pstmt.setString(3, industria.getObjetivo());
            pstmt.setString(4, industria.getEmail());
            pstmt.setString(5, industria.getSenha());
            pstmt.setString(6, industria.getNomePlano());
            pstmt.setInt(7, industria.getId());

            if (pstmt.executeUpdate() > 0) { // executando a instrução e verificando o retorno
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectando do BD
        }
    } // alterarIndustria(Industria industria)

    // DELETAR
    public int deletarIndustria(int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexao com o BD

        try {
            String instrucaoSQL = "DELETE FROM INDUSTRIA WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando os parâmetros
            pstmt.setInt(1, id);
            if (pstmt.executeUpdate() > 0) { // executando a instrução
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
    } // deletarIndustria(int id)

    // SELECIONAR
    public List<Industria> buscarIndustria() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Industria> listaIndustrias = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM INDUSTRIA I";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Industria industria = new Industria(rset.getInt("id"), rset.getString("cnpj"), rset.getString("nome"),
                        rset.getString("objetivo"), rset.getString("email"), rset.getString("senha"), rset.getString("nome_plano"));
                listaIndustrias.add(industria); // adicionando o objeto à lista
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return listaIndustrias;
    } // buscarIndustria()

    public List<Industria> buscarNomeIndustria() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Industria> industrias = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT NOME FROM INDUSTRIA I";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Industria industria = new Industria(rset.getString("nome"));
                industrias.add(industria); // adicionando o objeto à lista
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return industrias;
    } // buscarNomeIndustria()

    public List<Industria> buscarIndustriaPorNome(String nome) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Industria> listaIndustrias = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM INDUSTRIA WHERE NOME LIKE ? ";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1,"%"+nome+"%"); // setando o parâmetro na instrução
            rset = pstmt.executeQuery(); // executando a query

            while (rset.next()) {
                Industria industria = new Industria(rset.getInt("id"), rset.getString("cnpj"), rset.getString("nome"),
                        rset.getString("objetivo"), rset.getString("email"), rset.getString("senha"), rset.getString("nome_plano"));
                listaIndustrias.add(industria); // adicionando o objeto à lista que será retornada
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return listaIndustrias;
    } // buscarIndustriaPorNome(String nome)

    // Limitar por 3 indústrias para mostrar no portal
    public List<Industria> buscarIndustriaPortal() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Industria> listaIndustrias = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM INDUSTRIA I ORDER BY ID DESC LIMIT 3";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Industria industria = new Industria(rset.getInt("id"), rset.getString("cnpj"), rset.getString("nome"),
                        rset.getString("objetivo"), rset.getString("email"), rset.getString("senha"), rset.getString("nome_plano"));
                listaIndustrias.add(industria); // adicionando o objeto à lista
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return listaIndustrias;
    } // buscarIndustriaPortal()

    public List<Industria> buscarIndustriaPorPlano(String plano){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Industria> listaIndustrias = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM INDUSTRIA WHERE NOME_PLANO LIKE ? ";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1,"%"+plano+"%"); // setando o parâmetro da instrução
            rset = pstmt.executeQuery(); // executando a query

            while (rset.next()) {
                Industria industria = new Industria(rset.getInt("id"), rset.getString("cnpj"), rset.getString("nome"),
                        rset.getString("objetivo"), rset.getString("senha"));
                listaIndustrias.add(industria); // adicionando o objeto à lista que será retornada
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return listaIndustrias;
    }

    public int buscarIdIndustria() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        int id = -1;

        try {
            String instrucaoSQL = "SELECT ID FROM INDUSTRIA ORDER BY 1 DESC LIMIT 1";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                id = rset.getInt("id");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return id;
    } // buscarIdIndustria()

    public Industria buscarIndustria(Industria industria) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;

        try {
            String instrucaoSQL = "SELECT * FROM INDUSTRIA WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1, industria.getId()); // setando os parâmetros da instrução
            rset = pstmt.executeQuery(); // executando a query

            while (rset.next()) {
                industria = new Industria(rset.getInt("id"), rset.getString("cnpj"), rset.getString("nome"), rset.getString("objetivo"), rset.getString("email"), rset.getString("senha"), rset.getString("nome_plano"));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
        return industria;
    } // buscarNomeIndustria(Industria industria)


    public Industria buscarNomeIndustria(int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        Industria industria = null;

        try {
            String instrucaoSQL = "SELECT NOME FROM INDUSTRIA WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1, id); // setando os parâmetros da instrução
            rset = pstmt.executeQuery(); // executando a query

            while (rset.next()) {
                industria = new Industria(rset.getString("nome"));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
        return industria;
    } // buscarNomeIndustria(int id)

    public int buscarIdIndustria(String nome) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        int idIndustria = -1;
        ResultSet rset;

        try {
            String instrucaoSQL = "SELECT ID FROM INDUSTRIA WHERE NOME LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, "%"+nome+"%"); // setando os parâmetros da instrução
            rset = pstmt.executeQuery(); // executando a query

            while (rset.next()) {
                idIndustria = rset.getInt("id");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
        return idIndustria;
    } // buscarIdIndustria(String nome)

} // IndustriaDAO

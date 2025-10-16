package DAO;



import Conexao.Conexao;
import Model.Alergia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlergiaDAO {
    // INSERIR
    public int inserirAlergia(Alergia alergia) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "INSERT INTO ALERGIA (ALERGENO, NOME, DESCRICAO) VALUES(?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando os parâmetros da instrução
            pstmt.setString(1, alergia.getAlergeno());
            pstmt.setString(2, alergia.getNome());
            pstmt.setString(3, alergia.getDescricao());
            if (pstmt.executeUpdate() > 0) { // executando o comando e verificando o retorno
                return 1; // conseguiu realizar a instrução
            } else {
                return 0; // não foi possível realizar a instrução
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // fechando a conexão como BD
        }
    } // inserirAlergia()

    // ALTERAR
    public int alterarAlergia(Alergia alergia) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "UPDATE INGREDIENTE SET ALERGENO = ?, NOME = ?, DESCRICAO = ? WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando os parametros da instrucao
            pstmt.setString(1, alergia.getNome());
            pstmt.setString(2, alergia.getNome());
            pstmt.setString(3, alergia.getDescricao());
            pstmt.setInt(4, alergia.getId());

            if (pstmt.executeUpdate() > 0) { // executando o comando e verificando o retorno
                return 1; // conseguiu realizar a alteração
            } else {
                return 0; // não encontrou o registro
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }

    } // alterarAlergia()

    // DELETAR
    public int removerAlergia(int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexao com o BD

        try {
            // deletando os campos que recebem a pk
            String instrucaoSQL = "DELETE FROM CLIENTE_ALERGIA WHERE ID_ALERGIA = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            // deletando a alergia
            instrucaoSQL = "DELETE FROM ALERGIA WHERE ID = ?";
            pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1, id); // setando parametro na instrução
            if (pstmt.executeUpdate() > 0) { // // executando o comando e verificando o retorno
                return 1; // conseguiu deletar
            } else {
                return 0; // não encontrou o registro
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn);
        }
    } // removerAlergia()

    // SELECT
    public List<Alergia> buscarAlergia() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Alergia> lista = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM ALERGIA";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // realizando a query

            while (rset.next()) {
                Alergia alergia = new Alergia(rset.getInt("id"), rset.getString("alergeno"), rset.getString("nome"), rset.getString("descricao"));
                lista.add(alergia);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return lista;
    } // buscarAlergia()

    public List<Alergia> buscarNomeAlergia() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Alergia> alergias = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT nome FROM alergia";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // realizando a query

            while (rset.next()) {
                Alergia alergia = new Alergia(rset.getString("nome"));
                alergias.add(alergia);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return alergias;
    } // buscarAlergia()
}


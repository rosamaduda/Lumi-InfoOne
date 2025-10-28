package com.example.lumi.DAO;

import com.example.lumi.Conexao.Conexao;
import com.example.lumi.Model.Avaliacao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoDAO {
    // INSERIR
    public int inserirAvaliacao(Avaliacao avaliacao){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco de dados

        try {
            String instrucaoSQL= "INSERT INTO AVALIACAO (NOTAS, AVALIACAO, DT_AVALIACAO, EMAIL_CLIENTE, ID_PRODUTO) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setInt(1, avaliacao.getNota());
            pstmt.setString(2, avaliacao.getAvaliacao());
            pstmt.setObject(3, avaliacao.getDataAvaliacao());
            pstmt.setString(4, avaliacao.getEmailCliente());
            pstmt.setInt(5, avaliacao.getIdProduto());
            if (pstmt.executeUpdate() > 0){
                return 1; // conseguiu realizar a instrução
            } else {
                return 0; // não conseguiu realizar a instrução
            }
        } catch (SQLException e){
            e.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
    } // inserirAvaliacao()

    // ALTERAR
    public int alterarAvaliacao(Avaliacao avaliacao) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "UPDATE AVALIACAO SET NOTA = ?, AVALIACAO = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando os parametros da instrucao
            pstmt.setInt(1, avaliacao.getNota());
            pstmt.setString(2, avaliacao.getAvaliacao());
            pstmt.setInt(3,avaliacao.getId());
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
    } // alterarAvaliacao()

    // DELETAR
    public int removerAvaliacao(int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexao com o BD

        try {
            String instrucaoSQL = "DELETE FROM AVALIACAO WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
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
            conexao.desconectar(conn); // desconectando o BD
        }
    } // removerAvaliacao()

    public int removerAvaliacao(String emailCliente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexao com o BD

        try {
            String instrucaoSQL = "DELETE FROM AVALIACAO WHERE EMAIL_CLIENTE = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, emailCliente); // setando parametro na instrução
            if (pstmt.executeUpdate() > 0) { // // executando o comando e verificando o retorno
                return 1; // conseguiu deletar
            } else {
                return 0; // não encontrou o registro
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
    } // removerAvaliacao()

    // SELECT
    public List<Avaliacao> buscarAvaliacao() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Avaliacao> avaliacoes = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT A.*, C.EMAIL, P.NOME AS NOME_PRODUTO FROM AVALIACAO A JOIN CLIENT C ON A.EMAIL_CLIENTE = C.EMAIL JOIN PRODUTO P ON A.ID_CLIENTE = P.ID";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // realizando a query

            while (rset.next()) {
                Avaliacao avaliacao = new Avaliacao(rset.getInt("id"), rset.getInt("NOTA"), rset.getString("AVALIACAO"), rset.getObject("DT_AVALIACAO", LocalDate.class),rset.getString("EMAIL_CLIENTE"),rset.getInt("NOME_PRODUTO"));
                avaliacoes.add(avaliacao); // adicionando o objeto à lista que será retornada
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return avaliacoes;
    } // buscarAvaliacao()
}

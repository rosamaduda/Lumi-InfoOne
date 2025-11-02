package com.example.lumi.DAO;

import com.example.lumi.Conexao.Conexao;
import com.example.lumi.Model.Avaliacao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoDAO {
    // DELETAR
    public int deletarAvaliacaoPorEmail(String emailCliente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexao com o BD

        try {
            String instrucaoSQL = "DELETE FROM AVALIACAO WHERE EMAIL_CLIENTE = ?"; // deletando a avaliaçõa a partir do email do cliente para nao dar problema na hora de remover o cliente
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
    } // deletarAvaliacaoPorEmail(String emailCliente)

    public int deletarAvaliacaoPorCodigo(String codigoBarras) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexao com o BD

        try {
            String instrucaoSQL = "DELETE FROM AVALIACAO WHERE COD_BARRAS_PRODUTO = ?"; // deletando a avaliaçõa a partir do email do cliente para nao dar problema na hora de remover o cliente
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, codigoBarras); // setando parametro na instrução
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
    } // deletarAvaliacaoPorCodigo(String codigoBarras)
} // AvaliacaoDAO

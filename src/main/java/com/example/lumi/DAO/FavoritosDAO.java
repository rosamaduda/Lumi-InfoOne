package com.example.lumi.DAO;

import com.example.lumi.Conexao.Conexao;
import com.example.lumi.Model.Favorito;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FavoritosDAO {
    // DELETAR
    public int deletarFavorito(String emailCliente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // conectando o BD

        try {
            String instrucaoSQL = "DELETE FROM FAVORITO WHERE EMAIL_CLIENTE = ? "; // deletando o favorito pela pk do cliente para nao ter problema quando remover o cliente
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando os parâmetros da instrução
            pstmt.setString(1, emailCliente);
            if (pstmt.executeUpdate() > 0) {
                return 1; // conseguiu realizar a instrução
            } else {
                return 0; // não encontrou o registro
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
    } // deletarFavorito()

    public int deletarFavoritoPorCodigo(String codigoBarras) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // conectando o BD

        try {
            String instrucaoSQL = "DELETE FROM FAVORITO WHERE COD_BARRAS_PRODUTO = ? "; // deletando o favorito pela pk do cliente para nao ter problema quando remover o cliente
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando os parâmetros da instrução
            pstmt.setString(1, codigoBarras);
            if (pstmt.executeUpdate() > 0) {
                return 1; // conseguiu realizar a instrução
            } else {
                return 0; // não encontrou o registro
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
    } // deletarFavoritoPorCodigo(String codigoBarras)
    }//favoritosDAO
package com.example.lumi.DAO;

import com.example.lumi.Conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoIngredienteDAO {
    public int removerProdutoIngrediente(int idIngrediente){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "DELETE FROM PRODUTO_INGREDIENTE WHERE ID_INGREDIENTE = ?";
            PreparedStatement pstm = conn.prepareStatement(instrucaoSQL);
            pstm.setInt(1, idIngrediente); // setando os parâmetros da instrução

            if (pstm.executeUpdate() > 0){ // executando a instrução e verificando o retorno
                return 1; // conseguiu realizar a instrução
            } else {
                return 0; // não realizou a instrução
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // fechando a conexão
        }
    } // removerProdutoIngrediente(int idIngrediente)
} // ProdutoIngredienteDAO

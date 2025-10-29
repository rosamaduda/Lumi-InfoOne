package com.example.lumi.DAO;

import com.example.lumi.Conexao.Conexao;
import com.example.lumi.Model.Plano;
import com.example.lumi.Model.Produto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlanoDAO {
    public List<Plano> buscarNomePlano() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        ResultSet rset;
        List<Plano> planos = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT NOME FROM PLANO";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Plano plano = new Plano(rset.getString("nome"));
                planos.add(plano);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando do BD
        }
        return planos;
    }

    public static class ProdutoDAO {
        public List<Produto> buscarNomeProduto() {
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar(); // abrindo a conexão com o BD
            ResultSet rset;
            List<Produto> produtos = new ArrayList<>();

            try {
                String instrucaoSQL = "SELECT NOME FROM PRODUTO";
                Statement stmt = conn.createStatement();
                rset = stmt.executeQuery(instrucaoSQL); // realizando a query

                while (rset.next()) {
                    Produto produto = new Produto(rset.getString("nome"));
                    produtos.add(produto);
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } finally {
                conexao.desconectar(conn); // desconectando o BD
            }
            return produtos;
        }




        public List<Produto> buscarCodigoProduto(){
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar(); // abrindo a conexão com o BD
            ResultSet rset;
            List<Produto> produtos = new ArrayList<>();

            try {
                String instrucaoSQL = "SELECT CODIGO_BARRAS FROM PRODUTO";
                Statement stmt = conn.createStatement();
                rset = stmt.executeQuery(instrucaoSQL); // realizando a query

                while (rset.next()) {
                    Produto produto = new Produto(rset.getInt("codigo_barras"));
                    produtos.add(produto);
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } finally {
                conexao.desconectar(conn); // desconectando o BD
            }
            return produtos;

        }
    } // ProdutoDAO
} // PlanoDAO

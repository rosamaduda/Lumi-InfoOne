package DAO;

import Conexao.Conexao;
import Model.Alergia;
import Model.Produto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
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

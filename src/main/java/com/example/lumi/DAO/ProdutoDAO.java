package com.example.lumi.DAO;

import com.example.lumi.Conexao.Conexao;
import com.example.lumi.Model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public int adicionarProduto(Produto produto){
        Conexao conexao=new Conexao();
        Connection conn= conexao.conectar();
        try{
            String instrucaoSQL="INSERT INTO PRODUTO (CODIGO_BARRAS,NOME,FABRICANTE,DESCRICAO,MASSA,ID_INDUSTRIA,ID_INFO_NUTRI) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pstmt= conn.prepareStatement(instrucaoSQL);
            pstmt.setLong(1,produto.getCodigoBarras());
            pstmt.setString(2,produto.getNome());
            pstmt.setString(3,produto.getFabricante());
            pstmt.setString(4,produto.getDescricao());
            pstmt.setDouble(5,produto.getMassa());
            pstmt.setInt(6,produto.getIdIndustria());
            pstmt.setInt(7,produto.getIdInfoNutri());
            if (pstmt.executeUpdate()>0){
                return 1;
            }
            else {
                return 0;
            }
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
            return -1;
        }
        finally {
            conexao.desconectar(conn);
        }
    }

    public int alterarProduto(Produto produto){
        Conexao conexao=new Conexao();
        Connection conn= conexao.conectar();
        try{
           String instrucaoSQL="UPDATE PRODUTO SET NOME=?,FABRICANTE=?,DESCRICAO=?,MASSA=? WHERE CODIGO_BARRAS=?";
           PreparedStatement pstmt= conn.prepareStatement(instrucaoSQL);
           pstmt.setString(1,produto.getNome());
           pstmt.setString(2,produto.getFabricante());
           pstmt.setString(3,produto.getDescricao());
           pstmt.setDouble(4,produto.getMassa());
           pstmt.setLong(5,produto.getCodigoBarras());
           if(pstmt.executeUpdate()>0){
               return 1;
           }
           else{
               return 0;
           }
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
            return -1;
        }
        finally {
            conexao.desconectar(conn);
        }
    }




    public int removerProduto(int codigoBarras){
        Conexao conexao=new Conexao();
        Connection conn= conexao.conectar();
        try{
            String instrucaoSQL="DELETE FROM PRODUTO WHERE CODIGO_BARRAS=?";
            PreparedStatement pstmt= conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1,codigoBarras);
            if (pstmt.executeUpdate()>0){
                return 1;
            }
            else {
                return 0;
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return -1;
        }
        finally {
            conexao.desconectar(conn);
        }
    }
    public int removerProdutoIndustria(int idIndustria) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD


        try {
            String instrucaoSQL = "DELETE FROM PRODUTO WHERE ID_INDUSTRIA = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1, idIndustria); // setando o parâmetro na instrução

            if (pstmt.executeUpdate() > 0) { // executando a instrução e verificando o retorno
                return 1; // conseguiu realizar a instrução
            } else {
                return 0; // não realizou a instrução
            }

        } catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectando o banco
        }
    }

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


    public List<Produto> buscarProduto(){
        Conexao conexao= new Conexao();
        Connection conn= conexao.conectar();
        List<Produto> lista=new ArrayList<>();
        ResultSet rset;
        try{
            String instrucaoSQL= "SELECT * FROM PRODUTO";
            Statement stmt= conn.createStatement();
            rset=stmt.executeQuery(instrucaoSQL);
            while (rset.next()){
                Produto produto=new Produto(rset.getLong("codigo_barras"),
                        rset.getString("nome"),
                        rset.getString("fabricante"),
                        rset.getString("descricao"),
                        rset.getDouble("massa"),
                        rset.getInt("id_industria"),
                        rset.getInt("id_info_nutri"));
                lista.add(produto);
            }
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
        }
        finally {
            conexao.desconectar(conn);
        }
        return lista;


    }


    public List<Produto> buscarProdutoPortal(){
        Conexao conexao= new Conexao();
        Connection conn= conexao.conectar();
        List<Produto> lista=new ArrayList<>();
        ResultSet rset;
        try{
            String instrucaoSQL= "SELECT * FROM PRODUTO LIMIT 3";
            Statement stmt= conn.createStatement();
            rset=stmt.executeQuery(instrucaoSQL);
            while (rset.next()){
                Produto produto=new Produto(rset.getLong("codigo_barras"),
                        rset.getString("nome"),
                        rset.getString("fabricante"),
                        rset.getString("descricao"),
                        rset.getDouble("massa"),
                        rset.getInt("id_industria"),
                        rset.getInt("id_info_nutri"));
                lista.add(produto);
            }
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
        }
        finally {
            conexao.desconectar(conn);
        }
        return lista;


    }

    public List<Produto> buscarProdutoPorNome(String nome){
        Conexao conexao= new Conexao();
        Connection conn= conexao.conectar();
        List<Produto> lista=new ArrayList<>();
        ResultSet rset;
        try{
            String instrucaoSQL= "SELECT * FROM PRODUTO WHERE NOME LIKE ?";
            PreparedStatement pstmt= conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1,"%"+nome+"%");
            rset=pstmt.executeQuery(instrucaoSQL);
            while (rset.next()){
                Produto produto=new Produto(rset.getLong("codigo_barras"),
                        rset.getString("nome"),
                        rset.getString("fabricante"),
                        rset.getString("descricao"),
                        rset.getDouble("massa"),
                        rset.getInt("id_industria"),
                        rset.getInt("id_info_nutri"));
                lista.add(produto);
            }
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
        }
        finally {
            conexao.desconectar(conn);
        }
        return lista;
    }


    public List<Produto> buscarProdutoPorCodBarras(String codBarras){
        Conexao conexao= new Conexao();
        Connection conn= conexao.conectar();
        List<Produto> lista=new ArrayList<>();
        ResultSet rset;
        try{
            String instrucaoSQL= "SELECT * FROM PRODUTO WHERE CAST(CODIGO_BARRAS AS VARCHAR) LIKE ?";
            PreparedStatement pstmt= conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1,"%"+codBarras+"%");
            rset=pstmt.executeQuery(instrucaoSQL);
            while (rset.next()){
                Produto produto=new Produto(rset.getLong("codigo_barras"),
                        rset.getString("nome"),
                        rset.getString("fabricante"),
                        rset.getString("descricao"),
                        rset.getDouble("massa"),
                        rset.getInt("id_industria"),
                        rset.getInt("id_info_nutri"));
                lista.add(produto);
            }
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
        }
        finally {
            conexao.desconectar(conn);
        }
        return lista;
    }


    public List<Produto> buscarProdutoPorFabricante(String fabricante){
        Conexao conexao= new Conexao();
        Connection conn= conexao.conectar();
        List<Produto> lista=new ArrayList<>();
        ResultSet rset;
        try{
            String instrucaoSQL= "SELECT * FROM PRODUTO WHERE FABRICANTE LIKE ?";
            PreparedStatement pstmt= conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1,"%"+fabricante+"%");
            rset=pstmt.executeQuery(instrucaoSQL);
            while (rset.next()){
                Produto produto=new Produto(rset.getLong("codigo_barras"),
                        rset.getString("nome"),
                        rset.getString("fabricante"),
                        rset.getString("descricao"),
                        rset.getDouble("massa"),
                        rset.getInt("id_industria"),
                        rset.getInt("id_info_nutri"));
                lista.add(produto);
            }
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
        }
        finally {
            conexao.desconectar(conn);
        }
        return lista;
    }

} // ProdutoDAO

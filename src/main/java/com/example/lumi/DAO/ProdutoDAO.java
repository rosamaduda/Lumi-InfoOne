package com.example.lumi.DAO;

import com.example.lumi.Conexao.Conexao;
import com.example.lumi.Model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    // INSERIR
    public int inserirProduto(Produto produto){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco

        try {
            // insere o registro do produto
            String instrucaoSQL = "INSERT INTO PRODUTO (CODIGO_BARRAS,NOME,FABRICANTE,DESCRICAO,MASSA,ID_INDUSTRIA,ID_INFO_NUTRI) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pstmt= conn.prepareStatement(instrucaoSQL);

            // setando os parâmetros da instrução
            pstmt.setString(1,produto.getCodigoBarras());
            pstmt.setString(2,produto.getNome());
            pstmt.setString(3,produto.getFabricante());
            pstmt.setString(4,produto.getDescricao());
            pstmt.setDouble(5,produto.getMassa());
            pstmt.setInt(6,produto.getIdIndustria());
            pstmt.setInt(7,produto.getIdInfoNutri());

            if (pstmt.executeUpdate() > 0) { // executando o comando e verificando o retorno
                return 1; // conseguiu realizar a instrução
            } else {
                return 0; // não foi possível realizar a instrução
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
    } // inserirProduto(Produto produto)

    // ALTERAR
    public int alterarProduto(Produto produto){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco

        try {
            // atualiza as informações do produto, com exceção do id da informação nutricional, porque a info. nutricional é atualizada na própria tabela
            String instrucaoSQL = "UPDATE PRODUTO SET NOME = ?, FABRICANTE = ?, DESCRICAO = ?, MASSA = ?, ID_INDUSTRIA = ? WHERE CODIGO_BARRAS=?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando os parâmetros da instrução
           pstmt.setString(1,produto.getNome());
           pstmt.setString(2,produto.getFabricante());
           pstmt.setString(3,produto.getDescricao());
           pstmt.setDouble(4,produto.getMassa());
           pstmt.setString(5,produto.getCodigoBarras());
           pstmt.setInt(6, produto.getIdIndustria());

            if (pstmt.executeUpdate() > 0) { // executando o comando e verificando o retorno
                return 1; // conseguiu realizar a instrução
            } else {
                return 0; // não foi possível realizar a instrução
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        }
        finally {
            conexao.desconectar(conn);
        }
    } // alterarProduto(Produto produto)

    // DELETAR
    public int deletarProduto(String codigoBarras) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco

        try {
            String instrucaoSQL = "DELETE FROM PRODUTO WHERE CODIGO_BARRAS = ?"; // deletando o produto pela pk
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, codigoBarras); // setando o parâmetro na instrução

            if (pstmt.executeUpdate() > 0) { // executando o comando e verificando o retorno
                return 1; // conseguiu realizar a instrução
            } else {
                return 0; // não foi possível realizar a instrução
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return -1;
        }
        finally {
            conexao.desconectar(conn);
        }
    }

    public int deletarProdutoIndustria(int idIndustria) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "DELETE FROM PRODUTO WHERE ID_INDUSTRIA = ?"; // deletando o produto a partir do id da indústria para conseguir excluir a industria sem problemas
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1, idIndustria); // setando o parâmetro na instrução

            if (pstmt.executeUpdate() > 0) { // executando o comando e verificando o retorno
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

    // BUSCAR
    public List<Produto> buscarNomeProduto() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Produto> listaProdutos = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT NOME FROM PRODUTO";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // realizando a query

            while (rset.next()) {
                Produto produto = new Produto(rset.getString("nome"));
                listaProdutos.add(produto); // adicionando o objeto à lista que será retornada
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return listaProdutos;
    }


    public List<Produto> buscarProduto(){
        Conexao conexao= new Conexao();
        Connection conn= conexao.conectar();
        List<Produto> listaProdutos=new ArrayList<>();
        ResultSet rset;

        try {
            String instrucaoSQL= "SELECT * FROM PRODUTO"; // procura todas as informações do produto
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a instrução

            while (rset.next()){
                Produto produto = new Produto(rset.getString("codigo_barras"),
                        rset.getString("nome"),
                        rset.getString("fabricante"),
                        rset.getString("descricao"),
                        rset.getDouble("massa"),
                        rset.getInt("id_industria"),
                        rset.getInt("id_info_nutri"));
                listaProdutos.add(produto);
            }
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
        }
        finally {
            conexao.desconectar(conn);
        }
        return listaProdutos;
    }

    public Produto buscarProduto(Produto produto){
        Conexao conexao= new Conexao();
        Connection conn= conexao.conectar();
        ResultSet rset;

        try {
            String instrucaoSQL = "SELECT * FROM PRODUTO WHERE CODIGO_BARRAS = ?"; // busca o produto a partir do código de barras
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, produto.getCodigoBarras()); // setando os parâmetros da instrução
            rset = pstmt.executeQuery(); // executando a instrução
            while (rset.next()){
                produto = new Produto(rset.getString("codigo_barras"),
                        rset.getString("nome"),
                        rset.getString("fabricante"),
                        rset.getString("descricao"),
                        rset.getDouble("massa"),
                        rset.getInt("id_industria"),
                        rset.getInt("id_info_nutri"));
            }
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
        }
        finally {
            conexao.desconectar(conn);
        }
        return produto;
    }

    public List<Produto> buscarProdutoPortal(){
        Conexao conexao= new Conexao();
        Connection conn= conexao.conectar();
        List<Produto> listaProdutos=new ArrayList<>();
        ResultSet rset;
        try{
            String instrucaoSQL = "SELECT * FROM PRODUTO LIMIT 3"; // busca apenas 3 produtos para colocar no portal
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a instrução

            while (rset.next()){
                Produto produto=new Produto(rset.getString("codigo_barras"),
                        rset.getString("nome"),
                        rset.getString("fabricante"),
                        rset.getString("descricao"),
                        rset.getDouble("massa"),
                        rset.getInt("id_industria"),
                        rset.getInt("id_info_nutri"));
                listaProdutos.add(produto);
            }
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
        }
        finally {
            conexao.desconectar(conn);
        }
        return listaProdutos;


    }

    public List<Produto> buscarProdutoPorNome(String nome){
        Conexao conexao= new Conexao();
        Connection conn= conexao.conectar();
        List<Produto> listaProdutos=new ArrayList<>();
        ResultSet rset;

        try {
            String instrucaoSQL = "SELECT * FROM PRODUTO WHERE NOME LIKE ?"; // busca o produto a partir do nome
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1,"%"+nome+"%"); // setando o parâmetro da instrução
            rset = pstmt.executeQuery(); // executando a instrução

            while (rset.next()) {
                Produto produto = new Produto(rset.getString("codigo_barras"),
                        rset.getString("nome"),
                        rset.getString("fabricante"),
                        rset.getString("descricao"),
                        rset.getDouble("massa"),
                        rset.getInt("id_industria"),
                        rset.getInt("id_info_nutri"));
                listaProdutos.add(produto);
            }
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
        }
        finally {
            conexao.desconectar(conn);
        }
        return listaProdutos;
    }


    public List<Produto> buscarProdutoPorCodBarras(String codBarras){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        List<Produto> listaProdutos = new ArrayList<>();
        ResultSet rset;
        try{
            String instrucaoSQL= "SELECT * FROM PRODUTO WHERE CAST(CODIGO_BARRAS AS VARCHAR) LIKE ?";
            PreparedStatement pstmt= conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1,"%"+codBarras+"%");
            rset=pstmt.executeQuery();
            while (rset.next()){
                Produto produto=new Produto(rset.getString("codigo_barras"),
                        rset.getString("nome"),
                        rset.getString("fabricante"),
                        rset.getString("descricao"),
                        rset.getDouble("massa"),
                        rset.getInt("id_industria"),
                        rset.getInt("id_info_nutri"));
                listaProdutos.add(produto);
            }
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
        }
        finally {
            conexao.desconectar(conn);
        }
        return listaProdutos;
    }


    public List<Produto> buscarProdutoPorFabricante(String fabricante){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        List<Produto> listaProdutos = new ArrayList<>();
        ResultSet rset;
        try{
            String instrucaoSQL= "SELECT * FROM PRODUTO WHERE FABRICANTE LIKE ?";
            PreparedStatement pstmt= conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1,"%"+fabricante+"%");
            rset=pstmt.executeQuery();
            while (rset.next()){
                Produto produto=new Produto(rset.getLong("codigo_barras"),
                        rset.getString("nome"),
                        rset.getString("fabricante"),
                        rset.getString("descricao"),
                        rset.getDouble("massa"),
                        rset.getInt("id_industria"),
                        rset.getInt("id_info_nutri"));
                listaProdutos.add(produto);
            }
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
        }
        finally {
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
        return listaProdutos;
    }

    public List<Produto> buscarProdutoPorIndustria(int idIndustria){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        List<Produto> listaProdutos = new ArrayList<>();
        ResultSet rset;
        try{
            String instrucaoSQL= "SELECT * FROM PRODUTO WHERE ID_INDUSTRIA = ?";
            PreparedStatement pstmt= conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1,idIndustria);
            rset=pstmt.executeQuery();

            while (rset.next()){
                Produto produto = new Produto(rset.getString("codigo_barras"),
                        rset.getString("nome"),
                        rset.getString("fabricante"),
                        rset.getString("descricao"),
                        rset.getDouble("massa"),
                        rset.getInt("id_industria"),
                        rset.getInt("id_info_nutri"));
                listaProdutos.add(produto);
            }
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
        }
        finally {
            conexao.desconectar(conn);
        }
        return listaProdutos;
    } // buscarProdutoPorIndustria(int idIndustria)

    public List<Produto> buscarProdutoPorMassa(double massa) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco
        List<Produto> listaProduto = new ArrayList<>();
        ResultSet rset;
        try{
            String instrucaoSQL= "SELECT * FROM PRODUTO WHERE MASSA = ?";
            PreparedStatement pstmt= conn.prepareStatement(instrucaoSQL);
            pstmt.setDouble(1,massa);
            rset=pstmt.executeQuery();
            while (rset.next()){
                Produto produto = new Produto(rset.getString("codigo_barras"),
                        rset.getString("nome"),
                        rset.getString("fabricante"),
                        rset.getString("descricao"),
                        rset.getDouble("massa"),
                        rset.getInt("id_industria"),
                        rset.getInt("id_info_nutri"));
                listaProduto.add(produto);
            }
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
        }
        finally {
            conexao.desconectar(conn);
        }
        return listaProduto;
    }

    public int buscarIdInfoNutri(String codigoBarras) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco
        int idInfoNutri = -1;
        ResultSet rset;

        try {
            String instrucaoSQL = "SELECT ID_INFO_NUTRI FROM PRODUTO WHERE CODIGO_BARRAS = ?"; // buscando o id da informação nutricional do produto a partir do codigo de barras
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, codigoBarras); // setando os parâmetros da instrução
            rset = pstmt.executeQuery(); // executando a instrução

            while (rset.next()){
                idInfoNutri = rset.getInt("id_info_nutri"); // recebendo o id da informação nutricional do produto
            }
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
        }
        finally {
            conexao.desconectar(conn);
        }
        return idInfoNutri;
    } // buscarIdInfoNutri(long codigoBarras)
} // ProdutoDAO

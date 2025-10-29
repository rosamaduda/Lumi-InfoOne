package com.example.lumi.DAO;

import com.example.lumi.Conexao.Conexao;
import com.example.lumi.Model.Ingrediente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngredienteDAO {
    // INSERIR
    public int inserirIngrediente(Ingrediente ingrediente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "INSERT INTO INGREDIENTE (NOME, DESCRICAO) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando parâmetros na instrução
            pstmt.setString(1, ingrediente.getNome());
            pstmt.setString(2, ingrediente.getDescricao());

            if (pstmt.executeUpdate() > 0) { // executando o comando e verificando o retorno
                return 1; // conseguiu realizar a instrução
            } else {
                return 0; // não foi possível realizar a instrução
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
    } // inserirIngrediente()

    // ALTERAR
    public int alterarNomeIngrediente(int id, String nome) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "UPDATE INGREDIENTE SET NOME = ? WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando os parâmetros
            pstmt.setString(1, nome);
            pstmt.setInt(2, id);

            if (pstmt.executeUpdate() > 0) { // executando o comando e verificando o retorno
                return 1; // conseguiu realizar a alteração
            } else {
                return 0; // não encontrou o registro
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        }
    } /// alterarDescricaoIngrediente()
    public int alterarDescricaoIngrediente(int id, String descricao) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "UPDATE INGREDIENTE SET DESCRICAO = ? WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando os parametros da instrucao
            pstmt.setString(1, descricao);
            pstmt.setInt(2, id);

            if (pstmt.executeUpdate() > 0) { // executando o comando e verificando o retorno
                return 1; // conseguiu realizar a alteração
            } else {
                return 0; // não encontrou o registro
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        }
    } /// alterarDescricaoIngrediente()

    public int alterarIngrediente(Ingrediente ingrediente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "UPDATE INGREDIENTE SET NOME = ?, DESCRICAO = ? WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando os parametros da instrucao
            pstmt.setString(1, ingrediente.getNome());
            pstmt.setString(2, ingrediente.getDescricao());
            pstmt.setInt(3, ingrediente.getId());

            if (pstmt.executeUpdate() > 0) { // executando o comando e verificando o retorno
                return 1; // conseguiu realizar a alteração
            } else {
                return 0; // não encontrou o registro
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        }
    }

    // DELETAR
    public int removerIngrediente(int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;

        try {
            String instrucaoSQL = "DELETE FROM INGREDIENTE WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1, id); // setando o parâmetro da instrução
            if (pstmt.executeUpdate() > 0) { // executando o comando e verificando o retorno
                return 1; // conseguiu executar a instrução
            } else {
                return 0; // não encontrou o registro
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectou o BD
        }
    } // removerIngrediente()

    // SELECT
    public List<Ingrediente> buscarIngrediente() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Ingrediente> lista = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM INGREDIENTE";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Ingrediente ingrediente = new Ingrediente(rset.getInt("id"), rset.getString("nome"), rset.getString("descricao"));
                lista.add(ingrediente);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);
        }
        return lista;
    } // buscarIngrediente()
    public Ingrediente buscarIngrediente(Ingrediente ingrediente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;

        try {
            String instrucaoSQL = "SELECT * FROM INGREDIENTE WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1, ingrediente.getId()); // setando os parâmetros da instrução
            rset = pstmt.executeQuery(); // executando a query

            while (rset.next()) {
                ingrediente = new Ingrediente(rset.getInt("id"), rset.getString("nome"), rset.getString("descricao"));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);
        }
        return ingrediente;
    } // buscarIngrediente(Ingrediente ingrediente)

    public List<Ingrediente> buscarIngredientePortal() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Ingrediente> lista = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM INGREDIENTE LIMIT 3 ORDER BY ID DESC";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Ingrediente ingrediente = new Ingrediente(rset.getInt("id"), rset.getString("nome"), rset.getString("descricao"));
                lista.add(ingrediente);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);
        }
        return lista;

    }


    public List<Ingrediente> buscarIngredientePorNome(String nome){
        Conexao conexao=new Conexao();
        Connection conn= conexao.conectar();
        ResultSet rset;
        List<Ingrediente> lista=new ArrayList<>();

        try{
            String instrucaoSQL="SELECT * FROM INGREDIENTE WHERE NOME LIKE ?";
            PreparedStatement pstmt= conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1,"%"+nome+"%");
            rset= pstmt.executeQuery();
            while (rset.next()){
                Ingrediente ingrediente=new Ingrediente(rset.getInt("id"),rset.getString("nome"),rset.getString("descricao"));
                lista.add(ingrediente);
            }

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
        finally {
            conexao.desconectar(conn);
        }
        return lista;
    }
} // IngredienteDAO
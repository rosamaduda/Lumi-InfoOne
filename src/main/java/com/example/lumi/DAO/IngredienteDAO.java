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
            String instrucaoSQL = "INSERT INTO INGREDIENTE (NOME, DESCRICAO) VALUES (?, ?)"; // inserindo o ingrediente
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
    public int alterarIngrediente(Ingrediente ingrediente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "UPDATE INGREDIENTE SET NOME = ?, DESCRICAO = ? WHERE ID = ?"; // alterando o ingrediente
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
    } // alterarIngrediente(Ingrediente ingrediente)

    // DELETAR
    public int deletarIngrediente(int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;

        try {
            String instrucaoSQL = "DELETE FROM INGREDIENTE WHERE ID = ?"; // deletando o ingrediente a partir do ID
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando o parâmetro da instrução
            pstmt.setInt(1, id);

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
        List<Ingrediente> listaIngredientes = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM INGREDIENTE"; // buscando todos os ingredientes
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Ingrediente ingrediente = new Ingrediente(rset.getInt("id"), rset.getString("nome"), rset.getString("descricao"));
                listaIngredientes.add(ingrediente); // adicionando à lista que será retornada
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
        return listaIngredientes;
    } // buscarIngrediente()
    public Ingrediente buscarIngrediente(Ingrediente ingrediente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;

        try {
            String instrucaoSQL = "SELECT * FROM INGREDIENTE WHERE ID = ?"; // buscando todos os ingredientes a partir do ID
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            pstmt.setInt(1, ingrediente.getId()); // setando os parâmetros da instrução
            rset = pstmt.executeQuery(); // executando a query

            while (rset.next()) {
                ingrediente = new Ingrediente(rset.getInt("id"), rset.getString("nome"), rset.getString("descricao"));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
        return ingrediente;
    } // buscarIngrediente(Ingrediente ingrediente)

    // Limitar por 3 ingredientes para mostrar no portal
    public List<Ingrediente> buscarIngredientePortal() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Ingrediente> listaIngredientes = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM INGREDIENTE ORDER BY ID DESC LIMIT 3"; // buscando os últimos 3 registros de ingrediente
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Ingrediente ingrediente = new Ingrediente(rset.getInt("id"), rset.getString("nome"), rset.getString("descricao"));
                listaIngredientes.add(ingrediente); // adicionando o objeto à lista que será retornada
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
        return listaIngredientes;
    } // buscarIngredientePortal()

    public int buscarIdIngrediente() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        int id = 0;

        try {
            String instrucaoSQL = "SELECT ID FROM INGREDIENTE ORDER BY 1 DESC LIMIT 1"; // buscando o ID do último ingrediente inserido
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                id = rset.getInt("id");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return id;
    } // buscarIdIndustria()

    public List<Ingrediente> buscarIngredientePorNome(String nome) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        ResultSet rset;
        List<Ingrediente> listaIngredientes = new ArrayList<>();

        try{
            String instrucaoSQL = "SELECT * FROM INGREDIENTE WHERE NOME LIKE ?"; // buscando o ingrediente pelo nome
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, "%"+nome+"%"); // setando o parâmetro da instrução
            rset = pstmt.executeQuery(); // executando a instrução

            while (rset.next()) {
                Ingrediente ingrediente = new Ingrediente(rset.getInt("id"),rset.getString("nome"),rset.getString("descricao"));
                listaIngredientes.add(ingrediente); // adicionando o objeto à lista que será retornada
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
        return listaIngredientes;
    } // buscarIngredientePorNome(String nome)
} // IngredienteDAO
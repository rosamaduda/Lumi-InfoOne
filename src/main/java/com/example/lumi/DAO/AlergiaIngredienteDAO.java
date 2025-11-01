package com.example.lumi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.lumi.Conexao.Conexao;
import com.example.lumi.Model.AlergiaIngrediente;

public class AlergiaIngredienteDAO {
    // INSERIR
    public int inserirAlergiaIngrediente(int idIngrediente, int idAlergia){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco

        try {
            String instrucaoSQL = "INSERT INTO ALERGIA_INGREDIENTE (ID_INGREDIENTE,ID_ALERGIA) VALUES (?,?)";
            PreparedStatement pstm = conn.prepareStatement(instrucaoSQL);

            // setando os parâmetros da instrução
            pstm.setInt(1, idIngrediente);
            pstm.setInt(2, idAlergia);

            if (pstm.executeUpdate() > 0) { // executando a instrução e verificando o retorno
                return 1; // realizou a instrução
            } else {
                return 0; // não realizou a instrução
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
    } // inserirAlergiaIngrediente(int idIngrediente, int idAlergia)

    // REMOVER
    public int deletarIngredienteAlergia(int idIngrediente,int idAlergia) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        try{
            String instrucaoSQL = "DELETE FROM ALERGIA_INGREDIENTE WHERE ID_INGREDIENTE=? AND ID_ALERGIA=? ";
            PreparedStatement pstm = conn.prepareStatement(instrucaoSQL);

            // setando os parâmetros da instrução
            pstm.setInt(1, idIngrediente);
            pstm.setInt(2, idAlergia);

            if (pstm.executeUpdate() > 0) { // executando a instrução e verificando o retorno
                return 1; // realizou a instrução
            } else {
                return 0; // não realizou a instrução
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
    } // DeletarIngredienteAlergia(int idIngrediente,int idAlergia)

    public int deletarAlergiaIngrediente(int idAlergia){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco

        try {
            String instrucaoSQL = "DELETE FROM ALERGIA_INGREDIENTE WHERE ID_ALERGIA=?"; // deletando o relacionaento a partir do id da alergia para nao dar problema na hora de remover a alergia
            PreparedStatement pstm = conn.prepareStatement(instrucaoSQL);

            pstm.setInt(1, idAlergia); // setando o parâmetro na instrução

            if (pstm.executeUpdate() > 0) { // executando a instrução e verificando o retorno
                return 1; // realizou a instrução
            } else {
                return 0; // não realizou a instrução
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
    } // removerAlergiaIngrediente(int idAlergia)

    public int deletarIngredienteAlergia(int idIngrediente){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            String instrucaoSQL = "DELETE FROM ALERGIA_INGREDIENTE WHERE ID_INGREDIENTE = ?"; // deletando o relacionaento a partir do id do ingrediente para nao dar problema de remover o ingrediente
            PreparedStatement pstm = conn.prepareStatement(instrucaoSQL);

            pstm.setInt(1, idIngrediente); // setando o parâmetro na instrução

            if (pstm.executeUpdate() > 0) { // executando a instrução e verificando o retorno
                return 1; // realizou a instrução
            } else {
                return 0; // não realizou a instrução
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
    } // removerIngredienteAlergia(int idIngrediente)

    public List<String> buscarAlergiasPorIngrediente(int idIngrediente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco
        ResultSet rset;
        List<String> listaAlergias = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT A.NOME FROM ALERGIA_INGREDIENTE AI JOIN ALERGIA A ON AI.ID_ALERGIA = A.ID WHERE AI.ID_INGREDIENTE = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1, idIngrediente); // setando os parâmetros da instrução
            rset = pstmt.executeQuery(); // executando a instrucao

            while (rset.next()) {
                listaAlergias.add(rset.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
        return listaAlergias;
    } // buscaClienteAlergia(String emailCliente)

    public List<AlergiaIngrediente> buscarAlergiaIngrediente(int idIngrediente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        ResultSet rset;
        List<AlergiaIngrediente> listaAlergias = new ArrayList<>();
    
        try {
            String instrucaoSQL = 
                "SELECT AI.ID_INGREDIENTE, AI.ID_ALERGIA, A.NOME " +
                "FROM ALERGIA_INGREDIENTE AI " +
                "JOIN ALERGIA A ON AI.ID_ALERGIA = A.ID " +
                "WHERE AI.ID_INGREDIENTE = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1, idIngrediente);
            rset = pstmt.executeQuery();
    
            while (rset.next()) {
                int idIng = rset.getInt("ID_INGREDIENTE");
                int idAlergia = rset.getInt("ID_ALERGIA");
                String nome = rset.getString("NOME");
    
                AlergiaIngrediente a = new AlergiaIngrediente(idIng, idAlergia, nome);
                listaAlergias.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.desconectar(conn);
        }
        return listaAlergias;
    } // buscarAlergiaIngrediente (int idIngrediente)
    


    
} // AlergiaIngredienteDAO

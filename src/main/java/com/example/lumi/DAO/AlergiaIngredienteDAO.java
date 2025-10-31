package com.example.lumi.DAO;

import com.example.lumi.Conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    public int DeletarIngredienteAlergia(int idIngrediente,int idAlergia) {
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

    public int removerAlergiaIngrediente(int idAlergia){
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

    public int removerIngredienteAlergia(int idIngrediente){
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
} // AlergiaIngredienteDAO

package com.example.lumi.DAO;

import com.example.lumi.Conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteAlergiaDAO {
    // INSERIR
    public int inserirClienteAlergia(String email,int id_alergia) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco

        try {
            String instrucaoSQL = "INSERT INTO CLIENTE_ALERGIA (EMAIL_CLIENTE,ID_PRODUTO) VALUES (?,?)";
            PreparedStatement pstm = conn.prepareStatement(instrucaoSQL);

            // setando os parâmetros da isntrução
            pstm.setString(1, email);
            pstm.setInt(2, id_alergia);

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
    }  // inserirClienteAlergia(String email, int idAlergia)

    // DELETAR
    public int DeletarClienteAlergia(String email,int id_alergia){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão como banco

        try {
            String instrucaoSQL = "DELETE FROM CLIENTE_ALERGIA WHERE EMAIL_CLIENTE= AND ID_PRODUTO=? ";
            PreparedStatement pstm = conn.prepareStatement(instrucaoSQL);

            // setando os parâmetros na instrução
            pstm.setString(1, email);
            pstm.setInt(2, id_alergia);

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
    } // DeletarClienteAlergia(String email,int id_alergia)


    public int deletarClienteAlergia(String email){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            String instrucaoSQL = "DELETE FROM CLIENTE_ALERGIA WHERE EMAIL_CLIENTE= ?";
            PreparedStatement pstm = conn.prepareStatement(instrucaoSQL);

            pstm.setString(1,email); // setando o parâmetro da instrução

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
    } // deletarClienteAlergia(String email)

    public int deletarClienteAlergia(int idAlergia){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco

        try {
            String instrucaoSQL = "DELETE FROM ALERGIA_CLIENTE WHERE ID_PRODUTO=? ";
            PreparedStatement pstm = conn.prepareStatement(instrucaoSQL);

            pstm.setInt(1, idAlergia); // setando o parâmetro da instrução

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
    } // deletarClienteAlergia(int idAlergia)













}

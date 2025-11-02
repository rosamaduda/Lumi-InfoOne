package com.example.lumi.DAO;

import com.example.lumi.Conexao.Conexao;
import com.example.lumi.Model.Alergia;
import com.example.lumi.Model.ClienteAlergia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteAlergiaDAO {
    // INSERIR
    public int inserirClienteAlergia(String email,int id_alergia) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco

        try {
            String instrucaoSQL = "INSERT INTO CLIENTE_ALERGIA (EMAIL_CLIENTE, ID_ALERGIA) VALUES (?,?)"; // inserindo o id da alergia e o email do cliente para criar o relacionamento
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
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco

        try {
            String instrucaoSQL = "DELETE FROM CLIENTE_ALERGIA WHERE EMAIL_CLIENTE = ?"; // deletando o relacionamento a partir do email do cliente para nao dar problema na hora de deletar o cliente
            PreparedStatement pstm = conn.prepareStatement(instrucaoSQL);

            pstm.setString(1, email); // setando o parâmetro da instrução

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
            String instrucaoSQL = "DELETE FROM CLIENTE_ALERGIA WHERE ID_ALERGIA=? ";// deletando o relacionamento a partir do id da alergia para nao dar problema na hora de deletar a alergia
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            pstmt.setInt(1, idAlergia); // setando o parâmetro da instrução

            if (pstmt.executeUpdate() > 0) { // executando a instrução e verificando o retorno
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

    // BUSCAR
    public List<ClienteAlergia> buscaClienteAlergia(String emailCliente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<ClienteAlergia> alergias = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT ID_ALERGIA FROM CLIENTE_ALERGIA WHERE EMAIL_CLIENTE = ?"; // buscando o nome da alergia a partir do ID
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, emailCliente); // setando o parâmetro da instrução
            rset = pstmt.executeQuery(); // realizando a query

            while (rset.next()) {
                ClienteAlergia clienteAlergia = new ClienteAlergia(rset.getInt("id_alergia"));
                alergias.add(clienteAlergia); // adicionando o objeto à lista que será retornada
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return alergias;
    } // buscaClienteAlergia(String emailCliente)

    public List<String> buscarAlergiasPorEmail(String emailCliente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco
        ResultSet rset;
        List<String> listaAlergias = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT A.NOME FROM CLIENTE_ALERGIA CA JOIN ALERGIA A ON CA.ID_ALERGIA = A.ID WHERE CA.EMAIL_CLIENTE = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, emailCliente); // setando os parâmetros da instrução
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









}

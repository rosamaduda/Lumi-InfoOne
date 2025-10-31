package com.example.lumi.DAO;

import com.example.lumi.Conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdmDAO {
    public boolean validarSenhaAdm(String login, String senha) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco de dados
        ResultSet rset;

        try {
            String instrucaoSQL = "SELECT SENHA FROM ADMINISTRADOR WHERE LOGIN = ?"; // buscando a senha do administrador equivalente ao login fornecido
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, login); // setando o parâmetro na instrução
            rset = pstmt.executeQuery(); // executando a query no BD

            // caso seja encontrado um usuário com o nome fornecido, cai no while
            while (rset.next()) {
                if (rset.getString("senha").equals(senha)) { // verificando se a senha do usuario recebido é igual a senha recebida
                    return true;
                }
            }
        } catch(SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando do BD
        }

        return false; // retornando fora do try-catch, pois dentro dá erro de falta de retorno
    } // validarSenhaAdm()

    public ResultSet buscarLogin() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco
        ResultSet rset = null;

        try {
            String instrucaoSQL = "SELECT LOGIN FROM ADMINISTRADOR";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            rset = pstmt.executeQuery();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando do BD
            return rset;
        }
    } // buscarAdm()
} // DAO
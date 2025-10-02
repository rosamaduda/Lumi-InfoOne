package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdmDAO {
    public boolean validarSenhaAdm(String usuario, String senha) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco de dados
        ResultSet rset = null;

        try {
            String instrucaoQuery = "SELECT senha FROM ADMINISTRADOR WHERE USUARIO = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoQuery);
            pstmt.setString(1, usuario); // setando o parâmetro na instrução
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

    public ResultSet buscarAdm() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco
        ResultSet rset = null;

        try {
            String instrucao = "SELECT * FROM ADMINISTRADOR";
            PreparedStatement pstmt = conn.prepareStatement(instrucao);
            rset = pstmt.executeQuery();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando do BD
            return rset;
        }
    } // buscarAdm()
} // DAO
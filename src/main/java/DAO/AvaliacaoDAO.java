package DAO;

import Conexao.Conexao;
import Model.Alergia;
import Model.Avaliacao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoDAO {
    public int adicionarAvaliacao(Avaliacao avalia){
        Conexao conexao=new Conexao();
        Connection conn= conexao.conectar();
        try{
            String instrucaoSQL="INSERT INTO AVALIACAO(NOTAS,AVALIACAO,DT_AVALIACAO,EMAIL_CLIENTE,ID_PRODUTO) VALUES(?,?,?,?,?)";
            PreparedStatement pstmt= conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1,avalia.getNota());
            pstmt.setString(2,avalia.getAvaliacao());
            pstmt.setDate(3, (Date) avalia.getDataHorario());
            pstmt.setString(4,avalia.getEmailCliente());
            pstmt.setInt(5,avalia.getIdProduto());
            if (pstmt.executeUpdate()>0){
                return 1;

            }
            else {
                return 0;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    public int alterarAvaliacao(Avaliacao avalia) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "UPDATE AVALIACAO SET NOTA = ?, AVALIACAO = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando os parametros da instrucao
            pstmt.setInt(1, avalia.getNota());
            pstmt.setString(2, avalia.getAvaliacao());
            pstmt.setInt(3,avalia.getId());
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
    public int removerAvaliacao(int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexao com o BD

        try {
            String instrucaoSQL = "DELETE FROM AVALIACAO WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1, id); // setando parametro na instrução
            if (pstmt.executeUpdate() > 0) { // // executando o comando e verificando o retorno
                return 1; // conseguiu deletar
            } else {
                return 0; // não encontrou o registro
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn);
        }
    } // removerAlergia()

    // SELECT
    public List<Avaliacao> buscarAlergia() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Avaliacao> avaliacoes = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM AVALIACAO";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // realizando a query

            while (rset.next()) {
                Avaliacao avaliacao = new Avaliacao(rset.getInt("id"), rset.getInt("NOTA"), rset.getString("AVALIACAO"), rset.getDate("DT_AVALIACAO"),rset.getString("EMAIL_CLIENTE"),rset.getInt("ID_PRODUTO"));
                avaliacoes.add(avaliacao);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
            return avaliacoes;





}
    }
    public List<Avaliacao> buscarAlergiaPorCliente(int idCliente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Avaliacao> avaliacoes = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM AVALIACAO WHERE ID_CLIENTE=?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1,idCliente);
            rset = pstmt.executeQuery(); // realizando a query
            while (rset.next()) {
                Avaliacao avaliacao = new Avaliacao(rset.getInt("id"), rset.getInt("NOTA"), rset.getString("AVALIACAO"), rset.getDate("DT_AVALIACAO"),rset.getString("EMAIL_CLIENTE"),rset.getInt("ID_PRODUTO"));
                avaliacoes.add(avaliacao);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
            return avaliacoes;





        }
    }
}

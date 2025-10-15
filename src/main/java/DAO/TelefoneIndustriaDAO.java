package DAO;

import Conexao.Conexao;
import Model.TelefoneIndustria;
import org.w3c.dom.ls.LSException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TelefoneIndustriaDAO {
    public int adicionarTelIndustria(TelefoneIndustria tel){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "INSERT INTO TEL_INDUSTRIA (TELEFONE, ID_INDUSTRIA) VALUES(?, ?) ";
            PreparedStatement pstmt=conn.prepareStatement(instrucaoSQL);
            // setando os parâemetros da instrução
            pstmt.setInt(1, tel.getTelefone());
            pstmt.setInt(2, tel.getIdIndustria());
            if (pstmt.executeUpdate() > 0){ // executando a instrução e verificando o retorno
                return 1; // realizou a instrução
            } else {
                return 0; // não realizou a instrução
            }
        } catch (SQLException e){
            e.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
    } // adicionarTelIndustria()

    public int deletarTelIndustria(int id){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão no BD

        try {
            String intrucaoSQL = "DELETE FROM TEL_INDUSTRIA WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(intrucaoSQL);
            // setando os parâmetros na instruçãp
            pstmt.setInt(1,id);
            if (pstmt.executeUpdate() > 0){ // executando a instrução e verificando o retorno
                return 1; // executou a instrução
            } else {
                return 0; // não encontrou o registro
            }
        } catch (SQLException e){
            e.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectando com o BD
        }
    } // deletarTelIndustria()

    public int alterarTelefone(TelefoneIndustria tel){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL="UPDATE TEL_INDUSTRIA SET TELEFONE = ? WHERE ID = ?";
            PreparedStatement pstmt=conn.prepareStatement(instrucaoSQL);
            // setando os parâmetros da instrução
            pstmt.setInt(1,tel.getTelefone());
            pstmt.setInt(2,tel.getId());
            if (pstmt.executeUpdate() > 0){ // executando a instrução e verificando o retorno
                return 1; // conseguiu realizar a instrução
            } else {
                return 0; // não encontrou o registro
            }
        } catch (SQLException e){
            e.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
    } // alterarTelefone()


    public List<TelefoneIndustria> buscarTelefone() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<TelefoneIndustria> telefones = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM TEL_INDUSTRIA ORDER BY ID";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query
            while (rset.next()) {
                TelefoneIndustria telefone = new TelefoneIndustria(rset.getInt("id"),rset.getInt("telefone"),rset.getInt("id_industria"));
                telefones.add(telefone); // adicionando o objeto à lista que será retornada
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return telefones;
    } // buscarTelefone()
} // TelefoneIndustriaDAO



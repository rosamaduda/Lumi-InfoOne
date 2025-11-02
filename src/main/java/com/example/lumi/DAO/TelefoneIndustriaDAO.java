package com.example.lumi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.lumi.Conexao.Conexao;
import com.example.lumi.Model.TelefoneIndustria;

public class TelefoneIndustriaDAO {
    // INSERIR
    public int inserirTelIndustria(TelefoneIndustria tel){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "INSERT INTO TEL_INDUSTRIA (TELEFONE, ID_INDUSTRIA) VALUES(?, ?) ";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando os parâemetros da instrução
            pstmt.setString(1, tel.getTelefone());
            pstmt.setInt(2, tel.getIdIndustria());

            if (pstmt.executeUpdate() > 0){ // executando a instrução e verificando o retorno
                return 1; // realizou a instrução
            } else {
                return 0; // não realizou a instrução
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
    } // adicionarTelIndustria()

    public int deletarTelIdIndustria(int idIndustria){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão no BD

        try {
            String intrucaoSQL = "DELETE FROM TEL_INDUSTRIA WHERE ID_INDUSTRIA = ?";
            PreparedStatement pstmt = conn.prepareStatement(intrucaoSQL);

            // setando os parâmetros na instruçãp
            pstmt.setInt(1,idIndustria);

            if (pstmt.executeUpdate() > 0){ // executando a instrução e verificando o retorno
                return 1; // executou a instrução
            } else {
                return 0; // não encontrou o registro
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectando com o BD
        }
    } // deletarTelIndustria()

    public List<TelefoneIndustria> buscarTelefone(int idIndustria) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<TelefoneIndustria> listaTelefones = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM TEL_INDUSTRIA WHERE ID_INDUSTRIA = ?"; // buscando o telefone a partir do id da industria fornecido
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            pstmt.setInt(1,idIndustria); // setando o parâmetro na instrução
            rset = pstmt.executeQuery(); // executando a query

            while (rset.next()) {
                TelefoneIndustria telefone = new TelefoneIndustria(rset.getString("telefone"));
                listaTelefones.add(telefone); // adicionando o objeto à lista que será retornada
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return listaTelefones;
    } // buscarTelefone()

    public List<TelefoneIndustria> buscarTelPorIndustria(int idIndustria) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco
        ResultSet rset;
        List<TelefoneIndustria> listaTelefones = new ArrayList<>();
    
        try {
            String instrucaoSQL = "SELECT TELEFONE FROM TEL_INDUSTRIA WHERE ID_INDUSTRIA = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1, idIndustria); // setando o parâmetro da instrução
            rset = pstmt.executeQuery(); // executando a instrução
    
            while (rset.next()) {
                TelefoneIndustria telefoneObjeto = new TelefoneIndustria(rset.getString("telefone"));
                listaTelefones.add(telefoneObjeto);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
        return listaTelefones;
    }// buscarTelefone()
} // TelefoneIndustriaDAO



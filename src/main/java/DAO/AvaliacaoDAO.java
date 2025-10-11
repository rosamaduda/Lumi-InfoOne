package DAO;

import Conexao.Conexao;
import Model.Avaliacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AvaliacaoDAO {
    public int adicionarAvaliacao(Avaliacao avalia){
        Conexao conexao=new Conexao();
        Connection conn= conexao.conectar();
        try{
            String instrucaoSQL="INSERT INTO AVALIACAO(NOTAS,AVALIACAO,DT_AVALIACAO,EMAIL_CLIENTE,ID_PRODUTO) VALUES(?,?,?,?,?)";
            PreparedStatement pstmt= conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1,avalia.getNota());
            pstmt.setString(2,avalia.getAvaliacao());
            pstmt.setDate(3,avalia.getDataHorario());
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

}

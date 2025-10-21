package DAO;

import Conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteAlergiaDAO {
    public int inserirClienteAlergia(String email,int id_alergia){
        Conexao conexao=new Conexao();
        Connection conn=conexao.conectar();
        try{
            String instrucaoSQL="INSERT INTO CLIENTE_ALERGIA (EMAIL_CLIENTE,ID_PRODUTO) VALUES (?,?)";
            PreparedStatement pstm=conn.prepareStatement(instrucaoSQL);
            pstm.setString(1,email);
            pstm.setInt(2,id_alergia);
            if (pstm.executeUpdate()>0){
                return 1;
            }
            else {
                return 0;
            }


        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }finally {
            conexao.desconectar(conn);
        }
    }


    public int DeletarClienteAlergia(String email,int id_alergia){
        Conexao conexao=new Conexao();
        Connection conn=conexao.conectar();
        try{
            String instrucaoSQL="DELETE FROM CLIENTE_ALERGIA WHERE EMAIL_CLIENTE= AND ID_PRODUTO=? ";
            PreparedStatement pstm=conn.prepareStatement(instrucaoSQL);
            pstm.setString(1,email);
            pstm.setInt(2,id_alergia);
            if (pstm.executeUpdate()>0){
                return 1;
            }
            else {
                return 0;
            }


        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }finally {
            conexao.desconectar(conn);
        }
    }



    public int DeletarClienteAlergia(String email){
        Conexao conexao=new Conexao();
        Connection conn=conexao.conectar();
        try{
            String instrucaoSQL="DELETE FROM CLIENTE_ALERGIA WHERE EMAIL_CLIENTE= ";
            PreparedStatement pstm=conn.prepareStatement(instrucaoSQL);
            pstm.setString(1,email);
            if (pstm.executeUpdate()>0){
                return 1;
            }
            else {
                return 0;
            }


        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }finally {
            conexao.desconectar(conn);
        }
    }



    public int deletarClienteAlergia(int id_alergia){
        Conexao conexao=new Conexao();
        Connection conn=conexao.conectar();
        try{
            String instrucaoSQL="DELETE FROM CLIENTE_ALERGIA WHERE ID_PRODUTO=? ";
            PreparedStatement pstm=conn.prepareStatement(instrucaoSQL);
            pstm.setInt(1,id_alergia);

     if (pstm.executeUpdate()>0){
        return 1;
    }
            else {
        return 0;
    }}catch (SQLException e){
        e.printStackTrace();
        return -1;
        }finally {
        conexao.desconectar(conn);
        }
    }
}

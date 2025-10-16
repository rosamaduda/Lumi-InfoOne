package DAO;

import Conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlergiaIngredienteDAO {


    public int inserirAlergiaIngrediente(int id_ingrediente, int id_alergia){
        Conexao conexao=new Conexao();
        Connection conn=conexao.conectar();
        try{
            String instrucaoSQL="INSERT INTO ALERGIA_INGREDIENTE (ID_INGREDIENTE,ID_ALERGIA) VALUES (?,?)";
            PreparedStatement pstm=conn.prepareStatement(instrucaoSQL);
            pstm.setInt(1,id_ingrediente);
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


    public int DeletarClienteAlergia(int id_ingrediente,int id_alergia){
        Conexao conexao=new Conexao();
        Connection conn=conexao.conectar();
        try{
            String instrucaoSQL="DELETE FROM ALERGIA_INGREDIENTE WHERE ID_INGREDIENTE=? AND ID_ALERGIA=? ";
            PreparedStatement pstm=conn.prepareStatement(instrucaoSQL);
            pstm.setInt(1,id_ingrediente);
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






}

package DAO;

import Conexao.Conexao;
import Model.TelefoneIndustria;
import org.w3c.dom.ls.LSException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TelefoneIndustriaDAO {
            public int adicionarTelIndustria(TelefoneIndustria tel){
                Conexao conexao=new Conexao();
                Connection conn= conexao.conectar();
                try{
                    String instrucaoSQL="INSERT INTO TEL_INDUSTRIA (TELEFONE,ID_INDUSTRIA) VALUES(?,?) ";
                    PreparedStatement pstmt=conn.prepareStatement(instrucaoSQL);
                    pstmt.setString(1,tel.getTelefone());
                    pstmt.setInt(2,tel.getIdIndustria());
                    if (pstmt.executeUpdate()>0){
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

            public int deletarTelIndustria(int id){
                Conexao conexao=new Conexao();
                Connection conn= conexao.conectar();
                try{
                    String intrucaoSQL="DELETE FROM TEL_INDUSTRIA WHERE ID=?";
                    PreparedStatement pstmt=conn.prepareStatement(intrucaoSQL);
                    pstmt.setInt(1,id);
                    if (pstmt.executeUpdate()>0){
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


            public int alterarTelefone(int id){
                Conexao conexao=new Conexao();
                Connection conn=conexao.conectar();
                try{
                    String instrucaoSQL="UPDATE TEL_INDUSTRIA SET TELEFONE=? WHERE ID=?";
                    PreparedStatement pstmt=conn.prepareStatement(instrucaoSQL);
                    if (pstmt.executeUpdate()>0){
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


            public List<TelefoneIndustria> buscarTelenofe(){
                Conexao conexao=new Conexao();
                Connection conn= conexao.conectar();
                ResultSet rset;
                List<TelefoneIndustria> tel=new ArrayList<>();

                try{
                    String instrucaoSQL="SELECT * FROM TEL_INDUSTRIA ORDER BY ID";
                    Statement stmt= conn.createStatement();
                    rset=stmt.executeQuery(instrucaoSQL);
                    while (rset.next()){
                        TelefoneIndustria telefone=new TelefoneIndustria(rset.getInt("id"),rset.getString("telefone"),rset.getInt("id_industria"));
                        tel.add(telefone);
                    }


                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    conexao.desconectar(conn);
                    return tel;
                }

            }
}



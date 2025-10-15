package DAO;

import Conexao.Conexao;
import Model.Favorito;
import Model.TelefoneIndustria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FavoritosDAO {
    public int adicionarFavorito(Favorito fav){
         Conexao conexao =new Conexao();
        Connection conn= conexao.conectar();
        try{
            String instrucaoSQL="INSERT INTO FAVORITO (ID_PRODUTO,EMAIL_CLIENTE) VALUES(?,?)";
            PreparedStatement pstm=conn.prepareStatement(instrucaoSQL);
            pstm.setInt(1,fav.getIdProduto());
            pstm.setString(2,fav.getEmailCliente());
            if (pstm.executeUpdate()>0){
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


    public int deletarFavorito(int id){
        Conexao conexao=new Conexao();
        Connection conn= conexao.conectar();
        try{
            String instrucaoSQL="DELETE FROM FAVORITO WHERE ID=? ";

            PreparedStatement pstmt= conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1,id);
            if(pstmt.executeUpdate()>0){
                return 1;
            }
            else {
                return 0;

                }
            }
        catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
        finally {
            conexao.desconectar(conn);
        }
    }


        public List<Favorito> listarFavoritos(){
         Conexao conexao=new Conexao();
            Connection conn= conexao.conectar();
            ResultSet rset;
            List<Favorito> fav=new ArrayList<>();

            try{
                String instrucaoSQL="SELECT * FROM FAVORITO";
                Statement stmt= conn.createStatement();
                rset=stmt.executeQuery(instrucaoSQL);
                while (rset.next()){
                    Favorito favorito=new Favorito(rset.getInt("id"),rset.getInt("id_produto"),rset.getString("email_cliente"));
                    fav.add(favorito);
                }
        }catch (SQLException e){
                e.printStackTrace();

            }finally {
                conexao.desconectar(conn);
                return fav;
            }
    }



    public List<Favorito> listarFavoritosPorUser(String email){
        Conexao conexao=new Conexao();
        Connection conn= conexao.conectar();
        ResultSet rset;
        List<Favorito> fav=new ArrayList<>();

        try{
            String instrucaoSQL="SELECT * FROM FAVORITO WHERE EMAIL_USUARIO=?";
            PreparedStatement pstmt= conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1,email);
            rset=pstmt.executeQuery();
            while (rset.next()){
                Favorito favorito=new Favorito(rset.getInt("id"),rset.getInt("id_produto"),rset.getString("email_cliente"));
                fav.add(favorito);
            }
        }catch (SQLException e){
            e.printStackTrace();

        }finally {
            conexao.desconectar(conn);
            return fav;
        }
    }


    public List<Favorito> listarFavoritosPorProduto(int idProduto){
        Conexao conexao=new Conexao();
        Connection conn= conexao.conectar();
        ResultSet rset;
        List<Favorito> fav=new ArrayList<>();

        try{
            String instrucaoSQL="SELECT * FROM FAVORITO WHERE ID_PRODUTO=?";
            PreparedStatement pstmt= conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1,idProduto);
            rset=pstmt.executeQuery();
            while (rset.next()){
                Favorito favorito=new Favorito(rset.getInt("id"),rset.getInt("id_produto"),rset.getString("email_cliente"));
                fav.add(favorito);
            }
        }catch (SQLException e){
            e.printStackTrace();

        }finally {
            conexao.desconectar(conn);
        }
        return fav;

    }
    }

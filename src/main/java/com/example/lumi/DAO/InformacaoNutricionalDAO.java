package com.example.lumi.DAO;
import com.example.lumi.Conexao.Conexao;
import com.example.lumi.Model.InformacaoNutricional;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InformacaoNutricionalDAO {
    public int inserirInfoNutri(InformacaoNutricional info){
        Conexao conexao=new Conexao();
        Connection conn= conexao.conectar();
        try{
            String instrucaoSQL="INSERT INTO INFO_NUTRI(VALOR_ENERGETICO,PROTEINA,FIBRAS,CARBOIDRATOS,SODIO,GORDURA_SATURADA,GORDURA_TRANS,GORDURA_TOTAL) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt= conn.prepareStatement(instrucaoSQL);
            pstmt.setDouble(1,info.getValorEnergetico());
            pstmt.setDouble(2,info.getProteina());
            pstmt.setDouble(3,info.getFibras());
            pstmt.setDouble(4,info.getCarboidratos());
            pstmt.setDouble(5,info.getSodio());
            pstmt.setDouble(6,info.getGorduraSaturada());
            pstmt.setDouble(7,info.getGorduraTrans());
            pstmt.setDouble(8,info.getGordurasTotais());
            if (pstmt.executeUpdate()>0){
                return 1;
            }
            else{
                return 0;
            }

        }
        catch (SQLException sqle){
            sqle.printStackTrace();
            return -1;
        }
        finally {
            conexao.desconectar(conn);
        }
    }


    public int alterarInfoNutri(InformacaoNutricional info){
        Conexao conexao=new Conexao();
        Connection conn= conexao.conectar();
        try{
            String instrucaoSQL="UPDATE INFO_NUTRI SET VALOR_ENERGETICO=?,PROTEINA=?,FIBRAS=?,CARBOIDRATOS=?,SODIO=?,GORDURA_SATURADA=?,GORDURA_TRANS=?,GORDURA_TOTAL=? WHERE ID=?";
            PreparedStatement pstmt= conn.prepareStatement(instrucaoSQL);
            pstmt.setDouble(1,info.getValorEnergetico());
            pstmt.setDouble(2,info.getProteina());
            pstmt.setDouble(3,info.getFibras());
            pstmt.setDouble(4,info.getCarboidratos());
            pstmt.setDouble(5,info.getSodio());
            pstmt.setDouble(6,info.getGorduraSaturada());
            pstmt.setDouble(7,info.getGorduraTrans());
            pstmt.setDouble(8,info.getGordurasTotais());
            pstmt.setInt(9,info.getId());
            if (pstmt.executeUpdate()>0){
                return 1;
            }
            else{
                return 0;
            }

        }
        catch (SQLException sqle){
            sqle.printStackTrace();
            return -1;
        }
        finally {
            conexao.desconectar(conn);
        }
    }


    public int deletarInfoNutri(int id){
        Conexao conexao=new Conexao();
        Connection conn= conexao.conectar();
        try{
            String instrucaoSQL="DELETE FROM INFO_NUTRI WHERE ID=?";
            PreparedStatement pstmt= conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1,id);
            if (pstmt.executeUpdate()>0) {
                return 1;
            }
            else {
                return 0;
            }
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
            return -1;
        }
        finally {
            conexao.desconectar(conn);
        }
    }

    public List<InformacaoNutricional> buscarInfoNutri(){
        Conexao conexao=new Conexao();
        Connection conn= conexao.conectar();
        ResultSet rset;
        List<InformacaoNutricional> listaInfoNutri=new ArrayList<>();
        try{
            String instrucaoSQL="SELECT * FROM INFO_NUTRI";
            Statement stmt= conn.createStatement();
            rset=stmt.executeQuery(instrucaoSQL);
            while (rset.next()){
                InformacaoNutricional info=new InformacaoNutricional(rset.getInt("id"),
                        rset.getDouble("valor_energetico"),
                        rset.getDouble("proteina"),
                        rset.getDouble("proteina"),
                        rset.getDouble("carboidratos"),
                        rset.getDouble("sodio"),
                        rset.getDouble("gordura_saturada"),
                        rset.getDouble("gordura_trans"),
                        rset.getDouble("gordura_total"));
                listaInfoNutri.add(info);
            }
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
        }
        finally{
            conexao.desconectar(conn);
        }
        return listaInfoNutri;

    }

    public int buscarIdInfoNutri(){
        Conexao conexao=new Conexao();
        Connection conn= conexao.conectar();
        ResultSet rset;
        int id=-1;
        try{
            String instrucaoSQL="SELECT ID FROM INFO_NUTRI  ORDER BY DESC LIMIT 1";
            Statement stmt= conn.createStatement();
            rset=stmt.executeQuery(instrucaoSQL);
            while (rset.next()) {
                id=rset.getInt("id");
            }
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
        }
        finally{
            conexao.desconectar(conn);
        }
        return id;
    }












}

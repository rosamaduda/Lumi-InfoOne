package com.example.lumi.DAO;
import com.example.lumi.Conexao.Conexao;
import com.example.lumi.Model.InformacaoNutricional;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InformacaoNutricionalDAO {
    // INSERIR
    public int inserirInfoNutri(InformacaoNutricional info){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco

        try {
            String instrucaoSQL = "INSERT INTO INFO_NUTRI (VALOR_ENERGETICO,PROTEINA,FIBRAS,CARBOIDRATOS,SODIO,GORDURA_SATURADA,GORDURA_TRANS,GORDURA_TOTAL) VALUES (?,?,?,?,?,?,?,?)"; // inserindo o registro das info. nutricionais
            PreparedStatement pstmt= conn.prepareStatement(instrucaoSQL);

            // setando os parâmetros da instrução
            pstmt.setDouble(1,info.getValorEnergetico());
            pstmt.setDouble(2,info.getProteina());
            pstmt.setDouble(3,info.getFibras());
            pstmt.setDouble(4,info.getCarboidratos());
            pstmt.setDouble(5,info.getSodio());
            pstmt.setDouble(6,info.getGorduraSaturada());
            pstmt.setDouble(7,info.getGorduraTrans());
            pstmt.setDouble(8,info.getGordurasTotais());
            if (pstmt.executeUpdate() > 0) { // executando o comando e verificando o retorno
                return 1; // conseguiu realizar a instrução
            } else {
                return 0; // não foi possível realizar a instrução
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        }
        finally {
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
    } // inserirInfoNutri(InformacaoNutricional info)

    // ALTERAR
    public int alterarInfoNutri(InformacaoNutricional info) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco

        try {
            String instrucaoSQL = "UPDATE INFO_NUTRI SET VALOR_ENERGETICO = ?, PROTEINA = ?, FIBRAS = ?, CARBOIDRATOS = ?, SODIO = ?, GORDURA_SATURADA = ?, GORDURA_TRANS = ?, GORDURA_TOTAL = ? WHERE ID = ?"; // alterando a informação nutricional
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando os parâmetros da instrução
            pstmt.setDouble(1,info.getValorEnergetico());
            pstmt.setDouble(2,info.getProteina());
            pstmt.setDouble(3,info.getFibras());
            pstmt.setDouble(4,info.getCarboidratos());
            pstmt.setDouble(5,info.getSodio());
            pstmt.setDouble(6,info.getGorduraSaturada());
            pstmt.setDouble(7,info.getGorduraTrans());
            pstmt.setDouble(8,info.getGordurasTotais());
            pstmt.setInt(9,info.getId());
            if (pstmt.executeUpdate() > 0) { // executando o comando e verificando o retorno
                return 1; // conseguiu realizar a instrução
            } else {
                return 0; // não foi possível realizar a instrução
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
    }


    public int deletarInfoNutri(int id){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco

        try {
            String instrucaoSQL = "DELETE FROM INFO_NUTRI WHERE ID = ?"; // deletando o telefone pelo ID
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1, id); // setando o parâmetro na instrução

            if (pstmt.executeUpdate() > 0) { // executando o comando e verificando o retorno
                return 1; // conseguiu realizar a instrução
            } else {
                return 0; // não foi possível realizar a instrução
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
    } // deletarInfoNutri(int id)

    // BUSCAR
    public List<InformacaoNutricional> buscarInfoNutri(){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco
        ResultSet rset;
        List<InformacaoNutricional> listaInfoNutri=new ArrayList<>();

        try{
            String instrucaoSQL = "SELECT * FROM INFO_NUTRI ORDER BY ID"; // buscando as informações da info. nutricional
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a instrução
            while (rset.next()){
                InformacaoNutricional informacaoNutricional = new InformacaoNutricional(rset.getInt("id"),
                        rset.getDouble("valor_energetico"),
                        rset.getDouble("proteina"),
                        rset.getDouble("proteina"),
                        rset.getDouble("carboidratos"),
                        rset.getDouble("sodio"),
                        rset.getDouble("gordura_saturada"),
                        rset.getDouble("gordura_trans"),
                        rset.getDouble("gordura_total"));
                listaInfoNutri.add(informacaoNutricional);
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
        } finally{
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
        return listaInfoNutri;
    }

    public List<InformacaoNutricional> buscarInfoNutriPortal(){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco
        ResultSet rset;
        List<InformacaoNutricional> listaInfoNutri=new ArrayList<>();

        try{
            String instrucaoSQL = "SELECT I.* FROM INFO_NUTRI I ORDER BY ID DESC LIMIT 3"; // buscando as informações da info. nutricional ordenando pelo id de forma decrescente
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a instrução
            while (rset.next()){
                InformacaoNutricional informacaoNutricional = new InformacaoNutricional(rset.getInt("id"),
                        rset.getDouble("valor_energetico"),
                        rset.getDouble("proteina"),
                        rset.getDouble("proteina"),
                        rset.getDouble("carboidratos"),
                        rset.getDouble("sodio"),
                        rset.getDouble("gordura_saturada"),
                        rset.getDouble("gordura_trans"),
                        rset.getDouble("gordura_total"));
                listaInfoNutri.add(informacaoNutricional);
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
        } finally{
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
        return listaInfoNutri;
    } // buscarInfoNutriPortal()

    public InformacaoNutricional buscarInfoNutri(InformacaoNutricional informacaoNutricional) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco
        ResultSet rset;

        try {
            String instrucaoSQL = "SELECT I.* FROM INFO_NUTRI I WHERE ID = ?"; // procurando a informação nutricional pelo ID
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1, informacaoNutricional.getId()); // setando o parâmetro na instrução
            rset = pstmt.executeQuery(); // executando a instrução

            while (rset.next()){
                informacaoNutricional = new InformacaoNutricional(rset.getInt("id"),
                        rset.getDouble("valor_energetico"),
                        rset.getDouble("proteina"),
                        rset.getDouble("proteina"),
                        rset.getDouble("carboidratos"),
                        rset.getDouble("sodio"),
                        rset.getDouble("gordura_saturada"),
                        rset.getDouble("gordura_trans"),
                        rset.getDouble("gordura_total"));
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
        } finally{
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
        return informacaoNutricional;
    }

    public int buscarIdInfoNutri(){
        Conexao conexao=new Conexao();
        Connection conn= conexao.conectar(); // abrindo a conexão com o banco
        ResultSet rset;
        int id=-1;
        try{
            String instrucaoSQL="SELECT ID FROM INFO_NUTRI ORDER BY ID DESC LIMIT 1"; // buscando o id do último registro
            Statement stmt= conn.createStatement();
            rset=stmt.executeQuery(instrucaoSQL); // executando a instrução
            while (rset.next()) {
                id = rset.getInt("id");
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
        } finally{
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
        return id;
    }
} // InformacaoNutricionalDAO

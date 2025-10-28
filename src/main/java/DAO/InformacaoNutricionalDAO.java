package DAO;

import Conexao.Conexao;
import Model.InformacaoNutricional;

import java.sql.Connection;
import java.sql.SQLException;

public class InformacaoNutricionalDAO {
    public int adicionarInfoNutri(InformacaoNutricional info){
        Conexao conexao=new Conexao();
        Connection conn= conexao.conectar();
        try{

        }catch(SQLException sqle){
            sqle.printStackTrace();
            return -1;
        }
        }
}


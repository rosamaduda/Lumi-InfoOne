package com.example.lumi.DAO;

import com.example.lumi.Conexao.Conexao;
import com.example.lumi.Model.Plano;
import com.example.lumi.Model.Produto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlanoDAO {
    public List<Plano> buscarNomePlano() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco
        ResultSet rset;
        List<Plano> planos = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT NOME FROM PLANO";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Plano plano = new Plano(rset.getString("nome"));
                planos.add(plano); // adicionando à lista que será retornada
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando do BD
        }
        return planos;
    } // buscarNomePlano()
} // PlanoDAO

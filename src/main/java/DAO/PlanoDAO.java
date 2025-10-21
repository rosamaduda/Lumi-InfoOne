package DAO;

import Conexao.Conexao;
import Model.Cliente;
import Model.Plano;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlanoDAO {
    public List<Plano> buscarPlano() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        ResultSet rset;
        List<Plano> planos = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM PLANO";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Plano plano = new Plano(rset.getString("NOME"), rset.getString("descricao"),rset.getDouble("preco") );
                planos.add(plano);
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
                } finally {
            conexao.desconectar(conn);
                } // desconectando do BD
            return planos;
        }

        public List<Plano> buscarNomePorIndustria(){
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar(); // conectando o BD
            ResultSet rset;
            List<Plano> planos = new ArrayList<>();

            try {
                String instrucaoSQL = "SELECT P.NOME FROM INDUSTRIA I JOIN PLANO P ON P.NOME = I.NOME_PLANO";
                Statement stmt = conn.createStatement();
                rset=stmt.executeQuery(instrucaoSQL); // realizando as instruções

                while (rset.next()){
                    Plano plano = new Plano(rset.getString("nome"));
                    planos.add(plano);
                }
            } catch (SQLException sqle){
                sqle.printStackTrace();
            } finally {
                conexao.desconectar(conn); // desconectando o BD
            }
            return planos;
        }
} // PlanoDAO

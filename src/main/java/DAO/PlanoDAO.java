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
    public List<Plano> buscarNomePlano() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        ResultSet rset;
        List<Plano> lista = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT nome FROM plano";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Plano plano = new Plano(rset.getString("nome"));
                lista.add(plano);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando do BD
            return lista;
        }
    }
} // PlanoDAO

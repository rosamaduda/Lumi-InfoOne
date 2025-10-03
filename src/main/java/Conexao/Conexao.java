package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class Conexao {
    Dotenv dotenv = Dotenv.load();

    public Connection conectar(){
        Connection conn = null;

        try {
            Class.forName("org.postgresql.Driver"); // informando o driver de conexão usado

            // recebendo as informações do .env
            String usuario = dotenv.get("USUARIO");
            String senha = dotenv.get("SENHA");
            String url = dotenv.get("URL");

            conn = DriverManager.getConnection(url, usuario, senha); // criando conexão com o BD
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } finally{return conn;}
    } // conectar()

    public void desconectar(Connection conn){
        try{
            if (conn != null && !conn.isClosed()) {
                conn.close(); // desconectando o BD
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    } // desconectar()
} // Conexao

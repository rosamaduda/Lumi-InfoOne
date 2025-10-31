package com.example.lumi.DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.lumi.Conexao.Conexao;
import com.example.lumi.Model.Alergia;

public class AlergiaDAO {
    // INSERIR
    public int inserirAlergia(Alergia alergia) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "INSERT INTO ALERGIA (ALERGENO, NOME, DESCRICAO) VALUES(?, ?, ?)"; // inserindo as informações da alergia
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando os parâmetros da instrução
            pstmt.setString(1, alergia.getAlergeno());
            pstmt.setString(2, alergia.getNome());
            pstmt.setString(3, alergia.getDescricao());
            if (pstmt.executeUpdate() > 0) { // executando o comando e verificando o retorno
                return 1; // conseguiu realizar a instrução
            } else {
                return 0; // não foi possível realizar a instrução
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // fechando a conexão como BD
        }
    } // inserirAlergia()

    // ALTERAR
    public int alterarAlergia(Alergia alergia) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "UPDATE ALERGIA SET ALERGENO = ?, NOME = ?, DESCRICAO = ? WHERE ID = ?"; // alterando a alergia
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando os parametros da instrucao
            pstmt.setString(1, alergia.getAlergeno());
            pstmt.setString(2, alergia.getNome());
            pstmt.setString(3, alergia.getDescricao());
            pstmt.setInt(4, alergia.getId());

            if (pstmt.executeUpdate() > 0) { // executando o comando e verificando o retorno
                return 1; // conseguiu realizar a alteração
            } else {
                return 0; // não encontrou o registro
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }

    } // alterarAlergia(Alergia alergia)

    // DELETAR
    public int removerAlergia(int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexao com o BD

        try {
            // deletando a alergia
            String instrucaoSQL = "DELETE FROM ALERGIA WHERE ID = ?"; // apagando a alergia pelo id
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1, id); // setando parametro na instrução

            if (pstmt.executeUpdate() > 0) { // // executando o comando e verificando o retorno
                return 1; // conseguiu deletar
            } else {
                return 0; // não encontrou o registro
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
    } // removerAlergia()

    // SELECT
    public List<Alergia> buscarAlergia() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Alergia> lista = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM ALERGIA"; // buscando todas as informações da alergia
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // realizando a query

            while (rset.next()) {
                Alergia alergia = new Alergia(rset.getInt("id"), rset.getString("nome"), rset.getString("alergeno"), rset.getString("descricao"));
                lista.add(alergia); // adicionando o objeto à lista que será retornada
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return lista;
    } // buscarAlergia()

    public Alergia buscarAlergia(Alergia alergia) { // busca por ID
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;

        try {
            String instrucaoSQL = "SELECT * FROM ALERGIA WHERE ID = ?"; // buscando a alergia pelo ID
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1, alergia.getId()); // setando o parâmetro da instrução
            rset = pstmt.executeQuery(); // realizando a query

            while (rset.next()) {
                alergia = new Alergia(rset.getInt("id"), rset.getString("nome"), rset.getString("alergeno"), rset.getString("descricao"));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return alergia;
    } // buscarAlergia(Alergia alergia)

    public List<Alergia> buscarNomeAlergia() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Alergia> alergias = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT NOME FROM ALERGIA"; // buscando o nome da alergia
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // realizando a query

            while (rset.next()) {
                Alergia alergia = new Alergia(rset.getString("nome"));
                alergias.add(alergia); // adicionando o objeto à lista que será retornada
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return alergias;
    } // buscarNomeAlergia()

    // Limitar por 3 alergias para mostrar no portal
    public List<Alergia> buscarAlergiaPortal() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Alergia> lista = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM ALERGIA ORDER BY ID DESC LIMIT 3"; // buscando as últimas 3 alergias inseridas
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Alergia alergia = new Alergia(rset.getInt("id"), rset.getString("nome"), rset.getString("alergeno"), rset.getString("descricao"));
                lista.add(alergia); // adicionando o objeto à lista que será retornada
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando com o BD
        }
        return lista;

    } // buscarAlergiaPortal()

    public List<Alergia> buscarAlergiaPorNome(String nome){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco
        ResultSet rset;
        List<Alergia> lista = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM ALERGIA WHERE NOME LIKE ?"; // buscando a alergia pelo nome
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1,"%"+nome+"%"); // setando parâmetros da instrução
            rset = pstmt.executeQuery(); // executando a instrução

            while(rset.next()){
                Alergia alergia = new Alergia(rset.getInt("id"),rset.getString("nome"), rset.getString("alergeno"),rset.getString("descricao"));
                lista.add(alergia); // adicionando o objeto à lista que setá retornada
            }
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }finally {
            conexao.desconectar(conn); // fechando a conexão com o BD
        }
        return lista;
    } // buscarAlergiaPorNome

    public List<Alergia> buscarAlergiaPorAlergeno(String alergeno){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco
        ResultSet rset;
        List<Alergia> lista = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM ALERGIA WHERE ALERGENO LIKE ?"; // buscando a alergia pelo alergeno
            PreparedStatement pstmt= conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1,"%"+alergeno+"%"); // setando os parâmetros na instrução
            rset= pstmt.executeQuery(); // executando a instrução

            while(rset.next()) {
                Alergia alergia = new Alergia(rset.getInt("id"),rset.getString("nome"), rset.getString("alergeno"),rset.getString("descricao"));
                lista.add(alergia); // adicionando o objeto à lista que será retornada
            }
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }finally {
            conexao.desconectar(conn); // desconectando do banco
        }
        return lista;
    } // buscarAlergiaPorAlergeno()
    

} // AlergiaDAO


package com.example.lumi.DAO;



import com.example.lumi.Conexao.Conexao;
import com.example.lumi.Model.Alergia;
import com.example.lumi.Model.Ingrediente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlergiaDAO {
    // INSERIR
    public int inserirAlergia(Alergia alergia) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "INSERT INTO ALERGIA (ALERGENO, NOME, DESCRICAO) VALUES(?, ?, ?)";
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
            String instrucaoSQL = "UPDATE ALERGIA SET ALERGENO = ?, NOME = ?, DESCRICAO = ? WHERE ID = ?";
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

    } // alterarAlergia()

    // DELETAR
    public int removerAlergia(int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexao com o BD

        try {
            // deletando a alergia
            String instrucaoSQL = "DELETE FROM ALERGIA WHERE ID = ?";
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
            conexao.desconectar(conn);
        }
    } // removerAlergia()

    // SELECT
    public List<Alergia> buscarAlergia() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Alergia> lista = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM ALERGIA";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // realizando a query

            while (rset.next()) {
                Alergia alergia = new Alergia(rset.getInt("id"), rset.getString("nome"), rset.getString("alergeno"), rset.getString("descricao"));
                lista.add(alergia);
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
        Alergia alergia1 = null;
        ResultSet rset;

        try {
            String instrucaoSQL = "SELECT * FROM ALERGIA WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1, alergia.getId()); // setando o parâmetro da instrução
            rset = pstmt.executeQuery(); // realizando a query

            while (rset.next()) {
                alergia1 = new Alergia(rset.getInt("id"), rset.getString("nome"), rset.getString("alergeno"), rset.getString("descricao"));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return alergia1;
    } // buscarAlergia(Alergia alergia)

    public List<Alergia> buscarNomeAlergia() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Alergia> alergias = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT nome FROM alergia";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // realizando a query

            while (rset.next()) {
                Alergia alergia = new Alergia(rset.getString("nome"));
                alergias.add(alergia);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return alergias;
    } // buscarNomeAlergia()
    //Limitar por 3 alergias para mostrar no portal
    public List<Alergia> buscarAlergiaPortal() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Alergia> lista = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM ALERGIA LIMIT 3";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Alergia alergia = new Alergia(rset.getInt("id"), rset.getString("nome"), rset.getString("alergeno"), rset.getString("descricao"));
                lista.add(alergia);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);
        }
        return lista;

    }



    public List<Alergia> buscarAlergiaPorNome(String nome){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco
        ResultSet rset;
        List<Alergia> lista =new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM ALERGIA WHERE NOME LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1,"%"+nome+"%"); // setando parmetros da instrução
            rset = pstmt.executeQuery(); // executando a instrução

            while(rset.next()){
                Alergia alergia = new Alergia(rset.getInt("id"),rset.getString("nome"), rset.getString("alergeno"),rset.getString("descricao"));
                lista.add(alergia); // adicionando o objeto à lista que setá retornada
            }
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }finally {
            conexao.desconectar(conn);
        }
        return lista;
    }



    public List<Alergia> buscarAlergiaPorAlergeno(String alergeno){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco
        ResultSet rset;
        List<Alergia> lista = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM ALERGIA WHERE ALERGENO LIKE ?";
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
    }

} // AlergiaDAO


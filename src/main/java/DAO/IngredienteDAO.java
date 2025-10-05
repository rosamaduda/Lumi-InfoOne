package DAO;

import Conexao.Conexao;
import Model.Ingrediente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngredienteDAO {
    // INSERIR
    public int inserirIngrediente(Ingrediente ingrediente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "INSERT INTO ingrediente (nome, descricao) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando parâmetros na instrução
            pstmt.setString(1, ingrediente.getNome());
            pstmt.setString(2, ingrediente.getDescricao());

            if (pstmt.executeUpdate() > 0) { // executando o comando e verificando o retorno
                return 1; // conseguiu realizar a instrução
            } else {
                return 0; // não foi possível realizar a instrução
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
    } // inserirIngrediente()

    // ALTERAR
    public int alterarNomeIngrediente(int id, String nome) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "UPDATE ingrediente SET nome = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando os parâmetros
            pstmt.setString(1, nome);
            pstmt.setInt(2, id);

            if (pstmt.executeUpdate() > 0) { // executando o comando e verificando o retorno
                return 1; // conseguiu realizar a alteração
            } else {
                return 0; // não encontrou o registro
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        }
    } /// alterarDescricaoIngrediente()
    public int alterarDescricaoIngrediente(int id, String descricao) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "UPDATE ingrediente SET descricao = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando os parametros da instrucao
            pstmt.setString(1, descricao);
            pstmt.setInt(2, id);

            if (pstmt.executeUpdate() > 0) { // executando o comando e verificando o retorno
                return 1; // conseguiu realizar a alteração
            } else {
                return 0; // não encontrou o registro
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        }
    } /// alterarDescricaoIngrediente()

    // DELETAR
    public int removerIngrediente(int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "DELETE FROM ingrediente WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1, id); // setando o parâmetro da instrução
            if (pstmt.executeUpdate() > 0) { // executando o comando e verificando o retorno
                return 1; // conseguiu executar a instrução
            } else {
                return 0; // não encontrou o registro
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn);
        }
    } // removerIngrediente()

    // SELECT
    public List<Ingrediente> buscarIngrediente() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Ingrediente> lista = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM ingrediente";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Ingrediente ingrediente = new Ingrediente(rset.getInt("id"), rset.getString("nome"), rset.getString("descricao"));
                lista.add(ingrediente);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);
            return lista;
        }
    } // buscarIngrediente()
} // IngredienteDAO
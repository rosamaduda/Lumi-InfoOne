package DAO;

import Conexao.Conexao;
import Model.Favorito;
import Model.TelefoneIndustria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FavoritosDAO {
    public int inserirFavorito(Favorito favorito) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "INSERT INTO FAVORITO (COD_PRODUTO, EMAIL_CLIENTE) VALUES(?, ?)";
            PreparedStatement pstm = conn.prepareStatement(instrucaoSQL);
            // setando os parâmetros na instrução
            pstm.setLong(1, favorito.getCodProduto());
            pstm.setString(2, favorito.getEmailCliente());
            if (pstm.executeUpdate() > 0) {
                return 1; // conseguiu realizar a instrução
            } else {
                return 0; // não conseguiu realizar a instrução
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
    } // inserirFavorito()

    // DELETAR
    public int deletarFavorito(int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // conectando o BD

        try {
            String instrucaoSQL = "DELETE FROM FAVORITO WHERE ID = ? ";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando os parâmetros da instrução
            pstmt.setInt(1, id);
            if (pstmt.executeUpdate() > 0) {
                return 1; // conseguiu realizar a instrução
            } else {
                return 0; // não encontrou o registro
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
    } // deletarFavorito()

    // SELECT
    public List<Favorito> buscarFavoritos() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Favorito> favoritos = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT F.* FAVORITO F";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query
            while (rset.next()) {
                Favorito favorito = new Favorito(rset.getInt("id"), rset.getString("nome_produto"),rset.getInt("cod_produto"));
                favoritos.add(favorito); // adicionando à lista que será retornada
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return favoritos;
    } // buscarFavoritos()


    public List<Favorito> buscarFavoritoPorProduto(long cod_produto){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Favorito> favoritos = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT F.* FROM FAVORITO F WHERE COD_PRODUTO=?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setLong(1,cod_produto);
            rset = pstmt.executeQuery(); // executando a query
            while (rset.next()) {
                Favorito favorito = new Favorito(rset.getInt("id"), rset.getString("nome_produto"));
                favoritos.add(favorito); // adicionando à lista que será retornada
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return favoritos;
    }

    }//favoritosDAO
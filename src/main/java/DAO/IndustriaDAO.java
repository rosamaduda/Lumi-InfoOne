package DAO;

import Conexao.Conexao;
import Model.Industria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class IndustriaDAO {
    // INSERIR
    public boolean inserirIndustria(Industria industria) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // conectando o BD

        try {
            String instrucaoSQL = "INSERT INTO INDUSTRIA (CNPJ, NOME, OBJETIVO, EMAIL, SENHA, NOME_PLANO) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, industria.getCnpj());
            pstmt.setString(2, industria.getNome());
            pstmt.setString(3, industria.getObjetivo());
            pstmt.setString(4, industria.getEmail());
            pstmt.setString(5, industria.getSenha());
            pstmt.setString(6,industria.getNomePlano());
            if (pstmt.executeUpdate() > 0) {
                return true; // realizou a instrução
            } else {
                return false; // não realizou a instrução
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false; // não realizou a instrução
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
    } // inserirIndustria()

    // ALTERAR
    public int alterarCnpjIndustria(int id, String cnpj) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexao com o BD

        try {
            String instrucaoSQL = "UPDATE INDUSTRIA SET CNPJ = ? WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, cnpj);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() > 0) {
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // algum outro problema aconteceu
        } finally {
            conexao.desconectar(conn); // desconecta do BD
        }
    } // alterarCnpjIndustria()

    public int alterarNomeIndustria(int id, String nome) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // conectando o BD

        try {
            String instrucaoSQL = "UPDATE INDUSTRIA SET NOME = ? WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, nome);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() > 0) {
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // algum outro problema aconteceu
        } finally {
            conexao.desconectar(conn); // desconecta do BD
        }
    } // alterarNomeIndustria()


    public int alterarObjetivoIndustria(int id, String objetivo) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // conectando o BD

        try {
            String instrucaoSQL = "UPDATE INDUSTRIA SET OBJETIVO = ? WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, objetivo);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() > 0) {
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // algum outro problema aconteceu
        } finally {
            conexao.desconectar(conn); // desconecta do BD
        }
    } // alterarDescricaoIndustria()


    public int alterarEmailIndustria(int id, String email) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexao com o BD

        try {
            String instrucaoSQL = "UPDATE INDUSTRIA SET EMAIL = ? WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, email);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() > 0) {
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // algum outro problema aconteceu
        } finally {
            conexao.desconectar(conn); // desconecta do BD
        }
    } // alterarEmailIndustria()

    public int alterarPlanoIndustria(int id, String nomePlano) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "UPDATE INDUSTRIA SET NOME_PLANO = ? WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, nomePlano);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() > 0) {
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectando do BD
        }
    } // alterarPlanoIndustria()

    public int alterarIndustria(Industria industria) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "UPDATE INDUSTRIA SET CNPJ = ?, NOME = ?, OBJETIVO = ?, EMAIL = ?, SENHA = ?, NOME_PLANO = ? WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, industria.getCnpj());
            pstmt.setString(2, industria.getNome());
            pstmt.setString(3, industria.getObjetivo());
            pstmt.setString(4, industria.getEmail());
            pstmt.setString(5, industria.getSenha());
            pstmt.setString(6, industria.getNomePlano());
            pstmt.setInt(7, industria.getId());

            if (pstmt.executeUpdate() > 0) {
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectando do BD
        }
    }

    // DELETAR
    public int deletarIndustria(int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexao com o BD

        try {
            // deletando os campos que recebem a pk da indústria
            String instrucaoSQL = "DELETE FROM PRODUTO WHERE ID_INDUSTRIA = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            instrucaoSQL = "DELETE FROM TELEFONE_INDUSTRIA WHERE ID_INDUSTRIA = ?";
            pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            // deletando a indústria
            instrucaoSQL = "DELETE FROM INDUSTRIA WHERE ID = ?";
            pstmt = conn.prepareStatement(instrucaoSQL);
            // setando os parâmetros
            pstmt.setInt(1, id);
            if (pstmt.executeUpdate() > 0) { // executando a instrução
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
    }

    // SELECIONAR
    public List<Industria> buscarIndustria() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Industria> industrias = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT I.* FROM INDUSTRIA I";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Industria industria = new Industria(rset.getInt("id"), rset.getString("cnpj"), rset.getString("nome"),
                                                    rset.getString("objetivo"), rset.getString("senha"));
                industrias.add(industria); // adicionando o objeto à lista
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return industrias;
    }


    public List<Industria> buscarIndustriaPortal(){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Industria> industrias = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM INDUSTRIA I LIMIT 3";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Industria industria = new Industria(rset.getInt("id"), rset.getString("cnpj"), rset.getString("nome"),
                        rset.getString("objetivo"), rset.getString("senha"));
                industrias.add(industria); // adicionando o objeto à lista
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return industrias;
    }


    public List<Industria> buscarIndustriaPorNome(String nome){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Industria> industrias = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM INDUSTRIA WHERE NOME LIKE ? ";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1,"%"+nome+"%");
            rset = pstmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Industria industria = new Industria(rset.getInt("id"), rset.getString("cnpj"), rset.getString("nome"),
                        rset.getString("objetivo"), rset.getString("senha"));
                industrias.add(industria); // adicionando o objeto à lista
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return industrias;
    }

    public List<Industria> buscarIndustriaPorPlano(String plano){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Industria> industrias = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM INDUSTRIA WHERE PLANO_NOME LIKE ? ";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1,"%"+plano+"%");
            rset = pstmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Industria industria = new Industria(rset.getInt("id"), rset.getString("cnpj"), rset.getString("nome"),
                        rset.getString("objetivo"), rset.getString("senha"));
                industrias.add(industria); // adicionando o objeto à lista
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return industrias;
    }






    public int buscarIdIndustria() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        int id = 0;
        try {
            String instrucaoSQL = "SELECT ID FROM INDUSTRIA ORDER BY 1 DESC LIMIT 1";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query
            id = rset.getInt("id");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
        return id;
    }

} // IndustriaDAO

package DAO;

import Conexao.Conexao;
import Model.Cliente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    // INSERT
    public int inserirCliente(Cliente cliente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco de dados

        try {
            String instrucaoSQL = "INSERT INTO cliente VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, cliente.getEmail());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setString(3, cliente.getNome());
            pstmt.setString(4, cliente.getNomeSobrenome());
            pstmt.setObject(5, cliente.getDataNascimento());
            pstmt.setString(6, cliente.getSenha());
            pstmt.setDouble(7, cliente.getAltura());
            pstmt.setDouble(8, cliente.getPeso());
            pstmt.setInt(9, cliente.getDiabetes());
            pstmt.setString(10, cliente.getTelefone());
            pstmt.setBoolean(11, cliente.isPressaoAlta());
            pstmt.setString(12, cliente.getEnderecoUf());
            pstmt.setString(13, cliente.getEnderecoCidade());
            pstmt.setString(14, cliente.getEnderecoCep());
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
    } // inserirCliente()

    // UPDATE
    public int alterarCpfCliente(String email, String cpf) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            String instrucaoSQL = "UPDATE cliente SET cpf = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, cpf);
            pstmt.setString(2, email);
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
    } // alterarCpfCliente()

    public int alterarNomeCliente(String email, String nome) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            String instrucaoSQL = "UPDATE cliente SET nome = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, nome);
            pstmt.setString(2, email);
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
    } // alterarNomeCliente()

    public int alterarSobrenomeCliente(String email, String sobrenome) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            String instrucaoSQL = "UPDATE cliente SET nome_sobrenome = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, sobrenome);
            pstmt.setString(2, email);
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
    } // alterarSobrenomeCliente()

    public int alterarDataNascimentoCliente(String email, Date dataNascimento) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            String instrucaoSQL = "UPDATE cliente SET data_nascimento = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setDate(1, dataNascimento);
            pstmt.setString(2, email);
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
    } // alterarDataNascimentoCliente()

    public int alterarSenhaCliente(String email, String senha) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // fazendo a conexao com o BD

        try {
            String instrucaoSQL = "UPDATE cliente SET senha = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, senha);
            pstmt.setString(2, email);
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
    } // alterarSenhaCliente()

    public int alterarAlturaCliente(String email, double altura) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // conectando com o BD

        try {
            String instrucaoSQL = "UPDATE cliente SET altura = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setDouble(1, altura);
            pstmt.setString(2, email);
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
    } // alterarAlturaCliente()

    public int alterarPesoCliente(String email, double peso) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            String instrucaoSQL = "UPDATE cliente SET peso = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setDouble(1, peso);
            pstmt.setString(2, email);
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
    } // alterarPesoCliente()

    public int alterarDiabetesCliente(String email, int diabetes) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão abrir

        try {
            String instrucaoSQL = "UPDATE cliente SET diabetes = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando os parâmetros da instrução
            pstmt.setInt(1, diabetes);
            pstmt.setString(2, email);
            if (pstmt.executeUpdate() > 0) { // executando a instrucao e verificando o retorno
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        }
    }

    public int alterarPressaoAltaCliente(String email, boolean pressaoAlta) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão abrir

        try {
            String instrucaoSQL = "UPDATE cliente SET pressao_alta = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando os parâmetros da instrução
            pstmt.setBoolean(1, pressaoAlta);
            pstmt.setString(2, email);
            if (pstmt.executeUpdate() > 0) { // executando a instrucao e verificando o retorno
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        }
    }

    public int alterarTelefoneCliente(String email, int telefone) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão abrir

        try {
            String instrucaoSQL = "UPDATE cliente SET telefone = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando os parâmetros da instrução
            pstmt.setInt(1, telefone);
            pstmt.setString(2, email);
            if (pstmt.executeUpdate() > 0) { // executando a instrucao e verificando o retorno
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        }
    }

    public int alterarUfCliente(String email, String enderecoUf) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "UPDATE cliente SET endereco_uf = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, enderecoUf);
            pstmt.setString(2, email);
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
    } // alterarUfCliente()

    public int alterarCidadeCliente(String email, String enderecoCidade) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "UPDATE cliente SET endereco_cidade = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, enderecoCidade);
            pstmt.setString(2, email);
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
    } // alterarCidadeCliente()

    public int alterarCepCliente(String email, String enderecoCep) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "UPDATE cliente SET endereco_cep = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, enderecoCep);
            pstmt.setString(2, email);
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
    } // alterarCepCliente()

    public int alterarCliente(Cliente cliente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "UPDATE cliente SET cpf = ?, nome = ?, nome_sobrenome = ?, data_nascimento = ?, senha = ?, altura = ?, peso = ?, diabetes = ?, pressao_alta = ?, telefone = ?, endereco_uf = ?, endereco_cidade = ?, endereco_cep = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, cliente.getCpf());
            pstmt.setString(2, cliente.getNome());
            pstmt.setString(3, cliente.getNomeSobrenome());
            pstmt.setObject(4, cliente.getDataNascimento());
            pstmt.setString(5, cliente.getSenha());
            pstmt.setDouble(6, cliente.getAltura());
            pstmt.setDouble(7, cliente.getPeso());
            pstmt.setInt(8, cliente.getDiabetes());
            pstmt.setString(9, cliente.getTelefone());
            pstmt.setBoolean(10, cliente.isPressaoAlta());
            pstmt.setString(11, cliente.getEnderecoUf());
            pstmt.setString(12, cliente.getEnderecoCidade());
            pstmt.setString(13, cliente.getEnderecoCep());
            pstmt.setString(14, cliente.getEmail());
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
    } // alterarCliente()

    // DELETE
    public boolean deletarCliente(String email) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // conectando o BD

        try {
            // deletando os campos que recebem a pk do cliente
            String instrucaoSQL = "DELETE FROM favorito WHERE email_cliente = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, email);
            pstmt.executeUpdate();

            instrucaoSQL = "DELETE FROM usuario_alergia WHERE email_cliente = ?";
            pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, email);
            pstmt.executeUpdate();

            instrucaoSQL = "DELETE FROM avaliacao WHERE email_cliente = ?";
            pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, email);
            pstmt.executeUpdate();

            // deletando o cliente
            instrucaoSQL = "DELETE FROM usuario WHERE email = ?";
            pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, email);// setando parâmetro da instrução
            if (pstmt.executeUpdate() > 0){
                return true;
            } else {
                return false;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        } finally {
            conexao.desconectar(conn); // desconectando do BD
        }
    } // deletarCliente()

    // SELECT
    public List<Cliente> buscarCliente() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Cliente> lista = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM cliente";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Cliente usuario = new Cliente(rset.getString("email"), rset.getString("cpf"), rset.getString("nome"),
                        rset.getString("nome_sobrenome"), rset.getObject("data_nascimento", LocalDate.class), rset.getString("senha"),
                        rset.getDouble("altura"), rset.getDouble("peso"), rset.getInt("diabetes"), rset.getBoolean("pressao_alta"),
                        rset.getString("telefone"), rset.getString("endereco_uf"), rset.getString("endereco_cidade"),
                        rset.getString("endereco_cep"));
                lista.add(usuario);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando do BD
            return lista;
        }

    } // buscarCliente()
} // UsuarioDAO

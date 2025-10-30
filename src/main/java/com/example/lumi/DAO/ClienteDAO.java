package com.example.lumi.DAO;

import com.example.lumi.Conexao.Conexao;
import com.example.lumi.Model.Cliente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    // INSERIR
    public int inserirCliente(Cliente cliente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco

        try {
            String instrucaoSQL = "INSERT INTO CLIENTE VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando parâmetros da instrução
            pstmt.setString(1, cliente.getEmail());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setString(3, cliente.getNome());
            pstmt.setString(4, cliente.getNomeSobrenome());
            pstmt.setObject(5, cliente.getDataNascimento());
            pstmt.setString(6, cliente.getSenha());
            pstmt.setDouble(7, cliente.getAltura());
            pstmt.setString(8, cliente.getTelefone());
            pstmt.setDouble(9, cliente.getPeso());
            pstmt.setString(10, cliente.getDiabetes());
            pstmt.setBoolean(11, cliente.isPressaoAlta());
            pstmt.setString(12, cliente.getEnderecoUf());
            pstmt.setString(13, cliente.getEnderecoCep());
            pstmt.setString(14, cliente.getEnderecoCidade());
            pstmt.setBoolean(15, cliente.isColesterolAlto());

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

    // ALTERAR
    public int alterarCpfCliente(String email, String cpf) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco

        try {
            String instrucaoSQL = "UPDATE CLIENTE SET CPF = ? WHERE EMAIL = ?";
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
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
    } // alterarCpfCliente(String email, String cpf)

    public int alterarNomeCliente(String email, String nome) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            String instrucaoSQL = "UPDATE CLIENTE SET NOME = ? WHERE EMAIL = ?";
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
    } // alterarNomeCliente(String email, String nome)

    public int alterarSobrenomeCliente(String email, String sobrenome) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco

        try {
            String instrucaoSQL = "UPDATE CLIENTE SET NOME_SOBRENOME = ? WHERE EMAIL = ?";
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
    } // alterarSobrenomeCliente(String email, String sobrenome)

    public int alterarDataNascimentoCliente(String email, Date dataNascimento) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco

        try {
            String instrucaoSQL = "UPDATE CLIENTE SET DATA_NASCIMENTO = ? WHERE EMAIL = ?";
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
    } // alterarDataNascimentoCliente(String email, Date dataNascimento)

    public int alterarSenhaCliente(String email, String senha) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // fazendo a conexao com o BD

        try {
            String instrucaoSQL = "UPDATE CLIENTE SET SENHA = ? WHERE EMAIL = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando os parâmetros da instrução
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
    } // alterarSenhaCliente(String email, String senha)

    public int alterarAlturaCliente(String email, double altura) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // conectando com o BD

        try {
            String instrucaoSQL = "UPDATE CLIENTE SET ALTURA = ? WHERE EMAIL = ?";
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
            String instrucaoSQL = "UPDATE CLIENTE SET PESO = ? WHERE EMAIL = ?";
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
            String instrucaoSQL = "UPDATE CLIENTE SET DIABETES = ? WHERE EMAIL = ?";
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
            String instrucaoSQL = "UPDATE CLIENTE SET PRESSAO_ALTA = ? WHERE EMAIL = ?";
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
            String instrucaoSQL = "UPDATE CLIENTE SET TELEFONE = ? WHERE EMAIL = ?";
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
            String instrucaoSQL = "UPDATE CLIENTE SET ENDERECO_UF = ? WHERE EMAIL = ?";
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
            String instrucaoSQL = "UPDATE CLIENTE SET ENDERECO_CIDADE = ? WHERE EMAIL = ?";
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
            String instrucaoSQL = "UPDATE CLIENTE SET ENDERECO_CEP = ? WHERE EMAIL = ?";
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
            String instrucaoSQL = "UPDATE CLIENTE SET CPF = ?, NOME = ?, NOME_SOBRENOME = ?, DATA_NASCIMENTO = ?, SENHA = ?, ALTURA = ?, PESO = ?, DIABETES = ?, PRESSAO_ALTA = ?, COLESTEROL_ALTO = ?, TELEFONE = ?, ENDERECO_UF = ?, ENDERECO_CIDADE = ?, ENDERECO_CEP = ? WHERE EMAIL = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando parâmetros da instrução
            pstmt.setString(1, cliente.getCpf());
            pstmt.setString(2, cliente.getNome());
            pstmt.setString(3, cliente.getNomeSobrenome());
            pstmt.setObject(4, cliente.getDataNascimento());
            pstmt.setString(5, cliente.getSenha());
            pstmt.setDouble(6, cliente.getAltura());
            pstmt.setDouble(7, cliente.getPeso());
            pstmt.setString(8, cliente.getDiabetes());
            pstmt.setBoolean(9, cliente.isPressaoAlta());
            pstmt.setBoolean(10, cliente.isColesterolAlto());
            pstmt.setString(11, cliente.getTelefone());
            pstmt.setString(12, cliente.getEnderecoUf());
            pstmt.setString(13, cliente.getEnderecoCidade());
            pstmt.setString(14, cliente.getEnderecoCep());
            pstmt.setString(15, cliente.getEmail());

            if (pstmt.executeUpdate() > 0) { // executando a instrução e verificando o retorno
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
    public int deletarCliente(String email) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // conectando o BD

        try {
            String instrucaoSQL = "DELETE FROM CLIENTE WHERE EMAIL = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando parâmetro da instrução
            pstmt.setString(1, email);

            if (pstmt.executeUpdate() > 0) { // executando a instrução e verificando o retorno
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
    } // deletarCliente()

    // SELECT
    public List<Cliente> buscarCliente() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Cliente> listaClientes = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM CLIENTE";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Cliente cliente = new Cliente(rset.getString("email"), rset.getString("cpf"), rset.getString("nome"),
                        rset.getString("nome_sobrenome"), rset.getObject("data_nascimento", LocalDate.class), rset.getString("senha"),
                        rset.getDouble("altura"), rset.getDouble("peso"), rset.getString("diabetes"), rset.getBoolean("pressao_alta"),
                        rset.getBoolean("colesterol_alto"), rset.getString("telefone"), rset.getString("endereco_uf"),
                        rset.getString("endereco_cidade"), rset.getString("endereco_cep"));
                listaClientes.add(cliente); // adicionando à lista que será retornada
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (DateTimeParseException dtpe) {
            dtpe.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando do BD
        }
        return listaClientes;
    } // buscarCliente()

    public Cliente buscarClientePorEmail(String email) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        Cliente cliente = null;

        try {
            String instrucaoSQL = "SELECT * FROM CLIENTE WHERE EMAIL LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, email); // setando os parâmetros na instrução
            rset = pstmt.executeQuery(); // executando a query

            while (rset.next()) {
                cliente = new Cliente(rset.getString("email"), rset.getString("cpf"), rset.getString("nome"),
                        rset.getString("nome_sobrenome"), rset.getObject("data_nascimento", LocalDate.class), rset.getString("senha"),
                        rset.getDouble("altura"), rset.getDouble("peso"), rset.getString("diabetes"), rset.getBoolean("pressao_alta"),
                        rset.getBoolean("colesterol_alto"), rset.getString("telefone"), rset.getString("endereco_uf"),
                        rset.getString("endereco_cidade"), rset.getString("endereco_cep"));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando do BD
        }
        return cliente;
    } // buscarCliente(String email)


    public List<Cliente> buscarClientePortal() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Cliente> listaCliente = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM CLIENTE LIMIT 3";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Cliente cliente = new Cliente(rset.getString("email"), rset.getString("cpf"), rset.getString("nome"),
                        rset.getString("nome_sobrenome"), rset.getObject("data_nascimento", LocalDate.class), rset.getString("senha"),
                        rset.getDouble("altura"), rset.getDouble("peso"), rset.getString("diabetes"), rset.getBoolean("pressao_alta"),
                        rset.getBoolean("colesterol_alto"), rset.getString("telefone"), rset.getString("endereco_uf"),
                        rset.getString("endereco_cidade"), rset.getString("endereco_cep"));
                listaCliente.add(cliente); // adicionando à lista que será retornada
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando do BD
        }
        return listaCliente;
    } // buscarCliente()

    public List<Cliente> buscarEmailCliente() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        List<Cliente> listaClientes = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT EMAIL FROM CLIENTE";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Cliente cliente = new Cliente(rset.getString("email"));
                listaClientes.add(cliente); // adicionando à lista que será retornada
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando do BD
        }
        return listaClientes;
    } // buscarEmailCliente()

    public List<Cliente> buscarClientePorUF(String uf) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        ResultSet rset;
        List<Cliente> listaClientes = new ArrayList<>();

        try{
            String instrucaoSQL = "SELECT * FROM CLIENTE WHERE ENDERECO_UF LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, uf); // setando o parâmetro da instrução
            rset = pstmt.executeQuery(); // executando ao instrução

            while(rset.next()){
                Cliente cliente = new Cliente(rset.getString("email"), rset.getString("cpf"), rset.getString("nome"),
                        rset.getString("nome_sobrenome"), rset.getObject("data_nascimento", LocalDate.class), rset.getString("senha"),
                        rset.getDouble("altura"), rset.getDouble("peso"), rset.getString("diabetes"), rset.getBoolean("pressao_alta"),
                        rset.getBoolean("colesterol_alto"), rset.getString("telefone"), rset.getString("endereco_uf"),
                        rset.getString("endereco_cidade"), rset.getString("endereco_cep"));
                listaClientes.add(cliente); // adicionando à lista que será retornada
            }
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
        finally {
            conexao.desconectar(conn); // desconectando com o banco
        }
        return listaClientes;
    } // buscarClientePorUF(String uf)


    public List<Cliente> buscarClientePorCidade(String cidade) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco
        ResultSet rset;
        List<Cliente> listaClientes = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM CLIENTE WHERE ENDERECO_CIDADE LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, "%"+cidade+"%"); // setando o parâmetro na instrução
            rset = pstmt.executeQuery(); // executando a instrução
            while(rset.next()){
                Cliente cliente = new Cliente(rset.getString("email"), rset.getString("cpf"), rset.getString("nome"),
                        rset.getString("nome_sobrenome"), rset.getObject("data_nascimento", LocalDate.class), rset.getString("senha"),
                        rset.getDouble("altura"), rset.getDouble("peso"), rset.getString("diabetes"), rset.getBoolean("pressao_alta"),
                        rset.getBoolean("colesterol_alto"), rset.getString("telefone"), rset.getString("endereco_uf"),
                        rset.getString("endereco_cidade"), rset.getString("endereco_cep"));
                listaClientes.add(cliente); // adicionando o objeto à lista que será retornada
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
        return listaClientes;
    } // buscarClientePorCidade(String cidade)

    public List<Cliente> buscarClientePorNomeCompleto(String nomeSobrenome) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco
        ResultSet rset;
        List<Cliente> listaClientes = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM CLIENTE WHERE NOME || ' ' || NOME_SOBRENOME LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, "%"+nomeSobrenome+"%"); // setando o parâmetro na instrução
            rset = pstmt.executeQuery(); // executando a instrução
            while(rset.next()){
                Cliente cliente = new Cliente(rset.getString("email"), rset.getString("cpf"), rset.getString("nome"),
                        rset.getString("nome_sobrenome"), rset.getObject("data_nascimento", LocalDate.class), rset.getString("senha"),
                        rset.getDouble("altura"), rset.getDouble("peso"), rset.getString("diabetes"), rset.getBoolean("pressao_alta"),
                        rset.getBoolean("colesterol_alto"), rset.getString("telefone"), rset.getString("endereco_uf"),
                        rset.getString("endereco_cidade"), rset.getString("endereco_cep"));
                listaClientes.add(cliente); // adicionando o objeto à lista que será retornada
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
        return listaClientes;
    } // buscarClientePorNomeCompleto(String nomeSobrenome)
} // ClienteDAO

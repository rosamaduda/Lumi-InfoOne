package com.example.lumi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import com.example.lumi.Conexao.Conexao;
import com.example.lumi.Model.Cliente;

public class ClienteDAO {
    // INSERIR
    public int inserirCliente(Cliente cliente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco

        try {
            String instrucaoSQL = "INSERT INTO CLIENTE (EMAIL, CPF, NOME, NOME_SOBRENOME, DT_NASCIMENTO, SENHA, ALTURA, PESO, DIABETES, PRESSAO_ALTA, COLESTEROL_ALTO, TELEFONE, ENDERECO_UF, ENDERECO_CEP, ENDERECO_CIDADE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // inserindo as informações do cliente
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
            pstmt.setString(9, cliente.getDiabetes());
            pstmt.setBoolean(10, cliente.isPressaoAlta());
            pstmt.setBoolean(11, cliente.isColesterolAlto());
            pstmt.setString(12, cliente.getTelefone());
            pstmt.setString(13, cliente.getEnderecoUf());
            pstmt.setString(14, cliente.getEnderecoCep());
            pstmt.setString(15, cliente.getEnderecoCidade());


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
    public int alterarCliente(Cliente cliente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "UPDATE CLIENTE SET CPF = ?, NOME = ?, NOME_SOBRENOME = ?, DT_NASCIMENTO = ?, SENHA = ?, ALTURA = ?, PESO = ?, DIABETES = ?, PRESSAO_ALTA = ?, COLESTEROL_ALTO = ?, TELEFONE = ?, ENDERECO_UF = ?, ENDERECO_CIDADE = ?, ENDERECO_CEP = ? WHERE EMAIL = ?"; // alterando o cliente
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
            String instrucaoSQL = "DELETE FROM CLIENTE WHERE EMAIL = ?"; // deletando o cliente a partir da pk
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
        List<Cliente> lista = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM CLIENTE"; // buscando tudo do cliente
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Cliente cliente = new Cliente(rset.getString("email"), rset.getString("cpf"), rset.getString("nome"),
                        rset.getString("nome_sobrenome"), rset.getObject("dt_nascimento", LocalDate.class), rset.getString("senha"),
                        rset.getDouble("altura"), rset.getDouble("peso"), rset.getString("diabetes"), rset.getBoolean("pressao_alta"),
                        rset.getBoolean("colesterol_alto"), rset.getString("telefone"), rset.getString("endereco_uf"),
                        rset.getString("endereco_cidade"), rset.getString("endereco_cep"));
                lista.add(cliente); // adicionando à lista que será retornada
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (DateTimeParseException dtpe) {
            dtpe.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando do BD
        }
        return lista;
    } // buscarCliente()

    public Cliente buscarCliente(String email) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset;
        Cliente cliente = null;

        try {
            String instrucaoSQL = "SELECT * FROM CLIENTE WHERE EMAIL = ?"; // buscando o cliente pelo email
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, email); // setando os parâmetros na instrução
            rset = pstmt.executeQuery(); // executando a query

            while (rset.next()) {
                cliente = new Cliente(rset.getString("email"), rset.getString("cpf"), rset.getString("nome"),
                        rset.getString("nome_sobrenome"), rset.getObject("dt_nascimento", LocalDate.class), rset.getString("senha"),
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
        List<Cliente> lista = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM CLIENTE LIMIT 3";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Cliente cliente = new Cliente(rset.getString("email"), rset.getString("cpf"), rset.getString("nome"),
                        rset.getString("nome_sobrenome"), rset.getObject("dt_nascimento", LocalDate.class), rset.getString("senha"),
                        rset.getDouble("altura"), rset.getDouble("peso"), rset.getString("diabetes"), rset.getBoolean("pressao_alta"),
                        rset.getBoolean("colesterol_alto"), rset.getString("telefone"), rset.getString("endereco_uf"),
                        rset.getString("endereco_cidade"), rset.getString("endereco_cep"));
                lista.add(cliente); // adicionando à lista que será retornada
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // desconectando do BD
        }
        return lista;
    } // buscarCliente()

    public List<Cliente> buscarClientePorUF(String uf) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        ResultSet rset;
        List<Cliente> lista = new ArrayList<>();

        try{
            String instrucaoSQL = "SELECT * FROM CLIENTE WHERE LOWER(ENDERECO_UF) LIKE ?"; // buscando o cliente pela UF
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, "%"+uf+"%"); // setando o parâmetro da instrução
            rset = pstmt.executeQuery(); // executando ao instrução

            while(rset.next()){
                Cliente cliente = new Cliente(rset.getString("email"), rset.getString("cpf"), rset.getString("nome"),
                        rset.getString("nome_sobrenome"), rset.getObject("dt_nascimento", LocalDate.class), rset.getString("senha"),
                        rset.getDouble("altura"), rset.getDouble("peso"), rset.getString("diabetes"), rset.getBoolean("pressao_alta"),
                        rset.getBoolean("colesterol_alto"), rset.getString("telefone"), rset.getString("endereco_uf"),
                        rset.getString("endereco_cidade"), rset.getString("endereco_cep"));
                lista.add(cliente); // adicionando à lista que será retornada
            }
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
        finally {
            conexao.desconectar(conn); // desconectando com o banco
        }
        return lista;
    } // buscarClientePorUF(String uf)

    public List<Cliente> buscarClientePorCidade(String cidade) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco
        ResultSet rset;
        List<Cliente> lista = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM CLIENTE WHERE LOWER(ENDERECO_CIDADE) LIKE ?"; // buscando o cliente pela cidade
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, "%"+cidade+"%"); // setando o parâmetro na instrução
            rset = pstmt.executeQuery(); // executando a instrução
            while(rset.next()){
                Cliente cliente = new Cliente(rset.getString("email"), rset.getString("cpf"), rset.getString("nome"),
                        rset.getString("nome_sobrenome"), rset.getObject("dt_nascimento", LocalDate.class), rset.getString("senha"),
                        rset.getDouble("altura"), rset.getDouble("peso"), rset.getString("diabetes"), rset.getBoolean("pressao_alta"),
                        rset.getBoolean("colesterol_alto"), rset.getString("telefone"), rset.getString("endereco_uf"),
                        rset.getString("endereco_cidade"), rset.getString("endereco_cep"));
                lista.add(cliente); // adicionando o objeto à lista que será retornada
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
        return lista;
    } // buscarClientePorCidade(String cidade)

    public List<Cliente> buscarClientePorNomeCompleto(String nomeSobrenome) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco
        ResultSet rset;
        List<Cliente> lista = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM CLIENTE WHERE LOWER(NOME || ' ' || NOME_SOBRENOME) LIKE ?"; // buscando o cliente pelo nome completo
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, "%"+nomeSobrenome+"%"); // setando o parâmetro na instrução
            rset = pstmt.executeQuery(); // executando a instrução
            while(rset.next()){
                Cliente cliente = new Cliente(rset.getString("email"), rset.getString("cpf"), rset.getString("nome"),
                        rset.getString("nome_sobrenome"), rset.getObject("dt_nascimento", LocalDate.class), rset.getString("senha"),
                        rset.getDouble("altura"), rset.getDouble("peso"), rset.getString("diabetes"), rset.getBoolean("pressao_alta"),
                        rset.getBoolean("colesterol_alto"), rset.getString("telefone"), rset.getString("endereco_uf"),
                        rset.getString("endereco_cidade"), rset.getString("endereco_cep"));
                lista.add(cliente); // adicionando o objeto à lista que será retornada
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // fechando a conexão com o banco
        }
        return lista;
    } // buscarClientePorNomeCompleto(String nomeSobrenome)
} // ClienteDAO
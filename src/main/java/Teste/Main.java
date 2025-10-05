package Teste;

import Conexao.Conexao;

public class Main {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();

        if (conexao.conectar() == null) {
            System.out.println("Conexão deu errado\n");
        } else {
            System.out.println("Conexão feita com sucesso.\n");
        }
    }
}

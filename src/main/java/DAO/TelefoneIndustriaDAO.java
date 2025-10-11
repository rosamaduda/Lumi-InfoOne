package DAO;

import Conexao.Conexao;

import java.sql.Connection;

public class TelefoneIndustria {
            public int adicionarTelIndustria(TelefoneIndustria tel){
                Conexao conexao=new Conexao();
                Connection conn= conexao.conectar();
                try{
                    String instrucaoSQL="INSERT INTO TEL_INDUSTRIA (TELEFONE,ID_INDUSTRIA) ";

                }
            }
        }

        

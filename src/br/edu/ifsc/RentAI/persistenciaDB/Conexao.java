package br.edu.ifsc.RentAI.persistenciaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
    private static final String URL = "jdbc:sqlite:database/rentai.db";
    private static Connection conexao;

    public static Connection getConexao() {
        try {
            if (conexao != null && conexao.isValid(5))
                return conexao;
            conexao = DriverManager.getConnection(URL);
            return conexao;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }

    public static void fecharConexao() {
        try {
            if (conexao != null)
                conexao.close();
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
        }
    }

    public static void criarTabelas() {
        String sql = "CREATE TABLE IF NOT EXISTS 'Cliente' (" +
                "'nome' TEXT NOT NULL," +
                "'cpf_cnpj' TEXT NOT NULL UNIQUE," +
                "'telefone' TEXT," +
                "'email' TEXT," +
                "'nome_usuario' TEXT UNIQUE," +
                "'senha_hash' TEXT," +
                "PRIMARY KEY ('cpf_cnpj')" +
                ");" +

                "CREATE TABLE IF NOT EXISTS 'Corretor' (" +
                "'nome' TEXT NOT NULL," +
                "'creci' TEXT NOT NULL UNIQUE," +
                "'telefone' TEXT," +
                "'email' TEXT," +
                "'nome_usuario' TEXT UNIQUE," +
                "'senha_hash' TEXT," +
                "PRIMARY KEY ('creci')" +
                ");" +

                "CREATE TABLE IF NOT EXISTS 'Proprietario' (" +
                "'nome' TEXT NOT NULL," +
                "'cpf_cnpj' TEXT NOT NULL UNIQUE," +
                "'telefone' TEXT," +
                "'email' TEXT," +
                "'nome_usuario' TEXT UNIQUE," +
                "'senha_hash' TEXT NOT NULL," +
                "PRIMARY KEY ('cpf_cnpj')" +
                ");" +

                "CREATE TABLE IF NOT EXISTS 'Imovel' (" +
                "'id_imovel' INTEGER," +
                "'tipo' TEXT NOT NULL," +
                "'endereco' TEXT," +
                "'metragem' REAL," +
                "'quartos' INTEGER," +
                "'banheiros' INTEGER," +
                "'vagas' INTEGER," +
                "'status' TEXT CHECK('status' IN ('disponível', 'vendido', 'em negociação'))," +
                "'cpf_cnpj_proprietario' TEXT NOT NULL," +
                "'creci_corretor' TEXT NOT NULL," +
                "PRIMARY KEY('id_imovel')," +
                "FOREIGN KEY ('cpf_cnpj_proprietario') REFERENCES 'Proprietario'('cpf_cnpj')" +
                "FOREIGN KEY ('creci_corretor') REFERENCES 'Corretor'('creci')" +
                ");" +

                "CREATE TABLE IF NOT EXISTS 'Proposta' (" +
                "'id_proposta' INTEGER," +
                "'valor_oferecido' REAL NOT NULL," +
                "'data_proposta' DATE NOT NULL," +
                "'status' TEXT CHECK('status' IN ('pendente', 'aceita', 'recusada'))," +
                "'cpf_cnpj_cliente' TEXT NOT NULL," +
                "'creci_corretor' TEXT NOT NULL," +
                "'id_imovel' INTEGER NOT NULL," +
                "PRIMARY KEY('id_proposta')," +
                "FOREIGN KEY ('cpf_cnpj_cliente') REFERENCES 'Cliente'('cpf_cnpj')" +
                "FOREIGN KEY ('creci_corretor') REFERENCES 'Corretor'('creci')" +
                "FOREIGN KEY ('id_imovel') REFERENCES 'Imovel'('id_imovel')" +
                ");" +

                "CREATE TABLE IF NOT EXISTS 'Venda' (" +
                "'id_venda' INTEGER NOT NULL," +
                "'valor_final' REAL NOT NULL," +
                "'data_venda' DATE NOT NULL," +
                "'forma_pagamento' TEXT CHECK('forma_pagamento' IN ('à vista', 'financiamento', 'parcelado'))," +
                "'valor_comissao_paga' REAL," +
                "'creci_corretor' TEXT NOT NULL," +
                "'id_imovel' INTEGER NOT NULL," +
                "'cpf_cnpj_proprietario' TEXT NOT NULL," +
                "'cpf_cnpj_cliente' TEXT NOT NULL," +
                "PRIMARY KEY('id_venda')," +
                "FOREIGN KEY ('cpf_cnpj_cliente') REFERENCES 'Cliente'('cpf_cnpj')" +
                "FOREIGN KEY ('creci_corretor') REFERENCES 'Corretor'('creci')" +
                "FOREIGN KEY ('id_imovel') REFERENCES 'Imovel'('id_imovel')" +
                "FOREIGN KEY ('cpf_cnpj_proprietario') REFERENCES 'Proprietario'('cpf_cnpj')" +
                ");"
                ;

        try (Statement stmt = getConexao().createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Erro ao criar a tabela de clientes: " + e.getMessage());
        }
    }
}

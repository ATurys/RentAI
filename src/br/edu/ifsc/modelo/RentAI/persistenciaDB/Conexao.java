package br.edu.ifsc.modelo.RentAI.persistenciaDB;

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
        String sql = """
            CREATE TABLE IF NOT EXISTS Cliente (
                id_cliente INTEGER PRIMARY KEY,
                nome TEXT NOT NULL,
                cpf_cnpj TEXT NOT NULL UNIQUE,
                telefone TEXT,
                email TEXT,
                nome_usuario TEXT UNIQUE,
                senha_hash TEXT
            );

            CREATE TABLE IF NOT EXISTS Corretor (
                id_corretor INTEGER PRIMARY KEY,
                nome TEXT NOT NULL,
                creci TEXT NOT NULL UNIQUE,
                telefone TEXT,
                email TEXT,
                percentual_comissao REAL,
                senha_hash TEXT
            );

            CREATE TABLE IF NOT EXISTS Imovel (
                id_imovel INTEGER PRIMARY KEY,
                tipo TEXT NOT NULL,
                endereco TEXT,
                metragem REAL,
                quartos INTEGER,
                banheiros INTEGER,
                vagas INTEGER,
                status TEXT CHECK(status IN ('disponível', 'vendido', 'em negociação')),
                id_proprietario INTEGER NOT NULL,
                id_corretor INTEGER,
                FOREIGN KEY (id_proprietario) REFERENCES Proprietario(id_proprietario),
                FOREIGN KEY (id_corretor) REFERENCES Corretor(id_corretor)
            );

            CREATE TABLE IF NOT EXISTS Proposta (
                id_proposta INTEGER PRIMARY KEY,
                valor_oferecido REAL NOT NULL,
                data_proposta DATE NOT NULL,
                status TEXT CHECK(status IN ('pendente', 'aceita', 'recusada')),
                id_cliente INTEGER NOT NULL,
                id_imovel INTEGER NOT NULL,
                FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
                FOREIGN KEY (id_imovel) REFERENCES Imovel(id_imovel)
            );

            CREATE TABLE IF NOT EXISTS Proprietario (
                id_proprietario INTEGER PRIMARY KEY,
                nome TEXT NOT NULL,
                cpf_cnpj TEXT NOT NULL UNIQUE,
                telefone TEXT,
                email TEXT,
                endereco TEXT
            );

            CREATE TABLE IF NOT EXISTS Venda (
                id_venda INTEGER PRIMARY KEY,
                data_venda DATE NOT NULL,
                valor_final REAL NOT NULL,
                forma_pagamento TEXT CHECK(forma_pagamento IN ('à vista', 'financiamento', 'parcelado')),
                comissao_paga BOOLEAN,
                id_cliente INTEGER NOT NULL,
                id_corretor INTEGER NOT NULL,
                id_imovel INTEGER UNIQUE NOT NULL,
                FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
                FOREIGN KEY (id_corretor) REFERENCES Corretor(id_corretor),
                FOREIGN KEY (id_imovel) REFERENCES Imovel(id_imovel)
            );
            """;

        try (Statement stmt = getConexao().createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Erro ao criar a tabela de clientes: " + e.getMessage());
        }
    }
}

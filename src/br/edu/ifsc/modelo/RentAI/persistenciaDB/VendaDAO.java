package br.edu.ifsc.modelo.RentAI.persistenciaDB;

import br.edu.ifsc.modelo.RentAI.modelo.transacoes.Venda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO implements DAO<Venda, Integer> {
    private static VendaDAO instance;
    private VendaDAO() {}
    public static VendaDAO getInstance() {
        if (instance == null) {
            instance = new VendaDAO();
        }
        return instance;
    }

    @Override
    public void criar(Venda entidade) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "INSERT INTO Venda (" +
                    "id_venda, " +
                    "id_imovel, " +
                    "creci_corretor, " +
                    "cpf_cnpj_cliente, " +
                    "cpf_cnpj_proprietario, " +
                    "data_venda, " +
                    "valor_final, " +
                    "forma_pagamento, " +
                    "valor_comissao_paga) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, entidade.getId());
            statement.setInt(2, entidade.getProposta().getImovel().getIdImovel());
            statement.setString(3, entidade.getProposta().getCorretor().getCreciCoretor());
            statement.setString(4, entidade.getProposta().getCliente().getCpfOuCnpjCliente());
            statement.setString(5, entidade.getDonoImovel().getCpfOuCnpjDonoImovel());
            statement.setDate(6, entidade.getDateTimeVenda());
            statement.setFloat(7, entidade.getValorFinalVenda());
            statement.setString(8, entidade.getFormaPagamentoVenda());
            statement.setFloat(9, entidade.getComissao());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao criar a venda " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Venda entidade, Integer arg) {

    }


    public void atualizarValor(Venda entidade, Integer arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Venda SET valor_final = ? WHERE id_venda = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setFloat(1, entidade.getValorFinalVenda());
            statement.setInt(2, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o valor da venda " + e.getMessage());
        }
    }

    public void atualizarPagamento(Venda entidade, Integer arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Venda SET forma_pagamento = ? WHERE id_venda = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, entidade.getFormaPagamentoVenda());
            statement.setInt(2, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar a forma de pagamento da venda " + e.getMessage());
        }
    }

    public void atualizarCorretor(Venda entidade, Integer arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Venda SET creci_corretor = ? WHERE id_venda = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, entidade.getProposta().getCorretor().getCreciCoretor());
            statement.setInt(2, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o corretor responsável pela venda " + e.getMessage());
        }
    }

    public void atualizarCliente(Venda entidade, Integer arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Venda SET cpf_cnpj_cliente = ? WHERE id_venda = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, entidade.getProposta().getCliente().getCpfOuCnpjCliente());
            statement.setInt(2, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o cliente da venda " + e.getMessage());
        }
    }

    public void atualizarComissao(Venda entidade, Integer arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Venda SET valor_comissao_paga = ? WHERE id_venda = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setFloat(1, entidade.getComissao());
            statement.setInt(2, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o valor da comissao da venda " + e.getMessage());
        }
    }

    @Override
    public void deletar(Venda entidade) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "DELETE FROM Venda WHERE id_venda = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, entidade.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao deletar a venda " + e.getMessage());
        }
    }

    @Override
    public Venda buscar(Integer arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT * FROM Venda WHERE id_venda = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, arg);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Venda v = new Venda(
                        resultSet.getString("creci_corretor"),
                        resultSet.getString("cpf_cnpj_cliente"),
                        resultSet.getString("cpf_cnpj_proprietario"),
                        resultSet.getInt("id_imovel"),
                        resultSet.getInt("id_venda"),
                        resultSet.getFloat("valor_final"),
                        resultSet.getString("forma_pagamento"),
                        resultSet.getFloat("valor_comissao_paga"),
                        resultSet.getDate("data_venda"));
                return v;
            }else{
                System.out.println("Não existe uma venda com o ID " + arg);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar a venda pelo ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Venda> buscarTodos() {
        List<Venda> vendas = new ArrayList<>();
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT * from Venda";
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Venda v = new Venda(
                        resultSet.getString("creci_corretor"),
                        resultSet.getString("cpf_cnpj_cliente"),
                        resultSet.getString("cpf_cnpj_proprietario"),
                        resultSet.getInt("id_imovel"),
                        resultSet.getInt("id_venda"),
                        resultSet.getFloat("valor_final"),
                        resultSet.getString("forma_pagamento"),
                        resultSet.getFloat("valor_comissao_paga"),
                        resultSet.getDate("data_venda"));
                vendas.add(v);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar todos as vendas " + e.getMessage());
        }
        return vendas;
    }
}

package br.edu.ifsc.RentAI.persistenciaDB;

import br.edu.ifsc.RentAI.modelo.transacoes.Venda;
import br.edu.ifsc.RentAI.modelo.usuarios.Cliente;
import br.edu.ifsc.RentAI.modelo.usuarios.Corretor;
import br.edu.ifsc.RentAI.modelo.usuarios.DonoImovel;

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
                Corretor corretor = CorretorDAO.getInstancia().buscar(resultSet.getString("creci_corretor"));
                if (corretor == null) {
                    corretor = new Corretor(null, null, "Não registrado no sistema", "", null, null, resultSet.getString("creci_corretor"));
                }
                Cliente cliente = ClienteDAO.getInstancia().buscar(resultSet.getString("cpf_cnpj_cliente"));
                if (cliente == null) {
                    cliente = new Cliente(null, null, "Não registrado no sistema", "", null, null, resultSet.getString("cpf_cnpj_cliente"));
                }

                DonoImovel proprietario = ProprietarioDAO.getInstancia().buscar(resultSet.getString("cpf_cnpj_proprietario"));
                if (proprietario == null) {
                    proprietario = new DonoImovel(null, null, "Não registrado no sistema", "", null, null, resultSet.getString("cpf_cnpj_proprietario"));
                }
                Venda v = new Venda(
                        corretor,
                        cliente,
                        proprietario,
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
                Corretor corretor = CorretorDAO.getInstancia().buscar(resultSet.getString("creci_corretor"));
                if (corretor == null) {
                    corretor = new Corretor(null, null, "Não registrado no sistema", "", null, null, resultSet.getString("creci_corretor"));
                }
                Cliente cliente = ClienteDAO.getInstancia().buscar(resultSet.getString("cpf_cnpj_cliente"));
                if (cliente == null) {
                    cliente = new Cliente(null, null, "Não registrado no sistema", "", null, null, resultSet.getString("cpf_cnpj_cliente"));
                }

                DonoImovel proprietario = ProprietarioDAO.getInstancia().buscar(resultSet.getString("cpf_cnpj_proprietario"));
                if (proprietario == null) {
                    proprietario = new DonoImovel(null, null, "Não registrado no sistema", "", null, null, resultSet.getString("cpf_cnpj_proprietario"));
                }
                Venda v = new Venda(
                        corretor,
                        cliente,
                        proprietario,
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

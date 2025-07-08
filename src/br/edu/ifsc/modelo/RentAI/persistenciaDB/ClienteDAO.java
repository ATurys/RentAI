package br.edu.ifsc.modelo.RentAI.persistenciaDB;

import br.edu.ifsc.modelo.RentAI.modelo.usuarios.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class ClienteDAO implements DAO<Cliente, String> {
    private static ClienteDAO instancia;
    private ClienteDAO(){}
    public static ClienteDAO getInstancia() {
        if (instancia == null) {
            instancia = new ClienteDAO();
        }
        return instancia;
    }

    @Override
    public void criar(Cliente entidade) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "INSERT INTO Cliente (cpf_cnpj, nome, telefone, email, nome_usuario, senha_hash) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, entidade.getCpfOuCnpjCliente());
            String nomeCompleto = entidade.getNome() + entidade.getSobrenome();
            statement.setString(2, nomeCompleto);
            statement.setString(3, entidade.getTelefone());
            statement.setString(4, entidade.getEmail());
            statement.setString(5, entidade.getUserName());
            statement.setString(6, entidade.getSenha());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao criar o cliente " + e.getMessage());
        }
    }

    @Override
    /*
     * atualizar() atualiza a chave primaria
     */
    public void atualizar(Cliente entidade, String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Cliente SET cpf_cnpj = ? WHERE cpf_cnpj = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(2, entidade.getCpfOuCnpjCliente());
            statement.setString(1, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o cpf_cnpj do cliente " + e.getMessage());
        }
    }

    public void atualizarSenha(Cliente entidade, String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Cliente SET senha_hash = ? WHERE cpf_cnpj = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(2, entidade.getCpfOuCnpjCliente());
            statement.setString(1, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar a senha do cliente " + e.getMessage());
        }
    }

    public void atualizarNome(Cliente entidade, String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Cliente SET nome = ? WHERE cpf_cnpj = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(2, entidade.getCpfOuCnpjCliente());
            statement.setString(1, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o nome do cliente " + e.getMessage());
        }
    }

    public void atualizarEmail(Cliente entidade, String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Cliente SET email = ? WHERE cpf_cnpj = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(2, entidade.getCpfOuCnpjCliente());
            statement.setString(1, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o email do cliente " + e.getMessage());
        }
    }

    public void atualizarTelefone(Cliente entidade, String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Cliente SET telefone = ? WHERE cpf_cnpj = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, entidade.getTelefone());
            statement.setString(2, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o telefone do cliente " + e.getMessage());
        }
    }

    @Override
    public void deletar(Cliente entidade) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "DELETE FROM Cliente WHERE cpf_cnpj = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, entidade.getCpfOuCnpjCliente());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao deletar o cliente " + e.getMessage());
        }
    }

    @Override
    public Cliente buscar(String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT * FROM Cliente WHERE cpf_cnpj = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, arg);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String[] nome = resultSet.getString("nome").split(" ");
                Cliente c = new Cliente(
                        resultSet.getString("email"),
                        resultSet.getString("senha_hash"),
                        nome[0],
                        nome[1],
                        resultSet.getString("telefone"),
                        resultSet.getString("nome_usuario"),
                        resultSet.getString("cpf_cnpj"));
                return c;
            }else{
                System.out.println("Não existe um cliente com o cpf ou cnpj " + arg);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar o cliente por cpf_cnpj: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Cliente> buscarTodos() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT * from Cliente";
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String[] nome = resultSet.getString("nome").split(" ");
                Cliente c = new Cliente(
                        resultSet.getString("email"),
                        resultSet.getString("senha_hash"),
                        nome[0],
                        nome[1],
                        resultSet.getString("telefone"),
                        resultSet.getString("nome_usuario"),
                        resultSet.getString("cpf_cnpj"));
                clientes.add(c);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar todos os clientes " + e.getMessage());
        }
        return clientes;
    }
}

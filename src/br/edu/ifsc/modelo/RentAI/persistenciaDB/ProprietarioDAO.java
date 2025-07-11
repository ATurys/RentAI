package br.edu.ifsc.modelo.RentAI.persistenciaDB;

import br.edu.ifsc.modelo.RentAI.modelo.usuarios.DonoImovel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProprietarioDAO implements DAO<DonoImovel, String>{
    private static ProprietarioDAO instancia;
    private ProprietarioDAO(){}
    public static ProprietarioDAO getInstancia(){
        if (instancia == null){
            instancia = new ProprietarioDAO();
        }
        return instancia;
    }


    @Override
    public void criar(DonoImovel entidade) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "INSERT INTO Proprietario (cpf_cnpj, nome, telefone, email, senha_hash, nome_usuario) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, entidade.getCpfOuCnpjDonoImovel());
            String nomeCompleto = entidade.getNome() + " " + entidade.getSobrenome();
            statement.setString(2, nomeCompleto);
            statement.setString(3, entidade.getTelefone());
            statement.setString(4, entidade.getEmail());
            statement.setString(5, entidade.getSenha());
            statement.setString(6, entidade.getUserName());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao criar o proprietario " + e.getMessage());
        }
    }

    @Override
    /*
     * atualizar() atualiza a chave primaria
     */
    public void atualizar(DonoImovel entidade, String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Proprietario SET cpf_cnpj = ? WHERE cpf_cnpj = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(2, entidade.getCpfOuCnpjDonoImovel());
            statement.setString(1, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o cpf ou cnpj do proprietario " + e.getMessage());
        }
    }

    public void atualizarSenha(DonoImovel entidade, String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Proprietario SET senha_hash = ? WHERE cpf_cnpj = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(2, entidade.getCpfOuCnpjDonoImovel());
            statement.setString(1, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar a senha do proprietario " + e.getMessage());
        }
    }

    public void atualizarNome(DonoImovel entidade, String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Proprietario SET nome = ? WHERE cpf_cnpj = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(2, entidade.getCpfOuCnpjDonoImovel());
            statement.setString(1, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o nome do proprietario " + e.getMessage());
        }
    }

    public void atualizarEmail(DonoImovel entidade, String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Proprietario SET email = ? WHERE cpf_cnpj = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(2, entidade.getCpfOuCnpjDonoImovel());
            statement.setString(1, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o email do proprietario " + e.getMessage());
        }
    }

    public void atualizarTelefone(DonoImovel entidade, String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Proprietario SET telefone = ? WHERE cpf_cnpj = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(2, entidade.getCpfOuCnpjDonoImovel());
            statement.setString(1, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o telefone do proprietario " + e.getMessage());
        }
    }

    @Override
    public void deletar(DonoImovel entidade) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "DELETE FROM Proprietario WHERE cpf_cnpj = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, entidade.getCpfOuCnpjDonoImovel());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao deletar o proprietario " + e.getMessage());
        }
    }

    @Override
    public DonoImovel buscar(String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT * FROM Proprietario WHERE cpf_cnpj = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, arg);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String[] nome = resultSet.getString("nome").split(" ");
                DonoImovel p = new DonoImovel(
                        resultSet.getString("email"),
                        resultSet.getString("senha_hash"),
                        nome[0],
                        nome[1],
                        resultSet.getString("telefone"),
                        resultSet.getString("nome_usuario"),
                        resultSet.getString("cpf_cnpj"));
                return p;
            }else{
                System.out.println("Não existe um proprietario com o cpf ou cnpj " + arg);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar o proprietario por cpf ou cnpj: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<DonoImovel> buscarTodos() {
        List<DonoImovel> proprietarios = new ArrayList<>();
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT * from Proprietario";
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String[] nome = resultSet.getString("nome").split(" ");
                DonoImovel p = new DonoImovel(
                        resultSet.getString("email"),
                        resultSet.getString("senha_hash"),
                        nome[0],
                        nome[1],
                        resultSet.getString("telefone"),
                        resultSet.getString("nome_usuario"),
                        resultSet.getString("cpf_cnpj"));
                proprietarios.add(p);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar todos os proprietarios " + e.getMessage());
        }
        return proprietarios;
    }
}

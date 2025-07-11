package br.edu.ifsc.modelo.RentAI.persistenciaDB;

import br.edu.ifsc.modelo.RentAI.modelo.usuarios.Corretor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CorretorDAO implements  DAO<Corretor, String> {
    private static CorretorDAO instancia;
    private CorretorDAO(){}
    public static CorretorDAO getInstancia(){
        if (instancia == null){
            instancia = new CorretorDAO();
        }
        return instancia;
    }

    @Override
    public void criar(Corretor entidade) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "INSERT INTO Corretor (creci, nome, telefone, email, senha_hash) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, entidade.getCreciCoretor());
            String nomeCompleto = entidade.getNome() + " " + entidade.getSobrenome();
            statement.setString(2, nomeCompleto);
            statement.setString(3, entidade.getTelefone());
            statement.setString(4, entidade.getEmail());
            statement.setString(5, entidade.getSenha());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao criar o corretor " + e.getMessage());
        }
    }

    @Override
    /*
     * atualizar() atualiza a chave primaria
     */
    public void atualizar(Corretor entidade, String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Corretor SET creci = ? WHERE creci = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(2, entidade.getCreciCoretor());
            statement.setString(1, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o creci do corretor " + e.getMessage());
        }
    }

    public void atualizarSenha(Corretor entidade, String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Corretor SET senha_hash = ? WHERE creci = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(2, entidade.getCreciCoretor());
            statement.setString(1, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar a senha do corretor " + e.getMessage());
        }
    }

    public void atualizarNome(Corretor entidade, String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Corretor SET nome = ? WHERE creci = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(2, entidade.getCreciCoretor());
            statement.setString(1, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o nome do corretor " + e.getMessage());
        }
    }

    public void atualizarUserName(Corretor entidade, String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Corretor SET nome_usuario = ? WHERE creci = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(2, entidade.getCreciCoretor());
            statement.setString(1, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o nome de usuário do corretor " + e.getMessage());
        }
    }

    public void atualizarEmail(Corretor entidade, String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Corretor SET email = ? WHERE creci = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(2, entidade.getCreciCoretor());
            statement.setString(1, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o email do corretor " + e.getMessage());
        }
    }

    public void atualizarTelefone(Corretor entidade, String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Corretor SET telefone = ? WHERE creci = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(2, entidade.getCreciCoretor());
            statement.setString(1, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o telefone do corretor " + e.getMessage());
        }
    }

    @Override
    public void deletar(Corretor entidade) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "DELETE FROM Corretor WHERE creci = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, entidade.getCreciCoretor());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao deletar o corretor " + e.getMessage());
        }
    }

    @Override
    public Corretor buscar(String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT * FROM Corretor WHERE creci = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, arg);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String[] nome = resultSet.getString("nome").split(" ");
                Corretor c = new Corretor(
                        resultSet.getString("email"),
                        resultSet.getString("senha_hash"),
                        nome[0],
                        nome[1],
                        resultSet.getString("telefone"),
                        resultSet.getString("nome_usuario"),
                        resultSet.getString("creci"));
                return c;
            }else{
                System.out.println("Não existe um corretor com o creci " + arg);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar o corretor por creci: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Corretor> buscarTodos() {
        List<Corretor> corretores = new ArrayList<>();
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT * from Corretor";
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String[] nome = resultSet.getString("nome").split(" ");
                Corretor c = new Corretor(
                        resultSet.getString("email"),
                        resultSet.getString("senha_hash"),
                        nome[0],
                        nome[1],
                        resultSet.getString("telefone"),
                        resultSet.getString("nome_usuario"),
                        resultSet.getString("creci"));
                corretores.add(c);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar todos os corretores " + e.getMessage());
        }
        return corretores;
    }
}

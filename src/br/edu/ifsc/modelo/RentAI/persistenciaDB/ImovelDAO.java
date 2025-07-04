package br.edu.ifsc.modelo.RentAI.persistenciaDB;

import br.edu.ifsc.modelo.RentAI.modelo.imovel.Imovel;
import br.edu.ifsc.modelo.RentAI.modelo.imovel.Endereco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImovelDAO implements DAO<Imovel, int> {
    private static ImovelDAO instancia;
    private ImovelDAO(){}
    public static ImovelDAO getInstancia(){
        if (instancia == null){
            instancia = new ImovelDAO();
        }
        return instancia;
    }

    @Override
    public void criar(Imovel entidade) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "INSERT INTO Imovel (" +
                    "id_imovel, " +
                    "tipo, " +
                    "endereco, " +
                    "metragem, " +
                    "quartos, " +
                    "banheiros, " +
                    "vagas, " +
                    "status, " +
                    "cpf_cnpj_proprietario, " +
                    "creci_corretor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, entidade.getIdImovel());
            statement.setString(2, entidade.getTipoImovel());
            statement.setString(3, entidade.getEndereco().getEnderecoCompleto());
            statement.setFloat(4, entidade.getMetragem());
            statement.setInt(5, entidade.getQuartos());
            statement.setInt(6, entidade.getBanheiros());
            statement.setInt(7, entidade.getVagas());
            statement.setString(8, entidade.getStatusImovel());
            statement.setString(9, entidade.getDonoImovel().getCpfOuCnpjDonoImovel());
            statement.setString(10, entidade.getCorretor().getCreciCoretor());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao criar o imovel: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Imovel entidade, int arg){

    }

    public void atualizarProprietario(Imovel entidade, int arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Imovel SET cpf_cnpj_proprietario = ? WHERE id_imovel = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, entidade.getDonoImovel().getCpfOuCnpjDonoImovel());
            statement.setInt(2, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o cpf ou cnpj do proprietario: " + e.getMessage());
        }
    }

    public void atualizarCorretor(Imovel entidade, String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Imovel SET creci_corretor = ? WHERE id_imovel = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, entidade.getCorretor().getCreciCoretor());
            statement.setString(2, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o corretor responsavel: " + e.getMessage());
        }
    }

    public void atualizarTipo(Imovel entidade, String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Imovel SET tipo = ? WHERE id_imovel = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, entidade.getTipoImovel());
            statement.setString(2, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o tipo do imovel: " + e.getMessage());
        }
    }

    public void atualizarEndereco(Imovel entidade, String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Imovel SET endereco = ? WHERE id_imovel = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, entidade.getEndereco().getEnderecoCompleto());
            statement.setString(2, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o endereço do imovel: " + e.getMessage());
        }
    }

    public void atualizarMetragem(Imovel entidade, String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Imovel SET metragem = ? WHERE id_imovel = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setFloat(1, entidade.getMetragem());
            statement.setString(2, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar a metragem do imovel: " + e.getMessage());
        }
    }

    public void atualizarQuartos(Imovel entidade, String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Imovel SET quartos = ? WHERE id_imovel = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, entidade.getQuartos());
            statement.setString(2, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o numero de quartos do imovel: " + e.getMessage());
        }
    }

    public void atualizarBanheiros(Imovel entidade, String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Imovel SET banheiros = ? WHERE id_imovel = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, entidade.getBanheiros());
            statement.setString(2, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o numero de banheiros do imovel: " + e.getMessage());
        }
    }

    public void atualizarVagas(Imovel entidade, String arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Imovel SET vagas = ? WHERE id_imovel = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, entidade.getVagas());
            statement.setString(2, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o numero de vagas do imovel: " + e.getMessage());
        }
    }

    @Override
    public void deletar(Imovel entidade) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "DELETE FROM Imovel WHERE id_imovel = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, entidade.getIdImovel());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao deletar o imovel: " + e.getMessage());
        }
    }

    @Override
    public Imovel buscar(int arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT * FROM Imovel WHERE id_imovel = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, arg);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String[] endereco = resultSet.getString("endereco").split(", ");
                Endereco e = new Endereco(endereco[0], endereco[1], endereco[2], endereco[3], endereco[4], endereco[5]);
                Imovel i = new Imovel(
                        e,
                        resultSet.getInt("id_imovel"),
                        resultSet.getString("tipo"),
                        resultSet.getString("status"),
                        resultSet.getFloat("metragem"),
                        resultSet.getInt("banheiros"),
                        resultSet.getInt("quartos"),
                        resultSet.getInt("vagas"),
                        resultSet.getString("cpf_cnpj_proprietario"),
                        resultSet.getString("creci_corretor"));
                return i;
            }else{
                System.out.println("Não existe um imovel com o ID " + arg);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar o imovel pelo ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Imovel> buscarTodos() {
        List<Imovel> imoveis = new ArrayList<>();
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT * from Imovel";
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String[] endereco = resultSet.getString("endereco").split(", ");
                Endereco e = new Endereco(endereco[0], endereco[1], endereco[2], endereco[3], endereco[4], endereco[5]);
                Imovel i = new Imovel(
                        e,
                        resultSet.getInt("id_imovel"),
                        resultSet.getString("tipo"),
                        resultSet.getString("status"),
                        resultSet.getFloat("metragem"),
                        resultSet.getInt("banheiros"),
                        resultSet.getInt("quartos"),
                        resultSet.getInt("vagas"),
                        resultSet.getString("cpf_cnpj_proprietario"),
                        resultSet.getString("creci_corretor"));
                imoveis.add(i);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar todos os imoveis " + e.getMessage());
        }
        return imoveis;
    }
}

package br.edu.ifsc.RentAI.persistenciaDB;

import br.edu.ifsc.RentAI.modelo.imovel.Imovel;
import br.edu.ifsc.RentAI.modelo.imovel.Endereco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImovelDAO implements DAO<Imovel, Integer> {
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
    public void atualizar(Imovel entidade, Integer arg){

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
    public Imovel buscar(Integer arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT * FROM Imovel WHERE id_imovel = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, arg);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String[] endereco = new String[6]; //inicializa o Array
                String[] enderecoCompletoDb = resultSet.getString("endereco").split(", "); //pega as informações do DB
                System.arraycopy(enderecoCompletoDb, 0, endereco, 0, enderecoCompletoDb.length); //Copia as informações com o tamanho correto
                for (int i = 0; i < endereco.length; i++) { //Altera as variaveis nulas para "";
                    if (endereco[i] == null) {
                        endereco[i] = "";
                    }
                }

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
                String[] endereco = new String[6]; //inicializa o Array
                String[] enderecoCompletoDb = resultSet.getString("endereco").split(", "); //pega as informações do DB
                System.arraycopy(enderecoCompletoDb, 0, endereco, 0, enderecoCompletoDb.length); //Copia as informações com o tamanho correto
                for (int i = 0; i < endereco.length; i++) { //Altera as variaveis nulas para "";
                    if (endereco[i] == null) {
                        endereco[i] = "";
                    }
                }

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

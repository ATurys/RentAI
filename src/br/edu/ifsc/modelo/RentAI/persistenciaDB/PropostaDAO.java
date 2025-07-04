package br.edu.ifsc.modelo.RentAI.persistenciaDB;

import br.edu.ifsc.modelo.RentAI.modelo.transacoes.Proposta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropostaDAO implements DAO<Proposta, Integer> {
    private static PropostaDAO instancia;
    private PropostaDAO(){}
    public static PropostaDAO getInstancia(){
        if (instancia == null){
            instancia = new PropostaDAO();
        }
        return instancia;
    }

    @Override
    public void criar(Proposta entidade) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "INSERT INTO Proposta (cpf_cnpj_cliente, id_imovel, id_proposta, valor_oferecido, data_proposta, status, creci_corretor) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, entidade.getCliente().getCpfOuCnpjCliente());
            statement.setInt(2, entidade.getImovel().getIdImovel());
            statement.setInt(3, entidade.getId());
            statement.setFloat(4, entidade.getValorOferecido());
            statement.setDate(5, entidade.getDateTimeProposta());
            statement.setString(6, entidade.getStatus());
            statement.setString(7, entidade.getCorretor().getCreciCoretor());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao criar a proposta " + e.getMessage());
        }
    }

    @Override
    /*
     * atualizar() atualiza o Status, pois outras informações podem ser consideradas novas propostas
     */
    public void atualizar(Proposta entidade, Integer arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE Proposta SET status = ? WHERE id_proposta = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, entidade.getStatus());
            statement.setInt(2, arg);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o status da proposta " + e.getMessage());
        }
    }


    @Override
    public void deletar(Proposta entidade) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "DELETE FROM Proposta WHERE id_proposta = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, entidade.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao deletar a proposta " + e.getMessage());
        }
    }

    @Override
    public Proposta buscar(Integer arg) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT * FROM Proposta WHERE id_proposta = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, arg);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Proposta p = new Proposta(
                        resultSet.getString("cpf_cnpj_cliente"),
                        resultSet.getString("creci_corretor"),
                        resultSet.getInt("id_imovel"),
                        resultSet.getInt("id_proposta"),
                        resultSet.getFloat("valor_oferecido"),
                        resultSet.getString("status"),
                        resultSet.getDate("data_proposta"));
                return p;
            }else{
                System.out.println("Não existe uma proposta com o ID " + arg);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar a proposta pelo ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Proposta> buscarTodos() {
        List<Proposta> propostas = new ArrayList<>();
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT * from Proposta";
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Proposta p = new Proposta(
                        resultSet.getString("cpf_cnpj_cliente"),
                        resultSet.getString("creci_corretor"),
                        resultSet.getInt("id_imovel"),
                        resultSet.getInt("id_proposta"),
                        resultSet.getFloat("valor_oferecido"),
                        resultSet.getString("status"));
                        resultSet.getDate("data_proposta");
                propostas.add(p);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar todos as propostas " + e.getMessage());
        }
        return propostas;
    }
}

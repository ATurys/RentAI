package br.edu.ifsc.modelo.RentAI.persistenciaDB;

import java.util.List;

/**
 * Interface para operações de Acesso a Dados (CRUD).
 *
 * @param <TipoClasse> Define o tipo da entidade.
 * @param <TipoChavePrimaria> Define o tipo da chave para busca no Banco de Dados.
 */
public interface DAO<TipoClasse, TipoChavePrimaria> {

    void criar(TipoClasse entidade);

    void atualizar(TipoClasse entidade, TipoChavePrimaria arg);

    void deletar(TipoClasse entidade);

    TipoClasse buscar(TipoChavePrimaria arg);

    List<TipoClasse> buscarTodos();

}

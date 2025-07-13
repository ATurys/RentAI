package br.edu.ifsc.RentAI.visao;

/**
 * Interface para operações de Acesso a Dados (CRUD).
 *
 * @param <TipoClasse> Define o tipo da entidade.
 */

public interface InputUser<TipoClasse> {

    default void atualizarPK(){} ;


    default void atualizarSenha(){};
    default void atualizarNomeSobrenome(){};
    default void atualizarEmail(){};

    default void atualizarTelefone() {

    }

    default void deletar() {

    }
}

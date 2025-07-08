package br.edu.ifsc.modelo.RentAI.visao;

/**
 * Interface para operações de Acesso a Dados (CRUD).
 *
 * @param <TipoClasse> Define o tipo da entidade.
 */

public interface InputUser<TipoClasse> {

    default TipoClasse cadastro(){
        return null;
    };

    default TipoClasse visualizar(){
        return null;
    };
    default void atualizarPK(){} ;


    default void atualizarSenha(){};
    default void atualizarNomeSobrenome(){};
    default void atualizarEmail(){};

    default void atualizarTelefone() {

    }

    default void deletar() {

    }
}

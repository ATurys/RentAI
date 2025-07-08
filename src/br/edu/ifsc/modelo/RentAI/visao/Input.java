package br.edu.ifsc.modelo.RentAI.visao;

/**
 * Interface para operações de Acesso a Dados (CRUD).
 *
 * @param <TipoClasse> Define o tipo da entidade.
 */

public interface Input<TipoClasse> {

    default TipoClasse cadastro(){
        return null;
    };

    default TipoClasse visualizar(){
        return null;
    };
    default void atualizarPK(){} ;


    default void atualzarSenha(){};
    default void atualizarNomeSobrenome(){};
    default void atualziarEmail(){};

    default void atualizarTelefone() {

    }

    default void deletar() {

    }
}

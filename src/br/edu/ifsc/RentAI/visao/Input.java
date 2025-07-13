package br.edu.ifsc.RentAI.visao;

/**
 * Interface para operações de Acesso a Dados (CRUD).
 *
 * @param <TipoClasse> Define o tipo da entidade.
 */
public interface Input<TipoClasse>{
    default TipoClasse cadastro(){
        return null;
    };

    default TipoClasse visualizar(){
        return null;
    };
}

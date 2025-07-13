package br.edu.ifsc.modelo.RentAI.visao;

import br.edu.ifsc.modelo.RentAI.leitor.Leitor;
import br.edu.ifsc.modelo.RentAI.modelo.usuarios.Corretor;
import br.edu.ifsc.modelo.RentAI.persistenciaDB.CorretorDAO;

import java.util.List;

import static br.edu.ifsc.modelo.RentAI.modelo.Main.verificarCreci;


public class InputUserCorretor implements InputUser<Corretor>, Input<Corretor> {

    private final Leitor leitor  = new Leitor();
    private final Mensagens mensagem = new Mensagens();
    //Cadastro de Corretor

    @Override
    public Corretor cadastro() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        System.out.println(mensagem.getCadastroCorretor());
        String emailCorretor = leitor.lerString("Digite seu e-mail: ");
        if (emailCorretor.equals("0")) {
            return null;
        }
        String senhaCorretor = leitor.lerString("Digite sua senha: ");
        if (senhaCorretor.equals("0")) {
            return null;
        }
        String nomeCorretor = leitor.lerString("Digite o nome do corretor: ");
        if (nomeCorretor.equals("0")) {
            return null;
        }
        String sobrenomeCorretor = leitor.lerString("Digite o sobrenome do corretor: ");
        if (sobrenomeCorretor.equals("0")) {
            return null;
        }
        String telefoneCorretor = leitor.lerString("Digite o telefone do corretor: ");
        if (telefoneCorretor.equals("0")) {
            return null;
        }
        String creciCorretor = leitor.lerString("Digite o CRECI do corretor: ");
        if (creciCorretor.equals("0")) {
            return null;
        }

        String userNameCorretor = leitor.lerString("Digite o nome de usuário do corretor: ");
        if (userNameCorretor.equals("0")) {
            return null;
        }

        //Realiza a verificação do CRECI digitado
        while (true){
            if (verificarCreci(creciCorretor)){
                break;
            }
            else{
                creciCorretor = leitor.lerString("Digite o CRECI do corretor: ");
                if (creciCorretor.equals("0")) {
                    break;
                }
            }
        }
        if (creciCorretor.equals("0")) {
            return null;
        }

        boolean verificador = false;
        List<Corretor> corretores = CorretorDAO.getInstancia().buscarTodos();
        for (Corretor i : corretores) { //Vê se já existe no sistema um CRECI igual
            if (i.getCreciCoretor().equals(creciCorretor) ) {
                System.out.println("Um usuário com este CRECI já existe no sistema!!!");
                System.out.println("Voltando...\n");
                return null;
            } else if (i.getUserName().equals(userNameCorretor) ) {
                verificador = true;
                System.out.println("Um corretor com este userName já existe no sistema!!!\n");
                break;
            }
        }
        while (verificador) { //Vê se já existe no sistema um userName igual
            boolean nomeDuplicado = false;
            userNameCorretor = leitor.lerString("Digite o nome de usuário do corretor: ");
            if (userNameCorretor.equals("0")) {
                return null;
            }
            for (Corretor i : corretores) {
                if (i.getUserName().equals(userNameCorretor) ) {
                    System.out.println("Um corretor com este userName já existe no sistema!!!\n");
                    nomeDuplicado = true;
                    break;
                }
            }
            if (!nomeDuplicado){
                verificador = false;
            }
        };

        return new Corretor(emailCorretor, senhaCorretor, nomeCorretor, sobrenomeCorretor, telefoneCorretor, userNameCorretor, creciCorretor);
    }

    @Override
    public Corretor visualizar() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        Corretor corretor;
        do {
            String view = leitor.lerString(mensagem.getVisualizarCorretor());
            if (view.equals("0")) {
                return null;
            }
            corretor = CorretorDAO.getInstancia().buscar(view);


            // Validação de corretor
            if (corretor == null) {
                System.out.println("Corretor não encontrado, tente novamente: ");
            }
        } while (corretor == null);
        return corretor;
    }

    @Override
    public void atualizarPK() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        String creciNovo = leitor.lerString("Digite o novo CRECI do corretor: ");
        if (creciNovo.equals("0")) {
            return;
        }
        boolean verificador = false;
        while (!verificador){
            if (verificarCreci(creciNovo)){
                verificador = true;
                break;
            }
            else{
                creciNovo = leitor.lerString("Digite o novo CRECI do corretor: ");
                if (creciNovo.equals("0")) {
                    return;
                }
            }
        }

        Corretor corretor = null;
        String view;

        System.out.println("[DIGITE 0 PARA SAIR]");
        do {
            view = leitor.lerString("Digite o CRECI que está atualmente no sistema do corretor : ");
            if (view.equals("0")) {
                return;
            }
            verificador = false;
            while (!verificador){
                if (verificarCreci(view)){
                    verificador = true;
                    break;
                }
                else{
                    view = leitor.lerString("Digite o CRECI que está atualmente no sistema do corretor: ");
                    if (view.equals("0")) {
                        return;
                    }
                }
            }
            corretor = CorretorDAO.getInstancia().buscar(view);

            // Validação de corretor
            if (corretor == null) {
                System.out.println("Corretor não encontrado, tente novamente: ");
            }
        } while (corretor == null);
        CorretorDAO.getInstancia().atualizar(corretor, creciNovo);
        System.out.println("Atualizado com sucesso!");
    }

    @Override
    public void atualizarSenha() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        String senhaNova = leitor.lerString("Digite a nova senha do corretor: ");
        if (senhaNova.equals("0")) {
            return;
        }

        Corretor corretor = null;
        String view;

        System.out.println("[DIGITE 0 PARA SAIR]");
        do {
            view = leitor.lerString("Digite o CRECI que está atualmente no sistema do corretor : ");
            if (view.equals("0")) {
                return;
            }
            boolean verificador = false;
            while (!verificador){
                if (verificarCreci(view)){
                    verificador = true;
                    break;
                }
                else{
                    view = leitor.lerString("Digite o CRECI que está atualmente no sistema do corretor: ");
                    if (view.equals("0")) {
                        return;
                    }
                }
            }

            corretor = CorretorDAO.getInstancia().buscar(view);

            // Validação de corretor
            if (corretor == null) {
                System.out.println("Cliente não encontrado, tente novamente: ");
            }
        } while (corretor == null);
        CorretorDAO.getInstancia().atualizarSenha(corretor, senhaNova);
        System.out.println("Atualizado com sucesso!");
    }

    @Override
    public void atualizarNomeSobrenome() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        String[] nomeNovo = new String[2];

        nomeNovo[0] = leitor.lerString("Digite o novo nome do corretor: ");
        if (nomeNovo[0].equals("0")) {
            return;
        }

        nomeNovo[1] = leitor.lerString("Digite o novo sobrenome do corretor: ");
        if (nomeNovo[1].equals("0")) {
            return;
        }

        String nomeCompleto = nomeNovo[0] + " " + nomeNovo[1];
        Corretor corretor = null;
        String view;

        System.out.println("[DIGITE 0 PARA SAIR]");
        do {
            view = leitor.lerString("Digite o CRECI que está atualmente no sistema do corretor : ");
            if (view.equals("0")) {
                return;
            }
            boolean verificador = false;
            while (!verificador){
                if (verificarCreci(view)){
                    verificador = true;
                    break;
                }
                else{
                    view = leitor.lerString("Digite o CRECI que está atualmente no sistema do corretor: ");
                    if (view.equals("0")) {
                        return;
                    }
                }
            }
            corretor = CorretorDAO.getInstancia().buscar(view);

            // Validação de corretor
            if (corretor == null) {
                System.out.println("Corretor não encontrado, tente novamente: ");
            }
        } while (corretor == null);
        CorretorDAO.getInstancia().atualizarNome(corretor, nomeCompleto);
        System.out.println("Atualizado com sucesso!");
    }

    @Override
    public void atualizarEmail() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        String emailNovo = leitor.lerString("Digite o novo Email do corretor: ");
        if (emailNovo.equals("0")) {
            return;
        }

        Corretor corretor = null;
        String view;

        System.out.println("[DIGITE 0 PARA SAIR]");
        do {
            view = leitor.lerString("Digite o CRECI que está atualmente no sistema do corretor : ");
            if (view.equals("0")) {
                return;
            }
            boolean verificador = false;
            while (!verificador){
                if (verificarCreci(view)){
                    verificador = true;
                    break;
                }
                else{
                    view = leitor.lerString("Digite o CRECI que está atualmente no sistema do corretor: ");
                    if (view.equals("0")) {
                        return;
                    }
                }
            }

            corretor = CorretorDAO.getInstancia().buscar(view);

            // Validação de corretor
            if (corretor == null) {
                System.out.println("Corretor não encontrado, tente novamente: ");
            }
        } while (corretor == null);
        CorretorDAO.getInstancia().atualizarEmail(corretor, emailNovo);
        System.out.println("Atualizado com sucesso!");
    }

    @Override
    public void atualizarTelefone() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        String telefoneNovo = leitor.lerString("Digite o novo telefone do corretor: ");
        if (telefoneNovo.equals("0")) {
            return;
        }

        Corretor corretor = null;
        String view;

        System.out.println("[DIGITE 0 PARA SAIR]");
        do {
            view = leitor.lerString("Digite o CRECI que está atualmente no sistema do corretor : ");
            if (view.equals("0")) {
                return;
            }
            boolean verificador = false;
            while (!verificador){
                if (verificarCreci(view)){
                    verificador = true;
                    break;
                }
                else{
                    view = leitor.lerString("Digite o CRECI que está atualmente no sistema do corretor: ");
                    if (view.equals("0")) {
                        return;
                    }
                }
            }

            corretor = CorretorDAO.getInstancia().buscar(view);

            // Validação de cliente
            if (corretor == null) {
                System.out.println("corretor não encontrado, tente novamente: ");
            }
        } while (corretor == null);
        CorretorDAO.getInstancia().atualizarTelefone(corretor, telefoneNovo);
        System.out.println("Atualizado com sucesso!");
    }

    @Override
    public void deletar() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        Corretor corretor;
        String view;
        do {
            view = leitor.lerString(mensagem.getDeletarCorretor());
            if (view.equals("0")) {
                break;
            }
            while (true){
                if (verificarCreci(view)){
                    break;
                }
                else{
                    view = leitor.lerString(mensagem.getDeletarCorretor());
                    if (view.equals("0")) {
                        return;
                    }
                }
            }

            corretor = CorretorDAO.getInstancia().buscar(view);

            // Validação de cliente
            if (corretor == null) {
                System.out.println("corretor não encontrado, tente novamente: ");
            } else {
                CorretorDAO.getInstancia().deletar(corretor);
            }
        } while (corretor == null);
        if (view.equals("0")) {
            return;
        } else {
            System.out.println("Corretor deletado com sucesso!");
        }
    }


}


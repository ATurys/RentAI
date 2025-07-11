package br.edu.ifsc.modelo.RentAI.visao;

import br.edu.ifsc.modelo.RentAI.leitor.Leitor;
import br.edu.ifsc.modelo.RentAI.modelo.usuarios.DonoImovel;
import br.edu.ifsc.modelo.RentAI.persistenciaDB.ProprietarioDAO;

import java.util.List;

import static br.edu.ifsc.modelo.RentAI.modelo.Main.verificarCpfOuCnpj;

public class InputUserProprietario implements InputUser<DonoImovel> {

    private final Leitor leitor = new Leitor();
    private final Mensagens mensagem = new Mensagens();
    //Cadastro de Cliente

    @Override
    public DonoImovel cadastro() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        System.out.println(mensagem.getCadastroCliente());

        String emailProprietario = leitor.lerString("Digite seu e-mail: ");
        if (emailProprietario.equals("0")) {
            return null;
        }
        String senhaProprietario = leitor.lerString("Digite sua senha: ");
        if (senhaProprietario.equals("0")) {
            return null;
        }
        String nomeProprietario = leitor.lerString("Digite o nome do proprietario: ");
        if (nomeProprietario.equals("0")) {
            return null;
        }
        String sobrenomeProprietario = leitor.lerString("Digite o sobrenome do proprietario: ");
        if (sobrenomeProprietario.equals("0")) {
            return null;
        }
        String telefoneProprietario = leitor.lerString("Digite o telefone do proprietario: ");
        if (telefoneProprietario.equals("0")) {
            return null;
        }

        String cpfCnpjProprietario = leitor.lerString("Digite o CPF/CNPJ do proprietario: ");
        if (cpfCnpjProprietario.equals("0")) {
            return null;
        }

        String userNameProprietario = leitor.lerString("Digite o nome de usuário do proprietario: ");
        if (userNameProprietario.equals("0")) {
            return null;
        }

        boolean verificador = false;
        List<DonoImovel> proprietarios = ProprietarioDAO.getInstancia().buscarTodos();
        for (DonoImovel i : proprietarios) { //Vê se já existe no sistema um CPF/CNPJ igual
            if (i.getCpfOuCnpjDonoImovel().equals(cpfCnpjProprietario) ) {
                System.out.println("Um usuário com este CPF/CNPJ já existe no sistema!!!");
                System.out.println("Voltando...\n");
                return null;
            } else if (i.getUserName().equals(userNameProprietario) ) {
                verificador = true;
                System.out.println("Um usuário com este userName já existe no sistema!!!\n");
                break;
            }
        }
        while (verificador) { //Vê se já existe no sistema um userName igual
            boolean nomeDuplicado = false;
            userNameProprietario = leitor.lerString("Digite o nome de usuário do proprietario: ");
            if (userNameProprietario.equals("0")) {
                return null;
            }
            for (DonoImovel i : proprietarios) {
                if (i.getUserName().equals(userNameProprietario)) {
                    System.out.println("Um usuário com este userName já existe no sistema!!!\n");
                    nomeDuplicado = true;
                    break;
                }
            }
            if (!nomeDuplicado){
                verificador = false;
            }
        }
        //Realiza a verificação do CPF/CNPJ digitado
        while (true) {
            if (verificarCpfOuCnpj(cpfCnpjProprietario)) { //Realiza a verificação da validade do CPF/CNPJ digitado
                break;
            } else {
                System.out.println("CPF/CNPJ Invalido, tente novamente.\n");
                cpfCnpjProprietario = leitor.lerString("Digite o CPF/CNPJ do proprietario: ");
                if (cpfCnpjProprietario.equals("0")) {
                    return null;
                }
            }
        }

        return new DonoImovel(emailProprietario, senhaProprietario, nomeProprietario, sobrenomeProprietario, telefoneProprietario, userNameProprietario, cpfCnpjProprietario);
    }

    @Override
    public DonoImovel visualizar() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        DonoImovel proprietario;
        do {
            String view = leitor.lerString(mensagem.getVisualizarProprietario());
            if (view.equals("0")) {
                return null;
            }
            proprietario = ProprietarioDAO.getInstancia().buscar(view);


            // Validação de cliente
            if (proprietario == null) {
                System.out.println("proprietario não encontrado, tente novamente: ");
            }
        } while (proprietario == null);
        return proprietario;
    }

    @Override
    public void atualizarPK() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        String cpf_cnpjNovo = leitor.lerString("Digite o novo CPF/CNPJ do proprietario: ");
        if (cpf_cnpjNovo.equals("0")) {
            return;
        }

        DonoImovel proprietario;
        String view;

        System.out.println("[DIGITE 0 PARA SAIR]");
        do {
            view = leitor.lerString("Digite o CPF/CNPJ que está atualmente no sistema do proprietario : ");
            if (view.equals("0")) {
                return;
            }
            proprietario = ProprietarioDAO.getInstancia().buscar(view);

            // Validação de cliente
            if (proprietario == null) {
                System.out.println("proprietario não encontrado, tente novamente: ");
            }
        } while (proprietario == null);
        ProprietarioDAO.getInstancia().atualizar(proprietario, cpf_cnpjNovo);
        System.out.println("Atualizado com sucesso!");
    }

    @Override
    public void atualizarSenha() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        String senhaNova = leitor.lerString("Digite a nova senha do proprietario: ");
        if (senhaNova.equals("0")) {
            return;
        }

        DonoImovel proprietario;
        String view;

        System.out.println("[DIGITE 0 PARA SAIR]");
        do {
            view = leitor.lerString("Digite o CPF/CNPJ que está atualmente no sistema do proprietario : ");
            if (view.equals("0")) {
                return;
            }
            proprietario = ProprietarioDAO.getInstancia().buscar(view);

            // Validação de cliente
            if (proprietario == null) {
                System.out.println("proprietario não encontrado, tente novamente: ");
            }
        } while (proprietario == null);
        ProprietarioDAO.getInstancia().atualizarSenha(proprietario, senhaNova);
        System.out.println("Atualizado com sucesso!");
    }

    @Override
    public void atualizarNomeSobrenome() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        String[] nomeNovo = new String[2];

        nomeNovo[0] = leitor.lerString("Digite o novo nome do proprietario: ");
        if (nomeNovo[0].equals("0")) {
            return;
        }

        nomeNovo[1] = leitor.lerString("Digite o novo sobrenome do proprietario: ");
        if (nomeNovo[1].equals("0")) {
            return;
        }

        String nomeCompleto = nomeNovo[0] + " " + nomeNovo[1];
        DonoImovel proprietario;
        String view;

        System.out.println("[DIGITE 0 PARA SAIR]");
        do {
            view = leitor.lerString("Digite o CPF/CNPJ que está atualmente no sistema do proprietario : ");
            if (view.equals("0")) {
                return;
            }
            proprietario = ProprietarioDAO.getInstancia().buscar(view);

            // Validação de cliente
            if (proprietario == null) {
                System.out.println("Cliente não encontrado, tente novamente: ");
            }
        } while (proprietario == null);
        ProprietarioDAO.getInstancia().atualizarNome(proprietario, nomeCompleto);
        System.out.println("Atualizado com sucesso!");
    }

    @Override
    public void atualizarEmail() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        String emailNovo = leitor.lerString("Digite o novo Email do proprietario: ");
        if (emailNovo.equals("0")) {
            return;
        }

        DonoImovel proprietario;
        String view;

        System.out.println("[DIGITE 0 PARA SAIR]");
        do {
            view = leitor.lerString("Digite o CPF/CNPJ que está atualmente no sistema do proprietario : ");
            if (view.equals("0")) {
                return;
            }
            proprietario = ProprietarioDAO.getInstancia().buscar(view);

            // Validação de cliente
            if (proprietario == null) {
                System.out.println("proprietario não encontrado, tente novamente: ");
            }
        } while (proprietario == null);
        ProprietarioDAO.getInstancia().atualizarEmail(proprietario, emailNovo);
        System.out.println("Atualizado com sucesso!");
    }

    @Override
    public void atualizarTelefone() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        String telefoneNovo = leitor.lerString("Digite o novo telefone do proprietario: ");
        if (telefoneNovo.equals("0")) {
            return;
        }

        DonoImovel proprietario;
        String view;

        System.out.println("[DIGITE 0 PARA SAIR]");
        do {
            view = leitor.lerString("Digite o CPF/CNPJ que está atualmente no sistema do proprietario : ");
            if (view.equals("0")) {
                return;
            }
            proprietario = ProprietarioDAO.getInstancia().buscar(view);

            // Validação de cliente
            if (proprietario == null) {
                System.out.println("proprietario não encontrado, tente novamente: ");
            }
        } while (proprietario == null);
        ProprietarioDAO.getInstancia().atualizarTelefone(proprietario, telefoneNovo);
        System.out.println("Atualizado com sucesso!");
    }

    @Override
    public void deletar() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        DonoImovel proprietario;
        String view;
        do {
            view = leitor.lerString(mensagem.getDeletarProprietario());
            if (view.equals("0")) {
                return;
            }
            proprietario = ProprietarioDAO.getInstancia().buscar(view);

            // Validação de cliente
            if (proprietario == null) {
                System.out.println("proprietario não encontrado, tente novamente: ");
            } else {
                ProprietarioDAO.getInstancia().deletar(proprietario);
            }
        } while (proprietario == null);
        System.out.println("proprietario deletado com sucesso!");

    }

}

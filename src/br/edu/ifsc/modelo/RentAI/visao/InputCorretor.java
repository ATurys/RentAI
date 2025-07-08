package br.edu.ifsc.modelo.RentAI.visao;

import br.edu.ifsc.modelo.RentAI.leitor.Leitor;
import br.edu.ifsc.modelo.RentAI.modelo.usuarios.Corretor;
import br.edu.ifsc.modelo.RentAI.persistenciaDB.ClienteDAO;
import br.edu.ifsc.modelo.RentAI.persistenciaDB.CorretorDAO;

import java.util.List;

import static br.edu.ifsc.modelo.RentAI.modelo.Main.verificarCreci;


public class InputCorretor {

    private Leitor leitor = new Leitor();
    private Mensagens mensagem = new Mensagens();
    //Cadastro de Corretor
    private Corretor cadastro() {
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
        boolean verificador = false;
        while (!verificador){
            if (verificarCreci(creciCorretor)){
                verificador = true;
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

        verificador = false;
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

    private Cliente visualizar() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        Cliente cliente;
        do {
            String view = leitor.lerString(mensagem.getVisualizarCliente());
            if (view.equals("0")) {
                return null;
            }
            cliente = ClienteDAO.getInstancia().buscar(view);


            // Validação de cliente
            if (cliente == null) {
                System.out.println("Cliente não encontrado, tente novamente: ");
            }
        } while (cliente == null);
        return cliente;
    }

    private void atualizarCpf_Cnpj() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        String cpf_cnpjNovo = leitor.lerString("Digite o novo CPF/CNPJ do cliente: ");
        if (cpf_cnpjNovo.equals("0")) {
            return;
        }

        Cliente cliente = null;
        String view;

        System.out.println("[DIGITE 0 PARA SAIR]");
        do {
            view = leitor.lerString("Digite o CPF/CNPJ que está atualmente no sistema do cliente : ");
            if (view.equals("0")) {
                return;
            }
            cliente = ClienteDAO.getInstancia().buscar(view);

            // Validação de cliente
            if (cliente == null) {
                System.out.println("Cliente não encontrado, tente novamente: ");
            }
        } while (cliente == null);
        ClienteDAO.getInstancia().atualizar(cliente, cpf_cnpjNovo);
        System.out.println("Atualizado com sucesso!");
    }

    private void atualzarSenha() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        String senhaNova = leitor.lerString("Digite a nova senha do cliente: ");
        if (senhaNova.equals("0")) {
            return;
        }

        Cliente cliente = null;
        String view;

        System.out.println("[DIGITE 0 PARA SAIR]");
        do {
            view = leitor.lerString("Digite o CPF/CNPJ que está atualmente no sistema do cliente : ");
            if (view.equals("0")) {
                return;
            }
            cliente = ClienteDAO.getInstancia().buscar(view);

            // Validação de cliente
            if (cliente == null) {
                System.out.println("Cliente não encontrado, tente novamente: ");
            }
        } while (cliente == null);
        ClienteDAO.getInstancia().atualizarSenha(cliente, senhaNova);
        System.out.println("Atualizado com sucesso!");
    }

    private void atualizarNomeSobrenome() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        String[] nomeNovo = new String[2];

        nomeNovo[0] = leitor.lerString("Digite o novo nome do cliente: ");
        if (nomeNovo[0].equals("0")) {
            return;
        }

        nomeNovo[1] = leitor.lerString("Digite o novo sobrenome do cliente: ");
        if (nomeNovo[1].equals("0")) {
            return;
        }

        String nomeCompleto = nomeNovo[0] + nomeNovo[1];
        Cliente cliente = null;
        String view;

        System.out.println("[DIGITE 0 PARA SAIR]");
        do {
            view = leitor.lerString("Digite o CPF/CNPJ que está atualmente no sistema do cliente : ");
            if (view.equals("0")) {
                return;
            }
            cliente = ClienteDAO.getInstancia().buscar(view);

            // Validação de cliente
            if (cliente == null) {
                System.out.println("Cliente não encontrado, tente novamente: ");
            }
        } while (cliente == null);
        ClienteDAO.getInstancia().atualizarSenha(cliente, nomeCompleto);
        System.out.println("Atualizado com sucesso!");
    }

    private void atualziarEmail() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        String emailNovo = leitor.lerString("Digite o novo Email do cliente: ");
        if (emailNovo.equals("0")) {
            return;
        }

        Cliente cliente = null;
        String view;

        System.out.println("[DIGITE 0 PARA SAIR]");
        do {
            view = leitor.lerString("Digite o CPF/CNPJ que está atualmente no sistema do cliente : ");
            if (view.equals("0")) {
                return;
            }
            cliente = ClienteDAO.getInstancia().buscar(view);

            // Validação de cliente
            if (cliente == null) {
                System.out.println("Cliente não encontrado, tente novamente: ");
            }
        } while (cliente == null);
        ClienteDAO.getInstancia().atualizar(cliente, emailNovo);
        System.out.println("Atualizado com sucesso!");
    }
    private void atualizarTelefone() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        String telefoneNovo = leitor.lerString("Digite o novo telefone do cliente: ");
        if (telefoneNovo.equals("0")) {
            return;
        }

        Cliente cliente = null;
        String view;

        System.out.println("[DIGITE 0 PARA SAIR]");
        do {
            view = leitor.lerString("Digite o CPF/CNPJ que está atualmente no sistema do cliente : ");
            if (view.equals("0")) {
                return;
            }
            cliente = ClienteDAO.getInstancia().buscar(view);

            // Validação de cliente
            if (cliente == null) {
                System.out.println("Cliente não encontrado, tente novamente: ");
            }
        } while (cliente == null);
        ClienteDAO.getInstancia().atualizar(cliente, telefoneNovo);
        System.out.println("Atualizado com sucesso!");
    }

    private void deletar() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        Cliente cliente;
        String view;
        do {
            view = leitor.lerString(mensagem.getDeletarCliente());
            if (view.equals("0")) {
                break;
            }
            cliente = ClienteDAO.getInstancia().buscar(view);

            // Validação de cliente
            if (cliente == null) {
                System.out.println("Cliente não encontrado, tente novamente: ");
            } else {
                ClienteDAO.getInstancia().deletar(cliente);
            }
        } while (cliente == null);
        if (view.equals("0")) {
            return;
        } else {
            System.out.println("Cliente deletado com sucesso!");
        }
    }

    //Getters (não há setters)

    public Corretor getCadastro() {
        return cadastro();
    }

    public Corretor getVisualizar() {
        return visualizar();
    }

    public void getDeletar() {
        deletar();
    }

    public void getAtualizarCpf_Cnpj() {
        atualizarCpf_Cnpj();
    }

    public void getAtualzarSenha() {
        atualzarSenha();
    }

    public void getAtualizarNomeSobrenome() {
        atualizarNomeSobrenome();
    }

    public void getAtualizarEmail() {
        atualziarEmail();
    }

    public void getAtualizarTelefone() {
        atualizarTelefone();
    }
}


package br.edu.ifsc.modelo.RentAI.visao;

import br.edu.ifsc.modelo.RentAI.modelo.usuarios.Cliente;
import br.edu.ifsc.modelo.RentAI.leitor.Leitor;
import br.edu.ifsc.modelo.RentAI.persistenciaDB.ClienteDAO;

import java.util.List;

import static br.edu.ifsc.modelo.RentAI.modelo.Main.verificarCpfOuCnpj;


public class InputUserCliente implements InputUser<Cliente>, Input<Cliente> {

    private final Leitor leitor = new Leitor();
    private final Mensagens mensagem = new Mensagens();
    //Cadastro de Cliente

    @Override
    public Cliente cadastro() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        System.out.println(mensagem.getCadastroCliente());

        String emailCliente = leitor.lerString("Digite seu e-mail: ");
        if (emailCliente.equals("0")) {
            return null;
        }
        String senhaCliente = leitor.lerString("Digite sua senha: ");
        if (senhaCliente.equals("0")) {
            return null;
        }
        String nomeCliente = leitor.lerString("Digite o nome do cliente: ");
        if (nomeCliente.equals("0")) {
            return null;
        }
        String sobrenomeCliente = leitor.lerString("Digite o sobrenome do cliente: ");
        if (sobrenomeCliente.equals("0")) {
            return null;
        }
        String telefoneCliente = leitor.lerString("Digite o telefone do cliente: ");
        if (telefoneCliente.equals("0")) {
            return null;
        }

        String cpfCnpjCliente = leitor.lerString("Digite o CPF/CNPJ do cliente: ");
        if (cpfCnpjCliente.equals("0")) {
            return null;
        }

        String userNameCliente = leitor.lerString("Digite o nome de usuário do cliente: ");
        if (userNameCliente.equals("0")) {
            return null;
        }

        boolean verificador = false;
        List<Cliente> clientes = ClienteDAO.getInstancia().buscarTodos();
        for (Cliente i : clientes) { //Vê se já existe no sistema um CPF/CNPJ igual
            if (i.getCpfOuCnpjCliente().equals(cpfCnpjCliente) ) {
                System.out.println("Um usuário com este CPF/CNPJ já existe no sistema!!!");
                System.out.println("Voltando...\n");
                return null;
            } else if (i.getUserName().equals(userNameCliente) ) {
                verificador = true;
                System.out.println("Um usuário com este userName já existe no sistema!!!\n");
                break;
            }
        }
        while (verificador) { //Vê se já existe no sistema um userName igual
            boolean nomeDuplicado = false;
            userNameCliente = leitor.lerString("Digite o nome de usuário do cliente: ");
            if (userNameCliente.equals("0")) {
                return null;
            }
            for (Cliente i : clientes) {
                if (i.getUserName().equals(userNameCliente) ) {
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
            if (verificarCpfOuCnpj(cpfCnpjCliente)) { //Realiza a verificação da validade do CPF/CNPJ digitado
                break;
            } else {
                System.out.println("CPF/CNPJ Invalido, tente novamente.\n");
                cpfCnpjCliente = leitor.lerString("Digite o CPF/CNPJ do cliente: ");
                if (cpfCnpjCliente.equals("0")) {
                    break;
                }
            }
        }
        if (cpfCnpjCliente.equals("0")) {
            return null;
        }
        return new Cliente(emailCliente, senhaCliente, nomeCliente, sobrenomeCliente, telefoneCliente, userNameCliente, cpfCnpjCliente);
    }

    @Override
    public Cliente visualizar() {
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

    @Override
    public void atualizarPK() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        String cpf_cnpjNovo = leitor.lerString("Digite o novo CPF/CNPJ do cliente: ");
        if (cpf_cnpjNovo.equals("0")) {
            return;
        }

        Cliente cliente;
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

    @Override
    public void atualizarSenha() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        String senhaNova = leitor.lerString("Digite a nova senha do cliente: ");
        if (senhaNova.equals("0")) {
            return;
        }

        Cliente cliente;
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

    @Override
    public void atualizarNomeSobrenome() {
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

        String nomeCompleto = nomeNovo[0] + " " + nomeNovo[1];
        Cliente cliente;
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
        ClienteDAO.getInstancia().atualizarNome(cliente, nomeCompleto);
        System.out.println("Atualizado com sucesso!");
    }

    @Override
    public void atualizarEmail() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        String emailNovo = leitor.lerString("Digite o novo Email do cliente: ");
        if (emailNovo.equals("0")) {
            return;
        }

        Cliente cliente;
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
        ClienteDAO.getInstancia().atualizarEmail(cliente, emailNovo);
        System.out.println("Atualizado com sucesso!");
    }

    @Override
    public void atualizarTelefone() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        String telefoneNovo = leitor.lerString("Digite o novo telefone do cliente: ");
        if (telefoneNovo.equals("0")) {
            return;
        }

        Cliente cliente;
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
        ClienteDAO.getInstancia().atualizarTelefone(cliente, telefoneNovo);
        System.out.println("Atualizado com sucesso!");
    }

    @Override
    public void deletar() {
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

}

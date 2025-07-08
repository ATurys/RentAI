package br.edu.ifsc.modelo.RentAI.visao;

import br.edu.ifsc.modelo.RentAI.modelo.usuarios.Cliente;
import br.edu.ifsc.modelo.RentAI.leitor.Leitor;
import br.edu.ifsc.modelo.RentAI.persistenciaDB.ClienteDAO;

import java.util.List;

import static br.edu.ifsc.modelo.RentAI.modelo.Main.verificarCpfOuCnpj;


public class InputCliente {

    private Leitor leitor = new Leitor();
    private Mensagens mensagem = new Mensagens();
    //Cadastro de Cliente
    private Cliente cadastro() {
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
        };
        //Realiza a verificação do CPF/CNPJ digitado
        verificador = false;
        while (!verificador) {
            if (verificarCpfOuCnpj(cpfCnpjCliente)) { //Realiza a verificação da validade do CPF/CNPJ digitado
                verificador = true;
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

    //Getters (não há setters)

    public Cliente getCadastro() {
        return cadastro();
    }

    public Cliente getVisualizar() {
        return visualizar();
    }
}

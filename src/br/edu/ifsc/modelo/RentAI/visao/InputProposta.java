package br.edu.ifsc.modelo.RentAI.visao;

import br.edu.ifsc.modelo.RentAI.leitor.Leitor;
import br.edu.ifsc.modelo.RentAI.modelo.imovel.Imovel;
import br.edu.ifsc.modelo.RentAI.modelo.transacoes.Proposta;
import br.edu.ifsc.modelo.RentAI.modelo.usuarios.Cliente;
import br.edu.ifsc.modelo.RentAI.modelo.usuarios.Corretor;
import br.edu.ifsc.modelo.RentAI.modelo.usuarios.DonoImovel;
import br.edu.ifsc.modelo.RentAI.persistenciaDB.*;

import java.util.List;

import static br.edu.ifsc.modelo.RentAI.modelo.Main.verificarCpfOuCnpj;
import static br.edu.ifsc.modelo.RentAI.modelo.Main.verificarCreci;

public class InputProposta {

    private final Leitor leitor = new Leitor();
    private final Mensagens mensagem = new Mensagens();
    //Cadastro de Cliente

    public Proposta cadastro() {
        System.out.println(mensagem.getCriar());








        System.out.println("[DIGITE 0 PARA SAIR]");

        // Pegar cliente pelo CPF
        String propostaCpfCnpjCliente = leitor.lerString(mensagem.getPropostaCpfCnpjCliente());

        boolean achou = false;
        Cliente clienteProposta = null;
        List<Cliente> clientes = ClienteDAO.getInstancia().buscarTodos();

        while (!achou) {
            if (propostaCpfCnpjCliente.equals("0")) {
                return null;
            } // verifica saida

            for (Cliente cliente : clientes) {
                if (cliente.getCpfOuCnpjCliente().equals(propostaCpfCnpjCliente)) {
                    // Achou o Cliente com o CPF correspondente
                    clienteProposta = cliente;
                    achou = true;
                    break;
                }
            }
            if (achou) {
                break;
            }
            System.out.println("Cliente não encontrado, tente novamente: ");
            propostaCpfCnpjCliente = leitor.lerString(mensagem.getPropostaCpfCnpjCliente());
        } // Verifica se existe esse cliente

        // Pegar corretor pelo Creci
        String propostaCreci = leitor.lerString(mensagem.getPropostaCreci());

        Corretor corretorProposta = null;
        List<Corretor> corretores = CorretorDAO.getInstancia().buscarTodos();
        achou = false;

        while (!achou) {
            if (propostaCreci.equals("0")) {
                return null;
            } // verifica saida

            for (Corretor corretor : corretores) {

                if (corretor.getCreciCoretor().equals(propostaCreci)) {
                    // Achou o Corretor com o CRECI correspondente
                    corretorProposta = corretor;
                    achou = true;
                    break;
                }
            }
            if (achou) {
                break;
            }
            System.out.println("corretor não encontrado, tente novamente: ");
            propostaCreci = leitor.lerString(mensagem.getPropostaCreci());
        }


        // Pegar Imovel pelo ID
        int propostaImovel = leitor.lerInt(mensagem.getPropostaImovel());

        Imovel imovelProposta = null;
        List<Imovel> imoveis = ImovelDAO.getInstancia().buscarTodos();
        achou = false;

        while (!achou) {
            if (propostaImovel == 0) {
                return null;
            } // verifica saida

            for (Imovel imovel : imoveis) {

                if (imovel.getIdImovel() == propostaImovel) {
                    // Achou o imovel com o ID correspondente
                    imovelProposta = imovel;
                    achou = true;
                    break;
                }
            }
            if (achou) {
                break;
            }
            System.out.println("imovel não encontrado, tente novamente: ");
            propostaImovel = leitor.lerInt(mensagem.getPropostaImovel());
        }

        // Pegar valor + verif. saida
        float propostaValor = leitor.lerFloat(mensagem.getPropostaValor());
        if (propostaValor == 0) {
            return null;
        }

        // Cria o ID no sistema
        List<Proposta> propostas = PropostaDAO.getInstancia().buscarTodos();
        int idProposta;
        if (propostas.isEmpty()) {
            idProposta = 1;
        } else {
            idProposta = 0;
            for (Proposta proposta : propostas) {
                if (proposta.getId() > idProposta) {
                    idProposta = proposta.getId();
                }
            }
            idProposta++;
        }

        int statusProposta;
        String status = "";
        do {
            statusProposta = leitor.lerInt(mensagem.getPropostaStatus());
            if (statusProposta == 0) {
                return null;
            } else if (statusProposta == 1) {
                status = "pendente";
            } else if (statusProposta == 2) {
                status = "aceita";
            } else if (statusProposta == 3) {
                status = "recusada";
            }
        } while (statusProposta > 3);



        return new Proposta(
                clienteProposta,
                corretorProposta,
                imovelProposta,
                idProposta,
                propostaValor,
                status
        );

    }


    public Proposta visualizar() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        Proposta proposta;
        do {
            int view = leitor.lerInt(mensagem.getVisualizarImovelPropostas());
            if (view == 0) {
                return null;
            }
            proposta = PropostaDAO.getInstancia().buscar(view);


            // Validação de cliente
            if (proposta == null) {
                System.out.println("proposta não encontrada, tente novamente: ");
            }
        } while (proposta == null);
        return proposta;
        }
    }
}

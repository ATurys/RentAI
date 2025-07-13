package br.edu.ifsc.modelo.RentAI.visao;

import br.edu.ifsc.modelo.RentAI.leitor.Leitor;
import br.edu.ifsc.modelo.RentAI.modelo.transacoes.Proposta;
import br.edu.ifsc.modelo.RentAI.modelo.transacoes.Venda;
import br.edu.ifsc.modelo.RentAI.modelo.usuarios.DonoImovel;
import br.edu.ifsc.modelo.RentAI.persistenciaDB.*;

import java.util.List;

public class InputVenda implements Input<Venda> {

    private final Leitor leitor = new Leitor();
    private final Mensagens mensagem = new Mensagens();

    @Override
    public Venda cadastro() {
        boolean verifica = false;
        System.out.println("[DIGITE 0 PARA SAIR]");
        System.out.println((mensagem.getAnunciar()));

        //Pegar Proposta
        int iDProposta = leitor.lerInt((mensagem.getVendaPropostaID()));
        boolean achou = false;
        List<Proposta> propostas = PropostaDAO.getInstancia().buscarTodos();
        Proposta propostaVenda = null;

        while (!achou) {
            if (iDProposta == 0) {
                return null;
            }// verifica saida
            for (Proposta proposta : propostas) {
                if (proposta.getId() == (iDProposta)) {
                    // Achou Proposta correspondente
                    propostaVenda = proposta;
                    achou = true;
                    break;
                }
            }
            if (achou) {
                break;
            }
            System.out.println("Proposta não encontrado, tente novamente: ");
            iDProposta = leitor.lerInt("Digite o ID da Proposta ou digite 0 para sair: ");
        }

        //Pegar Proprietario
        String cpfCnpjProprietario = leitor.lerString(mensagem.getVendaCpfCnpjProprietario());
        achou = false;
        List<DonoImovel> proprietarios = ProprietarioDAO.getInstancia().buscarTodos();
        DonoImovel proprietarioVenda = null;
        while (!achou) {
            if (cpfCnpjProprietario.equals("0")) {
                return null;
            }// verifica saida
            for (DonoImovel proprietario : proprietarios) {
                if (proprietario.getCpfOuCnpjDonoImovel().equals(cpfCnpjProprietario)) {
                    // Achou Proprietario correspondente
                    proprietarioVenda = proprietario;
                    achou = true;
                    break;
                }
            }
            if (achou) {
                break;
            }
            System.out.println("Proprietario não encontrado, tente novamente: ");
            cpfCnpjProprietario = leitor.lerString("Digite o CPF/CNPJ do Proprietario ou digite 0 para sair: ");
        } // Verifica se existe esse Proprietario


        //Escolher forma de pagamento
        System.out.println("[DIGITE 0 PARA SAIR]");
        int formaDePagamento;
        String pagamentoVenda = "";

        do {
            formaDePagamento = leitor.lerInt(mensagem.getVendaFormaDePagamento());
            if (formaDePagamento == 0) {
                return null;

            } else if (formaDePagamento == 1) {
                pagamentoVenda = "a vista";

            } else if (formaDePagamento == 2) {
                pagamentoVenda = "financiamento";

            } else if (formaDePagamento == 3) {
                pagamentoVenda = "parcelado";

            }
        } while (formaDePagamento > 3);

        // Informar a comissao
        float comissaoVenda;
        do {
            comissaoVenda = leitor.lerFloat("Digite o valor de comissão que o corretor vai receber: [Digite 0 para não informar comissao]: ");
        } while (comissaoVenda < 0);

        // Definir valor da venda
        float valorVenda = propostaVenda.getValorOferecido();

        //Definir ID da venda
        List<Venda> vendas = VendaDAO.getInstance().buscarTodos();
        int idVenda;
        if (vendas.isEmpty()) {
            idVenda = 1;
        } else {
            idVenda = 0;
            for (Venda venda : vendas) {
                if (venda.getId() > idVenda) {
                    idVenda = venda.getId();
                }
            }
            idVenda++;
        }


        System.out.println("Venda: " +
                "\nId da proposta: " + propostaVenda.getId() +
                "\nValor da venda: " + valorVenda +
                "\nForma de pagamento: " + pagamentoVenda +
                "\nProprietario atual: " + proprietarioVenda.getNome() + " " + proprietarioVenda.getSobrenome() +
                "\nCPF/CNPJ do proprietario atual: " + proprietarioVenda.getCpfOuCnpjProprietarioCripted()
        );
        verifica = leitor.lerBoolean("Confirmar?");
        if (verifica) {
            //Atualiza status da proposta
            propostaVenda.setStatus("aceita");
            PropostaDAO.getInstancia().atualizar(propostaVenda, propostaVenda.getId());

            //Cria a venda
            return new Venda(
                    propostaVenda,
                    proprietarioVenda,
                    idVenda,
                    valorVenda,
                    pagamentoVenda,
                    comissaoVenda
            );
        } else {
            System.out.println("Saindo...");
            return null;
        }
    }

    @Override
    public Venda visualizar() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        Venda venda;
        do {
            int view = leitor.lerInt(mensagem.getVisualizarVenda());
            if (view == 0) {
                return null;
            }
            venda = VendaDAO.getInstance().buscar(view);


            // Validação de cliente
            if (venda == null) {
                System.out.println("venda não encontrada, tente novamente: ");
            }
        } while (venda == null);
        return venda;
    }

}

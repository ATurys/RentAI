package br.edu.ifsc.modelo.RentAI.modelo;

import br.edu.ifsc.modelo.RentAI.leitor.Leitor;
import br.edu.ifsc.modelo.RentAI.modelo.imovel.Endereco;
import br.edu.ifsc.modelo.RentAI.modelo.imovel.Imovel;
import br.edu.ifsc.modelo.RentAI.modelo.transacoes.Proposta;
import br.edu.ifsc.modelo.RentAI.modelo.transacoes.Venda;
import br.edu.ifsc.modelo.RentAI.modelo.usuarios.Cliente;
import br.edu.ifsc.modelo.RentAI.modelo.usuarios.Corretor;
import br.edu.ifsc.modelo.RentAI.modelo.usuarios.DonoImovel;
import br.edu.ifsc.modelo.RentAI.persistenciaDB.*;
import br.edu.ifsc.modelo.RentAI.visao.*;

import java.util.ArrayList;

public class Main {
    public static void testePrompt (int max, int userPrompt) {
        if (userPrompt > max || userPrompt <= 0) {
            System.out.println("\nNesta parte, favor digitar um numero que esteja entre 1 e " + max + "\n" +
                    "Voltando... \n\n");
        } // Verifica se o numero esta entre os valores delimitados
    }
    public static boolean verificarCpfOuCnpj(String cpfOuCnpj) {
        if (cpfOuCnpj.length() == 11 || cpfOuCnpj.length() == 14 ) {
            return true;
        } else {
            System.out.println("Digite o CPF ou CNPJ corretamente:\n" +
                    "CPF(11 Dígitos): 12345678901\n" +
                    "CNPJ(14 Dígitos): 12345678901234\n");
            return false;
        }
    } // Verifica se esta entre o tamanho minimo de CPF ou CNPJ

    public static boolean verificarCreci(String creci) {
        /* REGEX:
            ^ → início da string
            CRECI- → texto fixo
            [A-Z]{2} → duas letras maiúsculas (iniciais do estado)
            \\d{8} → exatamente 8 dígitos
            $ → fim da string
         */
        String modelo = "^CRECI-[A-Z]{2}\\d{8}$";
        if (creci.matches(modelo) ) {
            return true;
        } else {
            System.out.println("Digite o CRECI corretamente:\n" +
                    "Modelo Exemplo de CRECI: CRECI-RS01234567");
            return false;
        }
    } // Verifica se esta o modelo CRECI corretamente

    public static void main(String[] args) {
        Conexao.getConexao();
        Conexao.criarTabelas();
        Leitor leitor = new Leitor();
        Mensagens mensagem = new Mensagens();
        ArrayList<Corretor> corretores = new ArrayList<Corretor>();
        ArrayList<DonoImovel> proprietarios = new ArrayList<DonoImovel>();
        ArrayList<Imovel> imoveis = new ArrayList<Imovel>();
        ArrayList<Proposta> propostas = new ArrayList<Proposta>();
        ArrayList<Venda> vendas = new ArrayList<Venda>();

        boolean continua = true;

        while (continua) {
            int userPrompt = leitor.lerInt(mensagem.getTextoInicial());
            testePrompt(7, userPrompt);// Verifica se o numero esta entre 1 e 5
            switch (userPrompt) {
                case 1://Cadastrar
                    userPrompt = leitor.lerInt(mensagem.getCadastro());
                    testePrompt(5, userPrompt);

                    switch (userPrompt) {
                        boolean verificado = false;
                        case 1: //Cadastro de Cliente

                            InputUserCliente inputCliente = new InputUserCliente();
                            Cliente novoCliente = inputCliente.cadastro();
                            if (novoCliente == null) {
                                break;
                            }

                            ClienteDAO.getInstancia().criar(novoCliente);
                            System.out.println("Cadastro concluído");
                            break;

                        case 2://Cadastro de Corretor

                            InputUserCorretor inputCorretor = new InputUserCorretor();
                            Corretor novoCorretor = inputCorretor.cadastro();
                            if (novoCorretor == null) {
                                break;
                            }

                            CorretorDAO.getInstancia().criar(novoCorretor);
                            System.out.println("Cadastro concluído");
                            break;


                        case 3://Cadastro de Proprietario

                            InputUserProprietario inputProprietario = new InputUserProprietario();
                            DonoImovel proprietario = inputProprietario.cadastro();
                            if (proprietario == null) {
                                break;
                            }

                            ProprietarioDAO.getInstancia().criar(proprietario);
                            System.out.println("Cadastro concluido");
                            break;

                        case 4://Cadastro de Imovel
                            InputImovel inputImovel = new InputImovel();
                            Imovel imovel = inputImovel.cadastro();
                            if (imovel == null) {
                                break;
                            }

                            ImovelDAO.getInstancia().criar(imovel);
                            //confirma o cadastro + informa a ID
                            System.out.println("Cadastro concluído, o número de ID desse ímovel é " + imovel.getIdImovel() + ", Não esqueça!");
                            break;
                        case 5: //opção de saida
                            break;
                    }
                    break;

                case 2://Visualizar
                    userPrompt = leitor.lerInt(mensagem.getVisualizar());
                    testePrompt(6, userPrompt);// Verifica se o numero esta entre 1 e 6
                    switch (userPrompt) {

                        case 1: // Ver cliente
                            InputUserCliente inputCliente = new InputUserCliente();
                            Cliente cliente = inputCliente.visualizar();
                            if (cliente != null) {
                                cliente.mostrarInfoCliente();
                            }
                            break;

                        case 2: // Ver corretor
                            InputUserCorretor inputCorretor = new InputUserCorretor();
                            Corretor corretor = inputCorretor.visualizar();
                            if (corretor != null) {
                                corretor.mostrarInfoCorretor();
                            }
                            break;

                        case 3: // Ver proprietario
                            InputUserProprietario inputProprietario = new InputUserProprietario();
                            DonoImovel proprietario = inputProprietario.visualizar();
                            if (proprietario != null) {
                                proprietario.mostrarInfoProprietario();
                            }
                            break;

                        case 4: // Ver imovel
                            System.out.println("[DIGITE 0 PARA SAIR]");
                            userPrompt = leitor.lerInt(mensagem.getVisualizarImovel());
                            if (userPrompt == 0) {
                                break;
                            }
                            testePrompt(2, userPrompt);// Verifica se o numero esta entre 1 e 2
                            switch (userPrompt) {
                                case 1:// Ver imovel Propostas
                                    System.out.println("[DIGITE 0 PARA SAIR]");
                                    userPrompt = leitor.lerInt(mensagem.getVisualzarImovelPropostas());
                                    // Validação da proposta
                                    boolean achouProposta = false;
                                    while (!achouProposta) {
                                        if (userPrompt == 0) {
                                            break;
                                        }
                                        for (int i = 0; i < propostas.size(); i++) {
                                            Proposta prop = propostas.get(i);
                                            if (prop.getId() == userPrompt) {
                                                // Achou a transacoes.Proposta com o ID correspondente
                                                propostas.get(i).mostrarInfoProposta();
                                                achouProposta = true;
                                                break;
                                            }
                                        }
                                        if (achouProposta) {
                                            break;
                                        }
                                        System.out.println("Proposta não encontrada, tente novamente: ");
                                        userPrompt = leitor.lerInt(mensagem.getVisualzarImovelPropostas());
                                    }
                                    break;

                                case 2: // Ver imoveis Infos
                                    System.out.println("[DIGITE 0 PARA SAIR]");
                                    InputImovel inputImovel = new InputImovel();
                                    Imovel imovel = inputImovel.visualizar();
                                    if (imovel != null) {
                                        imovel.mostrarInfoImovel();
                                    }
                                    break;
                            }
                            break;

                        case 5: // Ver vendas
                            System.out.println("[DIGITE 0 PARA SAIR]");
                            userPrompt = leitor.lerInt(mensagem.getVisualizarVenda());
                            // Validação de Venda
                            boolean achouVenda = false;
                            while (!achouVenda) {
                                if (userPrompt == 0) {
                                    break;
                                }
                                for (int i = 0; i < vendas.size(); i++) {
                                    Venda venda = vendas.get(i);
                                    if (venda.getId() == userPrompt) {
                                        // Achou a Venda com o ID correspondente
                                        vendas.get(i).mostrarInfoVenda();
                                        achouVenda = true;
                                        break;
                                    }
                                }
                                if (achouVenda) {
                                    break;
                                }
                                System.out.println("Venda não encontrada, tente novamente: ");
                                userPrompt = leitor.lerInt(mensagem.getVisualizarVenda());
                            }
                            break;

                        case 6:
                            break;
                }
                    break;

                case 3: //Criar proposta
                    System.out.println(mensagem.getCriar());
                    boolean achou = false;
                    Cliente clienteProposta = null;
                    Corretor corretorProposta = null;
                    Imovel imovelProposta = null;

                    System.out.println("[DIGITE 0 PARA SAIR]");

                    // Pegar cliente pelo CPF
                    String propostaCpfCnpjCliente = leitor.lerString(mensagem.getPropostaCpfCnpjCliente());
                    while (!achou) {
                        if (propostaCpfCnpjCliente.equals("0")) {
                            break;
                        } // verifica saida
                        for (int i = 0; i < clientes.size(); i++) {
                            clienteProposta = clientes.get(i);
                            if (clienteProposta.getCpfOuCnpjCliente().equals(propostaCpfCnpjCliente)) {
                                // Achou o Cliente com o CPF correspondente
                                achou = true;
                                break;
                            }
                        }
                        if (achou) {
                            break;
                        }
                        System.out.println("Cliente não encontrado, tente novamente: ");
                        propostaCpfCnpjCliente = leitor.lerString("Digite o CPF/CNPJ do Cliente ou digite 0 para sair: ");
                    } // Verifica se existe esse cliente
                        // Saida da criação de proposta
                    if (propostaCpfCnpjCliente.equals("0")) {
                        break;
                    }

                    // Pegar corretor pelo Creci
                    String propostaCreci = leitor.lerString(mensagem.getPropostaCreci());
                    achou = false;
                    while (!achou) {
                        if (propostaCreci.equals("0")) {
                            break;
                        }// verifica saida
                        for (int i = 0; i < corretores.size(); i++) {
                            corretorProposta = corretores.get(i);
                            if (corretorProposta.getCreciCoretor().equals(propostaCreci)) {
                                // Achou o Cliente com o CPF correspondente
                                achou = true;
                                break;
                            }
                        }
                        if (achou) {
                            break;
                        }
                        System.out.println("Corretor não encontrado, tente novamente: ");
                        propostaCreci = leitor.lerString("Digite o CRECI do Corretor ou digite 0 para sair: ");
                    } // Verifica se existe esse corretor
                        // Saida da criação de proposta
                    if (propostaCreci.equals("0")) {
                        break;
                    }

                    // Pegar Imovel pelo ID
                    int propostaImovel = leitor.lerInt(mensagem.getPropostaImovel());
                    achou = false;
                    while (!achou) {
                        if (propostaImovel == 0) {
                            break;
                        }// verifica saida
                        for (int i = 0; i < imoveis.size(); i++) {
                            imovelProposta = imoveis.get(i);
                            if (imovelProposta.getIdImovel() == propostaImovel) {
                                // Achou o Cliente com o CPF correspondente
                                achou = true;
                                break;
                            }
                        }
                        if (achou) {
                            break;
                        }
                        System.out.println("Imovel não encontrado, tente novamente: ");
                        propostaImovel = leitor.lerInt("Digite o ID do Imovel ou digite 0 para sair: ");
                    } // Verifica se existe esse imovel
                        // Saida da criação de proposta
                    if (propostaImovel == 0) {
                        break;
                    }

                    // Pegar valor + verif. saida
                    float propostaValor = leitor.lerFloat(mensagem.getPropostaValor());
                    if (propostaValor == 0) {
                        break;
                    }

                    // Pegar comissao (não há saida nesse caso)
                    System.out.println("Digite 0 caso não haja comissão, você não vai sair do sistema!\n");
                    float propostaComissao = leitor.lerFloat(mensagem.getPropostaComissao());

                    // Cria o ID no sistema
                    int iDProposta = propostas.size() + 1;


                    Proposta novaProposta = new Proposta(
                            clienteProposta,
                            corretorProposta,
                            propostaComissao,
                            imovelProposta,
                            iDProposta,
                            propostaValor,
                            "PROPOSTA ABERTA"
                    );
                    propostas.add(novaProposta);

                    System.out.println("Cadastro concluído, o ID dessa proposta é " + novaProposta.getId() + ", não esqueça!");
                    break;

                case 4://Anunciar Venda
                    boolean verifica = false;
                    while (!verifica) {
                        System.out.println("[DIGITE 0 PARA SAIR]");
                        System.out.println((mensagem.getAnunciar()));
                        Proposta propostaVenda = null;
                        DonoImovel donoImovel = null;

                        //Pegar Proposta
                        iDProposta = leitor.lerInt((mensagem.getVendaPropostaID()));
                        achou = false;
                        while (!achou) {
                            if (iDProposta == 0) {
                                break;
                            }// verifica saida
                            for (int i = 0; i < propostas.size(); i++) {
                                propostaVenda = propostas.get(i);
                                if (propostaVenda.getId() == (iDProposta)) {
                                    // Achou Proposta correspondente
                                    achou = true;
                                    break;
                                }
                            }
                            System.out.println("Proposta não encontrado, tente novamente: ");
                            iDProposta = leitor.lerInt("Digite o ID da Proposta ou digite 0 para sair: ");
                        } // Verifica se existe essa proposta
                        // Saida da escolha de proposta
                        if (iDProposta == 0) {
                            break;
                        }

                        //Pegar Proprietario
                        String cpfCnpjProprietario = leitor.lerString(mensagem.getVendaCpfCnpjProprietario());
                        achou = false;
                        while (!achou) {
                            if (cpfCnpjProprietario.equals("0")) {
                                break;
                            }// verifica saida
                            for (int i = 0; i < proprietarios.size(); i++) {
                                donoImovel = proprietarios.get(i);
                                if (donoImovel.getCpfOuCnpjDonoImovel().equals(cpfCnpjProprietario)) {
                                    // Achou Proprietario correspondente
                                    achou = true;
                                    break;
                                }
                            }
                            System.out.println("Proprietario não encontrado, tente novamente: ");
                            cpfCnpjProprietario = leitor.lerString("Digite o CPF/CNPJ do Proprietario ou digite 0 para sair: ");
                        } // Verifica se existe esse Proprietario
                        // Saida da escolha de Proprietario
                        if (cpfCnpjProprietario.equals("0")) {
                            break;
                        }

                        //Escolher forma de pagamento
                        System.out.println("[DIGITE 0 PARA SAIR]");
                        String formaDePagamento = leitor.lerString(mensagem.getVendaFormaDePagamento());
                        if (formaDePagamento.equals("0")) {
                            break;
                        }

                        // Definir valor da venda
                        float valorVenda = propostaVenda.getValorOferecido();

                        //Definir ID da venda
                        int idVenda = vendas.size() + 1;

                        System.out.println("Venda: " +
                                "\nId da proposta: " + propostaVenda.getId() +
                                "\nValor da venda: " + propostaVenda.getValorOferecido() +
                                "\nForma de pagamento: " + formaDePagamento +
                                "\nProprietario atual: " + donoImovel.getUserInfo().getNome() + " " + donoImovel.getUserInfo().getSobrenome() +
                                "\nCPF/CNPJ do proprietario atual: " + donoImovel.getCpfOuCnpjProprietarioCripted()
                        );
                        verifica = leitor.lerBoolean("Confirmar?");
                        if (verifica) {
                            //Atualiza status da proposta
                            for (int i = 0; i < propostas.size(); i++) {
                                if (propostaVenda.equals(propostas.get(i))) {
                                    // Achou Proposta correspondente
                                    propostas.get(i).setStatus("PROPOSTA TRANSFORMADA EM VENDA");
                                    propostaVenda.setStatus("PROPOSTA TRANSFORMADA EM VENDA");
                                    break;
                                }
                            }
                            //Cria a venda
                            Venda venda = new Venda(
                                    propostaVenda,
                                    donoImovel,
                                    idVenda,
                                    valorVenda,
                                    formaDePagamento
                            );
                            vendas.add(venda);
                        }
                    }
                    break;
                case 5: //Deletar
                    userPrompt = leitor.lerInt(mensagem.getDeletar());
                    testePrompt(4, userPrompt);

                    //Deletar
                    switch (userPrompt) {
                        case 1:
                            InputUserCliente inputCliente = new InputUserCliente();
                            inputCliente.deletar();
                            break;
                        case 2:
                            InputUserCorretor inputCorretor = new InputUserCorretor();
                            inputCorretor.deletar();
                            break;
                        case 3:
                            InputUserProprietario inputProprietario = new InputUserProprietario();
                            inputProprietario.deletar();
                            break;
                        case 4:
                            break;
                    }
                    break;


                case 6: // Alterar
                    userPrompt = leitor.lerInt(mensagem.getAtualizar());
                    testePrompt(4, userPrompt);

                    // Alterar
                    switch (userPrompt) {
                        case 1:
                            userPrompt = leitor.lerInt(mensagem.getAtualizarCliente());
                            testePrompt(6, userPrompt);
                            InputUserCliente inputCliente = new InputUserCliente();
                            switch (userPrompt) {
                                case 1:
                                    inputCliente.atualizarPK();
                                    break;
                                case 2:
                                    inputCliente.atualizarSenha();
                                    break;
                                case 3:
                                    inputCliente.atualizarNomeSobrenome();
                                    break;
                                case 4:
                                    inputCliente.atualizarEmail();
                                    break;
                                case 5:
                                    inputCliente.atualizarTelefone();
                                    break;
                                case 6:
                                    break;
                            }
                            break;
                        case 2:
                            userPrompt = leitor.lerInt(mensagem.getAtualizarCorretor());
                            testePrompt(6, userPrompt);

                            InputUserCorretor inputCorretor = new InputUserCorretor();
                            switch (userPrompt) {
                                case 1:
                                    inputCorretor.atualizarPK();
                                    break;
                                case 2:
                                    inputCorretor.atualizarSenha();
                                    break;
                                case 3:
                                    inputCorretor.atualizarNomeSobrenome();
                                    break;
                                case 4:
                                    inputCorretor.atualizarEmail();
                                    break;
                                case 5:
                                    inputCorretor.atualizarTelefone();
                                    break;
                                case 6:
                                    break;
                            }
                            break;
                        case 3:
                            userPrompt = leitor.lerInt(mensagem.getAtualizarProprietario());
                            testePrompt(6, userPrompt);

                            InputUserProprietario inputProprietario = new InputUserProprietario();
                            switch (userPrompt) {
                                case 1:
                                    inputProprietario.atualizarPK();
                                    break;
                                case 2:
                                    inputProprietario.atualizarSenha();
                                    break;
                                case 3:
                                    inputProprietario.atualizarNomeSobrenome();
                                    break;
                                case 4:
                                    inputProprietario.atualizarEmail();
                                    break;
                                case 5:
                                    inputProprietario.atualizarTelefone();
                                    break;
                                case 6:
                                    break;
                            }
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 7: //Sair
                    continua = false;
                    break;

            }
        }
    }
}
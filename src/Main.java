import java.util.ArrayList;

public class Main {
    public static void testePrompt (int max, int userPrompt) {
        if (userPrompt > max || userPrompt <= 0) {
            System.out.println("\nNesta parte, favor digitar um numero que esteja entre 1 e " + max + "\n" +
                    "Voltando... \n\n");
        } // Verifica se o numero esta entre os valores delimitados
    }

    public static void main(String[] args) {
        Leitor leitor = new Leitor();
        Mensagens mensagem = new Mensagens();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Corretor> corretores = new ArrayList<Corretor>();
        ArrayList<DonoImovel> proprietarios = new ArrayList<DonoImovel>();
        ArrayList<Imovel> imoveis = new ArrayList<Imovel>();
        ArrayList<Proposta> propostas = new ArrayList<Proposta>();
        ArrayList<Venda> vendas = new ArrayList<Venda>();

        boolean continua = true;

        while (continua) {
            int userPrompt = leitor.lerInt(mensagem.getTextoInicial());
            testePrompt(5, userPrompt);// Verifica se o numero esta entre 1 e 5
            switch (userPrompt) {
                case 1://Cadastrar
                    userPrompt = leitor.lerInt(mensagem.getCadastro());
                    testePrompt(5, userPrompt);

                    switch (userPrompt) {
                        case 1: //Cadastro de Cliente
                            System.out.println(mensagem.getCadastroCliente());
                            String emailCliente = leitor.lerString("Digite seu e-mail: ");
                            String senhaCliente = leitor.lerString("Digite sua senha: ");
                            String nomeCliente = leitor.lerString("Digite o nome do cliente: ");
                            String sobrenomeCliente = leitor.lerString("Digite o sobrenome do cliente: ");
                            String telefoneCliente = leitor.lerString("Digite o telefone do cliente: ");
                            String cpfCnpjCliente = leitor.lerString("Digite o CPF/CNPJ do cliente: ");

                            Usuario novoUser = new Usuario(emailCliente, senhaCliente, nomeCliente, sobrenomeCliente, telefoneCliente);
                            Cliente novoCliente = new Cliente(novoUser, cpfCnpjCliente);
                            clientes.add(novoCliente);

                            System.out.println("Cadastro concluído");
                            break;
                        case 2://Cadastro de Corretor
                            System.out.println(mensagem.getCadastroCorretor());
                            String emailCorretor = leitor.lerString("Digite seu e-mail: ");
                            String senhaCorretor = leitor.lerString("Digite sua senha: ");
                            String nomeCorretor = leitor.lerString("Digite o nome do corretor: ");
                            String sobrenomeCorretor = leitor.lerString("Digite o sobrenome do corretor: ");
                            String telefoneCorretor = leitor.lerString("Digite o telefone do corretor: ");
                            String creciCorretor = leitor.lerString("Digite o CRECI do corretor: ");

                            Usuario novoUser2 = new Usuario(emailCorretor, senhaCorretor, nomeCorretor, sobrenomeCorretor, telefoneCorretor);
                            Corretor novoCorretor = new Corretor(novoUser2, creciCorretor);
                            corretores.add(novoCorretor);

                            System.out.println("Cadastro concluído");
                            break;
                        case 3://Cadastro de Proprietario
                            System.out.println(mensagem.getCadastroProprietario());
                            String emailProprietario = leitor.lerString("Digite seu e-mail: ");
                            String senhaProprietario = leitor.lerString("Digite sua senha: ");
                            String nomeProprietario = leitor.lerString("Digite o nome do proprietário: ");
                            String sobrenomeProprietario = leitor.lerString("Digite o sobrenome do proprietário: ");
                            String telefoneProprietario = leitor.lerString("Digite o telefone do proprietário: ");
                            String cpfCnpjProprietario = leitor.lerString("Digite o CPF/CNPJ do proprietário: ");

                            Usuario novoUser3 = new Usuario(emailProprietario, senhaProprietario, nomeProprietario, sobrenomeProprietario, telefoneProprietario);
                            DonoImovel novoProprietario = new DonoImovel(novoUser3, cpfCnpjProprietario);
                            proprietarios.add(novoProprietario);

                            System.out.println("Cadastro concluído");
                            break;
                        case 4://Cadastro de Imovel
                            System.out.println("[DIGITE 0 PARA SAIR]");
                            System.out.println(mensagem.getCadastroImovel());
                            String bairroImovel = leitor.lerString("Digite o bairro: ");
                            if (bairroImovel.equals("0")) {
                                break;
                            }
                            String cidadeImovel = leitor.lerString("Digite a cidade: ");
                            if (cidadeImovel.equals("0")) {
                                break;
                            }
                            String ruaImovel = leitor.lerString("Digite a rua: ");
                            if (ruaImovel.equals("0")) {
                                break;
                            }
                            String numeroImovel = leitor.lerString("Digite o numero: ");
                            if (numeroImovel.equals("0")) {
                                break;
                            }
                            String cepImovel = leitor.lerString("Digite o CEP: ");
                            if (cepImovel.equals("0")) {
                                break;
                            }
                            String tipoImovel = leitor.lerString("Digite o tipo (casa ou apartamneto): ");
                            if (tipoImovel.equals("0")) {
                                break;
                            }
                            String statusImovel = leitor.lerString("Digite o status do ímovel (Reformado, Mobiliado ou Construção): ");
                            if (statusImovel.equals("0")) {
                                break;
                            }
                            String nomeImovel = leitor.lerString("Digite o nome do movel: ");
                            if (nomeImovel.equals("0")) {
                                break;
                            }
                            String cpfCnpjImovel = leitor.lerString("Digite o CPF/CNPJ do proprietário: ");
                            if (cpfCnpjImovel.equals("0")) {
                                break;
                            }

                            // Cria o Endereço, ID e Ímovel em sí no sistema
                            Endereco novoEndereco = new Endereco(bairroImovel, cidadeImovel, ruaImovel, numeroImovel, cepImovel);
                            int idImovel = imoveis.size() + 1;
                            Imovel novoimovel = new Imovel(novoEndereco, idImovel, nomeImovel,tipoImovel, statusImovel);

                            // Validação de proprietário
                            boolean achouProprietario = false;
                            while (!achouProprietario) {
                                for (int i = 0; i < proprietarios.size(); i++) {
                                    DonoImovel p = proprietarios.get(i);
                                    if (p.getCpfOuCnpjDonoImovel().equals(cpfCnpjImovel)) {
                                        // Achou o proprietário com o CPF correspondente
                                        System.out.println("Proprietário encontrado: " + p.getUserInfo().getNome());
                                        achouProprietario = true;
                                        break;
                                    }
                                }
                                if (achouProprietario) {
                                    break;
                                }
                                System.out.println("Proprietário não encontrado, tente novamente: ");
                                cpfCnpjImovel = leitor.lerString("Digite o CPF/CNPJ do proprietário: ");
                            }

                            //confirma o cadastro + informa a ID
                            System.out.println("Cadastro concluído, o número de ID desse ímovel é " + idImovel + ", Não esqueça!");
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
                            System.out.println("[DIGITE 0 PARA SAIR]");
                            String view = leitor.lerString(mensagem.getVisualizarCliente());
                            // Validação de cliente
                            boolean achouCliente = false;
                            while (!achouCliente) {
                                if (view.equals("0")) {
                                    break;
                                }
                                for (int i = 0; i < clientes.size(); i++) {
                                    Cliente c = clientes.get(i);
                                    if (c.getCpfOuCnpjCliente().equals(view)) {
                                        // Achou o Cliente com o CPF correspondente
                                        clientes.get(i).mostrarInfoCliente();
                                        achouCliente = true;
                                        break;
                                    }
                                }
                                System.out.println("Cliente não encontrado, tente novamente: ");
                                view = leitor.lerString("Digite o CPF/CNPJ do Cliente: ");
                            }
                            break;

                        case 2: // Ver corretor
                            System.out.println("[DIGITE 0 PARA SAIR]");
                            view = leitor.lerString(mensagem.getVisualizarCorretor());
                            // Validação de corretor
                            boolean achouCorretor = false;
                            while (!achouCorretor) {
                                if (view.equals("0")) {
                                    break;
                                }
                                for (int i = 0; i < corretores.size(); i++) {
                                    Corretor c = corretores.get(i);
                                    if (c.getCreciCoretor().equals(view)) {
                                        // Achou o Corretor com o CRECI correspondente
                                        corretores.get(i).mostrarInfoCorretor();
                                        achouCorretor = true;
                                        break;
                                    }
                                }
                                System.out.println("Corretor não encontrado, tente novamente: ");
                                view = leitor.lerString("Digite o CCRECI do Corretor: ");
                            }
                            break;

                        case 3: // Ver proprietario
                            System.out.println("[DIGITE 0 PARA SAIR]");
                            view = leitor.lerString(mensagem.getVisualizarProprietario());
                            // Validação de Proprietario
                            boolean achouProprietario = false;
                            while (!achouProprietario) {
                                if (view.equals("0")) {
                                    break;
                                }
                                for (int i = 0; i < proprietarios.size(); i++) {
                                    DonoImovel p = proprietarios.get(i);
                                    if (p.getCpfOuCnpjDonoImovel().equals(view)) {
                                        // Achou o Proprietario com o CPF correspondente
                                        proprietarios.get(i).mostrarInfoProprietario();
                                        achouProprietario = true;
                                        break;
                                    }
                                }
                                System.out.println("Proprietário não encontrado, tente novamente: ");
                                view = leitor.lerString("Digite o CPF/CNPJ do Proprietario: ");
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
                                                // Achou o Imovel com o ID correspondente
                                                propostas.get(i).mostrarInfoProposta();
                                                achouProposta = true;
                                                break;
                                            }
                                        }
                                        System.out.println("Proposta não encontrada, tente novamente: ");
                                        userPrompt = leitor.lerInt(mensagem.getVisualzarImovelPropostas());
                                    }
                                    break;

                                case 2: // Ver imoveis Infos
                                    System.out.println("[DIGITE 0 PARA SAIR]");
                                    userPrompt = leitor.lerInt(mensagem.getVisualzarImovelInformacoes());
                                    // Validação de Imovel
                                    boolean achouImovel = false;
                                    while (!achouImovel) {
                                        if (userPrompt == 0) {
                                            break;
                                        }
                                        for (int i = 0; i < imoveis.size(); i++) {
                                            Imovel imov = imoveis.get(i);
                                            if (imov.getIdImovel() == userPrompt) {
                                                // Achou o Imovel com o ID correspondente
                                                imoveis.get(i).mostrarInfoImovel();
                                                achouImovel = true;
                                                break;
                                            }
                                        }
                                        System.out.println("Imovel não encontrado, tente novamente: ");
                                        userPrompt = leitor.lerInt(mensagem.getVisualzarImovelInformacoes());
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
                    achou = false;
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
                    Boolean verifica = false;
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
                                if (donoImovel.getCpfOuCnpjDonoImovel() == (cpfCnpjProprietario)) {
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
                        }
                    }
                    break;
                case 5: //Sair
                    continua = false;
                    break;

            }
        }
    }
}
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

        boolean continua = true;

        while (continua) {
            int userPrompt = leitor.lerInt(mensagem.getTextoInicial());
            testePrompt(7, userPrompt);// Verifica se o numero esta entre 1 e 7
            switch (userPrompt) {
                case 1://Cadastrar
                    userPrompt = leitor.lerInt(mensagem.getCadastro());
                    testePrompt(5, userPrompt);

                    switch (userPrompt) {
                        case 1:
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
                        case 2:
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
                        case 3:
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
                        case 4:
                            System.out.println(mensagem.getCadastroImovel());
                            String bairroImovel = leitor.lerString("Digite o bairro: ");
                            String cidadeImovel = leitor.lerString("Digite a cidade: ");
                            String ruaImovel = leitor.lerString("Digite a rua: ");
                            String numeroImovel = leitor.lerString("Digite o numero: ");
                            String cepImovel = leitor.lerString("Digite o CEP: ");
                            String tipoImovel = leitor.lerString("Digite o tipo (casa ou apartamneto): ");
                            String statusImovel = leitor.lerString("Digite o status do ímovel (Reformado, Mobiliado ou Construção): ");
                            String nomeImovel = leitor.lerString("Digite o nome do movel: ");
                            String cpfCnpjImovel = leitor.lerString("Digite o CPF/CNPJ do proprietário: ");

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
                                System.out.println("Proprietário não encontrado, tente novamente: ");
                                cpfCnpjImovel = leitor.lerString("Digite o CPF/CNPJ do proprietário: ");
                            }

                            //confirma o cadastro + informa a ID
                            System.out.println("Cadastro concluído, o número de ID desse ímovel é " + idImovel + ", Não esqueça!");
                            break;
                        case 5:
                            break;
                    }
                    break;

                case 2://Visualizar
                    userPrompt = leitor.lerInt(mensagem.getVisualizar());
                    testePrompt(5, userPrompt);// Verifica se o numero esta entre 1 e 5
                    switch (userPrompt) {
                        case 1: // Ver cliente
                            String view = leitor.lerString(mensagem.getVisualizarCliente());
                            // Validação de cliente
                            boolean achouCliente = false;
                            while (!achouCliente) {
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
                            view = leitor.lerString(mensagem.getVisualizarCorretor());
                            // Validação de corretor
                            boolean achouCorretor = false;
                            while (!achouCorretor) {
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
                            view = leitor.lerString(mensagem.getVisualizarProprietario());
                            // Validação de Proprietario
                            boolean achouProprietario = false;
                            while (!achouProprietario) {
                                for (int i = 0; i < proprietarios.size(); i++) {
                                    DonoImovel p = proprietarios.get(i);
                                    if (p.getCpfOuCnpjDonoImovel().equals(view)) {
                                        // Achou o Cliente com o CPF correspondente
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
                            userPrompt = leitor.lerInt(mensagem.getVisualizarImovel());
                            testePrompt(2, userPrompt);// Verifica se o numero esta entre 1 e 2
                            switch (userPrompt) {
                                case 1:
                                    view = leitor.lerString(mensagem.getVisualzarImovelPropostas());
                                    // TODO
                                    break;
                                case 2:
                                    view = leitor.lerString(mensagem.getVisualzarImovelInformacoes());
                                    // TODO
                                    break;
                            }
                            break;
                        case 5:
                            break;
                }
                    break;

                case 3://Alterar informação
                    userPrompt = leitor.lerInt(mensagem.getAlterar());
                    switch (userPrompt) {
                        case 1:
                            break;
                    }
                    break;
                case 4://Remover informação
                    userPrompt = leitor.lerInt(mensagem.getRemover());
                    switch (userPrompt) {
                        case 1:
                            break;
                    }
                    break;
                case 5: //Criar proposta
                    System.out.println(mensagem.getCriar());
                    boolean achou = false;

                    // Pegar cliente pelo CPF
                    String propostaCpfCnpjCliente = leitor.lerString(mensagem.getPropostaCpfCnpjCliente());
                    achou = false;
                    while (!achou) {
                        for (int i = 0; i < clientes.size(); i++) {
                            Cliente clienteProposta = clientes.get(i);
                            if (clienteProposta.getCpfOuCnpjCliente().equals(propostaCpfCnpjCliente)) {
                                // Achou o Cliente com o CPF correspondente
                                achou = true;
                                break;
                            }
                        }
                        System.out.println("Cliente não encontrado, tente novamente: ");
                        propostaCpfCnpjCliente = leitor.lerString("Digite o CPF/CNPJ do Cliente ou digite 0 para sair: ");
                        if (propostaCpfCnpjCliente.equals("0")) {
                            break;
                        }
                    } // Verifica se existe esse cliente
                    // Saida da criação de proposta
                    if (propostaCpfCnpjCliente.equals("0")) {
                        break;
                    }

                    // Pegar corretor pelo Creci
                    String propostaCreci = leitor.lerString(mensagem.getPropostaCreci());
                    achou = false;
                    while (!achou) {
                        for (int i = 0; i < corretores.size(); i++) {
                            Corretor corretorProposta = corretores.get(i);
                            if (corretorProposta.getCreciCoretor().equals(propostaCreci)) {
                                // Achou o Cliente com o CPF correspondente
                                achou = true;
                                break;
                            }
                        }
                        System.out.println("Corretor não encontrado, tente novamente: ");
                        propostaCreci = leitor.lerString("Digite o CRECI do Corretor ou digite 0 para sair: ");
                        if (propostaCreci.equals("0")) {
                            break;
                        }
                    } // Verifica se existe esse corretor
                    // Saida da criação de proposta
                    if (propostaCreci.equals("0")) {
                        break;
                    }

                    int propostaImovel = leitor.lerInt(mensagem.getPropostaImovel());
                    achou = false;
                    while (!achou) {
                        for (int i = 0; i < imoveis.size(); i++) {
                            Imovel imovelProposta = imoveis.get(i);
                            if (imovelProposta.getIdImovel() == propostaImovel) {
                                // Achou o Cliente com o CPF correspondente
                                achou = true;
                                break;
                            }
                        }
                        if (propostaImovel == 0) {
                            break;
                        }
                        System.out.println("Imovel não encontrado, tente novamente: ");
                        propostaImovel = leitor.lerInt("Digite o ID do Imovel ou digite 0 para sair: ");
                    } // Verifica se existe esse cliente
                    // Saida da criação de proposta
                    if (propostaImovel == 0) {
                        break;
                    }

                    String propostaValor = leitor.lerString(mensagem.getPropostaValor());
                    String propostaComissao = leitor.lerString(mensagem.getPropostaComissao());

                    // Cria o ID no sistema
                    int idProposta = propostas.size() + 1;

                    //TODO
                        // Pegar cliente pelo CPF

                        // Pegar corretor pelo Creci
                        // Pegar Imovel pelo ID

                    //Proposta novaProposta = new Proposta(emailProprietario, senhaProprietario, nomeProprietario, sobrenomeProprietario, telefoneProprietario);
                    //DonoImovel novoProprietario = new DonoImovel(novoUser3, cpfCnpjProprietario);
                    //proprietarios.add(novoProprietario);

                    System.out.println("Cadastro concluído");
                    break;
                case 6://Anunciar Venda
                    userPrompt = leitor.lerInt(mensagem.getAnunciar());
                    switch (userPrompt) {
                        case 1:
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
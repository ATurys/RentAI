import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void testePrompt (int max, int userPrompt) {
        if (userPrompt > max || userPrompt <= 0) {
            throw new ArithmeticException("Nesta parte, favor digitar um numero que esteja entre 1 e " + max);
        } // Verifica se o numero esta entre os valores delimitados
    }

    public static void main(String[] args) {
        Leitor leitor = new Leitor();
        Mensagens mensagem = new Mensagens();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Corretor> corretores = new ArrayList<Corretor>();
        ArrayList<DonoImovel> proprietarios = new ArrayList<DonoImovel>();
        ArrayList<Imovel> imoveis = new ArrayList<Imovel>();

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
                    switch (userPrompt) {
                        case 1:
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
                    userPrompt = leitor.lerInt(mensagem.getCriar());
                    switch (userPrompt) {
                        case 1:
                            break;
                    }
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
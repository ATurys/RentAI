public class Mensagens {
    private String textoInicial =
            "Olá, selecione uma das opções abaixo:\n" +
            "\t1 - Cadastrar\n" +
            "\t2 - Visualizar\n" +
            "\t3 - Criar uma proposta\n" +
            "\t4 - Anunciar uma Venda\n" +
            "\t5 - Sair\n";

    // Textos camda 1
    private String cadastro =
            "\t1 - Cadastrar Cliente\n" +
            "\t2 - Cadastrar Corretor\n" +
            "\t3 - Cadastrar Proprietário\n" +
            "\t4 - Cadastrar Ímovel\n" +
            "\t5 - Voltar\n";

    private String visualizar =
            "\t1 - Visualizar Cliente\n" +
            "\t2 - Visualizar Corretor\n" +
            "\t3 - Visualizar Proprietário\n" +
            "\t4 - Visualizar Ímovel\n" +
            "\t5 - Voltar\n";

    private String criar =
            "Precisaremos das seguintes informações: \n" +
            "\t1 - CPF do Cliente\n" +
            "\t2 - CRECI do Corretor\n" +
            "\t3 - ID Ímovel\n" +
            "\t4 - Valor da proposta\n" +
            "\t5 - Comissão do corretor\n";
    private String anunciar =
            "\t1 - Selecione o ID da Proposta que foi aceita\n" +
            "\t2 - Voltar\n";

    // Opções após selecionar o texto inicial -> Cadastro
    private String cadastroCliente =
            "Precisaremos das seguintes informações: \n" +
            "1° - e-mail\n" +
            "2° - senha\n" +
            "3° - nome\n" +
            "4° - sobrenome\n" +
            "5 ° - telefone\n" +
            "6 ° - CPF/CNPJ\n";
    private String cadastroCorretor =
            "Precisaremos das seguintes informações: \n" +
            "1° - e-mail\n" +
            "2° - senha\n" +
            "3° - nome\n" +
            "4° - sobrenome\n" +
            "5 ° - telefone\n" +
            "6 ° - número do CRECI\n";
    private String cadastroProprietario =
            "Precisaremos das seguintes informações: \n" +
            "1° - e-mail:\n" +
            "2° - senha:\n" +
            "3° - nome:\n" +
            "4° - sobrenome:\n" +
            "5 ° - telefone:\n" +
            "6 ° - CPF/CNPJ\n";
    private String cadastroImovel =
            "Precisaremos das seguintes informações: \n" +
            "1° - bairro\n" +
            "2° - cidade\n" +
            "3° - rua\n" +
            "4° - numero\n" +
            "5° - cep\n" +
            "6° - tipo de imovel (casa ou apto.)\n" +
            "8° - status do imovel\n" +
            "9° - nome do ímovel\n" +
            "10° - CPF/CNPJ do proprietário\n";


    // Opções de visualizar após selecionar o texto inicial

    private String visualizarCliente =
            "Digite o CPF/CNPJ: \n";
    private String visualizarCorretor =
            "Digite o número do CRECI: \n";
    private String visualizarProprietario =
            "Digite o CPF/CNPJ: \n";
    private String visualizarImovel =
            "1° - Visualizar propostas\n" +
            "2° - Visualizar informações\n";
    private String visualzarImovelPropostas =
                   "Digite o ID da proposta: \n:";
    private String visualzarImovelInformacoes =
            "Digite o ID do ímovel: \n:";


    // Opções de alterar após selecionar o texto inicial
    private String alterarCliente =
            "Digite o CPF/CNPJ: \n";
    private String alterarCorretor =
            "Digite o número do creci: \n";
    private String alterarProprietario =
            "Digite o CPF/CNPJ: \n";
    private String alterarImovel =
            "Digite o ID do ímovel: \n:";


    // Opções de remover após selecionar o texto inicial
    private String removerCliente =
            "Digite o CPF/CNPJ: \n";
    private String removerCorretor =
            "Digite o número do creci: \n";
    private String removerProprietario =
            "Digite o CPF/CNPJ: \n";
    private String removerImovel =
            "Digite o ID do ímovel: \n:";


    // Opções para criar uma proposta

    private String propostaCpfCnpjCliente =
            "Digite o CPF/CNPJ do cliente que vai fazer a proposta: \n";
    private String propostaCreci =
            "Digite o Creci do corretor que vai fazer a proposta: \n";
    private String propostaImovel =
            "Digite o ID do ímovel que o cliente quer propor a oferta: \n";
    private String propostaValor =
            "Digite o valor da proposta: \n";
    private String propostaComissao =
            "Digite o valor da comissao do corretor (em porcentagem): \n";


    //Getter texto inicial
    public String getTextoInicial() {
        return textoInicial;
    }


    // Getter camada 01

    public String getCadastro() {
        return cadastro;
    }

    public String getVisualizar() {
        return visualizar;
    }

    public String getCriar() {
        return criar;
    }

    public String getAnunciar() {
        return anunciar;
    }


    // Getters camada 2 -> Cadastro

    public String getCadastroCliente() {
        return cadastroCliente;
    }

    public String getCadastroCorretor() {
        return cadastroCorretor;
    }

    public String getCadastroProprietario() {
        return cadastroProprietario;
    }

    public String getCadastroImovel() {
        return cadastroImovel;
    }

    // Getters camada 2 -> Visualizar
    public String getVisualizarCliente() {
        return visualizarCliente;
    }

    public String getVisualizarCorretor() {
        return visualizarCorretor;
    }

    public String getVisualizarProprietario() {
        return visualizarProprietario;
    }

    public String getVisualizarImovel() {
        return visualizarImovel;
    }

    public String getVisualzarImovelPropostas() {
        return visualzarImovelPropostas;
    }

    public String getVisualzarImovelInformacoes() {
        return visualzarImovelInformacoes;
    }


    // Getters camada 2 -> Alterar

    public String getAlterarCliente() {
        return alterarCliente;
    }

    public String getAlterarCorretor() {
        return alterarCorretor;
    }

    public String getAlterarProprietario() {
        return alterarProprietario;
    }

    public String getAlterarImovel() {
        return alterarImovel;
    }

    // Getters camada 2 -> remover

    public String getRemoverCliente() {
        return removerCliente;
    }

    public String getRemoverCorretor() {
        return removerCorretor;
    }

    public String getRemoverProprietario() {
        return removerProprietario;
    }

    public String getRemoverImovel() {
        return removerImovel;
    }


    // Getters camada 2 -> Criar Proposta

    public String getPropostaCpfCnpjCliente() {
        return propostaCpfCnpjCliente;
    }

    public String getPropostaCreci() {
        return propostaCreci;
    }

    public String getPropostaImovel() {
        return propostaImovel;
    }

    public String getPropostaValor() {
        return propostaValor;
    }

    public String getPropostaComissao() {
        return propostaComissao;
    }
}

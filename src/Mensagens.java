public class Mensagens {
    private String textoInicial =
            "Olá, selecione uma das opções abaixo:\n" +
            "\t1 - Cadastrar\n" +
            "\t2 - Visualizar\n" +
            "\t3 - Alterar uma informação\n" +
            "\t4 - Remover uma informação\n" +
            "\t5 - Criar uma proposta\n" +
            "\t6 - Anunciar uma Venda\n" +
            "\t7 - Sair\n";

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

    private String alterar =
            "\t1 - Alterar Cliente\n" +
            "\t2 - Alterar Corretor\n" +
            "\t3 - Alterar Proprietário\n" +
            "\t4 - Alterar Ímovel\n" +
            "\t5 - Voltar\n";

    private String remover =
            "\t1 - Remover Cliente\n" +
            "\t2 - Remover Corretor\n" +
            "\t3 - Remover Proprietário\n" +
            "\t4 - Remover Ímovel\n" +
            "\t5 - Voltar\n";

    private String criar =
            "\t1 - Informar Cliente\n" +
            "\t2 - Informar Corretor\n" +
            "\t3 - Informar Proprietário\n" +
            "\t4 - Informar Ímovel\n" +
            "\t5 - Voltar\n";
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
            "6 ° - número do seu creci\n";
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
            "5 ° - cep\n" +
            "6 ° - tipo de imovel (casa ou apto.)\n" +
            "8 ° - status do imovel\n" +
            "9 ° - nome do ímovel\n" +
            "10 ° - CPF/CNPJ do proprietário\n";

    // Criar getters e o texto para os de baixo
    // Opções após selecionar o texto inicial
    private String visualizarCliente;
    private String visualizarCorretor;
    private String visualizarProprietario;
    private String visualizarImovel;
    private String visualzarImovelPropostas;
    private String visualzarImovelInformacoes;

    // Criar getters e o texto para os de baixo
    // Opções após selecionar o texto inicial
    private String alterarCliente;
    private String alterarCorretor;
    private String alterarProprietario;
    private String alterarImovel;

    // Criar getters e o texto para os de baixo
    // Opções após selecionar o texto inicial
    private String removerCliente;
    private String removerCorretor;
    private String removerProprietario;
    private String removerImovel;

    // Criar getters e o texto para os de baixo
    // Opções para criar uma proposta

    private String proposta;


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

    public String getAlterar() {
        return alterar;
    }

    public String getRemover() {
        return remover;
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
}

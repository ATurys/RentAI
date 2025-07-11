package br.edu.ifsc.modelo.RentAI.visao;

public class Mensagens {
    private String textoInicial =
            "=======================================\n" +
            "Olá, selecione uma das opções abaixo:\n" +
            "\t1 - Cadastrar\n" +
            "\t2 - Visualizar\n" +
            "\t3 - Criar uma proposta\n" +
            "\t4 - Anunciar uma Venda\n" +
            "\t5 - Deletar\n" +
            "\t6 - Alterar\n" +
            "\t7 - Sair\n"+
            "=======================================\n";

    // Textos camda 1
    private String cadastro =
            "=======================================\n" +
            "\t1 - Cadastrar Cliente\n" +
            "\t2 - Cadastrar Corretor\n" +
            "\t3 - Cadastrar Proprietário\n" +
            "\t4 - Cadastrar Ímovel\n" +
            "\t5 - Voltar\n" +
            "=======================================\n";

    private String visualizar =
            "=======================================\n" +
            "\t1 - Visualizar Cliente\n" +
            "\t2 - Visualizar Corretor\n" +
            "\t3 - Visualizar Proprietário\n" +
            "\t4 - Visualizar Ímovel\n" +
            "\t5 - Visualizar Vendas\n" +
            "\t6 - Voltar\n" +
            "=======================================\n";

    private String criar =
            "=======================================\n" +
            "Precisaremos das seguintes informações: \n" +
            "\t1 - CPF do Cliente\n" +
            "\t2 - CRECI do Corretor\n" +
            "\t3 - ID Ímovel\n" +
            "\t4 - Valor da proposta\n" +
            "\t5 - Comissão do corretor\n" +
            "=======================================\n";

    private String anunciar =
            "=======================================\n" +
            "Precisaremos das seguintes informações: \n" +
            "\t1 - ID da Proposta que foi aceita\n" +
            "\t2 - CPF/CNPJ do proprietário atual\n" +
            "\t3 - Forma de pagamento\n" +
            "=======================================\n" ;

    // Opções após selecionar o texto inicial -> Cadastro
    private String cadastroCliente =
            "\nPrecisaremos das seguintes informações: \n" +
            "1° - e-mail\n" +
            "2° - senha\n" +
            "3° - nome\n" +
            "4° - sobrenome\n" +
            "5° - telefone\n" +
            "6° - CPF/CNPJ\n" +
            "7° - Nome de Usuário\n";
    private String cadastroCorretor =
            "\nPrecisaremos das seguintes informações: \n" +
            "1° - e-mail\n" +
            "2° - senha\n" +
            "3° - nome\n" +
            "4° - sobrenome\n" +
            "5 ° - telefone\n" +
            "6 ° - número do CRECI\n" +
            "7° - Nome de Usuário\n";
    private String cadastroProprietario =
            "\nPrecisaremos das seguintes informações: \n" +
            "1° - e-mail:\n" +
            "2° - senha:\n" +
            "3° - nome:\n" +
            "4° - sobrenome:\n" +
            "5 ° - telefone:\n" +
            "6 ° - CPF/CNPJ\n" +
            "7° - Nome de Usuário\n";
    private String cadastroImovel =
            "\nPrecisaremos das seguintes informações: \n" +
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
                   "Digite o ID da proposta: \n";
    private String visualzarImovelInformacoes =
            "Digite o ID do ímovel: \n";
    private String visualizarVenda =
            "Digite o ID da venda: \n";


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

    private String propostaStatus =
            "\nDefina o status do proposta: \n" +
            "\t1 - [pendente]\n" +
            "\t2 - [aceita]\n" +
            "\t3 - [recusada]\n";

    // Opções para criar uma venda
    private String vendaPropostaID =
            "ID da Proposta que foi aceita: ";
    private String vendaCpfCnpjProprietario =
            "CPF/CNPJ do proprietário atual: ";
    private String vendaFormaDePagamento =
            "Defina a forma de pagamento: \n" +
            "\t1 - [a vista]\n" +
            "\t2 - [financiamento]\n" +
            "\t3 - [parcelado]\n";

    // Opções para Atualizar
    private String atualizar =
            "=======================================\n" +
            "\t1 - atualizar Cliente\n" +
            "\t2 - atualizar Corretor\n" +
            "\t3 - atualizar Proprietário\n" +
            "\t4 - voltar\n" +
            "=======================================\n";

    private String atualizarCliente =
            "\t1 - atualizar CPF/CNPJ\n" +
            "\t2 - atualizar Senha\n" +
            "\t3 - atualizar Nome e Sobrenome\n" +
            "\t4 - atualizar Email\n" +
            "\t5 - atualizar Telefone\n" +
            "\t6 - voltar\n";

    private String atualizarCorretor =
            "\t1 - atualizar CRECI\n" +
            "\t2 - atualizar Senha\n" +
            "\t3 - atualizar Nome e Sobrenome\n" +
            "\t4 - atualizar Email\n" +
            "\t5 - atualizar Telefone\n" +
            "\t6 - voltar\n";

    private String atualizarProprietario =
            "\t1 - atualizar CPF/CNPJ\n" +
            "\t2 - atualizar Senha\n" +
            "\t3 - atualizar Nome e Sobrenome\n" +
            "\t4 - atualizar Email\n" +
            "\t5 - atualizar Telefone\n" +
            "\t6 - voltar\n";

    // Opções para deletar
    private String deletar =
            "=======================================\n" +
            "\t1 - Deletar Cliente\n" +
            "\t2 - Deletar Corretor\n" +
            "\t3 - Deletar Proprietário\n" +
            "\t4 - voltar\n" +
            "=======================================\n";

    private String deletarCliente =  "\t1 - CPF/CNPJ do cliente a ser Deletado [ESSA AÇÃO NÃO PODE SER DESFEITA!]: ";
    private String deletarCorretor =  "\t1 - CRECI do corretor a ser Deletado [ESSA AÇÃO NÃO PODE SER DESFEITA!]: ";
    private String deletarProprietario =  "\t1 - CPF/CNPJ do proprietario a ser Deletado [ESSA AÇÃO NÃO PODE SER DESFEITA!]: ";


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

    public String getDeletar() {
        return deletar;
    }

    public String getAtualizar() {
        return atualizar;
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



    public String getVisualizarImovelPropostas() {
        return visualzarImovelPropostas;
    }

    public String getVisualizarImovelInformacoes() {
        return visualzarImovelInformacoes;
    }

    public String getVisualizarVenda() {
        return visualizarVenda;
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

    public String getPropostaStatus() {
        return propostaStatus;
    }

    // Getters camada 2 -> Criar Venda

    public String getVendaPropostaID() {
        return vendaPropostaID;
    }

    public String getVendaCpfCnpjProprietario() {
        return vendaCpfCnpjProprietario;
    }

    public String getVendaFormaDePagamento() {
        return vendaFormaDePagamento;
    }

    // Getters camada 2 -> Deletar


    public String getDeletarCliente() {
        return deletarCliente;
    }

    public String getDeletarCorretor() {
        return deletarCorretor;
    }

    public String getDeletarProprietario() {
        return deletarProprietario;
    }

    // Getter camada 2 -> Atualziar


    public String getAtualizarCliente() {
        return atualizarCliente;
    }

    public String getAtualizarCorretor() {
        return atualizarCorretor;
    }

    public String getAtualizarProprietario() {
        return atualizarProprietario;
    }
}

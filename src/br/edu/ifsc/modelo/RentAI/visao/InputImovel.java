package br.edu.ifsc.modelo.RentAI.visao;

import br.edu.ifsc.modelo.RentAI.leitor.Leitor;
import br.edu.ifsc.modelo.RentAI.modelo.imovel.*;
import br.edu.ifsc.modelo.RentAI.modelo.usuarios.Corretor;
import br.edu.ifsc.modelo.RentAI.modelo.usuarios.DonoImovel;
import br.edu.ifsc.modelo.RentAI.persistenciaDB.CorretorDAO;
import br.edu.ifsc.modelo.RentAI.persistenciaDB.ImovelDAO;
import br.edu.ifsc.modelo.RentAI.persistenciaDB.ProprietarioDAO;

import java.util.List;

import static br.edu.ifsc.modelo.RentAI.modelo.Main.verificarCpfOuCnpj;
import static br.edu.ifsc.modelo.RentAI.modelo.Main.verificarCreci;

public class InputImovel {

    private final Leitor leitor = new Leitor();
    private final Mensagens mensagem = new Mensagens();
    //Cadastro de Cliente

    public Imovel cadastro() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        System.out.println(mensagem.getCadastroImovel());
        String bairroImovel = leitor.lerString("Digite o bairro: ");
        if (bairroImovel.equals("0")) {
            return null;
        }
        String cidadeImovel = leitor.lerString("Digite a cidade: ");
        if (cidadeImovel.equals("0")) {
            return null;
        }
        String ruaImovel = leitor.lerString("Digite a rua: ");
        if (ruaImovel.equals("0")) {
            return null;
        }
        String numeroImovel = leitor.lerString("Digite o numero: ");
        if (numeroImovel.equals("0")) {
            return null;
        }
        String cepImovel = leitor.lerString("Digite o CEP: ");
        if (cepImovel.equals("0")) {
            return null;
        }

        String complementoImovel = leitor.lerString("Digite o complemento (aperte enter caso não tenha nenhum): ");
        if (complementoImovel.equals("0")) {
            return null;
        }
        String tipoImovel = leitor.lerString("Digite o tipo (casa ou apartamneto): ");
        if (tipoImovel.equals("0")) {
            return null;
        }
        String statusImovel = leitor.lerString("Digite o status do ímovel (Reformado, Mobiliado ou Construção): ");
        if (statusImovel.equals("0")) {
            return null;
        }

        float metragemImovel = leitor.lerFloat("Digite a metragem do ímovel em M²: ");
        if (metragemImovel == 0) {
            return null;
        }
        int banheirosImovel = leitor.lerInt("Digite o numero de banheiros no ímovel: ");
        if (banheirosImovel == 0) {
            return null;
        }
        int quartosImovel = leitor.lerInt("Digite o numero de quartos no ímovel: ");
        if (quartosImovel == 0) {
            return null;
        }
        int vagasImovel = leitor.lerInt("Digite o numero de vagas para carro no ímovel: ");
        if (vagasImovel == 0) {
            return null;
        }

        String nomeImovel = leitor.lerString("Digite o nome do movel: ");
        if (nomeImovel.equals("0")) {
            return null;
        }
        String cpfCnpjProprietarioImovel = leitor.lerString("Digite o CPF/CNPJ do proprietário: ");
        if (cpfCnpjProprietarioImovel.equals("0")) {
            return null;
        }

        //Realiza a verificação do CPF/CNPJ digitado
        boolean verificado = false;
        while (true){
            if (verificarCpfOuCnpj(cpfCnpjProprietarioImovel)){
                verificado = true;
                break;
            }
            else{
                cpfCnpjProprietarioImovel = leitor.lerString("Digite o CPF/CNPJ do proprietário: ");
                if (cpfCnpjProprietarioImovel.equals("0")) {
                    return null;
                }
            }
        }

        // Validação de proprietário
        DonoImovel proprietarioImovel = ProprietarioDAO.getInstancia().buscar(cpfCnpjProprietarioImovel);
        if (proprietarioImovel == null) {
            System.out.println("VOLTANDO...");
            return null;
        }



        String creciCorretorImovel = leitor.lerString("Digite o CRECI do corretor responsavel: ");
        if (creciCorretorImovel.equals("0")) {
            return null;
        }
        //Realiza a verificação do CRECI digitado
        while (true){
            if (verificarCreci(creciCorretorImovel)){
                break;
            }
            else{
                creciCorretorImovel = leitor.lerString("Digite o CRECI do corretor responsavel: ");
                if (creciCorretorImovel.equals("0")) {
                    return null;
                }
            }
        }

        // Validação de corretor
        Corretor corretorImovel = CorretorDAO.getInstancia().buscar(creciCorretorImovel);
        if (corretorImovel == null) {
            System.out.println("VOLTANDO...");
            return null;
        }



        // Cria o Endereço
        Endereco endereco = new Endereco(bairroImovel, cidadeImovel, ruaImovel, numeroImovel, cepImovel, complementoImovel);

        //Verifica o ID dentro dos imoveis já existentes
        List<Imovel> imoveis = ImovelDAO.getInstancia().buscarTodos();
        int idImovel;
        if (imoveis.isEmpty()) {
            idImovel = 1;
        } else {
            idImovel = 0;
            for (Imovel imovel : imoveis) {
                if (imovel.getIdImovel() > idImovel) {
                    idImovel = imovel.getIdImovel();
                }
            }
            idImovel++;
        }


        return new Imovel(
                endereco,
                idImovel,
                tipoImovel,
                statusImovel,
                metragemImovel,
                banheirosImovel,
                quartosImovel,
                vagasImovel,
                proprietarioImovel,
                corretorImovel
        );
    }


    public Imovel visualizar() {
        System.out.println("[DIGITE 0 PARA SAIR]");
        Imovel imovel;
        do {
            int view = leitor.lerInt(mensagem.getVisualizarImovelInformacoes());
            if (view == 0) {
                return null;
            }
            imovel = ImovelDAO.getInstancia().buscar(view);


            // Validação de cliente
            if (imovel == null) {
                System.out.println("imovel não encontrado, tente novamente: ");
            }
        } while (imovel == null);
        return imovel;
    }
}

package br.edu.ifsc.RentAI.modelo;

import br.edu.ifsc.RentAI.verificar.Leitor;
import br.edu.ifsc.RentAI.modelo.imovel.Imovel;
import br.edu.ifsc.RentAI.modelo.transacoes.Proposta;
import br.edu.ifsc.RentAI.modelo.transacoes.Venda;
import br.edu.ifsc.RentAI.modelo.usuarios.Cliente;
import br.edu.ifsc.RentAI.modelo.usuarios.Corretor;
import br.edu.ifsc.RentAI.modelo.usuarios.DonoImovel;
import br.edu.ifsc.RentAI.persistenciaDB.*;
import br.edu.ifsc.RentAI.visao.*;

import static br.edu.ifsc.RentAI.verificar.Verificadores.testePrompt;

public class Main {
    public static void main(String[] args) {
        Conexao.getConexao();
        Conexao.criarTabelas();
        Leitor leitor = new Leitor();
        Mensagens mensagem = new Mensagens();

        boolean continua = true;

        while (continua) {
            int userPrompt = leitor.lerInt(mensagem.getTextoInicial());
            System.out.println("\n");
            testePrompt(5, userPrompt);// Verifica se o numero esta entre 1 e 5
            switch (userPrompt) {
                case 1://Cadastrar
                    userPrompt = leitor.lerInt(mensagem.getCadastro());
                    testePrompt(7, userPrompt);

                    switch (userPrompt) {
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

                        case 5: //Cadastrar proposta
                            InputProposta inputProposta = new InputProposta();
                            Proposta novaProposta = inputProposta.cadastro();
                            if (novaProposta == null) {
                                break;
                            }

                            PropostaDAO.getInstancia().criar(novaProposta);
                            System.out.println("Cadastro concluído, o ID dessa proposta é " + novaProposta.getId() + ", não esqueça!");

                            break;

                        case 6://Cadastrar Venda
                            InputVenda inputvenda = new InputVenda();
                            Venda novaVenda = inputvenda.cadastro();
                            if (novaVenda == null) {
                                break;
                            }

                            VendaDAO.getInstance().criar(novaVenda);
                            System.out.println("Venda concluída, o ID dessa venda é " + novaVenda.getId() + ", não esqueça!");
                            break;
                        case 7: //opção de saida
                            break;
                    }
                    break;

                case 2://Visualizar
                    userPrompt = leitor.lerInt(mensagem.getVisualizar());
                    testePrompt(7, userPrompt);// Verifica se o numero esta entre 1 e 6
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
                            InputImovel inputImovel = new InputImovel();
                            Imovel imovel = inputImovel.visualizar();
                            if (imovel != null) {
                                imovel.mostrarInfoImovel();
                            }
                            break;

                        case 5: //Ver propostas
                            InputProposta inputProposta = new InputProposta();
                            Proposta proposta = inputProposta.visualizar();
                            if (proposta != null) {
                                proposta.mostrarInfoProposta();
                            }
                            break;
                        case 6: // Ver vendas
                            InputVenda inputvenda = new InputVenda();
                            Venda novaVenda = inputvenda.visualizar();
                            if (novaVenda != null) {
                                novaVenda.mostrarInfoVenda();
                            }
                            break;

                        case 7:
                            break;
                }
                    break;

                case 3: //Deletar
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


                case 4: // Alterar
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
                case 5: //Sair
                    continua = false;
                    break;

            }
        }
    }
}
import java.util.Scanner;

public class Main {
    public static void testePrompt (int max, int userPrompt) {
        if (userPrompt > max || userPrompt <= 0) {
            throw new ArithmeticException("Nesta parte, favor digitar um numero que esteja entre 1 e " + max);
        } // Verifica se o numero esta entre os valores delimitados
    }

    public static void main(String[] args) {
        Leitor leitor = new Leitor();
        Mensagens mensagem = new Mensagens();
        ArrayList<Cliente> usuarios = new ArrayList<Cliente>();

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
                            userPrompt = leitor.lerInt(mensagem.getCadastroCliente());
                            break;
                        case 2:
                            userPrompt = leitor.lerInt(mensagem.getCadastroCorretor());
                            break;
                        case 3:
                            userPrompt = leitor.lerInt(mensagem.getCadastroProprietario());
                            break;
                        case 4:
                            userPrompt = leitor.lerInt(mensagem.getCadastroImovel());
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
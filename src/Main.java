import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Leitor leitor = new Leitor();
        Mensagens mensagem = new Mensagens();

        int userPrompt = leitor.lerInt(mensagem.getTextoInicial());
        if (userPrompt > 7 || userPrompt <= 0) {
            throw new ArithmeticException("Favor digitar um numero que esteja entre 1 e 7");
        } // Verifica se o numero esta entre 1 e 7

        switch (userPrompt){
            case 1:
                userPrompt = leitor.lerInt(mensagem.getCadastro());
                switch (userPrompt){
                    case 1:
                        break;
                }
                break;
            case 2:
                userPrompt = leitor.lerInt(mensagem.getVisualizar());
                break;
            case 3:
                userPrompt = leitor.lerInt(mensagem.getAlterar());
                break;
            case 4:
                userPrompt = leitor.lerInt(mensagem.getRemover());
                break;
            case 5:
                userPrompt = leitor.lerInt(mensagem.getCriar());
                break;
            case 6:
                userPrompt = leitor.lerInt(mensagem.getAnunciar());
                break;
            case 7:
                return;


        }
    }
}
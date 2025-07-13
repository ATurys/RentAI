package br.edu.ifsc.RentAI.verificar;

public class Verificadores {
    public static void testePrompt (int max, int userPrompt) {
        if (userPrompt > max || userPrompt <= 0) {
            System.out.println("\nNesta parte, favor digitar um numero que esteja entre 1 e " + max + "\n" +
                    "Voltando... \n\n");
        } // Verifica se o numero esta entre os valores delimitados
    }
    public static boolean verificarCpfOuCnpj(String cpfOuCnpj) {
        if (cpfOuCnpj.length() == 11 || cpfOuCnpj.length() == 14 ) {
            return true;
        } else {
            System.out.println("Digite o CPF ou CNPJ corretamente:\n" +
                    "CPF(11 Dígitos): 12345678901\n" +
                    "CNPJ(14 Dígitos): 12345678901234\n");
            return false;
        }
    } // Verifica se esta entre o tamanho minimo de CPF ou CNPJ

    public static boolean verificarCreci(String creci) {
        /* REGEX:
            ^ → início da string
            CRECI- → texto fixo
            [A-Z]{2} → duas letras maiúsculas (iniciais do estado)
            \\d{8} → exatamente 8 dígitos
            $ → fim da string
         */
        String modelo = "^CRECI-[A-Z]{2}\\d{8}$";
        if (creci.matches(modelo) ) {
            return true;
        } else {
            System.out.println("Digite o CRECI corretamente:\n" +
                    "Modelo Exemplo de CRECI: CRECI-RS01234567");
            return false;
        }
    } // Verifica se esta o modelo CRECI corretamente
}

package br.edu.ifsc.RentAI.modelo.usuarios;

public class DonoImovel extends Usuario {
    private String cpfOuCnpjDonoImovel;
    private String cpfOuCnpjProprietarioCripted;

    // Construtor
    public DonoImovel(String email, String senha, String nome, String sobrenome, String telefone, String userName, String cpfOuCnpjDonoImovel) {

        super(email, senha, nome, sobrenome, telefone, userName);
        this.cpfOuCnpjDonoImovel = cpfOuCnpjDonoImovel;
        this.cpfOuCnpjProprietarioCripted = cpfOuCnpjDonoImovel.substring(0,4) + "....";
    }

    public void mostrarInfoProprietario() {
        mostrarInfoUser();
        System.out.println("CPF/CNPJ: " + cpfOuCnpjProprietarioCripted);
    }

    // Getters

    public String getCpfOuCnpjDonoImovel() {
        return cpfOuCnpjDonoImovel;
    }

    public String getCpfOuCnpjProprietarioCripted() {
        return cpfOuCnpjProprietarioCripted;
    }

}

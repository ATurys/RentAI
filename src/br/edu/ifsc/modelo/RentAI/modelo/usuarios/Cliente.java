package br.edu.ifsc.modelo.RentAI.modelo.usuarios;

public class Cliente extends Usuario {

    private String cpfOuCnpjCliente;
    private String cpfOuCnpjClienteCripted;

    // Construtor
    public Cliente(String email, String senha, String nome, String sobrenome, String telefone, String userName, String cpfOuCnpjCliente) {
        super(email, senha, nome, sobrenome, telefone, userName);
        this.cpfOuCnpjCliente = cpfOuCnpjCliente;
        this.cpfOuCnpjClienteCripted = cpfOuCnpjCliente.substring(0,4);
    }

    public void mostrarInfoCliente() {
        mostrarInfoUser();
        System.out.println("CPF/CNPJ: " + cpfOuCnpjClienteCripted + "....");
    }

    // Getters

    public String getCpfOuCnpjCliente() {
        return cpfOuCnpjCliente;
    }

    public String getCpfOuCnpjClienteCripted() {
        return cpfOuCnpjClienteCripted;
    }

    // Setters
}

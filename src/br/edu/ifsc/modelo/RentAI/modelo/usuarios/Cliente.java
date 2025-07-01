package br.edu.ifsc.modelo.RentAI.modelo.usuarios;

public class Cliente {

    private Usuario userInfo;
    private String cpfOuCnpjCliente;
    private String cpfOuCnpjClienteCripted;

    // Construtor
    public Cliente(Usuario userInfo, String cpfOuCnpjCliente) {
        this.userInfo = userInfo;
        this.cpfOuCnpjCliente = cpfOuCnpjCliente;
        this.cpfOuCnpjClienteCripted = cpfOuCnpjCliente.substring(0,4);
    }

    public void mostrarInfoCliente() {
        userInfo.mostrarInfoUser();
        System.out.println("CPF/CNPJ: " + cpfOuCnpjClienteCripted + "....");
    }

    // Getters
    public Usuario getUserInfo() {
        return userInfo;
    }

    public String getCpfOuCnpjCliente() {
        return cpfOuCnpjCliente;
    }

    public String getCpfOuCnpjClienteCripted() {
        return cpfOuCnpjClienteCripted;
    }

    // Setters
    public void setUserInfo(Usuario userInfo) {
        this.userInfo = userInfo;
    }
}

public class Cliente {

    private Usuario userInfo;
    private String cpfOuCnpjCliente;

    // Construtor
    public Cliente(Usuario userInfo, String cpfOuCnpjCliente) {
        this.userInfo = userInfo;
        this.cpfOuCnpjCliente = cpfOuCnpjCliente;

    }

    public void mostrarInfoCliente() {
        System.out.println(userInfo.mostrarInfoUser());

        String cpfOuCnpjInicial = this.cpfOuCnpjCliente.substring(0,4);
        System.out.println("CPF/CNPJ: " + cpfOuCnpjInicial + "....");
    }

    // Getters
    public Usuario getUserInfo() {
        return userInfo;
    }

    public String getCpfOuCnpjCliente() {
        return cpfOuCnpjCliente;
    }

    // Setters
    public void setUserInfo(Usuario userInfo) {
        this.userInfo = userInfo;
    }
}

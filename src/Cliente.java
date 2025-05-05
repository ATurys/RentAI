public class Cliente {

    private Usuario userInfo;
    private String cpfOuCnpjCliente;

    // Construtor
    public Cliente(Usuario userInfo, String cpfOuCnpjCliente) {
        this.userInfo = userInfo;
        this.cpfOuCnpjCliente = cpfOuCnpjCliente;
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

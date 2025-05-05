public class Cliente {

    private Usuario userInfo;
    private String cpfOuCnpjCliente;

    public Cliente(Usuario userInfo, String cpfOuCnpjCliente) {
        this.userInfo = userInfo;
        this.cpfOuCnpjCliente = cpfOuCnpjCliente;
    }
}

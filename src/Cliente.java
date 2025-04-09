public class Cliente {

    private int idCliente;
    private String nomeCliente;
    private String sobrenomeCliente;
    private String cpfOuCnpjCliente;
    private String telefoneCliente;
    private String emailCliente;
    private String nomeUsuarioCliente;
    private String senhaCliente;

    public Cliente(String nomeCliente, String sobrenomeCliente, String cpfOuCnpjCliente, String emailCliente, String senhaCliente, String nomeUsuarioCliente, String telefoneCliente) {
        this.nomeCliente = nomeCliente;
        this.sobrenomeCliente = sobrenomeCliente;
        this.cpfOuCnpjCliente = cpfOuCnpjCliente;
        this.emailCliente = emailCliente;
        this.senhaCliente = senhaCliente;
        this.nomeUsuarioCliente = nomeUsuarioCliente;
        this.telefoneCliente = telefoneCliente;
        this.idCliente = 0;
    }

    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getSobrenomeCliente() {
        return sobrenomeCliente;
    }
    public void setSobrenomeCliente(String sobrenomeCliente) {
        this.sobrenomeCliente = sobrenomeCliente;
    }

    public String getCpfOuCnpjCliente() {
        return cpfOuCnpjCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }
    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public String getNomeUsuarioCliente() {
        return nomeUsuarioCliente;
    }
    public void setNomeUsuarioCliente(String nomeUsuarioCliente) {
        this.nomeUsuarioCliente = nomeUsuarioCliente;
    }

    public String getSenhaCliente() {
        return senhaCliente;
    }

}

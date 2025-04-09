public class Proprietario {

    private int idproprietario;
    private String nomeProprietario;
    private String sobrenomeProprietario;
    private String cpfOuCnpjProprietario;
    private String telefoneProprietario;
    private String emailProprietario;
    private String enderecoProprietario;

    public Proprietario(String nomeProprietario, String cpfOuCnpjProprietario, String emailProprietario) {
        this.nomeProprietario = nomeProprietario;
        this.cpfOuCnpjProprietario = cpfOuCnpjProprietario;
        this.emailProprietario = emailProprietario;
    }


    public int getIdproprietario() {
        return idproprietario;
    }
    public void setIdproprietario(int idproprietario) {
        this.idproprietario = idproprietario;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }
    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public String getSobrenomeProprietario() {
        return sobrenomeProprietario;
    }
    public void setSobrenomeProprietario(String sobrenomeProprietario) {
        this.sobrenomeProprietario = sobrenomeProprietario;
    }

    public String getCpfOuCnpjProprietario() {
        return cpfOuCnpjProprietario;
    }

    public String getTelefoneProprietario() {
        return telefoneProprietario;
    }
    public void setTelefoneProprietario(String telefoneProprietario) {
        this.telefoneProprietario = telefoneProprietario;
    }

    public String getEmailProprietario() {
        return emailProprietario;
    }
    public void setEmailProprietario(String emailProprietario) {
        this.emailProprietario = emailProprietario;
    }

    public String getEnderecoProprietario() {
        return enderecoProprietario;
    }
    public void setEnderecoProprietario(String enderecoProprietario) {
        this.enderecoProprietario = enderecoProprietario;
    }
}

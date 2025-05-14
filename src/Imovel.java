public class Imovel {

    private Endereco endereco;
    private int idImovel;
    private String tipoImovel;
    private String statusImovel;
    private String nomeImovel;

    // Construtor

    public Imovel(Endereco endereco, int idImovel, String nomeImovel, String tipoImovel, String statusImovel) {
        this.endereco = endereco;
        this.idImovel = idImovel;
        this.nomeImovel = nomeImovel;
        this.tipoImovel = tipoImovel;
        this.statusImovel = statusImovel;
    }

    public void mostrarInfoImovel() {
        System.out.println("Endereço: ");
        endereco.mostrarEndereco();
        System.out.println("\nSobre o ímovel: ");
        System.out.println("ID do Imovel: " + this.idImovel);
        System.out.println("Nome do Imovel: " + this.nomeImovel);
        System.out.println("Tipo do Imovel: " + this.tipoImovel);
        System.out.println("Status do Imovel: " + this.statusImovel);
    }

    // Getters
    public Endereco getEndereco() {
        return endereco;
    }

    public int getIdImovel() {
        return idImovel;
    }

    public String getTipoImovel() {
        return tipoImovel;
    }

    public String getStatusImovel() {
        return statusImovel;
    }

    public String getNomeImovel() {
        return nomeImovel;
    }

    // Setters
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setTipoImovel(String tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public void setStatusImovel(String statusImovel) {
        this.statusImovel = statusImovel;
    }

    public void setNomeImovel(String nomeImovel) {
        this.nomeImovel = nomeImovel;

    }

}


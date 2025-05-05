public class Imovel {

    private Endereco endereco;
    private int idImovel;
    private String tipoImovel;
    private String tamanhoImovel;
    private String statusImovel;
    private String nomeImovel;

    // Construtor
    public Imovel(Endereco endereco, int idImovel, String tipoImovel, String tamanhoImovel, String statusImovel, String nomeImovel) {
        this.endereco = endereco;
        this.idImovel = idImovel;
        this.tipoImovel = tipoImovel;
        this.tamanhoImovel = tamanhoImovel;
        this.statusImovel = statusImovel;
        this.nomeImovel = nomeImovel;
    }

    public Imovel(Endereco endereco, int idImovel, String nomeImovel, String tipoImovel) {
        this.endereco = endereco;
        this.idImovel = idImovel;
        this.nomeImovel = nomeImovel;
        this.tipoImovel = tipoImovel;
        this.statusImovel = "Disponível";
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

    public String getTamanhoImovel() {
        return tamanhoImovel;
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

    public void setTamanhoImovel(String tamanhoImovel) {
        this.tamanhoImovel = tamanhoImovel;
    }

    public void setStatusImovel(String statusImovel) {
        this.statusImovel = statusImovel;
    }

    public void setNomeImovel(String nomeImovel) {
        this.nomeImovel = nomeImovel;
    }
}

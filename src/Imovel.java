public class Imovel {

    private Endereco endereco;
    private int idImovel;
    private String tipoImovel;
    private String tamanhoImovel;
    private String statusImovel;
    private String nomeImovel;
    private float comissaoCorretor;

    // Construtor

    public Imovel(Endereco endereco, int idImovel, String nomeImovel, String tipoImovel, String statusImovel) {
        this.endereco = endereco;
        this.idImovel = idImovel;
        this.nomeImovel = nomeImovel;
        this.tipoImovel = tipoImovel;
        this.statusImovel = statusImovel;
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

    public float getComissaoCorretor() {
        return comissaoCorretor;
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

    public void setComissaoCorretor(float comissaoCorretor) {
        this.comissaoCorretor = comissaoCorretor;
    }
}


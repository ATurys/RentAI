public class Imovel {
    private int idImovel;
    private String tipoImovel;
    private String enderecoImovel;
    private String tamanhoImovel;
    private String statusImovel;
    private String nomeImovel;

    public Imovel(String nomeImovel, String enderecoImovel) {
        this.nomeImovel = nomeImovel;
        this.enderecoImovel = enderecoImovel;
        this.tamanhoImovel = "A verificar";
        this.statusImovel = "Aberto";
        this.tipoImovel = "A verificar";
        this.idImovel = 0;
    }
    public Imovel(String nomeImovel) {
        this.nomeImovel = nomeImovel;
        this.enderecoImovel = "A verificar";
        this.tamanhoImovel = "A verificar";
        this.statusImovel = "Aberto";
        this.tipoImovel = "A verificar";
        this.idImovel = 0;
    }

    public int getIdImovel() {
        return idImovel;
    }
    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }

    public String getTipoImovel() {
        return tipoImovel;
    }
    public void setTipoImovel(String tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public String getEnderecoImovel() {
        return enderecoImovel;
    }
    public void setEnderecoImovel(String enderecoImovel) {
        this.enderecoImovel = enderecoImovel;
    }

    public String getTamanhoImovel() {
        return tamanhoImovel;
    }
    public void setTamanhoImovel(String tamanhoImovel) {
        this.tamanhoImovel = tamanhoImovel;
    }

    public String getStatusImovel() {
        return statusImovel;
    }
    public void setStatusImovel(String statusImovel) {
        this.statusImovel = statusImovel;
    }

    public String getNomeImovel() {
        return nomeImovel;
    }
    public void setNomeImovel(String nomeImovel) {
        this.nomeImovel = nomeImovel;
    }
}

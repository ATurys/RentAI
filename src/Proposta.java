public class Proposta {

    private String idProposta;
    private float valorOferecido;
    private String dataDaProposta;
    private String status;


    public Proposta(String idProposta, float valorOferecido, String dataDaProposta, String status) {
        this.idProposta = idProposta;
        this.valorOferecido = valorOferecido;
        this.dataDaProposta = dataDaProposta;
        this.status = status;
    }

    public String getIdProposta() {
        return idProposta;
    }

    public float getValorOferecido() {
        return valorOferecido;
    }
    public void setValorOferecido(float valorOferecido) {
        this.valorOferecido = valorOferecido;
    }

    public String getDataDaProposta() {
        return dataDaProposta;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}

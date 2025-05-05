import java.time.LocalDateTime;

public class Proposta {

    private Cliente cliente;
    private int id;
    private float valorOferecido;
    private String dataDaProposta;
    private String status;

    public Proposta(Cliente cliente, int id, float valorOferecido, String status) {
        this.cliente = cliente;
        this.id = id;
        this.valorOferecido = valorOferecido;
        this.dataDaProposta = LocalDateTime.now().toString();
        this.status = status;
    }

    // Getters
    public Cliente getCliente() {
        return cliente;
    }

    public int getId() {
        return id;
    }

    public float getValorOferecido() {
        return valorOferecido;
    }

    public String getDataDaProposta() {
        return dataDaProposta;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setStatus(String status) {
        this.status = status;
    }
}

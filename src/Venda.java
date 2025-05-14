import java.time.LocalDateTime;

public class Venda {
    private Proposta proposta;
    private DonoImovel donoImovel;

    private int idVenda;
    private String dataVenda;
    private float valorFinalVenda;
    private String formaPagamentoVenda;


    public Venda(Proposta proposta, DonoImovel donoImovel, int id, float valorFinalVenda, String formaPagamentoVenda) {
        this.proposta = proposta;
        this.donoImovel = donoImovel;
        this.idVenda = id;
        this.dataVenda = LocalDateTime.now().toString();
        this.valorFinalVenda = valorFinalVenda;
        this.formaPagamentoVenda = formaPagamentoVenda;
    }

    // Getters
    public Proposta getProposta() {
        return proposta;
    }

    public DonoImovel getDonoImovel() {
        return donoImovel;
    }

    public int getId() {
        return idVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public float getValorFinalVenda() {
        return valorFinalVenda;
    }

    public String getFormaPagamentoVenda() {
        return formaPagamentoVenda;
    }

    // Setters
    public void setValorFinalVenda(float valorFinalVenda) {
        this.valorFinalVenda = valorFinalVenda;
    }

    public void setFormaPagamentoVenda(String formaPagamentoVenda) {
        this.formaPagamentoVenda = formaPagamentoVenda;
    }
}

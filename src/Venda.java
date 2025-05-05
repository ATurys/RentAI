import java.time.LocalDateTime;

public class Venda {
    private Proposta proposta;
    private Cliente cliente;
    private Corretor corretor;
    private DonoImovel donoImovel;

    private int id;
    private String dataVenda;
    private float valorFinalVenda;
    private String formaPagamentoVenda;
    private boolean comissaoVenda;


    public Venda(Proposta proposta, Cliente cliente, Corretor corretor, DonoImovel donoImovel, int id, float valorFinalVenda, String formaPagamentoVenda, boolean comissaoVenda) {
        this.proposta = proposta;
        this.cliente = cliente;
        this.corretor = corretor;
        this.donoImovel = donoImovel;
        this.id = id;
        this.dataVenda = LocalDateTime.now().toString();
        this.valorFinalVenda = valorFinalVenda;
        this.formaPagamentoVenda = formaPagamentoVenda;
        this.comissaoVenda = comissaoVenda;
    }

    // Getters
    public Proposta getProposta() {
        return proposta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public DonoImovel getDonoImovel() {
        return donoImovel;
    }

    public int getId() {
        return id;
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

    public boolean isComissaoVenda() {
        return comissaoVenda;
    }

    // Setters
    public void setValorFinalVenda(float valorFinalVenda) {
        this.valorFinalVenda = valorFinalVenda;
    }

    public void setFormaPagamentoVenda(String formaPagamentoVenda) {
        this.formaPagamentoVenda = formaPagamentoVenda;
    }

    public void setComissaoVenda(boolean comissaoVenda) {
        this.comissaoVenda = comissaoVenda;
    }
}

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

    public void mostrarInfoVenda() {
        System.out.println("Informações da Proposta: \n");
        this.proposta.mostrarInfoProposta();

        System.out.println("\nInformações sobre o dono anterior do ímovel (Antes de ser realizada a venda): \n");
        this.donoImovel.mostrarInfoProprietario();

        System.out.println("\nInformações sobre o dono atual do ímovel (Após de ser realizada a venda): \n");
        this.proposta.getCliente().mostrarInfoCliente();

        System.out.println("Informações da Venda em sí: \n");
        System.out.println("ID da venda: " + this.idVenda);
        System.out.println("Data da venda: " + this.dataVenda);
        System.out.println("Valor da venda: " + this.valorFinalVenda);
        System.out.println("Forma de pagamento: " + this.formaPagamentoVenda);

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

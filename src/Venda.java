public class Venda {
    private int idVenda;
    private String dataVenda;
    private float valorFinalVenda;
    private String formaPagamentoVenda;
    private boolean comissaoVenda;


    public Venda(int idVenda, String dataVenda, float valorFinalVenda, String formaPagamentoVenda, boolean comissaoVenda) {
        this.idVenda = idVenda;
        this.dataVenda = dataVenda;
        this.valorFinalVenda = valorFinalVenda;
        this.formaPagamentoVenda = formaPagamentoVenda;
        this.comissaoVenda = comissaoVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }
    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public float getValorFinalVenda() {
        return valorFinalVenda;
    }

    public String getFormaPagamentoVenda() {
        return formaPagamentoVenda;
    }
    public void setFormaPagamentoVenda(String formaPagamentoVenda) {
        this.formaPagamentoVenda = formaPagamentoVenda;
    }

    public boolean isComissaoVenda() {
        return comissaoVenda;
    }
    public void setComissaoVenda(boolean comissaoVenda) {
        this.comissaoVenda = comissaoVenda;
    }
}

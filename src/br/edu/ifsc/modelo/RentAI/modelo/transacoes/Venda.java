package br.edu.ifsc.modelo.RentAI.modelo.transacoes;

import br.edu.ifsc.modelo.RentAI.modelo.usuarios.DonoImovel;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Venda {
    private Proposta proposta;
    private DonoImovel donoImovel;
    private int idVenda;
    private String dataVenda;
    private java.sql.Date dateTimeVenda;
    private float valorFinalVenda;
    private String formaPagamentoVenda;
    private float comissao;


    public Venda(Proposta proposta,
                 DonoImovel donoImovel,
                 int id,
                 float valorFinalVenda,
                 String formaPagamentoVenda,
                 float comissao) {
        this.proposta = proposta;
        this.donoImovel = donoImovel;
        this.idVenda = id;
        this.dataVenda = LocalDateTime.now().toString();
        this.valorFinalVenda = valorFinalVenda;
        this.formaPagamentoVenda = formaPagamentoVenda;
        this.comissao = comissao;

        LocalDateTime agora = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        this.dateTimeVenda = (java.sql.Date) java.sql.Date.from(agora.atZone(zoneId).toInstant());
    }

    public Venda(String corretorProposta,
                 String clienteProposta,
                 String proprietarioDonoImovel,
                 int idImovel,
                 int idVenda,
                 float valorFinalVenda,
                 String formaPagamentoVenda,
                 float comissao,
                 Date dataVenda) {
        this.proposta = new Proposta(clienteProposta, corretorProposta, idImovel);
        this.donoImovel = new DonoImovel(proprietarioDonoImovel);

        this.idVenda = idVenda;
        this.valorFinalVenda = valorFinalVenda;
        this.formaPagamentoVenda = formaPagamentoVenda;
        this.comissao = comissao;
        this.dateTimeVenda = dataVenda;
    }

    public void mostrarInfoVenda() {
        System.out.println("Informações da Proposta: \n");
        System.out.println("ID da venda: " + this.idVenda + "\n");
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

    public java.sql.Date getDateTimeVenda() {return dateTimeVenda;}

    public float getComissao() {return comissao;}

    // Setters
    public void setValorFinalVenda(float valorFinalVenda) {
        this.valorFinalVenda = valorFinalVenda;
    }

    public void setFormaPagamentoVenda(String formaPagamentoVenda) {
        this.formaPagamentoVenda = formaPagamentoVenda;
    }
}

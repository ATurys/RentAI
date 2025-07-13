package br.edu.ifsc.RentAI.modelo.transacoes;

import br.edu.ifsc.RentAI.modelo.usuarios.Cliente;
import br.edu.ifsc.RentAI.modelo.usuarios.Corretor;
import br.edu.ifsc.RentAI.modelo.usuarios.DonoImovel;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Venda {
    private Proposta proposta;
    private DonoImovel donoImovel;
    private int idVenda;
    private String dataVenda;
    private java.sql.Date dateTimeVenda;
    private java.util.Date dataHoraVenda;
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
        this.dateTimeVenda = new java.sql.Date(agora.atZone(zoneId).toInstant().toEpochMilli());
    }

    public Venda(Corretor corretorProposta,
                 Cliente clienteProposta,
                 DonoImovel proprietarioDonoImovel,
                 int idImovel,
                 int idVenda,
                 float valorFinalVenda,
                 String formaPagamentoVenda,
                 float comissao,
                 java.sql.Date dataVenda) {
        this.proposta = new Proposta(clienteProposta, corretorProposta, idImovel);
        this.donoImovel = proprietarioDonoImovel;

        this.idVenda = idVenda;
        this.valorFinalVenda = valorFinalVenda;
        this.formaPagamentoVenda = formaPagamentoVenda;
        this.comissao = comissao;
        this.dataHoraVenda = dataVenda;// converte o tipo data do banco de dados para o tipo data suportado pelo CLI
    }

    public void mostrarInfoVenda() {

        System.out.println("\n=============================");
        System.out.println("Informações sobre o dono anterior do ímovel (Antes de ser realizada a venda): \n");
        this.donoImovel.mostrarInfoProprietario();

        System.out.println("\n=============================");
        System.out.println("\nInformações sobre o dono atual do ímovel (Após de ser realizada a venda): \n");
        this.proposta.getCliente().mostrarInfoCliente();

        System.out.println("\n=============================");
        System.out.println("Informações da Venda em sí: \n");
        System.out.println("ID da venda: " + this.idVenda);
        System.out.println("Data da venda: " + this.dataHoraVenda.toString());
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

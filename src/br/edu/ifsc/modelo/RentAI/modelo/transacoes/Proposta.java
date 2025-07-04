package br.edu.ifsc.modelo.RentAI.modelo.transacoes;

import br.edu.ifsc.modelo.RentAI.modelo.imovel.Endereco;
import br.edu.ifsc.modelo.RentAI.modelo.imovel.Imovel;
import br.edu.ifsc.modelo.RentAI.modelo.usuarios.Cliente;
import br.edu.ifsc.modelo.RentAI.modelo.usuarios.Corretor;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Proposta {

    private Cliente cliente;
    private Corretor corretor;
    private Imovel imovel;
    private int id;
    private float valorOferecido;
    private String dataDaProposta;
    private Date dateTimeProposta;
    private String status;

    public Proposta(Cliente cliente, Corretor corretor, Imovel imovel, int id, float valorOferecido, String status) {
        this.cliente = cliente;
        this.corretor = corretor;
        this.imovel = imovel;
        this.id = id;
        this.valorOferecido = valorOferecido;
        this.dataDaProposta = LocalDateTime.now().toString();
        this.status = status;

        LocalDateTime agora = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        this.dateTimeProposta = (Date) Date.from(agora.atZone(zoneId).toInstant());
    }

    public Proposta(String cpfCnpjCliente, String creciCorretor, int idImovel, int id, float valorOferecido, String status, Date dataDaProposta) { //Para buscar uma proposta
        this.cliente = new Cliente(null, null, null, null, null, null, cpfCnpjCliente);
        this.corretor = new Corretor(null, null, null, null, null, null, creciCorretor);
        this.imovel = new Imovel(idImovel);
        this.id = id;
        this.valorOferecido = valorOferecido;
        this.dataDaProposta = dataDaProposta.toString();
        this.status = status;
    }

    public Proposta(String cpfCnpjCliente, String creciCorretor, int idImovel){ //Para buscar uma venda
        this.cliente = new Cliente(null, null, null, null, null, null, cpfCnpjCliente);
        this.corretor = new Corretor(null, null, null, null, null, null, creciCorretor);
        this.imovel = new Imovel(idImovel);
    }

    public void mostrarInfoProposta(){
        System.out.println("ID da proposta: " + this.id);
        System.out.println("Cliente: " + cliente.getNome() + " " + cliente.getSobrenome() );
        System.out.println("Iniciais CPF/CNPJ do Cliente: " + cliente.getCpfOuCnpjClienteCripted());
        System.out.println("Corretor: " + corretor.getNome() + " " + corretor.getSobrenome() );
        System.out.println("CRECI Corretor: " + corretor.getCreciCoretor());
        System.out.println("Valor oferecido: " + this.valorOferecido);
        System.out.println("Data da proposta: " + this.dataDaProposta);
        System.out.println("Status: " + this.status);
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
    public Corretor getCorretor() {
        return corretor;
    }

    public Imovel getImovel(){
        return imovel;
    }

    public Date getDateTimeProposta() {
        return dateTimeProposta;
    }

    // Setters
    public void setStatus(String status) {
        this.status = status;
    }

}

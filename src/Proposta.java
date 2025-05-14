import java.time.LocalDateTime;

public class Proposta {

    private Cliente cliente;
    private Corretor corretor;
    private Imovel imovel;
    private int id;
    private float valorOferecido;
    private float comissaoCorretor;
    private String dataDaProposta;
    private String status;

    public Proposta(Cliente cliente, Corretor corretor, float comissaoCorretor, Imovel imovel, int id, float valorOferecido, String status) {
        this.cliente = cliente;
        this.corretor = corretor;
        this.comissaoCorretor = comissaoCorretor;
        this.imovel = imovel;
        this.id = id;
        this.valorOferecido = valorOferecido;
        this.dataDaProposta = LocalDateTime.now().toString();
        this.status = status;
    }

    public void mostrarInfoProposta(){
        System.out.println("ID da proposta: " + this.id);
        System.out.println("Cliente: " + cliente.getUserInfo().getNome() + " " + cliente.getUserInfo().getSobrenome() );
        System.out.println("Iniciais CPF/CNPJ do Cliente: " + cliente.getCpfOuCnpjClienteCripted());
        System.out.println("Corretor: " + corretor.getUserInfo().getNome() + " " + corretor.getUserInfo().getSobrenome() );
        System.out.println("CRECI Corretor: " + corretor.getCreciCoretor());
        System.out.println("Comissão do Corretor: " + comissaoCorretor);
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

    // Setters
    public void setStatus(String status) {
        this.status = status;
    }

}

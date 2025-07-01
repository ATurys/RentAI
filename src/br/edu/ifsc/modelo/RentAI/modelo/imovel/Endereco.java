package br.edu.ifsc.modelo.RentAI.modelo.imovel;

public class Endereco {
    private String bairro;
    private String cidade;
    private String rua;
    private String numero;
    private String complemento;
    private String cep;

    // Construtor
    public Endereco(String bairro, String cidade, String rua, String numero, String cep) {
        this.bairro = bairro;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
    }

    public void mostrarEndereco(){
        System.out.println("Bairro: " + bairro);
        System.out.println("Cidade: " + cidade);
        System.out.println("Rua: " + rua);
        System.out.println("Número: " + numero);
        System.out.println("CEP: " + cep);
    }

    // Getters e Setters (todos possuem tanto get quanto set)
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}

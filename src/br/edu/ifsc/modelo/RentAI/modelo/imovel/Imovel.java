package br.edu.ifsc.modelo.RentAI.modelo.imovel;

import br.edu.ifsc.modelo.RentAI.modelo.usuarios.Corretor;
import br.edu.ifsc.modelo.RentAI.modelo.usuarios.DonoImovel;

public class Imovel {

    private Endereco endereco;
    private int idImovel;
    private String tipoImovel;
    private String statusImovel;
    private float metragem;
    private int banheiros;
    private int quartos;
    private int vagas;
    private DonoImovel donoImovel;
    private Corretor corretor;

    // Construtores

    public Imovel(Endereco endereco, int idImovel, String tipoImovel, String statusImovel, float metragem, int banheiros, int quartos, int vagas, DonoImovel donoImovel, Corretor corretor) {
        this.endereco = endereco;
        this.idImovel = idImovel;
        this.tipoImovel = tipoImovel;
        this.statusImovel = statusImovel;
        this.donoImovel = donoImovel;
        this.corretor = corretor;
        this.metragem = metragem;
        this.banheiros = banheiros;
        this.quartos = quartos;
        this.vagas = vagas;
    }

    public Imovel(Endereco endereco, int idImovel, String tipoImovel, String statusImovel, float metragem, int banheiros, int quartos, int vagas, String cpfCnpjProprietario, String creciCorretpr) {
        this.endereco = endereco;
        this.idImovel = idImovel;
        this.tipoImovel = tipoImovel;
        this.statusImovel = statusImovel;
        this.donoImovel = new DonoImovel(null, null, null, null, null, null, cpfCnpjProprietario);
        this.corretor = new Corretor(null, null, null, null, null, creciCorretpr);
        this.metragem = metragem;
        this.banheiros = banheiros;
        this.quartos = quartos;
        this.vagas = vagas;
    }

    public Imovel(int idImovel) {
        this.idImovel = idImovel;
    }

    public void mostrarInfoImovel() {
        System.out.println("Dono do imovel: ");
        this.donoImovel.mostrarInfoProprietario();

        System.out.println("\nEndereço: ");
        this.endereco.mostrarEndereco();

        System.out.println("\nSobre o ímovel: ");
        System.out.println("ID do Imovel: " + this.idImovel);
        System.out.println("Tipo do Imovel: " + this.tipoImovel);
        System.out.println("Status do Imovel: " + this.statusImovel);
        System.out.println("Metragem: " + this.metragem);
        System.out.println("Numero de Banheiros: " + this.banheiros);
        System.out.println("Numero de Vagas: " + this.vagas);
        System.out.println("Dono do Imovel: " + this.donoImovel.getNome());
        System.out.println("Cpf_Cnpj do dono: " + this.donoImovel.getCpfOuCnpjProprietarioCripted());
        System.out.println("Corretor Responsável: " + this.corretor.getNome());
        System.out.println("Creci do Corretor Responsavel: " + this.corretor.getCreciCoretor());
    }

    // Getters
    public Endereco getEndereco() {
        return endereco;
    }

    public int getIdImovel() {
        return idImovel;
    }

    public String getTipoImovel() {
        return tipoImovel;
    }

    public String getStatusImovel() {
        return statusImovel;
    }

    public float getMetragem() {
        return metragem;
    }

    public int getBanheiros() {
        return banheiros;
    }

    public int getVagas() {
        return vagas;
    }

    public DonoImovel getDonoImovel() {
        return donoImovel;
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public int getQuartos() {
        return quartos;
    }

    // Setters
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setTipoImovel(String tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public void setStatusImovel(String statusImovel) {
        this.statusImovel = statusImovel;
    }

    public void setMetragem(float metragem) {
        this.metragem = metragem;
    }

    public void setBanheiros(int banheiros) {
        this.banheiros = banheiros;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public void setDonoImovel(DonoImovel donoImovel) {
        this.donoImovel = donoImovel;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    public void setQuartos(int quartos) {
        this.quartos = quartos;
    }
}


package br.edu.ifsc.modelo.RentAI.modelo.usuarios;

import java.util.ArrayList;

public class DonoImovel {
    private ArrayList<Imovel> imoveis;
    private Usuario userInfo;
    private String cpfOuCnpjDonoImovel;
    private String cpfOuCnpjProprietarioCripted;

    // Construtor
    public DonoImovel(Usuario userInfo, String cpfOuCnpjDonoImovel) {
        this.userInfo = userInfo;
        this.cpfOuCnpjDonoImovel = cpfOuCnpjDonoImovel;
        this.imoveis = new ArrayList<>();
        this.cpfOuCnpjProprietarioCripted = cpfOuCnpjDonoImovel.substring(0,4);
    }

    public void AdicionarImovel(Imovel imovel) {
        imoveis.add(imovel);
    };
    public void mostrarInfoProprietario() {
        userInfo.mostrarInfoUser();
        System.out.println("CPF/CNPJ: " + cpfOuCnpjProprietarioCripted + "....");
    }

    // Getters
    public ArrayList<Imovel> getImoveis() {
        return imoveis;
    }

    public Usuario getUserInfo() {
        return userInfo;
    }

    public String getCpfOuCnpjDonoImovel() {
        return cpfOuCnpjDonoImovel;
    }

    public String getCpfOuCnpjProprietarioCripted() {
        return cpfOuCnpjProprietarioCripted;
    }

    // Setters
    public void setImoveis(ArrayList<Imovel> imoveis) {
        this.imoveis = imoveis;
    }

    public void setUserInfo(Usuario userInfo) {
        this.userInfo = userInfo;
    }
}

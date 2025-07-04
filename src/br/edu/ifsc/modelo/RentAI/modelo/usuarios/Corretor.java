package br.edu.ifsc.modelo.RentAI.modelo.usuarios;

public class Corretor extends Usuario {

    private String creciCoretor;


    // Construtor
    public Corretor(String email, String senha, String nome, String sobrenome, String telefone, String userName, String creciCoretor) {
        super(email, senha, nome, sobrenome, telefone, userName);
        this.creciCoretor = creciCoretor;
    }

    public void mostrarInfoCorretor() {
        mostrarInfoUser();
        System.out.println("CRECI: " + creciCoretor);
    }
    // Getters

    public String getCreciCoretor() {
        return creciCoretor;
    }



    // Setters
}


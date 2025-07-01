package br.edu.ifsc.modelo.RentAI.modelo.usuarios;

public abstract class Usuario {
    private String email;
    private String senha;
    private String nome;
    private String sobrenome;
    private String telefone;

    //Construtores
    public Usuario(String email, String senha, String nome, String sobrenome) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = "N/A";
    }

    public Usuario(String email, String senha, String nome, String sobrenome, String telefone) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }

    public void mostrarInfoUser() {
        System.out.println("Email: " + this.email);
        System.out.println("Nome: " + this.nome);
        System.out.println("Sobrenome: " + this.sobrenome);
        System.out.println("Telefone: " + this.telefone);
    }
    //Getters
    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    //Setters
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

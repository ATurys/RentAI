public class Corretor {

    private int idCorretor;
    private String nomeCorretor;
    private String sobrenomeCorretor;
    private String creciCoretor;
    private String telefoneCorretor;
    private String emailCorretor;
    private String comissaoCorretor;
    private String senhaCorretor;

    public Corretor(String nomeCorretor, String sobrenomeCorretor, String creciCoretor, String senhaCorretor, String emailCorretor) {
        this.nomeCorretor = nomeCorretor;
        this.sobrenomeCorretor = sobrenomeCorretor;
        this.creciCoretor = creciCoretor;
        this.senhaCorretor = senhaCorretor;
        this.emailCorretor = emailCorretor;
        this.idCorretor = "0";
    }

    public Corretor(String nomeCorretor, String sobrenomeCorretor, String creciCoretor,  String senhaCorretor,  String emailCorretor, String comissaoCorretor, String telefoneCorretor) {
        this.nomeCorretor = nomeCorretor;
        this.sobrenomeCorretor = sobrenomeCorretor;
        this.creciCoretor = creciCoretor;
        this.telefoneCorretor = telefoneCorretor;
        this.emailCorretor = emailCorretor;
        this.comissaoCorretor = comissaoCorretor;
        this.senhaCorretor = senhaCorretor;
        this.idCorretor = "0";
    }

    public Corretor(String nomeCorretor, String sobrenomeCorretor, String creciCoretor, String senhaCorretor, String emailCorretor, String comissaoCorretor) {
        this.nomeCorretor = nomeCorretor;
        this.sobrenomeCorretor = sobrenomeCorretor;
        this.creciCoretor = creciCoretor;
        this.emailCorretor = emailCorretor;
        this.comissaoCorretor = comissaoCorretor;
        this.senhaCorretor = senhaCorretor;
        this.idCorretor = "0";
    }

    public int getIdCorretor() {
        return idCorretor;
    }
    public void setIdCorretor(int idCorretor) {
        this.idCorretor = idCorretor;
    }

    public String getNomeCorretor() {
        return nomeCorretor;
    }
    public void setNomeCorretor(String nomeCorretor) {
        this.nomeCorretor = nomeCorretor;
    }

    public String getSobrenomeCorretor() {
        return sobrenomeCorretor;
    }
    public void setSobrenomeCorretor(String sobrenomeCorretor) {
        this.sobrenomeCorretor = sobrenomeCorretor;
    }

    public String getCreciCoretor() {
        return creciCoretor;
    }

    public String getTelefoneCorretor() {
        return telefoneCorretor;
    }
    public void setTelefoneCorretor(String telefoneCorretor) {
        this.telefoneCorretor = telefoneCorretor;
    }

    public String getEmailCorretor() {
        return emailCorretor;
    }
    public void setEmailCorretor(String emailCorretor) {
        this.emailCorretor = emailCorretor;
    }

    public String getComissaoCorretor() {
        return comissaoCorretor;
    }
    public void setComissaoCorretor(String comissaoCorretor) {
        this.comissaoCorretor = comissaoCorretor;
    }

    public String getSenhaCorretor() {
        return senhaCorretor;
    }
}


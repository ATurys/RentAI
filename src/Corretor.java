public class Corretor {

    private Usuario userInfo;
    private String creciCoretor;
    private float comissaoCorretor;

    // Construtor
    public Corretor(Usuario userInfo, String creciCoretor) {
        this.userInfo = userInfo;
        this.creciCoretor = creciCoretor;
    }

    // Getters
    public Usuario getUserInfo() {
        return userInfo;
    }

    public String getCreciCoretor() {
        return creciCoretor;
    }

    public float getComissaoCorretor() {
        return comissaoCorretor;
    }

    // Setters
    public void setUserInfo(Usuario userInfo) {
        this.userInfo = userInfo;
    }

    public void setComissaoCorretor(float comissaoCorretor) {
        this.comissaoCorretor = comissaoCorretor;
    }
}


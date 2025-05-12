public class Corretor {

    private Usuario userInfo;
    private String creciCoretor;


    // Construtor
    public Corretor(Usuario userInfo, String creciCoretor) {
        this.userInfo = userInfo;
        this.creciCoretor = creciCoretor;
    }

    public void mostrarInfoCorretor() {
        System.out.println(userInfo.mostrarInfoUser());
        System.out.println("CRECI: " + creciCoretor);
    }
    // Getters
    public Usuario getUserInfo() {
        return userInfo;
    }

    public String getCreciCoretor() {
        return creciCoretor;
    }



    // Setters
    public void setUserInfo(Usuario userInfo) {
        this.userInfo = userInfo;
    }


}


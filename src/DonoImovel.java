import java.util.ArrayList;

public class DonoImovel {
    private ArrayList<Imovel> imoveis;
    private Usuario userInfo;
    private String cpfOuCnpjDonoImovel;

    // Construtor
    public DonoImovel(Usuario userInfo, String cpfOuCnpjDonoImovel) {
        this.userInfo = userInfo;
        this.cpfOuCnpjDonoImovel = cpfOuCnpjDonoImovel;
        this.imoveis = new ArrayList<>();
    }

    public void AdicionarImovel(Imovel imovel) {
        imoveis.add(imovel);
    };

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

    // Setters
    public void setImoveis(ArrayList<Imovel> imoveis) {
        this.imoveis = imoveis;
    }

    public void setUserInfo(Usuario userInfo) {
        this.userInfo = userInfo;
    }
}

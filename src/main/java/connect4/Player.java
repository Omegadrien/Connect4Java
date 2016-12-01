package connect4;

/**
 * Created by Adrien on 24/11/2016.
 */
public class Player {

    public String getSymbole() {
        return symbole;
    }

    private String symbole;

    public Player(String Symbole) {
        if (Symbole != "X" && Symbole != "O") {
            throw new BadSymbolException();
        }
        this.symbole = Symbole;
    }
}

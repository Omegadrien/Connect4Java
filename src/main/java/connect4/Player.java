package connect4;

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

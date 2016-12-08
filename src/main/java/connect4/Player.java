package connect4;

public class Player {

    public String getSymbol() {
        return symbol;
    }

    private String symbol;

    public Player(String Symbol) {
        if (Symbol != "X" && Symbol != "O") {
            throw new BadSymbolException();
        }
        this.symbol = Symbol;
    }
}

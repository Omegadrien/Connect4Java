package connect4;

/**
 * Created by Adrien on 24/11/2016.
 */
public class Game {

    private Board board;
    private Display display;
    private Player j1;
    private Player j2;

    public Game () {
        board = new Board();
        display = new Display();
        j1 = new Player("X");
        j2 = new Player("O");
    }

    private boolean Turn(Player j) {
        int playerChoice;
        try {
            playerChoice = display.AskChoicePlayer(j);
        }
        catch (NumberFormatException NumberFormatException) {
            display.DisplayBadInput();
            return false;
        }

        try {
            board.PutASquare(playerChoice, j.getSymbole());
        }
        catch (FullStackExeption FullStackException) {
            display.DisplayFullStack();
            return false;
        }
        catch (TableOverflow TableOverflow) {
            display.DisplayTabOverflow();
            return  false;
        }
        return true;
    }

    private Player ReversePlayer(Player p) {
        if (p == j1)
            return  j2;
        else
            return j1;
    }

    private boolean CheckVictory(Player p) {
        return board.Check4Squares();
    }

    public void Start() {
        int numberOfSquaredPlaced = 0;
        boolean someoneWon = false;
        Player currentPlayer = j1;
        display.DisplayTheBoard(board.getBoard2D());

        // trouver un nom pour la fonction
        while (numberOfSquaredPlaced < 7*6 && !someoneWon) {
            if (Turn(currentPlayer)) {
                someoneWon = CheckVictory(currentPlayer);
                numberOfSquaredPlaced++;
                currentPlayer = ReversePlayer(currentPlayer);
            }

            display.DisplayTheBoard(board.getBoard2D());
        }

        if (someoneWon) {
            display.DisplayTheWinner(ReversePlayer(currentPlayer));
        }
        else {
            display.DisplayTie();
        }

    }

}

package connect4;

public class Game {

    private Board board;
    private Display display;
    private Player player1;
    private Player player2;

    public Game () {
        board = new Board();
        display = new Display();
        player1 = new Player("X");
        player2 = new Player("O");
    }

    private boolean Turn(Player player) {
        int playerChoice;
        try {
            playerChoice = display.AskChoicePlayer(player);
        }
        catch (NumberFormatException NumberFormatException) {
            display.DisplayBadInput();
            return false;
        }

        try {
            board.PutASquare(playerChoice, player.getSymbole());
        }
        catch (connect4.FullStackException FullStackException) {
            display.DisplayFullStack();
            return false;
        }
        catch (TableOverflowException TableOverflowException) {
            display.DisplayTabOverflow();
            return  false;
        }
        return true;
    }

    private Player ReversePlayer(Player player) {
        if (player == player1)
            return player2;
        else
            return player1;
    }

    private boolean CheckVictory(Player player) {
        return board.Check4Squares();
    }

    public void Start() {
        int numberOfSquaredPlaced = 0;
        boolean someoneWon = false;
        Player currentPlayer = player1;
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
            display.DisplayDraw();
        }

    }

}

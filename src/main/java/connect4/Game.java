package connect4;

public class Game {

    private Board board;
    private Display display;
    private Player playerX;
    private Player playerO;

    public Game () {
        board = new Board();
        display = new Display();
        playerX = new Player("X");
        playerO = new Player("O");
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
            board.PlaceTokenTopOfRow(playerChoice, player.getSymbol());
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
        if (player == playerX)
            return playerO;
        else
            return playerX;
    }

    private boolean CheckVictory() {
        return board.Check4Tokens();
    }

    public void Play() {
        int numberOfPlacedTokens = 0;
        boolean someoneWin = false;
        Player currentPlayer = playerX; //Player X is always the first to play
        display.DisplayTheBoard(board.getBoard2D());

        while (numberOfPlacedTokens < 7*6 && !someoneWin) {
            if (Turn(currentPlayer)) {
                numberOfPlacedTokens++;
                if (!CheckVictory())
                    currentPlayer = ReversePlayer(currentPlayer);
                else
                    someoneWin = true;
            }
            display.DisplayTheBoard(board.getBoard2D());
        }

        if (someoneWin) {
            display.DisplayTheWinner(currentPlayer);
        }
        else {
            display.DisplayDraw();
        }
    }
}

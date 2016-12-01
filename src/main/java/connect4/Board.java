package connect4;

public class Board {

    public Token[][] getBoard2D() {
        return Board2D;
    }

    private Token[][] Board2D;
    private int tokenPosX;
    private int tokenPosY;

    public Board () {
        Board2D = new Token[7][6];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                Board2D[i][j] = new Token();
            }
        }
    }

    public void PlaceTokenTopOfRow(int row, String symbolPlayer) {
        if (row < 1 || row > 7) {
            throw new TableOverflowException();
        }

        int line = 0;
        boolean squarePlaced = false;
        while (line < 6 && squarePlaced == false) {
            if (Board2D[row-1][line].getValue() != " ") {
                line++;
            }
            else {
                Board2D[row-1][line].setValue(symbolPlayer);
                squarePlaced = true;
            }
        }

        if (squarePlaced) {
            tokenPosX = row-1;//the player will enter 1, but it's 0 on the board.
            tokenPosY = line;
        }
        else {
            throw new FullStackException();
        }
    }

    public boolean Check4Tokens() {
        return (Check4TokensHorizontal() ||
                Check4TokensVertical() ||
                Check4TokensDiagonalBottomLeftToTopRight() ||
                Check4TokensDiagonalBottomRightToTopLeft());
    }

    private boolean Check4TokensVertical() {
        for (int j = 0; j < 3; j++) {
            if (Board2D[tokenPosX][j].getValue() != " " &&
                Board2D[tokenPosX][j].getValue() == Board2D[tokenPosX][j+1].getValue() &&
                Board2D[tokenPosX][j+1].getValue() == Board2D[tokenPosX][j+2].getValue() &&
                Board2D[tokenPosX][j+2].getValue() == Board2D[tokenPosX][j+3].getValue())
            {
                return true;
            }
        }
        return false;
    }

    private boolean Check4TokensHorizontal() {
        for (int i = 0; i < 4; i++) {
            if (Board2D[i][tokenPosY].getValue() != " " &&
                Board2D[i][tokenPosY].getValue() == Board2D[i+1][tokenPosY].getValue() &&
                Board2D[i+1][tokenPosY].getValue() == Board2D[i+2][tokenPosY].getValue() &&
                Board2D[i+2][tokenPosY].getValue() == Board2D[i+3][tokenPosY].getValue())
            {
                return true;
            }
        }
        return false;
    }

    private boolean Check4TokensDiagonalBottomLeftToTopRight() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (Board2D[i][j].getValue() != " " &&
                    Board2D[i][j].getValue() == Board2D[i+1][j+1].getValue() &&
                    Board2D[i+1][j+1].getValue() == Board2D[i+2][j+2].getValue() &&
                    Board2D[i+2][j+2].getValue() == Board2D[i+3][j+3].getValue())
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean Check4TokensDiagonalBottomRightToTopLeft() {
        for (int i = 3; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                if (Board2D[i][j].getValue() != " " &&
                    Board2D[i][j].getValue() == Board2D[i-1][j+1].getValue() &&
                    Board2D[i-1][j+1].getValue() == Board2D[i-2][j+2].getValue() &&
                    Board2D[i-2][j+2].getValue() == Board2D[i-3][j+3].getValue())
                {
                    return true;
                }
            }
        }
        return false;
    }

}

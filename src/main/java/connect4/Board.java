package connect4;

public class Board {

    public Token[][] getBoard2D() {
        return Board2D;
    }

    private Token[][] Board2D;

    public Board () {
        Board2D = new Token[7][6];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                Board2D[i][j] = new Token();
            }
        }
    }

    public void PutASquare(int row, String symbolPlayer) {
        if (row < 1 || row > 7) {
            throw new TableOverflowException();
        }

        int line = 0;
        boolean squarePlaced = false;
        while (squarePlaced == false && line < 6) {
            if (Board2D[row-1][line].getValue() != " ") {
                line++;
            }
            else {
                Board2D[row-1][line].setValue(symbolPlayer);
                squarePlaced = true;
            }
        }

        if (squarePlaced == false) {
            throw new FullStackException();
        }
    }

    public boolean Check4Squares() {
        return (Check4SquaresHorizontal() || Check4SquaresVertical() || Check4SquaresDiagonalBottomLeftToTopRight() || Check4SquaresDiagonalBottomRightTopLeft());
    }

    private boolean Check4SquaresVertical() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                if (Board2D[i][j].getValue() != " " &&
                        Board2D[i][j].getValue() == Board2D[i][j+1].getValue() &&
                        Board2D[i][j+1].getValue() == Board2D[i][j+2].getValue() &&
                        Board2D[i][j+2].getValue() == Board2D[i][j+3].getValue())
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean Check4SquaresHorizontal() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                if (Board2D[i][j].getValue() != " " &&
                        Board2D[i][j].getValue() == Board2D[i+1][j].getValue() &&
                        Board2D[i+1][j].getValue() == Board2D[i+2][j].getValue() &&
                        Board2D[i+2][j].getValue() == Board2D[i+3][j].getValue())
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean Check4SquaresDiagonalBottomLeftToTopRight() {
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

    private boolean Check4SquaresDiagonalBottomRightTopLeft() {
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

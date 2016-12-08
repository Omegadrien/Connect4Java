package connect4;

import java.util.Scanner;

public class Display {

    private Scanner scanner = new Scanner(System.in);

    public void DisplayTheBoard(Token[][] table) {
        System.out.print("\n - - - - - - - -\n");
        for (int j = 5; j >= 0; j--) {
            System.out.print("||");
            for (int i = 0; i < 7; i++) {
                System.out.print(table[i][j].getValue() + "|");
            }
            System.out.print("|");
            System.out.println();
        }

        System.out.print("  1 2 3 4 5 6 7\n");
        System.out.println();
    }

    public void DisplayTheWinner(Player player) {
        System.out.println();
        System.out.print("The player " + player.getSymbol() + " won!");
    }

    public void DisplayDraw() {
        System.out.println();
        System.out.print("The game ended in a draw...");
    }

    public int AskChoicePlayer(Player player) {
        System.out.print("Enter a row number, player " + player.getSymbol() + " : ");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }

    public void DisplayFullStack() { System.out.print("\nThe row is full! Please select another one.\n");}

    public void DisplayTabOverflow() {
        System.out.print("\nBad row input.\n");
    }

    public void DisplayBadInput() {
        System.out.print("\nBad input. Please enter an integer.\n");
    }
}


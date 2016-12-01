package connect4;

import java.util.Scanner;

/**
 * Created by Adrien on 25/11/2016.
 */
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

    public void DisplayTheWinner(Player p) {
        System.out.println();
        System.out.print("Le joueur " + p.getSymbole() + " a gagné");
    }

    public void DisplayTie() {
        System.out.println();
        System.out.print("Match nul !");
    }

    public int AskChoicePlayer(Player p) {
        System.out.print("Rentrez la colonne, joueur " + p.getSymbole() + " : ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        return Integer.parseInt(str);
    }

    public void DisplayFullStack() {
        System.out.print("\n Pile pleine !!\n");
    }

    public void DisplayTabOverflow() {
        System.out.print("\n Valeur en dehors du tableau.\n");
    }

    public void DisplayBadInput() {
        System.out.print("\nLa valeur entrée est incorrecte.\n");
    }

}


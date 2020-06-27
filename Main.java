package tictactoe;

import java.util.Scanner;

public class Main {
    final static Scanner scanner = new Scanner(System.in); // Do not change this line
    static char[] ch;

    public static void main(String[] args) {
        enterCells();
        printBoard();
    }

    public static void enterCells() {
        System.out.println("Enter cells: ");
        String pattern = scanner.nextLine();

        ch = pattern.toCharArray();
    }

    static void printBoard() {
        System.out.println("---------");
        System.out.println("| " + ch[0] + " " + ch[1] + " " + ch[2] + " |");
        System.out.println("| " + ch[3] + " " + ch[4] + " " + ch[5] + " |");
        System.out.println("| " + ch[6] + " " + ch[7] + " " + ch[8] + " |");
        System.out.println("---------");
    }
}

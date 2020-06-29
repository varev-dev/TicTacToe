package tictactoe;

import java.util.Scanner;

public class Main {
    final static Scanner scanner = new Scanner(System.in); // Do not change this line
    static char[] ch;
    static char winner = 0;
    static int countX = 0, countO = 0;

    public static void main(String[] args) {
        enterCells();
        printBoard();
        checkStatus();
        result();
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

    static void checkStatus() {
        if ((ch[0] == 'X' && ch[1] == 'X' && ch[2] == 'X') || (ch[3] == 'X' && ch[4] == 'X' && ch[5] == 'X') || (ch[6] == 'X' && ch[7] == 'X' && ch[8] == 'X') || (ch[0] == 'X' && ch[3] == 'X' && ch[6] == 'X') || (ch[1] == 'X' && ch[4] == 'X' && ch[7] == 'X') || (ch[2] == 'X' && ch[5] == 'X' && ch[8] == 'X') || (ch[0] == 'X' && ch[4] == 'X' && ch[8] == 'X') || (ch[2] == 'X' && ch[4] == 'X' && ch[6] == 'X')) {
            winner += 1;
        }

        if ((ch[0] == 'O' && ch[1] == 'O' && ch[2] == 'O') || (ch[3] == 'O' && ch[4] == 'O' && ch[5] == 'O') || (ch[6] == 'O' && ch[7] == 'O' && ch[8] == 'O') || (ch[0] == 'O' && ch[3] == 'O' && ch[6] == 'O') || (ch[1] == 'O' && ch[4] == 'O' && ch[7] == 'O') || (ch[2] == 'O' && ch[5] == 'O' && ch[8] == 'O') || (ch[0] == 'O' && ch[4] == 'O' && ch[8] == 'O') || (ch[2] == 'O' && ch[4] == 'O' && ch[6] == 'O')) {
            winner += 2;
        }

        if (winner == 0) {
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == '_') {
                    winner = 4;
                }
            }
        }

        for (int i = 0; i < ch.length; i++) {
            if(ch[i] == 'X') {
                countX += 1;
            }
            else if (ch[i] == 'O') {
                countO += 1;
            }
        }

        if (countX != countO && countX - 1 != countO && countX != countO - 1) {
            winner = 3;
        }
    }

    static void result() {
        if (winner == 0) {
            System.out.println("Draw");
        }
        else if (winner == 1) {
            System.out.println("X wins");
        }
        else if (winner == 2) {
            System.out.println("O wins");
        }
        else if (winner == 3) {
            System.out.println("Impossible");
        }
        else if (winner == 4) {
            System.out.println("Game not finished");
        }
    }
}
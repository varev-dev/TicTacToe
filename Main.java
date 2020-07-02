package tictactoe;

import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    final static Scanner scanner = new Scanner(System.in);
    static char[][] gameArray = new char[3][3];
    static char previousMove;
    static int column = 0, line = 0;

    public static void main(String[] args) {
        enterCells();
        firstMove();
    }

    public static void enterCells() {
        String pattern;
        char[] cellsCode;

        do {
            System.out.print("Enter cells: ");
            pattern = scanner.nextLine();
            cellsCode = pattern.toCharArray();
        } while (cellsCode.length != 9);

        int k = 0;

        for (int i = gameArray.length - 1; i >= 0; i--) {
            for (int j = 0; j < gameArray.length; j++) {
                cellsCode[k] = cellsCode[k] == '_' ? cellsCode[k] = ' ' : cellsCode[k];
                gameArray[j][i] = cellsCode[k];
                k++;
            }
        }

        displayTable();
    }

    public static void firstMove() {
        String fCell, sCell;
        do {
            System.out.print("Enter the coordinates: ");
            fCell = scanner.next();
            sCell = scanner.next();

            if (fCell.matches("\\d") && sCell.matches("\\d")) {
                column = parseInt(fCell) - 1;
                line = parseInt(sCell) - 1;

                if ((column < 3 && column >= 0) && (line < 3 && line >= 0)) {
                    if (gameArray[column][line] == ' ') {
                        previousMove = ' ';
                        gameArray[column][line] = 'X';
                        displayTable();
                    }
                    else {
                        System.out.println("This cell is occupied! Choose another one!");
                        previousMove = 'X';
                    }
                }
                else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            }
            else {
                System.out.println("You should enter numbers!");
            }
        } while (previousMove != ' ');
    }

    public static void displayTable() {
        System.out.println("---------");
        System.out.println("| " + gameArray[0][2] + " " + gameArray[1][2] + " " + gameArray[2][2] + " |");
        System.out.println("| " + gameArray[0][1] + " " + gameArray[1][1] + " " + gameArray[2][1] + " |");
        System.out.println("| " + gameArray[0][0] + " " + gameArray[1][0] + " " + gameArray[2][0] + " |");
        System.out.println("---------");
    }
}
package tictactoe;

import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    final static Scanner scanner = new Scanner(System.in);
    static char[][] gameArray = new char[3][3];
    static char winner = ' ';
    static int column = 0, line = 0;

    public static void main(String[] args) {
        for (int i = 0; i < gameArray.length; i++) {
            for (int j = 0; j < gameArray.length; j++) {
                gameArray[i][j] = ' ';
            }
        }
        displayTable();
        move();
    }

    public static void move() {
        String fCell, sCell;
        int countX = 0, countO = 0;

        do {
            System.out.print("Enter the coordinates: ");
            fCell = scanner.next();
            sCell = scanner.next();

            if (fCell.matches("\\d") && sCell.matches("\\d")) {
                column = parseInt(fCell) - 1;
                line = parseInt(sCell) - 1;

                if ((column < 3 && column >= 0) && (line < 3 && line >= 0)) {
                    if (gameArray[column][line] == ' ') {
                        if (countX == countO) {
                            gameArray[column][line] = 'X';
                            countX++;
                            displayTable();
                            checkStatusX();
                            checkDraw();
                        }
                        else {
                            gameArray[column][line] = 'O';
                            countO++;
                            displayTable();
                            checkStatusO();
                        }
                    }
                    else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                }
                else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            }
            else {
                System.out.println("You should enter numbers!");
            }
        } while (winner == ' ');
    }

    public static void checkStatusX() {
        if (gameArray[0][2] == 'X' && gameArray[1][2] == 'X' && gameArray[2][2] == 'X') {
            winner = 'X';
        } else if (gameArray[0][1] == 'X' && gameArray[1][1] == 'X' && gameArray[2][1] == 'X') {
            winner = 'X';
        } else if (gameArray[0][0] == 'X' && gameArray[1][0] == 'X' && gameArray[2][0] == 'X') {
            winner = 'X';
        } else if (gameArray[0][2] == 'X' && gameArray[0][1] == 'X' && gameArray[0][0] == 'X') {
            winner = 'X';
        } else if (gameArray[1][2] == 'X' && gameArray[1][1] == 'X' && gameArray[1][0] == 'X') {
            winner = 'X';
        } else if (gameArray[2][2] == 'X' && gameArray[2][1] == 'X' && gameArray[2][0] == 'X') {
            winner = 'X';
        } else if (gameArray[0][2] == 'X' && gameArray[1][1] == 'X' && gameArray[2][0] == 'X') {
            winner = 'X';
        } else if (gameArray[0][0] == 'X' && gameArray[1][1] == 'X' && gameArray[2][2] == 'X') {
            winner = 'X';
        }

        if (winner == 'X') {
            System.out.println("X wins");
        }
    }

    public static void checkStatusO() {
        if (gameArray[0][2] == 'O' && gameArray[1][2] == 'O' && gameArray[2][2] == 'O') {
            winner = 'O';
        } else if (gameArray[0][1] == 'O' && gameArray[1][1] == 'O' && gameArray[2][1] == 'O') {
            winner = 'O';
        } else if (gameArray[0][0] == 'O' && gameArray[1][0] == 'O' && gameArray[2][0] == 'O') {
            winner = 'O';
        } else if (gameArray[0][2] == 'O' && gameArray[0][1] == 'O' && gameArray[0][0] == 'O') {
            winner = 'O';
        } else if (gameArray[1][2] == 'O' && gameArray[1][1] == 'O' && gameArray[1][0] == 'O') {
            winner = 'O';
        } else if (gameArray[2][2] == 'O' && gameArray[2][1] == 'O' && gameArray[2][0] == 'O') {
            winner = 'O';
        } else if (gameArray[0][2] == 'O' && gameArray[1][1] == 'O' && gameArray[2][0] == 'O') {
            winner = 'O';
        } else if (gameArray[0][0] == 'O' && gameArray[1][1] == 'O' && gameArray[2][2] == 'O') {
            winner = 'O';
        }

        if (winner == 'O') {
            System.out.println("O wins");
        }
    }

    public static void checkDraw() {
        int occupied = 0;

        for (int i = 0; i < gameArray.length; i++) {
            for (int j = 0; j < gameArray.length; j++) {
                if (gameArray[i][j] != ' ') {
                    occupied++;
                }
            }
        }

        if (occupied == 9 && winner == ' ') {
            System.out.println("Draw");
            winner = 'F';
        }
    }

    public static void displayTable() {
        System.out.println("---------");
        System.out.println("| " + gameArray[0][2] + " " + gameArray[1][2] + " " + gameArray[2][2] + " |");
        System.out.println("| " + gameArray[0][1] + " " + gameArray[1][1] + " " + gameArray[2][1] + " |");
        System.out.println("| " + gameArray[0][0] + " " + gameArray[1][0] + " " + gameArray[2][0] + " |");
        System.out.println("---------");
    }
}

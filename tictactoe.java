package tictactoe;

import java.util.*;

public class Main {

    public static void display(char[][] table) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static int checkWinner(char[][] table) {
        for (int i = 0; i < 3; i++) {
            int row = 0, col = 0, diagA = 0, diagB = 0;
            for (int j = 0; j < 3; j++) {
                row += table[i][j];
                col += table[j][i];
                diagA += table[j][j];
                diagB += table[j][2 - j];
            }
            if (row == 264 || col == 264 || diagA == 264 || diagB == 264) {
                return 1;
            } else if (row == 237 || col == 237 || diagA == 237 || diagB == 237) {
                return 2;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] table = new char[3][3];
        for (int i = 0; i < 9; i++) {
            table[i/3][i%3] = ' ';
        }
        display(table);
        for (int moves = 0; moves < 9;) {
            System.out.print("Enter the coordinates: ");
            try {
                int x = scanner.nextInt() - 1;
                int z = 3 - scanner.nextInt();
                if (x < 0 || x > 2 || z < 0 || z > 2) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (table[z][x] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    table[z][x] = (moves % 2 == 0) ? 'X' : 'O';
                    display(table);
                    switch (checkWinner(table)) {
                        case 1: {
                            System.out.println("X wins");
                            return;
                        }
                        case 2: {
                            System.out.println("O wins");
                            return;
                        }
                    }
                    moves++;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("You should enter numbers!");
            }
        }
        System.out.println("Draw");
    }

}

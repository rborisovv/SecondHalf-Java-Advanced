package ExamPrep;

import java.util.Scanner;

public class SnakeTest {
    public static int snakeRow = 0;
    public static int snakeCol = 0;
    public static int eatenFood = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        char[][] gameField = new char[sizeOfMatrix][];

        for (int i = 0; i < sizeOfMatrix; i++) {
            String line = scanner.nextLine();
            if (line.contains("S")) {
                snakeRow = i;
                snakeCol = line.indexOf("S");
            }
            gameField[i] = line.toCharArray();
        }
        while (eatenFood < 10) {
            String command = scanner.nextLine();
            if (command.equals("up")) {
                if (isInBounds(snakeRow - 1, snakeCol, gameField)) {
                    if (!moveSnake(snakeRow - 1,
                            snakeCol, gameField)) {
                        snakeRow -= 1;
                    }
                } else {
                    break;
                }
            } else if (command.equals("down")) {
                if (isInBounds(snakeRow + 1, snakeCol, gameField)) {
                    if (!moveSnake(snakeRow + 1, snakeCol, gameField)) {
                        snakeRow += 1;
                    }
                } else {
                    break;
                }
            } else if (command.equals("left")) {
                if (isInBounds(snakeRow, snakeCol - 1, gameField)) {
                    if (!moveSnake(snakeRow, snakeCol - 1, gameField)) {
                        snakeCol -= 1;
                    }
                } else {
                    break;
                }
            } else if (command.equals("right")) {
                if (isInBounds(snakeRow, snakeCol + 1, gameField)) {
                    if (!moveSnake(snakeRow, snakeCol + 1, gameField)) {
                        snakeCol += 1;
                    }
                } else {
                    break;
                }
            }
        }
        if (eatenFood == 10) {
            System.out.println("You won! You fed the snake.");
        } else {
            gameField[snakeRow][snakeCol] = '.';
            System.out.println("Game over!");
        }
        System.out.println("Food eaten: " + eatenFood);
        printMatrix(gameField);
    }

    private static void printMatrix(char[][] gameField) {
        for (int row = 0; row < gameField.length; row++) {
            for (int col = 0; col < gameField[row].length; col++) {
                System.out.print(gameField[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean moveSnake(int nextSnakeRow, int nextSnakeCol, char[][] gameField) {
        if (gameField[nextSnakeRow][nextSnakeCol] == '*') {
            gameField[nextSnakeRow][nextSnakeCol] = 'S';
            gameField[snakeRow][snakeCol] = '.';
            eatenFood += 1;
        } else if (gameField[nextSnakeRow][nextSnakeCol] == 'B') {
            moveSnakeToBurrow(nextSnakeRow, nextSnakeCol, gameField);
            return true;
        } else if (gameField[nextSnakeRow][nextSnakeCol] == '-') {
            gameField[nextSnakeRow][nextSnakeCol] = 'S';
            gameField[snakeRow][snakeCol] = '.';
        }
        return false;
    }

    private static void moveSnakeToBurrow(int nextSnakeRow, int nextSnakeCol,
                                          char[][] gameField) {
        for (int row = 0; row < gameField.length; row++) {
            for (int col = 0; col < gameField[row].length; col++) {
                if (gameField[row][col] == 'B' && nextSnakeRow != row &&
                        nextSnakeCol != col) {
                    gameField[row][col] = 'S';
                    gameField[nextSnakeRow][nextSnakeCol] = '.';
                    gameField[snakeRow][snakeCol] = '.';
                    snakeRow = row;
                    snakeCol = col;
                    return;
                }
            }
        }
    }

    private static boolean isInBounds(int snakeRow, int snakeCol, char[][] gameField) {
        return snakeRow >= 0 && snakeRow < gameField.length &&
                snakeCol >= 0 && snakeCol < gameField.length;
    }
}
package ExamPrep;

import java.util.Scanner;

public class Revolt_02 {
    public static int carRowPosition = 0;
    public static int carColPosition = 0;
    public static boolean isFinished = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        char[][] gameField = new char[sizeOfMatrix][sizeOfMatrix];

        for (int i = 0; i < sizeOfMatrix; i++) {
            String lineOfMatrix = scanner.nextLine();
            if (lineOfMatrix.contains("f")) {
                carRowPosition = i;
                carColPosition = lineOfMatrix.indexOf("f");
            }
            gameField[i] = lineOfMatrix.toCharArray();
        }
        while (numberOfCommands-- != 0) {
            String command = scanner.nextLine();

            if (command.equals("up")) {
                if (isInBounds(carRowPosition - 1, carColPosition, gameField)) {
                    if (!moveCar(carRowPosition, carColPosition, carRowPosition - 1, carColPosition, gameField, command)) {
                        carRowPosition -= 1;
                    }
                } else {
                    if (gameField[gameField.length - 1][carColPosition] == 'F') {
                        isFinished = true;
                    }
                    gameField[gameField.length - 1][carColPosition] = 'f';
                    gameField[carRowPosition][carColPosition] = '-';
                    carRowPosition = gameField.length - 1;
                }
            } else if (command.equals("down")) {
                if (isInBounds(carRowPosition + 1, carColPosition, gameField)) {
                    if (!moveCar(carRowPosition, carColPosition, carRowPosition + 1, carColPosition, gameField, command)) {
                        carRowPosition += 1;
                    }
                } else {
                    if (gameField[0][carColPosition] == 'F') {
                        isFinished = true;
                    }
                    gameField[0][carColPosition] = 'f';
                    gameField[carRowPosition][carColPosition] = '-';
                    carRowPosition = 0;
                }
            } else if (command.equals("left")) {
                if (isInBounds(carRowPosition, carColPosition - 1, gameField)) {
                    if (!moveCar(carRowPosition, carColPosition, carRowPosition, carColPosition - 1, gameField, command)) {
                        carColPosition -= 1;
                    }
                } else {
                    if (gameField[carRowPosition][gameField.length - 1] == 'F') {
                        isFinished = true;
                    }
                    gameField[carRowPosition][gameField.length - 1] = 'f';
                    gameField[carRowPosition][carColPosition] = '-';
                    carColPosition = gameField.length - 1;
                }
            } else if (command.equals("right")) {
                if (isInBounds(carRowPosition, carColPosition + 1, gameField)) {
                    if (!moveCar(carRowPosition, carColPosition, carRowPosition, carColPosition + 1, gameField, command)) {
                        carColPosition += 1;
                    }
                } else {
                    if (gameField[carRowPosition][0] == 'F') {
                        isFinished = true;
                    }
                    gameField[carRowPosition][0] = 'f';
                    gameField[carRowPosition][carColPosition] = '-';
                    carColPosition = 0;
                }
            }
            if (isFinished) {
                break;
            }
        }
        if (isFinished) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
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

    private static boolean moveCar(int carPreviousRowPosition, int carPreviousColPosition,
                                   int nextCarRowPosition, int nextCarColPosition, char[][] gameField, String command) {
        if (gameField[nextCarRowPosition][nextCarColPosition] == '-') {
            gameField[nextCarRowPosition][nextCarColPosition] = 'f';
            gameField[carPreviousRowPosition][carPreviousColPosition] = '-';
        } else if (gameField[nextCarRowPosition][nextCarColPosition] == 'B') {
            switch (command) {
                case "up":
                    if (isInBounds(nextCarRowPosition - 1, nextCarColPosition, gameField)) {
                        bonusMove(carPreviousRowPosition, carPreviousColPosition,
                                nextCarColPosition - 1, nextCarColPosition, gameField);
                    } else {
                        if (gameField[gameField.length - 1][nextCarColPosition] == 'F') {
                            isFinished = true;
                        }
                        gameField[gameField.length - 1][nextCarColPosition] = 'f';
                        gameField[carRowPosition][carColPosition] = '-';
                        carRowPosition = gameField.length - 1;
                    }
                    return true;
                case "down":
                    if (isInBounds(nextCarRowPosition + 1, nextCarColPosition, gameField)) {
                        bonusMove(carPreviousRowPosition, carPreviousColPosition,
                                nextCarRowPosition + 1, nextCarColPosition, gameField);
                    } else {
                        if (gameField[0][nextCarColPosition] == 'F') {
                            isFinished = true;
                        }
                        gameField[0][nextCarColPosition] = 'f';
                        gameField[carRowPosition][carColPosition] = '-';
                        carRowPosition = 0;
                    }
                    return true;
                case "left":
                    if (isInBounds(nextCarRowPosition, nextCarColPosition - 1, gameField)) {
                        bonusMove(carPreviousRowPosition, carPreviousColPosition,
                                nextCarRowPosition, nextCarColPosition - 1, gameField);
                    } else {
                        if (gameField[nextCarRowPosition][gameField.length - 1] == 'F') {
                            isFinished = true;
                        }
                        gameField[nextCarRowPosition][gameField.length - 1] = 'f';
                        gameField[carRowPosition][carColPosition] = '-';
                        carColPosition = gameField.length - 1;
                    }
                    return true;
                case "right":
                    if (isInBounds(nextCarRowPosition, nextCarColPosition + 1, gameField)) {
                        bonusMove(carPreviousRowPosition, carPreviousColPosition,
                                nextCarRowPosition, nextCarColPosition + 1, gameField);
                    } else {
                        if (gameField[0][0] == 'F') {
                            isFinished = true;
                        }
                        gameField[0][0] = 'f';
                        gameField[carRowPosition][carColPosition] = '-';
                        carColPosition = 0;
                    }
                    return true;
            }
        } else if (gameField[nextCarRowPosition][nextCarColPosition] == 'T') {
            return true;
        } else if (gameField[nextCarRowPosition][nextCarColPosition] == 'F') {
            gameField[nextCarRowPosition][nextCarColPosition] = 'f';
            gameField[carRowPosition][carColPosition] = '-';
            isFinished = true;
            return true;
        }
        return false;
    }

    private static void bonusMove(int carPreviousRowPosition, int carPreviousColPosition,
                                  int nextCarRowPosition, int nextCarColPosition, char[][] gameField) {
        gameField[nextCarRowPosition][nextCarColPosition] = 'f';
        gameField[carPreviousRowPosition][carPreviousColPosition] = '-';
        carRowPosition = nextCarRowPosition;
        carColPosition = nextCarColPosition;
    }

    private static boolean isInBounds(int carRowPosition, int carColPosition, char[][] gameField) {
        return carRowPosition >= 0 && carRowPosition < gameField.length &&
                carColPosition >= 0 && carColPosition < gameField.length;
    }
}
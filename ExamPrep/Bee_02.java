package ExamPrep;

import java.util.Scanner;

public class Bee_02 {
    public static int beeRowPosition = 0;
    public static int beeColPosition = 0;
    public static boolean isOutOfBounds = false;
    public static int pollinatedFlowersCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[sizeOfMatrix][sizeOfMatrix];
        for (int row = 0; row < field.length; row++) {
            String matrixLines = scanner.nextLine();
            if (matrixLines.contains("B")) {
                beeRowPosition = row;
                beeColPosition = matrixLines.indexOf('B');
            }
            field[row] = matrixLines.toCharArray();
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            if (command.equals("up")) {
                if (beeIsInBounds(beeRowPosition - 1, beeColPosition, field)) {
                    if (!moveBee(beeRowPosition - 1, beeColPosition, field, command)) {
                        beeRowPosition -= 1;
                    }
                } else {
                    isOutOfBounds = true;
                }
            } else if (command.equals("down")) {
                if (beeIsInBounds(beeRowPosition + 1, beeColPosition, field)) {
                    if (!moveBee(beeRowPosition + 1, beeColPosition, field, command)) {
                        beeRowPosition += 1;
                    }
                } else {
                    isOutOfBounds = true;
                }
            } else if (command.equals("left")) {
                if (beeIsInBounds(beeRowPosition, beeColPosition - 1, field)) {
                    if (!moveBee(beeRowPosition, beeColPosition - 1, field, command)) {
                        beeColPosition -= 1;
                    }
                } else {
                    isOutOfBounds = true;
                }
            } else if (command.equals("right")) {
                if (beeIsInBounds(beeRowPosition, beeColPosition + 1, field)) {
                    if (!moveBee(beeRowPosition, beeColPosition + 1, field, command)) {
                        beeColPosition += 1;
                    }
                } else {
                    isOutOfBounds = true;
                }
            }
            if (isOutOfBounds) {
                break;
            }
            command = scanner.nextLine();
        }
        if (isOutOfBounds) {
            field[beeRowPosition][beeColPosition] = '.';
            System.out.println("The bee got lost!");
        }
        if (pollinatedFlowersCount >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n",
                    pollinatedFlowersCount);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n",
                    5 - pollinatedFlowersCount);
        }
        printMatrix(field);
    }

    private static void printMatrix(char[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean moveBee(int nextBeeRowPosition, int nextBeeColPosition, char[][] field, String command) {
        if (field[nextBeeRowPosition][nextBeeColPosition] == '.') {
            field[nextBeeRowPosition][nextBeeColPosition] = 'B';
            field[beeRowPosition][beeColPosition] = '.';
        } else if (field[nextBeeRowPosition][nextBeeColPosition] == 'f') {
            field[nextBeeRowPosition][nextBeeColPosition] = 'B';
            field[beeRowPosition][beeColPosition] = '.';
            pollinatedFlowersCount += 1;
        } else if (field[nextBeeRowPosition][nextBeeColPosition] == 'O') {
            switch (command) {
                case "up":
                    moveBeeToBonus(nextBeeRowPosition - 1, nextBeeColPosition, field);
                    beeRowPosition -= 2;
                    break;
                case "down":
                    moveBeeToBonus(nextBeeRowPosition + 1, nextBeeColPosition, field);
                    beeRowPosition += 2;
                    break;
                case "left":
                    moveBeeToBonus(nextBeeRowPosition, nextBeeColPosition - 1, field);
                    beeColPosition -= 2;
                    break;
                case "right":
                    moveBeeToBonus(nextBeeRowPosition, nextBeeColPosition + 1, field);
                    beeColPosition += 2;
                    break;
            }
            field[nextBeeRowPosition][nextBeeColPosition] = '.';
            return true;
        }
        return false;
    }

    private static void moveBeeToBonus(int nextBeeRowPosition, int nextBeeColPosition, char[][] field) {
        if (field[nextBeeRowPosition][nextBeeColPosition] == 'f') {
            field[nextBeeRowPosition][nextBeeColPosition] = 'B';
            field[beeRowPosition][beeColPosition] = '.';
            pollinatedFlowersCount += 1;
        } else if (field[nextBeeRowPosition][nextBeeColPosition] == '.') {
            field[nextBeeRowPosition][nextBeeColPosition] = 'B';
            field[beeRowPosition][beeColPosition] = '.';
        }
    }

    private static boolean beeIsInBounds(int beeRowPosition, int beeColPosition, char[][] field) {
        return beeRowPosition >= 0 && beeRowPosition < field.length &&
                beeColPosition >= 0 && beeColPosition < field.length;
    }
}
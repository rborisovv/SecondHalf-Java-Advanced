package ExamPrep;

import java.util.Scanner;

public class BookWorm {
    public static int wormRow = 0;
    public static int wormCol = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder initialString = new StringBuilder(scanner.nextLine());
        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        char[][] bookField = new char[sizeOfMatrix][sizeOfMatrix];

        for (int row = 0; row < sizeOfMatrix; row++) {
            String line = scanner.nextLine();
            if (line.contains("P")) {
                wormRow = row;
                wormCol = line.indexOf("P");
            }
            bookField[row] = line.toCharArray();
        }
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            if (command.equals("up")) {
                if (isInBounds(wormRow - 1, wormCol, bookField)) {
                    moveWorm(wormRow - 1, wormCol, bookField, initialString);
                    wormRow -= 1;
                } else {
                    //TODO decide what to do if starting initial text is null
                    if (initialString.length() > 0) {
                        initialString.deleteCharAt(initialString.length() - 1);
                    }
                }
            } else if (command.equals("down")) {
                if (isInBounds(wormRow + 1, wormCol, bookField)) {
                    moveWorm(wormRow + 1, wormCol, bookField, initialString);
                    wormRow += 1;
                } else {
                    if (initialString.length() > 0) {
                        initialString.deleteCharAt(initialString.length() - 1);
                    }
                }
            } else if (command.equals("left")) {
                if (isInBounds(wormRow, wormCol - 1, bookField)) {
                    moveWorm(wormRow, wormCol - 1, bookField, initialString);
                    wormCol -= 1;
                } else {
                    if (initialString.length() > 0) {
                        initialString.deleteCharAt(initialString.length() - 1);
                    }
                }
            } else if (command.equals("right")) {
                if (isInBounds(wormRow, wormCol + 1, bookField)) {
                    moveWorm(wormRow, wormCol + 1, bookField, initialString);
                    wormCol += 1;
                } else {
                    if (initialString.length() > 0) {
                        initialString.deleteCharAt(initialString.length() - 1);
                    }
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(initialString);
        printMatrix(bookField);
    }

    private static void printMatrix(char[][] bookField) {
        for (int row = 0; row < bookField.length; row++) {
            for (int col = 0; col < bookField[row].length; col++) {
                System.out.print(bookField[row][col]);
            }
            System.out.println();
        }
    }

    private static void moveWorm(int nextWormRow, int nextWormCol, char[][] bookField, StringBuilder initialString) {
        if (Character.isAlphabetic(bookField[nextWormRow][nextWormCol])) {
            initialString.append(bookField[nextWormRow][nextWormCol]);
            bookField[nextWormRow][nextWormCol] = 'P';
            bookField[wormRow][wormCol] = '-';
        } else if (bookField[nextWormRow][nextWormCol] == '-') {
            bookField[nextWormRow][nextWormCol] = 'P';
            bookField[wormRow][wormCol] = '-';
        }
    }

    private static boolean isInBounds(int nextWormRow, int nextWormCol, char[][] bookField) {
        return nextWormRow >= 0 && nextWormRow < bookField.length &&
                nextWormCol >= 0 && nextWormCol < bookField.length;
    }
}

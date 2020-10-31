package ExamPrep;

import java.util.Scanner;

public class PresentDelivery_02 {
    public static Scanner scanner = new Scanner(System.in);
    public static int presents = Integer.parseInt(scanner.nextLine());
    public static int santaRow = 0, santaCol = 0, happyNiceKids = 0;

    public static void main(String[] args) {
        int sizeofNeighbourhood = Integer.parseInt(scanner.nextLine());

        char[][] neighbourhood = new char[sizeofNeighbourhood][sizeofNeighbourhood];
        for (int row = 0; row < sizeofNeighbourhood; row++) {
            String line = scanner.nextLine();
            if (line.contains("S")) {
                santaRow = row;
                santaCol = line.indexOf("S");
            }
            neighbourhood[row] = line.toCharArray();
        }
        String command = scanner.nextLine();
        while (!command.equals("Christmas morning")) {
            if (command.equals("up")) {
                if (!moveSanta(santaRow - 1, santaCol, neighbourhood)) {
                    santaRow -= 1;
                }

            } else if (command.equals("down")) {
                if (!moveSanta(santaRow + 1, santaCol, neighbourhood)) {
                    santaRow += 1;
                }

            } else if (command.equals("left")) {
                if (!moveSanta(santaRow, santaCol - 2, neighbourhood)) {
                    santaCol -= 2;
                }

            } else if (command.equals("right")) {
                if (!moveSanta(santaRow, santaCol + 2, neighbourhood)) {
                    santaCol += 2;
                }

            }
            //TODO work the case where we have less presents than kids
            if (presents <= 0) {
                break;
            }
            command = scanner.nextLine();
        }
        int niceKidsLeft = findNiceKids(neighbourhood);
        if (presents <= 0 && niceKidsLeft > 0) {
            System.out.println("Santa ran out of presents!");
        }
        printMatrix(neighbourhood);
        if (niceKidsLeft == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.%n", happyNiceKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.", niceKidsLeft);
        }
    }

    private static int findNiceKids(char[][] neighbourhood) {
        int niceKidsLeft = 0;
        for (int row = 0; row < neighbourhood.length; row++) {
            for (int col = 0; col < neighbourhood[row].length; col++) {
                if (neighbourhood[row][col] == 'V') {
                    niceKidsLeft += 1;
                }
            }
        }
        return niceKidsLeft;
    }

    private static void printMatrix(char[][] neighbourhood) {
        for (int row = 0; row < neighbourhood.length; row++) {
            for (int col = 0; col < neighbourhood[row].length; col++) {
                System.out.print(neighbourhood[row][col]);
            }
            System.out.print(" ");
            System.out.println();
        }
    }

    private static boolean moveSanta(int nextSantaRow, int nextSantaCol, char[][] neighbourhood) {
        if (neighbourhood[nextSantaRow][nextSantaCol] == 'V') {
            neighbourhood[nextSantaRow][nextSantaCol] = 'S';
            neighbourhood[santaRow][santaCol] = '-';
            presents -= 1;
            happyNiceKids += 1;
        } else if (neighbourhood[nextSantaRow][nextSantaCol] == 'X') {
            neighbourhood[nextSantaRow][nextSantaCol] = 'S';
            neighbourhood[santaRow][santaCol] = '-';
        } else if (neighbourhood[nextSantaRow][nextSantaCol] == 'C') {
            neighbourhood[nextSantaRow][nextSantaCol] = 'S';
            neighbourhood[santaRow][santaCol] = '-';
            santaRow = nextSantaRow;
            santaCol = nextSantaCol;
            eatCookies(santaRow - 1, santaRow + 1,
                    santaCol - 2, santaCol + 2, neighbourhood);
            return true;
        } else if (neighbourhood[nextSantaRow][nextSantaCol] == '-') {
            neighbourhood[nextSantaRow][nextSantaCol] = 'S';
            neighbourhood[santaRow][santaCol] = '-';
        }
        return false;
    }

    private static void eatCookies(int upperHouseRow, int downHouseRow, int leftHouseCol,
                                   int rightHouseCol, char[][] neighbourhood) {
        //TODO work the case where we have less presents than kids
        if (neighbourhood[upperHouseRow][santaCol] == 'V' || neighbourhood[upperHouseRow][santaCol] == 'X') {
            if (neighbourhood[upperHouseRow][santaCol] == 'V') {
                happyNiceKids += 1;
            }
            neighbourhood[upperHouseRow][santaCol] = '-';
            presents -= 1;
        }
        if (neighbourhood[downHouseRow][santaCol] == 'V' || neighbourhood[downHouseRow][santaCol] == 'X') {
            if (neighbourhood[downHouseRow][santaCol] == 'V') {
                happyNiceKids += 1;
            }
            neighbourhood[downHouseRow][santaCol] = '-';
            presents -= 1;
        }
        if (neighbourhood[santaRow][leftHouseCol] == 'V' || neighbourhood[santaRow][leftHouseCol] == 'X') {
            if (neighbourhood[santaRow][leftHouseCol] == 'V') {
                happyNiceKids += 1;
            }
            neighbourhood[santaRow][leftHouseCol] = '-';
            presents -= 1;
        }
        if (neighbourhood[santaRow][rightHouseCol] == 'V' || neighbourhood[santaRow][rightHouseCol] == 'X') {
            if (neighbourhood[santaRow][rightHouseCol] == 'V') {
                happyNiceKids += 1;
            }
            neighbourhood[santaRow][rightHouseCol] = '-';
            presents -= 1;
        }
    }
}
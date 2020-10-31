package AdvancedExam;

import java.util.LinkedList;
import java.util.Scanner;

public class Exam02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixInfo = scanner.nextLine().split("\\s+");
        int rowsInfo = Integer.parseInt(matrixInfo[0]);
        int colsInfo = Integer.parseInt(matrixInfo[1]);

        int[][] gardenField = new int[rowsInfo][colsInfo];

        for (int row = 0; row < rowsInfo; row++) {
            for (int col = 0; col < colsInfo; col++) {
                gardenField[row][col] = 0;
            }
        }
        String command = scanner.nextLine();
        LinkedList<String> flowersPositions = new LinkedList<>();
        while (!command.equals("Bloom Bloom Plow")) {
            String[] splitCommand = command.split("\\s+");
            int rowPlant = Integer.parseInt(splitCommand[0]);
            int colPlant = Integer.parseInt(splitCommand[1]);
            if (isInBounds(rowPlant, colPlant, gardenField)) {
                flowersPositions.add(command);
            } else {
                System.out.println("Invalid coordinates.");
            }
            command = scanner.nextLine();
        }
        while (!flowersPositions.isEmpty()) {
            bloomFlowers(flowersPositions, gardenField);
            flowersPositions.remove(0);
        }
        printMatrix(gardenField);
    }

    private static void printMatrix(int[][] gardenField) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < gardenField.length; row++) {
            for (int col = 0; col < gardenField[row].length; col++) {
                sb.append(gardenField[row][col]).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString().trim());
    }

    private static void bloomFlowers(LinkedList<String> flowersPositions, int[][] gardenField) {
        String currentCoordinates = flowersPositions.get(0);
        String[] splitCoordinates = currentCoordinates.split("\\s+");
        int flowersRow = Integer.parseInt(splitCoordinates[0]);
        int flowersCol = Integer.parseInt(splitCoordinates[1]);
        for (int row = 0; row < gardenField.length; row++) {
            for (int col = 0; col < gardenField[row].length; col++) {
                if (row == flowersRow || col == flowersCol) {
                    gardenField[row][col] += 1;
                }
            }
        }
    }

    private static boolean isInBounds(int rowPlant, int colPlant, int[][] gardenField) {
        return rowPlant >= 0 && rowPlant < gardenField.length &&
                colPlant >= 0 && colPlant < gardenField.length;
    }
}
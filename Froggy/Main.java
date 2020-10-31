package Froggy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] lakeStones = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        Lake lake = new Lake(lakeStones);
        String command = scanner.nextLine();
        if (command.equals("END")) {
            StringBuilder sb = new StringBuilder();
            for (Integer stone : lake) {
                sb.append(stone).append(", ");
            }
            System.out.println(sb.substring(0, sb.length() - 2));
        }
    }
}

package FuncionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvenOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String condition = scanner.nextLine();
        Predicate<Integer> evenOrOddNumber = testNumber(condition);

        for (int i = range[0]; i <= range[1]; i++) {
            if (evenOrOddNumber.test(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static Predicate<Integer> testNumber(String condition) {
        if (condition.equals("even")) {
            return n -> n % 2 == 0;
        }
        return n -> n % 2 != 0;
    }
}
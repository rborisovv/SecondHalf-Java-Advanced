package FuncionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IntPredicate isEvenNumber = num -> num % 2 == 0;
        int[] filteredNumbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(isEvenNumber)
                .toArray();
        StringBuilder sb = new StringBuilder();
        for (int filteredNumber : filteredNumbers) {
            sb.append(filteredNumber).append(", ");
        }
        System.out.println(sb.delete(sb.length() - 2, sb.length()));

        sb.setLength(0);
        filteredNumbers = Arrays.stream(filteredNumbers)
                .sorted().toArray();
        for (int number : filteredNumbers) {
            sb.append(number).append(", ");
        }
        System.out.println(sb.delete(sb.length() - 2, sb.length()));
    }
}
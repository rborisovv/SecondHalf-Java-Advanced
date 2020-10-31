package FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class listOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> collection = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        BiFunction<List<Integer>, Integer, Boolean> predicate = ((list, number) -> {
            for (Integer integer : list) {
                if (number % integer != 0) {
                    return false;
                }
            }
            return true;
        });
        for (int i = 1; i <= n; i++) {
            if (predicate.apply(collection,i)) {
                System.out.print(i + " ");
            }
        }

    }
}

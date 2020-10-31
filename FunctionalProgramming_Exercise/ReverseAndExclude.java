package FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> collection = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        Collections.reverse(collection);
        Predicate<Integer> predicate = num -> num % n == 0;
        collection.removeIf(predicate);
        collection.forEach(e -> System.out.print(e + " "));
    }
}
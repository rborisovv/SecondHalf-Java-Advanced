package FunctionalProgramming_Exercise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> collection = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        Function<List<Integer>, Integer> findIndex = list -> {
            int min = Collections.min(collection);
            return collection.lastIndexOf(min);
        };
        System.out.println(findIndex.apply(collection));
    }
}

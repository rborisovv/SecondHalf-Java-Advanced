package FuncionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] count = new int[1];
        AtomicInteger sum = new AtomicInteger();
        Function<String, Integer> parseInteger = Integer::parseInt;

        Arrays.stream(scanner.nextLine().split(", "))
                .map(parseInteger)
                .forEach(e -> {
                    count[0]++;
                    sum.addAndGet(e);
                });
        System.out.println("Count =" + " " + count[0]);
        System.out.println("Sum =" + " " + sum.get());
    }
}
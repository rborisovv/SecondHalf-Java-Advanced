package FuncionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> collection = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Prices with VAT:");
        UnaryOperator<Double> priceWithVet = num -> num = num * 1.20;
        for (Double price : collection) {
            System.out.printf("%.2f%n", priceWithVet.apply(price));
        }
    }
}
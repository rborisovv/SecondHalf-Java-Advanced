package GenericCount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Elements<Double> elements = new Elements<>();
        int numberOfLines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfLines; i++) {
            elements.add(Double.valueOf(scanner.nextLine()));
        }
        Double element = Double.parseDouble(scanner.nextLine());
        System.out.println(elements.compareTo(element));
    }
}

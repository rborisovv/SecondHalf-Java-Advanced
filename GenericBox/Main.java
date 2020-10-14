package GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(scanner.nextLine());
        Box<Integer> box = new Box<>();
        for (int i = 0; i < numberOfLines; i++) {
            box.add(Integer.parseInt(scanner.nextLine()));
        }
        System.out.println(box.toString());
    }
}
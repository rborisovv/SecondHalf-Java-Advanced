package GenericSwap;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());
        Box<Integer> box = new Box<>();
        for (int i = 0; i < numberOfLines; i++) {
            String element = scanner.nextLine();
            box.add(Integer.valueOf(element));
        }
        int[] indexes = Arrays.stream
                (scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        box.swap(indexes[0], indexes[1]);
        System.out.println(box);
    }
}
package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> list = new ArrayList<>();
        while (!input.equals("END")) {
            list.add(input);
            input = scanner.nextLine();
        }
        int n = Integer.parseInt(scanner.nextLine());
        String person = list.get(n - 1);
        list.remove(n - 1);

        int equalCount = 1;
        for (String current : list) {
            if (current.equals(person)) {
                equalCount++;
            }
        }
        int numberOfNotEqualCount = list.size() - equalCount + 1;
        if (equalCount == 1) {
            System.out.println("No matches");
        } else {
            System.out.println(String.format("%d %d %d", equalCount , numberOfNotEqualCount, list.size() + 1));
        }
    }
}
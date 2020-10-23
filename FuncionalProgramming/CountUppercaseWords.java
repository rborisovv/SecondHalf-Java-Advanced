package FuncionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> isUpperCase = e -> Character.isUpperCase(e.charAt(0));
        String[] text = scanner.nextLine().split("\\s+");
        List<String> upperCaseWords = new ArrayList<>();
        for (String word : text) {
            if (isUpperCase.test(word)) {
                upperCaseWords.add(word);
            }
        }
        System.out.println(upperCaseWords.size());
        for (String upperCaseWord : upperCaseWords) {
            System.out.println(upperCaseWord);
        }
    }
}
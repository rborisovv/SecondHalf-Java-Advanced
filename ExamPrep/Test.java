package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] stackInputLineNumbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> stackLilies = new ArrayDeque<>();
        for (int stackInputLineNumber : stackInputLineNumbers) {
            stackLilies.push(stackInputLineNumber);
        }
        ArrayDeque<Integer> queueRoses = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));
        int wreathsCount = 0;
        int storedFlowers = 0;
        while (stackLilies.size() > 0 && queueRoses.size() > 0) {
            int rose = queueRoses.peek();
            int lilly = stackLilies.peek();
            int sum = rose + lilly;
            if (sum == 15) {
                queueRoses.pop();
                stackLilies.poll();
                wreathsCount += 1;
            } else if (sum > 15) {
                lilly -= 2;
                stackLilies.pop();
                stackLilies.push(lilly);
            } else {
                storedFlowers += (rose + lilly);
                stackLilies.pop();
                queueRoses.poll();
            }
        }
        while (storedFlowers >= 15) {
            wreathsCount += 1;
            storedFlowers -= 15;
        }
        if (wreathsCount >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreathsCount);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreathsCount);
        }
    }
}
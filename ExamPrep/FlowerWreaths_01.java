package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class FlowerWreaths_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] lillies = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int[] roses = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stackLillies = new ArrayDeque<>();
        ArrayDeque<Integer> queueRoses = new ArrayDeque<>();

        for (int lilly : lillies) {
            stackLillies.push(lilly);
        }
        for (int rose : roses) {
            queueRoses.offer(rose);
        }
        int wreathsCount = 0;
        ArrayDeque<Integer> storedLilliesStack = new ArrayDeque<>();
        ArrayDeque<Integer> storedRosesDeque = new ArrayDeque<>();
        while (stackLillies.size() > 0 && queueRoses.size() > 0) {
            int currentLillies = stackLillies.peek();
            int currentRoses = queueRoses.peek();
            if (currentLillies + currentRoses == 15) {
                wreathsCount++;
                stackLillies.pop();
                queueRoses.poll();
            } else if (currentLillies + currentRoses > 15) {
                while (currentLillies + currentRoses > 15) {
                    currentLillies -= 2;
                }
                wreathsCount++;
                stackLillies.pop();
                queueRoses.poll();
            } else if (currentLillies + currentRoses < 15) {
                storedLilliesStack.push(stackLillies.pop());
                storedRosesDeque.offer(Objects.requireNonNull(queueRoses.poll()));
            }
        }
        int resultFromStock = 0;
        while (storedLilliesStack.size() > 0 && storedRosesDeque.size() > 0) {
            resultFromStock += storedLilliesStack.pop() + storedRosesDeque.poll();
            if (resultFromStock >= 15) {
                resultFromStock -= 15;
                wreathsCount++;
            }
        }
        if (wreathsCount >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreathsCount);
        } else {
            int neededWreaths = 5 - wreathsCount;
            System.out.printf("You didn't make it, you need %d wreaths more!", neededWreaths);
        }
    }
}
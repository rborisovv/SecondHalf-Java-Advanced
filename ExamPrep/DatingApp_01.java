package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stackElements = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        for (String stackElement : stackElements) {
            malesStack.push(Integer.parseInt(stackElement));
        }
        ArrayDeque<Integer> femaleQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));
        int matchedCouples = 0;
        while (malesStack.size() > 0 && femaleQueue.size() > 0) {
            int stackElement = malesStack.peek();
            int queueElement = femaleQueue.peek();
            if (stackElement <= 0 || queueElement <= 0) {
                if (stackElement <= 0) {
                    malesStack.pop();
                } else {
                    femaleQueue.poll();
                }
                continue;
            }
            if (stackElement % 25 == 0 || queueElement % 25 == 0) {
                if (stackElement % 25 == 0) {
                    malesStack.pop();
                    malesStack.pop();
                } else {
                    femaleQueue.poll();
                    femaleQueue.poll();
                }
                continue;
            }
            if (stackElement == queueElement) {
                matchedCouples += 1;
                malesStack.pop();
                femaleQueue.poll();
            } else {
                femaleQueue.poll();
                stackElement -= 2;
                malesStack.pop();
                malesStack.push(stackElement);
            }
        }
        System.out.println("Matches: " + matchedCouples);
        if (malesStack.size() > 0) {
            System.out.print("Males left: ");
            StringBuilder sb = new StringBuilder();
            for (Integer male : malesStack) {
                sb.append(male).append(", ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            System.out.print(sb);
            System.out.println();
        } else {
            System.out.println("Males left: none");
        }
        if (femaleQueue.size() > 0) {
            System.out.print("Females left: ");
            StringBuilder sb = new StringBuilder();
            for (Integer female : femaleQueue) {
                sb.append(female).append(", ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        } else {
            System.out.println("Females left: none");
        }
    }
}

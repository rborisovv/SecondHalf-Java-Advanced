package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LootBox_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> firstLootBoxQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> secondLootBoxStack = new ArrayDeque<>();

        int[] secondInputLine = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int item : secondInputLine) {
            secondLootBoxStack.push(item);
        }
        int obtainedValue = 0;
        while (firstLootBoxQueue.size() != 0 && secondLootBoxStack.size() != 0) {
            int queueElement = firstLootBoxQueue.peek();
            int stackElement = secondLootBoxStack.pop();
            int sum = queueElement + stackElement;

            if (sum % 2 == 0) {
                obtainedValue += sum;
                firstLootBoxQueue.poll();
            } else {
                firstLootBoxQueue.offer(stackElement);
            }
        }
        if (firstLootBoxQueue.size() == 0) {
            System.out.println("First lootbox is empty");
        }
        if (secondLootBoxStack.size() == 0) {
            System.out.println("Second lootbox is empty");
        }
        if (obtainedValue >= 100) {
            System.out.printf("Your loot was epic! Value: %d%n",obtainedValue);
        } else {
            System.out.printf("Your loot was poor... Value: %d",obtainedValue);
        }
    }
}
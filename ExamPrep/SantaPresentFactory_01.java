package ExamPrep;

import java.util.*;

public class SantaPresentFactory_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stackItems = scanner.nextLine().split("\\s+");
        String[] queueItems = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        ArrayDeque<Integer> magicsQueue = new ArrayDeque<>();

        for (String material : stackItems) {
            materialsStack.push(Integer.parseInt(material));
        }
        for (String queueItem : queueItems) {
            magicsQueue.offer(Integer.parseInt(queueItem));
        }
        int dollCounter = 0;
        int woodenTrainCounter = 0;
        int teddyBearCounter = 0;
        int bicycleCounter = 0;
        while (materialsStack.size() > 0 && magicsQueue.size() > 0) {
            int material = materialsStack.peek();
            int magic = magicsQueue.peek();
            int totalMagicLvlSum = material * magic;
            if (totalMagicLvlSum == 150) {
                dollCounter++;
                materialsStack.pop();
                magicsQueue.poll();
            } else if (totalMagicLvlSum == 250) {
                woodenTrainCounter++;
                materialsStack.pop();
                magicsQueue.poll();
            } else if (totalMagicLvlSum == 300) {
                teddyBearCounter++;
                materialsStack.pop();
                magicsQueue.poll();
            } else if (totalMagicLvlSum == 400) {
                bicycleCounter++;
                materialsStack.pop();
                magicsQueue.poll();
            } else if (totalMagicLvlSum < 0) {
                int sum = material + magic;
                materialsStack.pop();
                magicsQueue.poll();
                materialsStack.push(sum);
            } else if (totalMagicLvlSum > 0) {
                magicsQueue.poll();
                materialsStack.pop();
                material += 15;
                materialsStack.push(material);
            } else if (material == 0 || magic == 0) {
                if (material == 0) {
                    materialsStack.pop();
                }
                if (magic == 0) {
                    magicsQueue.poll();
                }
            }
        }
        if (dollCounter > 0 && woodenTrainCounter > 0) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else if (teddyBearCounter > 0 && bicycleCounter > 0) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if (materialsStack.size() > 0) {
            System.out.print("Materials left: ");
            StringBuilder sb = new StringBuilder();
            for (Integer material : materialsStack) {
                sb.append(material).append(", ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        }
        if (magicsQueue.size() > 0) {
            System.out.print("Magic left: ");
            StringBuilder sb = new StringBuilder();
            for (Integer magic : magicsQueue) {
                sb.append(magic).append(", ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        }
        if (bicycleCounter > 0) {
            System.out.println("Bicycle: " + bicycleCounter);
        }
        if (dollCounter > 0) {
            System.out.println("Doll: " + dollCounter);
        }
        if (teddyBearCounter > 0) {
            System.out.println("Teddy bear: " + teddyBearCounter);
        }
        if (woodenTrainCounter > 0) {
            System.out.println("Wooden train: " + woodenTrainCounter);
        }
    }
}
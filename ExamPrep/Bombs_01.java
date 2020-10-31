package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bombs_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] bombEffects = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] bombCasings = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> bombEffectsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasingsStack = new ArrayDeque<>();
        for (int bombEffect : bombEffects) {
            bombEffectsQueue.offer(bombEffect);
        }
        for (Integer bombCasing : bombCasings) {
            bombCasingsStack.push(bombCasing);
        }
        int bombPouch = 0; // MUST BE 9
        int DaturaBombsCount = 0;
        int CherryBombsCount = 0;
        int SmokeDecoyBombsCount = 0;
        boolean isSuccessfullyFilled = false;
        while (bombEffectsQueue.size() != 0 && bombCasingsStack.size() != 0) {
            int currentBombMix = bombEffectsQueue.peek() + bombCasingsStack.peek();
            switch (currentBombMix) {
                case 40: //Datura Bombs
                    DaturaBombsCount += 1;
                    bombEffectsQueue.poll();
                    bombCasingsStack.pop();
                    bombPouch++;
                    break;
                case 60: //Cherry Bombs
                    CherryBombsCount += 1;
                    bombEffectsQueue.poll();
                    bombCasingsStack.pop();
                    bombPouch++;
                    break;
                case 120://Smoke Decoy Bombs
                    SmokeDecoyBombsCount += 1;
                    bombEffectsQueue.poll();
                    bombCasingsStack.pop();
                    bombPouch++;
                    break;
                default:
                    int queuePoll = bombEffectsQueue.poll();
                    int stackPop = bombCasingsStack.pop();
                    currentBombMix = queuePoll + stackPop;
                    while (currentBombMix != 40 && currentBombMix != 60 && currentBombMix != 120) {
                        currentBombMix = queuePoll + (stackPop -= 5);
                    }
                    if (currentBombMix == 40) {
                        DaturaBombsCount++;
                        bombPouch++;
                    } else if (currentBombMix == 60) {
                        CherryBombsCount++;
                        bombPouch++;
                    } else {
                        SmokeDecoyBombsCount++;
                        bombPouch++;
                    }
                    break;
            }
            if (DaturaBombsCount >= 3 && CherryBombsCount >= 3 && SmokeDecoyBombsCount >= 3) {
                isSuccessfullyFilled = true;
                break;
            }
        }
        if (isSuccessfullyFilled) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (!bombEffectsQueue.isEmpty()) {
            System.out.print("Bomb Effects: ");
            while (bombEffectsQueue.size() - 1 != 0) {
                System.out.print(bombEffectsQueue.poll() + ", ");
            }
            System.out.println(bombEffectsQueue.poll());
        } else {
            System.out.println("Bomb Effects: empty");
        }
        if (!bombCasingsStack.isEmpty()) {
            System.out.print("Bomb Casings: ");
            while (bombCasingsStack.size() - 1 != 0) {
                System.out.print(bombCasingsStack.pop() + ", ");
            }
            System.out.println(bombCasingsStack.pop());
        } else {
            System.out.println("Bomb Casings: empty");
        }
        System.out.printf("Cherry Bombs: %d%n", CherryBombsCount);
        System.out.printf("Datura Bombs: %d%n", DaturaBombsCount);
        System.out.printf("Smoke Decoy Bombs: %d%n", SmokeDecoyBombsCount);
    }
}
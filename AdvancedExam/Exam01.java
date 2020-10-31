package AdvancedExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exam01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLineTasks = scanner.nextLine().split(", ");
        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        for (String firstLineTask : firstLineTasks) {
            tasksStack.push(Integer.parseInt(firstLineTask));
        }
        ArrayDeque<Integer> threadsQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));
        int taskToBeKilled = Integer.parseInt(scanner.nextLine());
        int lastTask = 0;
        int lastThread = 0;
        while (tasksStack.size() != 0 && threadsQueue.size() != 0) {//TODO check that
            int task = tasksStack.peek();
            int thread = threadsQueue.peek();
            if (task == taskToBeKilled) {
                lastTask = task;
                lastThread = thread;
                break;
            }
            if (thread >= task) {
                tasksStack.pop();
                threadsQueue.poll();
            } else {
                threadsQueue.poll();
            }
        }
        System.out.printf("Thread with value %d killed task %d%n",lastThread,lastTask);
        while (!threadsQueue.isEmpty()) {
            System.out.print(threadsQueue.poll() + " ");
        }
    }
}
package CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> customList = new CustomList<String>();
        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("END")) {
            String element;
            int index;
            switch (command[0]) {
                case "Add":
                    element = command[1];
                    customList.add(element);
                    break;
                case "Remove":
                    index = Integer.parseInt(command[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    element = command[1];
                    System.out.println(customList.contains(element));
                    break;
                case "Swap":
                    index = Integer.parseInt(command[1]);
                    int secondIndex = Integer.parseInt(command[2]);
                    customList.swap(index, secondIndex);
                    break;
                case "Greater":
                    element = command[1];
                    System.out.println(customList.greaterThan(element));
                    break;
                case "Max":
                    System.out.println(customList.maxElement());
                    break;
                case "Min":
                    System.out.println(customList.minElement());
                    break;
                case "Print":
                    System.out.print(customList.toString());
                    break;
                case "Sort":
                    customList.sort();
                    break;
            }
            command = scanner.nextLine().split("\\s+");
        }
    }
}
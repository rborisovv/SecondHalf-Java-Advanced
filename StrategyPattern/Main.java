package StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeSet<Person> nameComparatorTreeSet = new TreeSet<>(new NameComparator());
        TreeSet<Person> ageComparatorTreeSet = new TreeSet<>(new AgeComparator());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            nameComparatorTreeSet.add(person);
            ageComparatorTreeSet.add(person);
        }
        for (Person person : nameComparatorTreeSet) {
            System.out.println(person);
        }
        for (Person person : ageComparatorTreeSet) {
            System.out.println(person);
        }
    }
}

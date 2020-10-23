package FuncionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterByAge {
    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();
        while (n-- != 0) {
            String[] tokens = scanner.nextLine().split(", ");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            people.add(person);
        }
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String printCondition = scanner.nextLine();
        Predicate<Person> tester = createTester(condition, age);
        Function<Person, String> printer = createPrinter(printCondition);
        people.stream().filter(tester).forEach(e -> System.out.println(printer.apply(e)));
    }

    private static Function<Person, String> createPrinter(String printCondition) {
        switch (printCondition) {
            case "name":
                return p -> p.name;
            case "age":
                return p -> String.valueOf(p.age);
        }
        return p -> p.name + " - " + p.age;
    }

    private static Predicate<Person> createTester(String condition, int age) {
        Predicate<Person> tester;
        if (condition.equals("younger")) {
            tester = e -> e.age <= age;
        } else {
            tester = e -> e.age >= age;
        }
        return tester;
    }
}
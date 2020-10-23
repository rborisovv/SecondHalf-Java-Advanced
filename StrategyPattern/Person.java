package StrategyPattern;

import java.util.Comparator;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person other) {
        int result = this.getName().length() - other.getName().length();
        if (result == 0) {
            String firstName = String.valueOf(this.getName().toLowerCase().charAt(0));
            String secondName = String.valueOf(other.getName().toLowerCase().charAt(0));
            result = firstName.compareTo(secondName);
            return result;
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.name, this.age);
    }
}
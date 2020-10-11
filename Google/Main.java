package Google;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        HashMap<String, Person> people = new HashMap<>();
        while (!tokens[0].equals("End")) {
            String name = tokens[0];
            Person person;
            if (!people.containsKey(name)) {
                person = new Person();
                people.put(name, person);
            }
            switch (tokens[1]) {
                case "company":
                    Company company = new Company(tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                    people.get(name).setCompany(company);
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(tokens[2], tokens[3]);
                    people.get(name).getPokemonList().add(pokemon);
                    break;
                case "parents":
                    Parents parents = new Parents(tokens[2], tokens[3]);
                    people.get(name).getParentsList().add(parents);
                    break;
                case "children":
                    Children children = new Children(tokens[2], tokens[3]);
                    people.get(name).getChildrenList().add(children);
                    break;
                case "car":
                    Car car = new Car(tokens[2], Integer.parseInt(tokens[3]));
                    people.get(name).setCar(car);
                    break;
            }
            tokens = scanner.nextLine().split("\\s+");
        }
        String name = scanner.nextLine();
        for (String person : people.keySet()) {
            if (name.equals(person)) {
                System.out.println(name);
                System.out.println("Company:");
                if (people.get(name).getCompany() != null) {
                    System.out.println(people.get(name).getCompany().toString());
                }
                System.out.println("Car:");
                if (people.get(name).getCar() != null) {
                    System.out.print(people.get(name).getCar().toString());
                }
                System.out.println("Pokemon:");
                if (people.get(name).getPokemonList() != null) {
                    people.get(name).getPokemonList().stream().forEach(p -> {
                        System.out.println(String.format("%s %s", p.getPokemonName(), p.getPokemonType()));
                    });
                }
                System.out.println("Parents:");
                if (people.get(name).getParentsList() != null) {
                    people.get(name).getParentsList().stream().forEach(p -> {
                        System.out.println(String.format("%s %s", p.getParentName(), p.getParentBirthday()));
                    });
                }
                System.out.println("Children:");
                if (people.get(name).getChildrenList() != null) {
                    people.get(name).getChildrenList().stream().forEach(children -> {
                        System.out.println(String.format("%s %s", children.getChildName(), children.getChildBirthday()));
                    });
                }
            }
        }
    }
}
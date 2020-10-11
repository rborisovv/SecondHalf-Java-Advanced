package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    Company company;
    Car car;
    private List<Pokemon> pokemonList = new ArrayList<>();
    private List<Parents> parentsList = new ArrayList<>();
    private List<Children> childrenList = new ArrayList<>();

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public List<Parents> getParentsList() {
        return parentsList;
    }

    public List<Children> getChildrenList() {
        return childrenList;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }
}
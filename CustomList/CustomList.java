package CustomList;

import java.util.*;

public class CustomList<T extends Comparable<T>> {
    private final List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public void remove(int index) {
        list.remove(index);
    }

    public boolean contains(T element) {
        return list.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(this.list, firstIndex, secondIndex);
    }

    public int greaterThan(T element) {
        return (int) this.list
                .stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
    }

    public T maxElement() {
        T maximumElement = this.list.get(0);
        return this.list.stream().max(Comparable::compareTo).get();
    }

    public T minElement() {
        T minElement = this.list.get(0);
        return this.list.stream().min(Comparable::compareTo).get();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : this.list) {
            sb.append(element).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void sort() {
        Collections.sort(this.list);
    }
}
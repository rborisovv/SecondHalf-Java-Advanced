package GenericSwap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<E> {
    private final List<E> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void add(E element) {
        this.list.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(this.list, firstIndex, secondIndex);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E element : list) {
            sb.append(String.format("%s: %s", element.getClass().getName(), element)).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
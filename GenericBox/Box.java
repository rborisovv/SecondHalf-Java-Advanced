package GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<E> {
    List<E> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(E element) {
        this.elements.add(element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E element : elements) {
            sb.append(element.getClass().getName()).append(": ")
                    .append(element).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
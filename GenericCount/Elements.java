package GenericCount;

import java.util.ArrayList;
import java.util.List;

public class Elements<E extends Comparable<E>> {
    private List<E> list;

    public Elements() {
        this.list = new ArrayList<>();
    }

    public void add(E element) {
        this.list.add(element);
    }

    public int compareTo(E element) {
        return (int) this.list
                .stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
    }
}

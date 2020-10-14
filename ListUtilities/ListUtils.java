package ListUtilities;

import java.util.Comparator;
import java.util.List;

public class ListUtils {

    public static <E extends Comparable<E>> E getMin(List<E> list) {
        return list
                .stream()
                .min(Comparator.naturalOrder())
                .orElseThrow(IllegalArgumentException::new);
    }
    public static <E extends Comparable<E>> E getMax(List<E> list) {
        return list
                .stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(IllegalArgumentException::new);
    }
}
package ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        Collections.addAll(integerList, 10, 2, 3, 5, -1,0);
        Integer maxInteger = ListUtils.getMax(integerList);

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "a", "b", "c","d");
        String minString = ListUtils.getMin(strings);
        System.out.println(minString);
        System.out.println(maxInteger);
    }
}

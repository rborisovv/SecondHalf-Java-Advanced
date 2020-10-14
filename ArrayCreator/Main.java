package ArrayCreator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(ArrayCreator.create(10, "10")));
        String[] strings = ArrayCreator.create(String.class, 10, "0");
    }
}
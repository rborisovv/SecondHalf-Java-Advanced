package ArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {

    @SuppressWarnings("unchecked")
    public static <E> E[] create(int length, E item) {
        return (E[]) Array.newInstance(item.getClass(), length);
    }
    @SuppressWarnings("unchecked")
    public static <E> E[] create(Class<E> clazz, int length,E item) {
        return (E[]) Array.newInstance(clazz, length, 0);
    }
}
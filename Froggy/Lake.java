package Froggy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private int[] lakeStones;

    public Lake(int[] stones) {
        this.lakeStones = stones;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int index = 0;
            private int lastEvenIndex = lakeStones.length % 2 == 0 ?
                    lakeStones.length - 2 : lakeStones.length - 1;

            @Override
            public boolean hasNext() {
                return index < lakeStones.length;
            }

            @Override
            public Integer next() {
                if (this.index == lastEvenIndex) {
                    int element = lakeStones[index];
                    this.index = 1;
                    return element;
                }
                int element = lakeStones[index];
                this.index += 2;
                return element;
            }
        };
    }
}
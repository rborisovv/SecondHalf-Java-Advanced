import java.util.function.Consumer;

public class SmartArray {
    private static final int Initial_Capacity = 4;
    private int size;
    private int[] elements;

    public SmartArray() {
        this.elements = new int[Initial_Capacity];
        this.size = 0;
    }

    public void add(int element) {
        if (this.size == this.elements.length) {
            this.elements = grow();
        }
        this.elements[this.size] = element;
        this.size++;
    }

    private int[] grow() {
        int[] newElements = new int[this.elements.length * 2];
        System.arraycopy(this.elements, 0, newElements, 0, this.elements.length);
        return newElements;
    }

    public int getElement(int index) {
        validateIndex(index);
        return this.elements[index];
    }

    public int removeIndex(int index) {
        int element = this.elements[index];
        if (this.size - 1 - index >= 0)
            System.arraycopy(this.elements, index + 1, this.elements, index, this.size - 1 - index);
        this.elements[this.size - 1] = 0;
        this.size--;
        if (this.elements.length > 4 && this.size == this.elements.length / 2) {
            this.elements = shrink();
        }
        return element;
    }

    private int[] shrink() {
        int[] newElements = new int[this.elements.length / 2];
        System.arraycopy(this.elements, 0, newElements, 0, newElements.length);
        return newElements;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void add(int index, int element) {
        validateIndex(index);
        int lastElement = this.elements[this.size - 1];
        if (this.size - 1 - index >= 0)
            System.arraycopy(this.elements, index, this.elements, index + 1, this.size - 1 - index);
        this.elements[index] = element;
        this.add(lastElement);
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.elements[i]);
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index " + index +
                    " out of bounds" + " for size " + this.size);
        }
    }
}
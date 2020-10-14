package GenericScale;

public class Scale<E extends Comparable<E>> {
    private E left;
    private E right;

    public Scale(E left, E right) {
        this.left = left;
        this.right = right;
    }

    public E getHeavier() {
        if (this.left.compareTo(this.right) > 0) {
            return this.left;
        } else if (this.left.compareTo(this.right) < 0) {
            return this.right;
        } else {
            return null;
        }
    }
}
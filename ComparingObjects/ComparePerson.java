package ComparingObjects;

public class ComparePerson implements Comparable<ComparePerson> {
    private String name;
    private int age;
    private String town;

    @Override
    public int compareTo(ComparePerson other) {
        int result = this.name.compareTo(other.name);
        if (result == 0) {
            result = Integer.compare(this.age, other.age);
            if (result == 0) {
                result = this.town.compareTo(other.town);
            }
        }
        return result;
    }
}

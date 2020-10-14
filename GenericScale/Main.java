package GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> scale = new Scale<>(60,80);
        System.out.println(scale.getHeavier());
    }
}
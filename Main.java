import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SmartArray smartArray = new SmartArray();
        for (int i = 1; i <= 8; i++) {
            smartArray.add(i);
        }
        smartArray.add(1, 6);
    }
}
package JarOfElements;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> jarOne = new Jar<>();
        Jar<String> jarTwo = new Jar<>();
        jarOne.add(10);
        jarTwo.add("10");
        System.out.println(jarOne.remove());
        System.out.println(jarTwo.remove());
    }
}
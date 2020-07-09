import java.util.Scanner;

class Main {
    private final static double g = 9.8;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final double p = scanner.nextDouble();
        final double h = scanner.nextDouble();

        System.out.println(p*g*h);
    }
}
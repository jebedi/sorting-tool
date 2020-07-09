import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double distance = scanner.nextDouble();
        double averageHours = scanner.nextDouble();
        System.out.println(distance/averageHours);
    }
}
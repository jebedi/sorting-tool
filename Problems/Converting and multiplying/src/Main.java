import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = -1;
        do {
            String number = scanner.next();
            try {
                i = Integer.parseInt(number);
                if (i == 0) break;
                System.out.println(i * 10);
            } catch (Exception e) {
                System.out.println("Invalid user input: " + number);
            }
        } while (true);
    }
}
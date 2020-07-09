import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        int length = text.length();
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            int midpoint = length / 2; //2
            if (length % 2 == 0) {
                if (i == midpoint || i == midpoint - 1) {
                    System.out.print("");
                } else {
                    System.out.print(ch);
                }
            } else {
                if (i != midpoint) {
                    System.out.print(ch);
                }
            }
        }
    }
}
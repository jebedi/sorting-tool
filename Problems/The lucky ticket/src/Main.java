import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();
        int sumStart = 0;
        int sumEnd = 0;

        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            int numericValue = Character.getNumericValue(ch);
            if (i < 3) {
                sumStart += numericValue;
            } else {
                sumEnd += numericValue;
            }
        }

        if (sumStart == sumEnd) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
    }
}
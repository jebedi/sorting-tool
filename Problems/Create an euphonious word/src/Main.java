import java.util.*;

public class Main {
    public static final List<Character> VOWELS = List.of('a', 'e', 'i', 'o', 'u', 'y');

    public static void main(String[] args) {
        int vowelsInserted = 0;
        int consonantsInserted = 0;

        Scanner scanner = new Scanner(System.in);

        String text = scanner.next();

        int vowelsInOrder = 0;
        int consonantsInOrder = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (VOWELS.contains(ch)) {
                vowelsInOrder++;
                consonantsInOrder = 0;
            } else {
                consonantsInOrder++;
                vowelsInOrder = 0;
            }

            if (vowelsInOrder == 3) {
                vowelsInserted++;
                vowelsInOrder = 1;
            } else if (consonantsInOrder == 3) {
                consonantsInserted++;
                consonantsInOrder = 1;
            }
        }

        System.out.println(vowelsInserted + consonantsInserted);
    }
}
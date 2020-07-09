import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> availableWords = new HashMap<>();
        Arrays.stream(scanner.nextLine().split(" ")).forEach(word -> {
            if (availableWords.containsKey(word)) {
                availableWords.put(word, availableWords.get(word) + 1);
            } else {
                availableWords.put(word, 1);
            }
        });

        boolean success = true;
        for (String word : scanner.nextLine().split(" ")) {
            if (availableWords.containsKey(word) && availableWords.get(word) > 0) {
                availableWords.put(word, availableWords.get(word) - 1);
            } else {
                success = false;
                break;
            }
        }

        if (success) {
            System.out.println("You get money");
        } else {
            System.out.println("You are busted");
        }

    }
}
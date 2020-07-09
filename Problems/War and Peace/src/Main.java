import java.util.*;

class Main {
    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        Arrays.stream(scanner.nextLine()
                .split(" "))
                .forEach(word -> {
                    String checkedWord = word.toLowerCase();
                    if (wordCount.containsKey(checkedWord)) {
                        wordCount.put(checkedWord, wordCount.get(checkedWord) + 1);
                    } else {
                        wordCount.put(checkedWord, 1);
                    }
                });
        new TreeMap<>(wordCount).forEach((k, v) -> System.out.println(k + " " + v));
    }
}
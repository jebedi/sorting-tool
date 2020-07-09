package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static sorting.DataType.*;

enum DataType {
    LONG {
        @Override
        void processSortingNatural(Scanner scanner, String inputType, String outputType) {
            List<Long> list = new ArrayList<>();
            scanner = getScanner(scanner, inputType);

            while (scanner.hasNext()) {
                list.add(scanner.nextLong());
            }
            scanner.close();

            if (outputType != null) {
                try (FileWriter fileWriter = new FileWriter(outputType);) {
                    fileWriter.write("Total numbers: " + list.size());
                    String result = list.stream()
                            .sorted(Comparator.naturalOrder())
                            .map(Object::toString)
                            .reduce((s1, s2) -> s1 + " " + s2)
                            .orElse("");
                    fileWriter.write("Sorted data: " + result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Total numbers: " + list.size());
                String result = list.stream()
                        .sorted(Comparator.naturalOrder())
                        .map(Object::toString)
                        .reduce((s1, s2) -> s1 + " " + s2)
                        .orElse("");
                System.out.println("Sorted data: " + result);
            }
        }

        void processSortingByCount(Scanner scanner, String inputType, String outputType) {
            Map<Integer, Integer> counter = new HashMap<>();
            scanner = getScanner(scanner, inputType);

            while (scanner.hasNext()) {
                Integer number = scanner.nextInt();
                if (counter.containsKey(number)) {
                    counter.put(number, counter.get(number) + 1);
                } else {
                    counter.put(number, 1);
                }
            }
            scanner.close();

            int howManyEntries = counter.values().stream().reduce(Integer::sum).orElse(0);

            if (outputType != null) {
                try (FileWriter fileWriter = new FileWriter(outputType)) {
                    Comparator<Map.Entry<Integer, Integer>> byValue = Map.Entry.comparingByValue();
                    Comparator<Map.Entry<Integer, Integer>> byKey = Map.Entry.comparingByKey();

                    counter.entrySet().stream()
                            .sorted(byValue.thenComparing(byKey))
                            .forEach((e -> {
                                Integer key = e.getKey();
                                Integer value = e.getValue();
                                try {
                                    fileWriter.write(key + ": " + value + " time(s)," + (int) (100 * ((double) value / howManyEntries)) + "%");
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }
                            }));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Total numbers: " + howManyEntries);
                Comparator<Map.Entry<Integer, Integer>> byValue = Map.Entry.comparingByValue();
                Comparator<Map.Entry<Integer, Integer>> byKey = Map.Entry.comparingByKey();

                counter.entrySet().stream()
                        .sorted(byValue.thenComparing(byKey))
                        .forEach((e -> {
                            Integer key = e.getKey();
                            Integer value = e.getValue();
                            System.out.println(key + ": " + value + " time(s)," + (int) (100 * ((double) value / howManyEntries)) + "%");
                        }));
            }

        }
    }, LINE {
        @Override
        void processSortingNatural(Scanner scanner, String inputType, String outputType) {
            List<String> list = new ArrayList<>();
            scanner = getScanner(scanner, inputType);

            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
            }
            scanner.close();


            if (outputType != null) {
                try (FileWriter fileWriter = new FileWriter(outputType);) {
                    fileWriter.write("Total words: " + list.size());
                    String result = list.stream()
                            .sorted(Comparator.naturalOrder())
                            .map(Object::toString)
                            .reduce((s1, s2) -> s1 + " " + s2)
                            .orElse("");
                    fileWriter.write("Sorted data: " + result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Total words: " + list.size());
                String result = list.stream()
                        .sorted(Comparator.naturalOrder())
                        .map(Object::toString)
                        .reduce((s1, s2) -> s1 + " " + s2)
                        .orElse("");
                System.out.println("Sorted data: " + result);
            }
        }

        void processSortingByCount(Scanner scanner, String inputType, String outputType) {
            Map<String, Integer> counter = new HashMap<>();
            scanner = getScanner(scanner, inputType);

            while (scanner.hasNext()) {
                String word = scanner.nextLine();
                if (counter.containsKey(word)) {
                    counter.put(word, counter.get(word) + 1);
                } else {
                    counter.put(word, 1);
                }
            }
            scanner.close();

            Map<String, Integer> counterMap = new TreeMap<>(counter);
            int howManyEntries = counterMap.values().stream().reduce(Integer::sum).orElse(0);

            if (outputType != null) {
                try (FileWriter fileWriter = new FileWriter(outputType)) {
                    fileWriter.write("Total words: " + howManyEntries);
                    Comparator<Map.Entry<String, Integer>> byValue = Map.Entry.comparingByValue();
                    Comparator<Map.Entry<String, Integer>> byKey = Map.Entry.comparingByKey();

                    counter.entrySet().stream()
                            .sorted(byValue.thenComparing(byKey))
                            .forEach((e -> {
                                String key = e.getKey();
                                Integer value = e.getValue();
                                try {
                                    fileWriter.write(key + ": " + value + " time(s)," + (int) (100 * ((double) value / howManyEntries)) + "%");
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }
                            }));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Total words: " + howManyEntries);
                Comparator<Map.Entry<String, Integer>> byValue = Map.Entry.comparingByValue();
                Comparator<Map.Entry<String, Integer>> byKey = Map.Entry.comparingByKey();

                counter.entrySet().stream()
                        .sorted(byValue.thenComparing(byKey))
                        .forEach((e -> {
                            String key = e.getKey();
                            Integer value = e.getValue();
                            System.out.println(key + ": " + value + " time(s)," + (int) (100 * ((double) value / howManyEntries)) + "%");
                        }));
            }
        }
    }, WORD {
        @Override
        void processSortingNatural(Scanner scanner, String inputType, String outputType) {
            List<String> list = new ArrayList<>();
            scanner = getScanner(scanner, inputType);
            while (scanner.hasNext()) {
                list.add(scanner.next());
            }
            scanner.close();

            if (outputType != null) {
                try (FileWriter fileWriter = new FileWriter(outputType);) {
                    fileWriter.write("Total words: " + list.size());
                    String result = list.stream()
                            .sorted(Comparator.naturalOrder())
                            .map(Object::toString)
                            .reduce((s1, s2) -> s1 + " " + s2)
                            .orElse("");
                    fileWriter.write("Sorted data: " + result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Total words: " + list.size());
                String result = list.stream()
                        .sorted(Comparator.naturalOrder())
                        .map(Object::toString)
                        .reduce((s1, s2) -> s1 + " " + s2)
                        .orElse("");
                System.out.println("Sorted data: " + result);
            }
        }

        void processSortingByCount(Scanner scanner, String inputType, String outputType) {
            Map<String, Integer> counter = new HashMap<>();
            scanner = getScanner(scanner, inputType);
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (counter.containsKey(word)) {
                    counter.put(word, counter.get(word) + 1);
                } else {
                    counter.put(word, 1);
                }
            }
            scanner.close();

            Map<String, Integer> counterMap = new TreeMap<>(counter);
            int howManyEntries = counterMap.values().stream().reduce(Integer::sum).orElse(0);

            if (outputType != null) {
                try (FileWriter fileWriter = new FileWriter(outputType)) {
                    fileWriter.write("Total words: " + howManyEntries);
                    Comparator<Map.Entry<String, Integer>> byValue = Map.Entry.comparingByValue();
                    Comparator<Map.Entry<String, Integer>> byKey = Map.Entry.comparingByKey();

                    counter.entrySet().stream()
                            .sorted(byValue.thenComparing(byKey))
                            .forEach((e -> {
                                String key = e.getKey();
                                Integer value = e.getValue();
                                try {
                                    fileWriter.write(key + ": " + value + " time(s)," + (int) (100 * ((double) value / howManyEntries)) + "%");
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }
                            }));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Total words: " + howManyEntries);
                Comparator<Map.Entry<String, Integer>> byValue = Map.Entry.comparingByValue();
                Comparator<Map.Entry<String, Integer>> byKey = Map.Entry.comparingByKey();

                counter.entrySet().stream()
                        .sorted(byValue.thenComparing(byKey))
                        .forEach((e -> {
                            String key = e.getKey();
                            Integer value = e.getValue();
                            System.out.println(key + ": " + value + " time(s)," + (int) (100 * ((double) value / howManyEntries)) + "%");
                        }));
            }
        }
    };

    private static Scanner getScanner(Scanner scanner, String inputType) {
        if (inputType != null) {
            try {
                scanner = new Scanner(new File(inputType));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return scanner;
    }

    abstract void processSortingNatural(Scanner scanner, String inputType, String outputType);

    abstract void processSortingByCount(Scanner scanner, String inputType, String outputType);

    public void processSorting(Scanner scanner, Map<String, String> args) {
        String sortType = args.get(Main.SORTING_TYPE_KEYWORD);
        String inputType = args.get(Main.INPUT_FILE_KEYWORD);
        String outputType = args.get(Main.OUTPUT_FILE_KEYWORD);

        if (sortType == null) sortType = "";
        switch (sortType) {
            case "byCount":
                this.processSortingByCount(scanner, inputType, outputType);
                break;
            case "natural":
            default:
                this.processSortingNatural(scanner, inputType, outputType);
                break;
        }
    }
}

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String DATA_TYPE_KEYWORD = "-dataType";
    public static final String SORTING_TYPE_KEYWORD = "-sortingType";
    public static final String INPUT_FILE_KEYWORD = "-inputFile";
    public static final String OUTPUT_FILE_KEYWORD = "-outputFile";

    public static void main(final String[] args) {
        try {
            Map<String, String> arguments = new HashMap<>();
            for (int i = 0; i < args.length; i += 2) {
                arguments.put(args[i], args[i + 1]);
            }
            handleSorting(arguments);
        } catch (IndexOutOfBoundsException e) {
            List<String> arguments = Arrays.stream(args).collect(Collectors.toList());
            if (arguments.contains(SORTING_TYPE_KEYWORD)) {
                System.out.println("No sorting type defined!");
            } else if (arguments.contains(DATA_TYPE_KEYWORD)) {
                System.out.println("No data type defined!");
            } else {
                System.out.println("Unknown exception");
            }
        }
    }

    private static void handleSorting(Map<String, String> args) {
        String dataType = args.get(DATA_TYPE_KEYWORD) != null
                ? args.get(DATA_TYPE_KEYWORD)
                : args.get(INPUT_FILE_KEYWORD) != null
                ? "input"
                : "";
        switch (dataType) {
            case "long":
                LONG.processSorting(scanner, args);
                break;
            case "line":
                LINE.processSorting(scanner, args);
                break;
            case "input":
            case "word":
                WORD.processSorting(scanner, args);
                break;
            default:
                System.out.println("Unknown operation");
                break;
        }

    }
}

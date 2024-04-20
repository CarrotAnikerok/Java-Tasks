import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.List;
import java.util.IntSummaryStatistics;

import java.util.Scanner;


import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;

public class StreamsAndScannerTasks {

    public static long calcWordsCount(File inputFile) throws Exception {
        if (inputFile == null || !inputFile.getName().matches("test_input_(\\d+)\\.txt")) {
            throw new RuntimeException("Failed to load file");
        }
        String path = inputFile.getAbsolutePath();
        Scanner in = new Scanner(new FileInputStream(path));
        int numb = (int) in.tokens().count();
        return numb;
    }

    public static long calcWordsCountWithoutStopWords(File inputFile, File stopWords)
            throws Exception {
        if ((inputFile == null || stopWords == null)
                || !inputFile.getName().matches("test_input_(\\d+)\\.txt")
                || !stopWords.getName().matches("stop_words.txt")) {
            throw new RuntimeException("Failed to load file");
        }
        String path = inputFile.getAbsolutePath();
        String exp = stopWords.getAbsolutePath();
        Scanner in = new Scanner(new FileInputStream(path));
        Scanner ex = new Scanner(new FileInputStream(exp));
        HashSet<String> set = new HashSet<>();
        while (ex.hasNext()) {
            set.add(ex.next());
        }
        int numb = (int) in.tokens()
                .map(x -> x.toLowerCase())
                .filter(x -> !set.contains(x))
                .count();
        return numb;
    }

    public static long calcWordsCountWithUpperCaseFirstLetter(File inputFile) throws Exception {
        if (inputFile == null || !inputFile.getName().matches("test_input_(\\d+)\\.txt")) {
            throw new RuntimeException("Failed to load file");
        }
        String path = inputFile.getAbsolutePath();
        Scanner in = new Scanner(new FileInputStream(path));
        int numb = (int) in.tokens()
                .filter(x -> Character.isUpperCase(x.charAt(0)))
                .count();
        return numb;
    }

    public static Map<String, Double> calcWordsStatistic(File inputFile) throws Exception {
        if (inputFile == null || !inputFile.getName().matches("test_input_(\\d+)\\.txt")) {
            throw new RuntimeException("Failed to load file");
        }
        String path = inputFile.getAbsolutePath();
        Scanner in = new Scanner(new FileInputStream(path));
        Map<String, Double> middle = new HashMap<>();
        List<Integer> words = in.tokens()
                .map(x -> x.length())
                .collect(Collectors.toList());
        IntSummaryStatistics stats = words.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        middle.put("min_length", (double) stats.getMin());
        middle.put("max_length", (double) stats.getMax());
        middle.put("average_length", stats.getAverage());
        return middle;
    }

    public static Map<String, Integer> calcWordsFrequency(File inputFile) throws Exception {
        if (inputFile == null || !inputFile.getName().matches("test_input_(\\d+)\\.txt")) {
            throw new RuntimeException("Failed to load file");
        }
        String path = inputFile.getAbsolutePath();
        Scanner in = new Scanner(new FileInputStream(path));
        Map<String, Integer> length = in.tokens()
                .map(x -> x.toLowerCase())
                .collect(Collectors
                        .groupingBy(x -> x, collectingAndThen(Collectors
                                .counting(), Long::intValue)));
        return length;
    }
}

package Homework9;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;

public class Streams {

    public static int countN(int n) {
        return IntStream.rangeClosed(0, n).sum();
    }

    public static int countN3(int n) {
        int rangeS = IntStream.rangeClosed(0, n).map(x -> x*x*x).sum();
        return rangeS;
    }

    public static List<Integer> makeOdd(List<Integer> a) {
        List<Integer> newArray = a.stream().filter(x -> x % 2 != 0).toList();
        return newArray;
    }

    public static String tossACoin() {
        // 0 - решка, 1 -  орел
        long reshka = IntStream.rangeClosed(0, 100).
                map(x -> (int) (Math.random() * 2)).
                sum(); // подсчитываем количество решек
        return String.format("Решка выпадет %d раз, a орел выпадет %d раз", reshka, 100 - reshka);
    }

    public static int countWords(String path) throws Exception {
        Scanner in = new Scanner(new FileInputStream(path));
        int numb = (int) in.tokens().count();
        return numb;
    }

    public static int countWithoutStop(String path, String exp) throws Exception {
        Scanner in = new Scanner(new FileInputStream(path));
        Scanner ex = new Scanner(new FileInputStream(exp));
        HashSet<String> set = new HashSet<>();
        while (ex.hasNext()) {
            set.add(ex.next());
        }
        int numb = (int) in.tokens().map(x -> x.toLowerCase()).filter(x -> !set.contains(x)).count();
        return numb;
    }

    public static int startsWithCapital(String path) throws Exception {
        Scanner in = new Scanner(new FileInputStream(path));
        int numb = (int) in.tokens().filter(x -> Character.isUpperCase(x.charAt(0))).count();
        return numb;
    }

    public static Map<String, Double> middleCount(String path) throws Exception {
        Scanner in = new Scanner(new FileInputStream(path));
        Map<String, Double> middle = new HashMap<String, Double>();
        List<Integer> words = in.tokens().map(x -> x.length()).collect(Collectors.toList());
        IntSummaryStatistics stats = words.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        middle.put("min_length", (double) stats.getMin());
        middle.put("max_length", (double) stats.getMax());
        middle.put("average_length", stats.getAverage());
        return middle;
    }

        public static Map<String, Integer> frequencyOfWords(String path) throws Exception {
        // нужно найти частоту слов
        Scanner in = new Scanner(new FileInputStream(path));
        Map<String, Integer> length = in.tokens().map(x -> x.toLowerCase()).collect(Collectors.groupingBy(x -> x, collectingAndThen(Collectors.counting(), Long::intValue)));
        return length;
    }

    /*public static int frequencyOfWords(String path) throws Exception {
        // нужно найти частоту слов
        Scanner in = new Scanner(new FileInputStream(path));
        Map<String, Integer> length = in.tokens().map(x -> x.toLowerCase()).collect(Collectors.groupingBy(, Collectors.counting()));
        return 0;
    }*/
}

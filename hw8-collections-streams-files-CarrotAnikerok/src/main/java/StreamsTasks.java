import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsTasks {
    public static int sumN(int n) {
        if (n < 0) {
            throw new RuntimeException("Wrong input data");
        }
        n = n - 1;
        int rangeS = IntStream.rangeClosed(0, n).sum();
        return rangeS;

    }

    public static int sumN3(int n) {
        if (n < 0) {
            throw new RuntimeException("Wrong input data");
        }
        n = n - 1;
        int rangeS = IntStream.rangeClosed(0, n).map(x -> x * x * x).sum();
        return rangeS;
    }

    public static List<Integer> oddNumbersList(List<Integer> list) {
        if (list == null) {
            throw new RuntimeException("Wrong input data");
        }
        List<Integer> newArray = list.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
        return newArray;
    }

    public static String tossaCoin() {
        // 0 - решка, 1 -  орел
        long reshka = IntStream.rangeClosed(0, 100)
                .map(x -> (int) (Math.random() * 2))
                .sum(); // подсчитываем количество решек
        return String.format("Решка выпадет %d раз, a орел выпадет %d раз", reshka, 100 - reshka);
    }
}

package Homework1;

import java.util.Arrays;

public class ArraysTasks {
    public static void main(String[] args) {
        int[] s = even(5);
        System.out.println("Первое задание: " + Arrays.toString(s));

        int[] b = {2, 2, 2};
        System.out.println("Второе задание: " + allSimilar(b));

        int[] c = {1, 2, 3, 4, 6};
        System.out.println("Третье задание: " + hasSimilar(c));

        System.out.println("Четвертое задание: " + mean(c));

        int[] g = {10, 20, 30, 40, 50};
        shift(g);
        System.out.println("Пятое задание: " + Arrays.toString(g));

        int[] h = {1, 3, 5, 6};
        System.out.println("Шестое задание:" + Arrays.toString(copyShift(h)));
        System.out.println(Arrays.toString(h));
    }

    public static int[] even(int n) {
        int[] a = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            a[i] = 2 * (i + 1);
        }
        return a;
    }

    public static boolean allSimilar(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i-1] != a[i])
                return false;
        }
        return true;
    }

    public static boolean hasSimilar(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j])
                    return true;
            }
        }
        return false;
    }

    public static double mean(int[] a) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum / a.length;
    }

    public static void shift(int[] a) {
        int lastNumber = a[a.length - 1];
        int[] aClone = a.clone();
        for (int i = 0; i < a.length - 1; i++) {
            a[i + 1] = aClone[i];
        }
        a[0] = lastNumber;
    }

    public static int[] copyShift(int[] a) {
        int lastNumber = a[a.length - 1];
        int[] aClone = a.clone();
        for (int i = 0; i < a.length - 1; i++) {
            aClone[i + 1] = a[i];
        }
        aClone[0] = lastNumber;
        return aClone;
    }
}

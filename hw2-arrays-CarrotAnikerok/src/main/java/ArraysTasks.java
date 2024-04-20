import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.codehaus.groovy.runtime.ArrayUtil;

public class ArraysTasks {
    public static int[] even(int n) {
        if (n <= 0)
            return new int[0];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = 2 * (i + 1);
        }
        return a;
    }

    public static boolean allSimilar(int[] a) {
        if (a.length == 0)
            return false;
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
        if (a.length == 0)
            return 0;
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum / a.length;
    }

    /* изменила клонирование*/
    public static void shift(int[] a) {
        if (a.length == 0)
            return;
        int lastNumber = a[a.length - 1];
        int prevNumber = a[0];
        for (int i = 1; i < a.length; i++) {
            int nextNumber = a[i];
            a[i] = prevNumber;
            prevNumber = nextNumber;
        }
        a[0] = lastNumber;
    }

    public static int[] copyShift(int[] a) {
        if (a.length == 0)
            return new int[0];
        int lastNumber = a[a.length - 1];
        int[] aClone = a.clone();
        for (int i = 0; i < a.length - 1; i++) {
            aClone[i + 1] = a[i];
        }
        aClone[0] = lastNumber;
        return aClone;
    }
}

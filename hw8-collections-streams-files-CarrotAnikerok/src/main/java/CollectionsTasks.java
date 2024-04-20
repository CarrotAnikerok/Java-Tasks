import groovyjarjarantlr4.v4.runtime.atn.BlockEndState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTasks {
    public static <T> void reverseList(List<T> list) {
        if (list == null) {
            throw new RuntimeException("Wrong input data");
        }
        Collections.reverse(list);
    }

    public static <T> List<T> createReversedList(List<T> list) {
        if (list == null) {
            throw new RuntimeException("Wrong input data");
        }
        List<T> newList = new ArrayList<>(list);
        Collections.reverse(newList);
        return newList;
    }

    public static <T> void deleteEvenElements(List<T> list) {
        if (list == null) {
            throw new RuntimeException("Wrong input data");
        }
        int length = list.size();
        if (length % 2 == 0) {
            for (int i = 0; i < length / 2; i++) {
                list.remove(i);
            }
        } else {
            for (int i = 0; i < length / 2 + 1; i++) {
                list.remove(i);
            }
        }
    }

    public static <T> List<T> createOddElementsList(List<T> list) {
        if (list == null) {
            throw new RuntimeException("Wrong input data");
        }
        List<T> newList = new ArrayList<>(list);
        deleteEvenElements(newList);
        return newList;
    }
}

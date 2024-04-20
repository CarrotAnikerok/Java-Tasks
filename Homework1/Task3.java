package Homework1;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        ArraysTasks.shift(a);
        System.out.println(Arrays.toString(a));
        char[][] c = createTable(2, '.');
        printTable(c);
        /*System.out.println("============ Заполним строки: ==========");
        fillFirstAndLastLines(c, '#');
        printTable(c);
        System.out.println("============ Заполним столбцы: =========");
        fillFirstAndLastColumns(c, '#');
        printTable(c);*/
    }

    public static char[][] createTable(int n, char k) {
        char[][] a = new char[n][n];
        for (char[] i: a) {
            for (int j = 0; j < i.length; j++) {
                i[j] = k;
            }
        }
        char[][] b = {{'1','2'},{'2','2'}};
        return a;
    }

    public static void printTable(char[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static int[] fillFirstAndLastLines() {
        int[] a = {};
        return a;
    }

    public static int[] fillFirstAndLastColumns() {
        int[] a = {};
        return a;
    }
}

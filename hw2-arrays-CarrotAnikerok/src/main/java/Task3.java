import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        char[][] c = createTable(20, '.');
        printTable(c);
        System.out.println("============ Заполним строки: ==========");
        fillFirstAndLastLines(c, '#');
        printTable(c);
        System.out.println("============ Заполним столбцы: =========");
        fillFirstAndLastColumns(c, '#');
        printTable(c);
    }

    public static char[][] createTable(int n, char k) {
        char[][] a = new char[n][n];
        for (char[] i : a) {
            Arrays.fill(i, k);
        }
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

    public static void fillFirstAndLastLines(char[][] a, char k) {
        Arrays.fill(a[0], k);
        Arrays.fill(a[a.length - 1], k);
    }

    public static void fillFirstAndLastColumns(char[][] a, char k) {
        for (char[] i : a) {
            i[0] = k;
            i[i.length - 1] = k;
        }
    }
}

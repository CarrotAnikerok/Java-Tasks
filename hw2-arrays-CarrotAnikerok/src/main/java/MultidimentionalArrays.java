

public class MultidimentionalArrays {
    public static void main(String[] args) {
        printTable(new int[][]{{10, 30, 40}, {20, 40, 50, 50}});
        printTableAligned(new int[][]{{10, 300, 4000}, {200, 40, 50, 50}, {20}, {30, 404}});
    }

    public static void printTable(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void printTableAligned(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                int maxim = maxNumb(a, j + 1);
                int formNumb = (Integer.toString(maxim)).length();
                String form = "%" + formNumb + "d";
                System.out.printf(form , a[i][j]);
                System.out.print("  ");
            }
            System.out.print("\n");
        }
    }

    public static int maxNumb(int[][] a, int b) {
        int bigMax = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i+1].length < b || a[i].length < b) {
                continue;
            }
            int maximum = Math.max(a[i][b - 1], a[i + 1][b - 1]);
            if (bigMax < maximum)
                bigMax = maximum;
        }
        return bigMax;
    }
}

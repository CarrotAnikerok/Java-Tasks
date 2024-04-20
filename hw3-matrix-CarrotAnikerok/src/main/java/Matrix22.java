import java.util.Arrays;


public class Matrix22 {
    public double a;
    public double b;
    public double c;
    public double d;

    //1 задание
    public Matrix22(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    // перегрузка
    public Matrix22(double[][] mas) {
        this.a = mas[0][0];
        this.b = mas[0][1];
        this.c = mas[1][0];
        this.d = mas[1][1];
    }

    public double[][] get() {
        return new double[][]{{a, b}, {c, d}};
    }

    public double trace() {
        return this.a + this.d;
    }

    public double det() {
        return this.a * this.d - this.b * this.c;
    }

    public String toString() {
        String str = "[" + Arrays.toString(this.get()[0]) + ", " + Arrays.toString(this.get()[1]) + "]";
        return str;
    }

    public void print() {
        for (int i = 0; i < this.get().length; i++ ) {
            for (int j = 0; j < this.get()[i].length; j++ ){
                System.out.print(this.get()[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public Matrix22 add(Matrix22 bi) {
        Matrix22 mat = new Matrix22(0, 0, 0, 0);
        mat.a = this.a + bi.a;
        mat.b = this.b + bi.b;
        mat.c = this.c + bi.c;
        mat.d = this.d + bi.d;
        return mat;
    }

    public Matrix22 mul(Matrix22 bi) {
        Matrix22 mat = new Matrix22(0, 0, 0, 0);
        mat.a = this.a * bi.a + this.b * bi.c;
        mat.b = this.a * bi.b + this.b * bi.d;
        mat.c = this.c * bi.a + this.d * bi.c;
        mat.d = this.c * bi.b + this.d * bi.d;
        return mat;
    }

    public void pow(int n) {
        double a = this.a, b = this.b, c = this.c, d = this.d;
        for (int i = 1; i < n; i++) {
            double newA = this.a * a + this.b * c;
            double newB = this.a * b + this.b * d;
            double newC = this.c * a + this.d * c;
            double newD = this.c * b + this.d * d;
            this.a = newA;
            this.b = newB;
            this.c = newC;
            this.d = newD;
        }
    }

    public static void main(String[] args) {
        Matrix22 matrix = new Matrix22(1, 2, 3, 4); //инициализация матрицы через первый конструктор

        double[][] matrixArray = {{0, 1}, {2, 3}};
        Matrix22 matrix2 = new Matrix22(matrixArray); // инициализация матрицы через второй конструктор
        System.out.println(matrix.det()); // вычисление дискриминанта
        System.out.println(matrix.trace()); // вычисление следа
        double[][] arrayFromMatrix = matrix2.get(); // метод get

        matrixArray[0][0] = 101;
        System.out.println(matrixArray[0][0]);
        System.out.println(arrayFromMatrix[0][0]);

        System.out.println(matrix2); // проверка метода StringTo()
        matrix.print(); // проверка принта
        Matrix22 x = new Matrix22(5, 6, 7, 8);
        System.out.println(matrix.add(x)); // сложение матрицы
        System.out.println(matrix.mul(x)); // умножение матрицы
        System.out.println(matrix);
        matrix.pow(3);
        System.out.println(matrix);
    }
}

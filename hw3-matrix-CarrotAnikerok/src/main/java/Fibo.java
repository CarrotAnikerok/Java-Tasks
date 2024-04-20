public class Fibo {
    public static void main(String[] args) {
        System.out.println(fibi(-8));
    }

    public static double fibi(int n){
        if (n == 0)
            return 0;
        else if (n == 1 || n == 2)
            return 1;
        else {
            double[][] matrixArray = {{1, 1}, {1, 0}};
            Matrix22 fib = new Matrix22(matrixArray);
            fib.pow(Math.abs(n) - 1);
            if (n < 0 && n%2==0) {
                return -fib.a;
            }
            return fib.a;
        }
    }
}

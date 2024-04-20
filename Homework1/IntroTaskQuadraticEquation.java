package Homework1;

public class IntroTaskQuadraticEquation {
    public static void main(String[] args) {
        System.out.println(uravn(3, -14, -5));
    }

    public static String uravn(int a, int b, int c) {
        double D = b * b - 4 * a * c;
        if (a == 0 && b != 0) {
            double x1 = (-c) / b;
            return String.format("одно решение x = %.2f", x1);
        } else if (b == 0 && a == 0 && c == 0) {
            return "решений бесконечно много";
        } else if (D < 0 || b == 0 && a == 0 && c != 0) {
            return "решений нет";
        } else if (D == 0) {
            double x1 = (-b) / (2 * a);
            return String.format("одно решение x = %.2f", x1);
        } else {
            double x1 = (-(b) + Math.pow(D, 0.5)) / (2 * a);
            double x2 = (-(b) - Math.pow(D, 0.5)) / (2 * a);
            double xbol;
            double xmen;
            if (x2 > x1) {
                xbol = x2;
                xmen = x1;
            } else {
                xbol = x1;
                xmen = x2;
            }
            String stroka = String.format("два решения: x1 = %.2f, x2 = %.2f", xmen, xbol);
            return stroka;
        }
    }
}

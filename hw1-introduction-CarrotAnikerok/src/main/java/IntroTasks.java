public class IntroTasks {
    public static boolean is3Digit(int a) {
        return a >= 100 && a <= 999;
    }

    public static boolean isLast5(int a) {
        return a % 10 == 5;
    }

    public static boolean isSameDigits(int a) {
        return a != 0 && a % 10 == a % 100 / 10;
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static String cat(int numberOfCats) {
        int absNumberOfCats = Math.abs(numberOfCats);
        if (absNumberOfCats % 100 >= 10 && absNumberOfCats % 100 <= 19)
            return numberOfCats + " kotov";
        else if (absNumberOfCats % 10 == 1)
            return numberOfCats + " kot";
        else if (absNumberOfCats % 10 > 1 && absNumberOfCats % 10 <= 4)
            return numberOfCats + " kota";
        else
            return numberOfCats + " kotov";
    }

    public static String getQuadraticEquationSolution(int a, int b, int c) {
        double D = b * b - 4 * a * c;
        if (a == 0 && b != 0) {
            double x1 = (-c) / b;
            return String.format("one solution x = %.0f", x1);
        } else if (b == 0 && a == 0 && c == 0) {
            return "there are infinitely many solutions";
        } else if (D < 0 || b == 0 && a == 0) {
            return "no solution";
        } else if (D == 0) {
            double x1 = (-b) / (2 * a);
            return String.format("one solution x = %.0f", x1);
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
            return String.format("two solutions x1 = %.0f, x2 = %.0f", xmen, xbol);
        }
    }

    public static boolean isPrimality(int a) {
        for(int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0)
                return false;
        }
        return true;
    }
}

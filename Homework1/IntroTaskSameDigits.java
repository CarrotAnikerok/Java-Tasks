package Homework1;

public class IntroTaskSameDigits {
    public static void main(String[] args) {
        System.out.println(task(23));
    }

    public static String task(int x) {
        if (x % 10 == (x % 100)/10)
            return "Последние две цифры совпадают";
        return "Последние две цифры отличны";
    }
}

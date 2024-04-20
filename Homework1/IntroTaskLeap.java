package Homework1;

public class IntroTaskLeap {
    public static void main(String[] args) {
        System.out.println(task(1025));
    }

    public static String task(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            return "Этот год високосный";
        return "Этот год не високосный";

    }
}

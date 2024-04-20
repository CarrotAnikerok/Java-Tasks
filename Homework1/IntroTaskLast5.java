package Homework1;

public class IntroTaskLast5 {
    public static void main(String[] args) {
        System.out.println(task(25));
    }

    public static String task(int x) {
        if (x % 10 == 5)
            return "Число делится на 5";
        return "Число не делится на 5";

    }
}

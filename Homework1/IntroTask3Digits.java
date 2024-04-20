package Homework1;

public class IntroTask3Digits {
    public static void main(String[] args) {
        System.out.println(printTable(100));
    }
    public static String printTable(int x) {
        if (x >= 100 && x <= 999)
            return "В числе " + x + " 3 цифры";
        return "В числе " + x + " не 3 цифры";
    }
}

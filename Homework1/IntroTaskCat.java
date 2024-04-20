package Homework1;

public class IntroTaskCat {
    public static void main(String[] args) {
        System.out.println(cats(23));
    }

    public static String cats(int numberOfCats) {
        if (numberOfCats % 100 >= 10 && numberOfCats % 100 <= 19)
            return numberOfCats + " котов";
         else if (numberOfCats % 10 == 1)
            return numberOfCats + " кот";
         else if (numberOfCats % 10 > 1 && numberOfCats % 10 <= 4)
            return numberOfCats + " кота";
         else
            return numberOfCats + " котов";
    }
}

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class RegexpTasks {

    public static boolean isTrueCat(String input) {
        if (input == null || input.isEmpty())
            return false;
        return input.matches(".*([Cc])([Aa])([Tt]).*");
    }

    public static int catculator(String input) {
        if (input == null || input.isEmpty() || !isTrueCat(input))
            return 0;
        Pattern numberCat = Pattern.compile("(\\d+) ([Cc])([Aa])([Tt])");
        Pattern cat = Pattern.compile("(\\D)\\s([Cc])([Aa])([Tt])");
        Matcher m1 = numberCat.matcher(input);
        Matcher m2 = cat.matcher(input);
        int numberOfCats = 0;
        while (m1.find()) {
            numberOfCats += Integer.parseInt(m1.group(1));
        }
        while (m2.find()) {
            numberOfCats += 1;
        }
        return numberOfCats;
    }

    public static String skynet(String input) {
        if (input == null || input.isEmpty())
            return "";
        input = input.replaceAll("\\bhuman\\b", "computer");
        return input;
    }

    public static String removeDuplicates(String input) {
        if (input == null || input.isEmpty())
            return "";
        for (int i = 0; i < input.length() - 1; i += 1) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                String a = Character.toString(input.charAt(i));
                String reg = a + "+";
                input = input.replaceAll(reg, a);
            }
        }
        return input;
    }

    public static boolean isEmail(String input) {
        if (input == null || input.isEmpty())
            return false;
        return input.matches("([a-zA-Z])+(\\.)?([a-zA-Z])+@[a-zA-Z]+\\.[a-z]+");
    }

    public static String validateForDuplicates(String input) {
        if (input == null || input.isEmpty())
            return "";
        /* Создаю массив всех слов
        * Проверяю повторы, проходя по набору.
        * С помощью регулярных выражений заменяю все повторы кроме первого */
        String[] array = input.split(" ");
        HashSet<String> setOfWords = new HashSet<>(Arrays.asList(array)); // создаю набор из массива
        for (String word : setOfWords) {
            Pattern p = Pattern.compile("\\b" + word + "\\b");
            Matcher m = p.matcher(input);
            int counter = 0;
            while (m.find()) {
                counter +=1;
            }
            if (counter > 1) {
                input = input.replaceAll("\\b" + word + "\\b" , "<strong>" + word + "</strong>");
                input = input.replaceFirst("<strong>" + word + "</strong>", word);
            }
            System.out.println(word);
        }
        return input;
    }
}
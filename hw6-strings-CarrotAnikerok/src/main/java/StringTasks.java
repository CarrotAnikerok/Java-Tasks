import org.jetbrains.annotations.NotNull;

public class StringTasks {
    public static boolean isLowerCase(String input) {
        if (input == null || input.isEmpty())
            return false;
        int[] unicode = new int[26]; // массив с номерами только маленьких английских букв из юникод
        for (int i = 97; i < 123; i++) {
            unicode[i - 97] = i;
        }
        int n = 0;
        for (int i = 0; i < input.length(); i++) {
            for (int x : unicode) {
                if (input.codePointAt(i) == x) {
                    n += 1;
                }
            }
        }

        return n == input.length();
    }

    public static boolean isUpperCase(String input) {
        if (input == null || input.isEmpty())
            return false;
        int[] unicode = new int[26]; // массив с номерами только маленьких английских букв из юникод
        for (int i = 65; i < 91; i++) {
            unicode[i - 65] = i;
        }
        int n = 0;
        for (int i = 0; i < input.length(); i++) {
            for (int x : unicode) {
                if (input.codePointAt(i) == x) {
                    n += 1;
                }
            }
        }

        return n == input.length();
    }

    public static boolean isCamelCase(String input) {
        if (input == null || input.isEmpty())
            return false;
        return Character.isUpperCase(input.charAt(0)) & isLowerCase(input.substring(1));
    }

    public static boolean isMixedCase(String input) {
        if (input == null || input.isEmpty() || !Character.isLetter(input.charAt(0)))
            return false;
        for (int i = 0; i < input.length() - 1; i++)
            if (Character.isLowerCase(input.charAt(i)) && Character.isUpperCase(input.charAt(i + 1)) ||
                    Character.isUpperCase(input.charAt(i)) && Character.isLowerCase(input.charAt(i + 1))) {
            } else return false;
        return true;
    }

    public static boolean isPalindrome(String input) {
        if (input == null || input.isEmpty())
            return false;
        input = input.toLowerCase();
        int i = 0;
        int j = input.length() - 1;
        while (j - i > 1) {
            if (!Character.isLetterOrDigit(input.charAt(i))) {
                i += 1;
                continue;
            } else if (!Character.isLetterOrDigit(input.charAt(j))) {
                j -= 1;
                continue;
            }
            if (!(input.charAt(i) == input.charAt(j))) {
                return false;
            }
            i += 1;
            j -= 1;
        }
        return true;
    }

    public static boolean isStrictPalindrome(String input, boolean isStrict) {
        if (input == null || input.isEmpty())
            return false;
        int i = 0;
        int j = input.length() - 1;
        if (isStrict) {
            while (j - i > 1) {
                if (!(input.charAt(i) == input.charAt(j))) {
                    return false;
                }
                i += 1;
                j -= 1;
            }
        } else {
            return isPalindrome(input);
        }
        return true;
    }

    public static boolean isAllCharactersPaired(String input) {
        if (input == null || input.isEmpty() || input.length() % 2 != 0)
            return false;
        for (int i = 0; i < input.length(); i += 2) {
            if (input.charAt(i) != input.charAt(i + 1))
                return false;
        }
        return true;
    }

    public static String replaceBinaryNumbers(String input) {
        if (input == null)
            return null;
        if (!input.contains("1") && !input.contains("0"))
            return input;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '1') {
                sb.append("0");
            } else if (input.charAt(i) == '0') {
                sb.append("1");
            } else
                sb.append(input.charAt(i));
        }
        return sb.toString();
    }

    public static String replace(String input, char from, char to) {
        if (input == null)
            return null;
        if (input.indexOf(from) == -1 && input.indexOf(to) == -1)
            return input;
        return input.replace(from, to);
    }

    public static String replace2(String input, char from, char to) {
        if (input == null)
            return null;
        if (input.indexOf(from) == -1 && input.indexOf(to) == -1)
            return input;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == from) {
                sb.append(to);
            } else if (input.charAt(i) == to) {
                sb.append(from);
            } else
                sb.append(input.charAt(i));
        }
        return sb.toString();
    }

    public static String makeDragonCurve(int n) {
        StringBuilder sb = new StringBuilder();
        String s;
        if (n == 0) {
            return "R";
        }
        sb.append("R");
        for (int i = 0; i < n; i++) {
            s = StringTasks.replace2(sb.reverse().toString(), 'R', 'L');
            sb.reverse();
            sb.append("R").append(s);
        }
        return sb.toString();
    }

    public static String makeGrayCode(int n) {
        StringBuilder sb = new StringBuilder();
        String s = "0";
        int k = 1;
        if (n == 0) {
            return "0";
        }
        sb.append("0");
        for (int i = 0; i < n; i++) {
            sb.append(" " + k + " ").append(s);
            s = sb.toString();
            k += 1;
        }
        return sb.toString();
    }
}



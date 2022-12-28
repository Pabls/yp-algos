package sprint_1.f_palindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {
    private static final String TRUE = "True";
    private static final String FALSE = "False";

    private static final String REGEX = "^[a-zA-Z0-9]+$";
    private static final Pattern pattern = Pattern.compile(REGEX);


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String resultString = reader.readLine();

        if (resultString == null || resultString.length() < 2) {
            System.out.println(FALSE);
            return;
        }

        boolean isPalindrome = true;
        int startIndex = 0;
        int endIndex = resultString.length() - 1;
        boolean isNeedToWork = true;

        while (isNeedToWork) {
            if (startIndex >= endIndex) {
                isNeedToWork = false;
                continue;
            }

            char firstChar = resultString.charAt(startIndex);
            if (!isValidChar(firstChar)) {
                startIndex++;
                continue;
            }

            char lastChar = resultString.charAt(endIndex);
            if (!isValidChar(lastChar)) {
                endIndex--;
                continue;
            }

            if (Character.toLowerCase(firstChar) != Character.toLowerCase(lastChar)) {
                isPalindrome = false;
                isNeedToWork = false;
            } else {
                startIndex++;
                endIndex--;
            }
        }


        if (isPalindrome) {
            System.out.println(TRUE);
        } else {
            System.out.println(FALSE);
        }
    }

    private static boolean isValidChar(Character value) {
        return pattern.matcher(value.toString()).matches();
    }
}

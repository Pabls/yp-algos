package sprint_3.b;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    private final static String two = "abc";
    private final static String three = "def";
    private final static String four = "ghi";
    private final static String five = "jkl";
    private final static String six = "mno";
    private final static String seven = "pqr";
    private final static String eight = "tuv";
    private final static String nine = "wxy";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        String[] arr = new String[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            char number = numbers.charAt(i);
            switch (number) {
                case '2':
                    arr[i] = two;
                    break;
                case '3':
                    arr[i] = three;
                    break;
                case '4':
                    arr[i] = four;
                    break;
                case '5':
                    arr[i] = five;
                    break;
                case '6':
                    arr[i] = six;
                    break;
                case '7':
                    arr[i] = seven;
                    break;
                case '8':
                    arr[i] = eight;
                    break;
                case '9':
                    arr[i] = nine;
                    break;
            }
        }

        concatValues(arr, 0, 0);
        System.out.println(Arrays.toString(arr));
        System.out.println(sb);
    }

    private static void concatValues(String[] values, int valueIndex, int index) {
        if (values.length < index && values[valueIndex].length() > index) {
            char value = values[valueIndex].charAt(index);
            sb.append(value);
            concatValues(values, valueIndex + 1, index + 1);
        } else {
            return;
        }
    }
}

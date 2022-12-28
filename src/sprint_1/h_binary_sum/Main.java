package sprint_1.h_binary_sum;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        String firstValue = scanner.next();
        String secondValue = scanner.next();

        int firstIndex = firstValue.length() - 1;
        int secondIndex = secondValue.length() - 1;

        StringBuilder builder = new StringBuilder();

        int firstTerm = 0;
        int secondTerm = 0;
        int extraTerm = 0;

        while (firstIndex >= 0 || secondIndex >= 0) {
            firstTerm = getValueByExpression(firstIndex >= 0, firstValue, firstIndex);
            secondTerm = getValueByExpression(secondIndex >= 0, secondValue, secondIndex);

            int sum = firstTerm + secondTerm;

            if (sum > 1) {
                if (extraTerm == 0) {
                    builder.append(0);
                } else {
                    builder.append(1);
                }
                extraTerm = 1;
            } else {
                if (extraTerm == 0) {
                    builder.append(sum);
                    extraTerm = 0;
                } else if (sum + extraTerm > 1) {
                    builder.append(0);
                    extraTerm = 1;
                } else {
                    builder.append(1);
                    extraTerm = 0;
                }
            }
            firstIndex--;
            secondIndex--;
        }

        if (extraTerm != 0) {
            builder.append(extraTerm);
        }

        System.out.println(builder.reverse());
    }

    private static int getValueByExpression(boolean isNeedToGetValue, String value, int index) {
        if (isNeedToGetValue) {
            return Integer.parseInt(String.valueOf(value.charAt(index)));
        } else {
            return 0;
        }
    }
}
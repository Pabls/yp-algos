package sprint_1.g_home_work;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int value = scanner.nextInt();

        System.out.println(convertToBinary(value));
    }

    private static String convertToBinary(int value) {
        if (value == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (value != 0) {
            sb.append(value % 2);
            value = value / 2;
        }
        return sb.reverse().toString();
    }
}

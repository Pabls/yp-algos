package sprint_1.l_extra_letter;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        char[] firstValue = scanner.next().toCharArray();
        char[] secondValue = scanner.next().toCharArray();

        Arrays.sort(firstValue);
        Arrays.sort(secondValue);

        for (int i = 0; i < secondValue.length; i++) {
            if (firstValue.length == i) {
                System.out.println(secondValue[i]);
                break;
            } else if(firstValue[i] != secondValue[i]) {
                System.out.println(secondValue[i]);
                break;
            }
        }
    }
}

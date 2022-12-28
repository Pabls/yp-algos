package sprint_1.i_four;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        while (num != 1 && num % 4 == 0 && num > 0) {
            num /= 4;
        }

        System.out.println(num == 1 ? "True" : "False");
    }
}

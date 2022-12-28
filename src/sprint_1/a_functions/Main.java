package sprint_1.a_functions;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * На вход через пробел подаются целые числа a, x, b, c. В конце ввода находится перенос строки.
 * Вывод : y = ax2 + bx + c
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int a = scanner.nextInt();
        int x = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int y = (a * (x * x)) + (b * x) + c;
        System.out.println(y);
    }
}

package sprint_3.a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        genBinary(0, count, count, "");
    }


    private static void genBinary(int control, int n1, int n2, String prefix) {
        if (n1 == 0 && n2 == 0) {
            System.out.println(prefix);
        } else {
            if (n1 > 0) {
                genBinary(control + 1, n1 - 1, n2, prefix + "(");
            }
            if (control > 0 && n2 > 0) {
                genBinary(control - 1, n1, n2 - 1, prefix + ")");
            }
        }
    }
}

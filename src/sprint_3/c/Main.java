package sprint_3.c;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();

        int charIndex = 0;
        int endIndex = second.length();
        int firstStrLength = first.length();
        for (int i = 0; i < endIndex; i++) {
            if (first.charAt(charIndex) == second.charAt(i)) {
                charIndex++;
                if (charIndex >= firstStrLength) {
                    break;
                }
            }
        }

        if (charIndex >= first.length()) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
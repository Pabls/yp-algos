package sprint_3.c;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();

        int charIndex = 0;
        for (int i = 0; i < second.length(); i++) {
            if (charIndex >= first.length()) {
                break;
            }
            if (first.charAt(charIndex) == second.charAt(i)) {
                charIndex++;
            }
        }

        if (charIndex == first.length()) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
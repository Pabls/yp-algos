package sprint_3.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String first = reader.readLine();
        String second = reader.readLine();

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
package sprint_2.h;

import java.util.Scanner;
import java.util.Stack;

public class BracketSequence {

    private static final String TRUE = "True";
    private static final String FALSE = "False";

    private static final char OPEN_S_B = '[';
    private static final char CLOSED_S_B = ']';

    private static final char OPEN_F_B = '{';
    private static final char CLOSED_F_B = '}';

    private static final char OPEN_R_B = '(';
    private static final char CLOSED_R_B = ')';


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String seq = scanner.nextLine().trim();

        if (seq == null || seq.isBlank()) {
            System.out.println(TRUE);
            return;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < seq.length(); i++) {
            char currentChar = seq.charAt(i);
            if (isOpenBracket(currentChar)) {
                stack.push(seq.charAt(i));
                continue;
            }

            if (stack.empty()) {
                stack.push(OPEN_F_B);
                break;
            }

            char lastOpenBracket = stack.pop();

            if (!isPair(lastOpenBracket, currentChar)) {
                stack.push(lastOpenBracket);
                break;
            }
        }

        if (stack.empty()) {
            System.out.println(TRUE);
        } else {
            System.out.println(FALSE);
        }
    }

    private static boolean isOpenBracket(char bracket) {
        return bracket == OPEN_F_B || bracket == OPEN_R_B || bracket == OPEN_S_B;
    }

    private static boolean isPair(char openBracket, char closedBracket) {
        boolean res;
        switch (closedBracket) {
            case CLOSED_F_B:
                res = openBracket == OPEN_F_B;
                break;
            case CLOSED_R_B:
                res = openBracket == OPEN_R_B;
                break;
            default:
                res = openBracket == OPEN_S_B;
                break;
        }
        return res;
    }
}

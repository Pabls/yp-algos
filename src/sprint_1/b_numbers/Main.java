package sprint_1.b_numbers;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * В первой строке записаны три случайных целых числа a, b и c. Числа не превосходят 109 по модулю.
 *  Если все три числа оказываются одной чётности, игрок выигрывает.
 * Выведите «WIN», если игрок выиграл, и «FAIL» в противном случае.
 */
public class Main {
    private static final String FAIL = "FAIL";
    private static final String WIN = "WIN";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        boolean aIsEven = isEvenNumber(scanner.nextInt());
        boolean bIsEven = isEvenNumber(scanner.nextInt());
        boolean cIsEven = isEvenNumber(scanner.nextInt());

        if(aIsEven == bIsEven && aIsEven == cIsEven) {
            System.out.println(WIN);
        } else {
            System.out.println(FAIL);
        }
    }

    private static boolean isEvenNumber(int value) {
        return value % 2 == 0;
    }
}

package sprint_1.xyz_final_tasks.b;

import java.util.Scanner;

// B. Ловкость рук
// Отчет 80086807
// https://contest.yandex.ru/contest/22450/run-report/80086807/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int keysCountForOneRound = scanner.nextInt() * 2;
        int[] numbersCount = new int[9];

        for (int i = 0; i < 4; i++) {
            String field = scanner.next();
            char[] chars = field.toCharArray();
            for (char symbol : chars) {
                if (Character.isDigit(symbol)) {
                    int numberValue = Integer.parseInt(String.valueOf(symbol));
                    int index = numberValue - 1;
                    int count = numbersCount[index];
                    numbersCount[index] = count + 1;
                }
            }
        }

        int scores = 0;
        for (int i : numbersCount) {
            if (i > 0 && i <= keysCountForOneRound) {
                scores++;
            }
        }

        System.out.println(scores);
    }
}
package sprint_1.xyz_final_tasks.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// A. Ближайший ноль
// Отчет 80080402
// https://contest.yandex.ru/contest/22450/run-report/80080402/
public class Main {

    public static void main(String[] args) throws IOException {

        // Получение данных
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int arraySize = Integer.parseInt(reader.readLine());

        int[] values = new int[arraySize];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arraySize; i++) {
            values[i] = Integer.parseInt(tokenizer.nextToken());
        }

        // Обработка данных
        int[] result = new int[arraySize];
        Integer currentEmptyValueIndex = null;
        Integer previouslyEmptyValueIndex = null;
        for (int index = 0; index < arraySize; index++) {
            int value = values[index];
            if (value == 0) {
                previouslyEmptyValueIndex = currentEmptyValueIndex;
                currentEmptyValueIndex = index;
                result[index] = value;
                int maxPreviouslyIndex = previouslyEmptyValueIndex != null ? previouslyEmptyValueIndex : -1;
                for (int i = index - 1; i > maxPreviouslyIndex; i--) {
                    if (result[i] == -1 || result[i] > index - i) {
                        result[i] = index - i;
                    } else {
                        break;
                    }
                }
            } else if (currentEmptyValueIndex != null) {
                result[index] = index - currentEmptyValueIndex;
            } else {
                result[index] = -1;
            }
        }

        StringBuilder builder = new StringBuilder();

        for (int i : result) {
            builder.append(i).append(" ");
        }

        System.out.print(builder);
    }
}

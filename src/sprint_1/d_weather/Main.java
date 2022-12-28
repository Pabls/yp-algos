package sprint_1.d_weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int valuesCount = Integer.parseInt(reader.readLine());
        final int[] values = new int[valuesCount];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < valuesCount; i++) {
            values[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int counter = 0;

        if (valuesCount == 1) {
            System.out.println(1);
        } else {
            int nextIndex = 0;
            int prevIndex = 0;
            for (int i = 0; i < valuesCount; i++) {
                nextIndex = i + 1;
                prevIndex = i - 1;

                if (prevIndex < 0 && nextIndex < valuesCount && values[i] > values[nextIndex]) {
                    counter++;
                    continue;
                }

                if (prevIndex >= 0 && nextIndex < valuesCount && values[i] > values[nextIndex] && values[i] > values[prevIndex]) {
                    counter++;
                    continue;
                }

                if (nextIndex == valuesCount && values[i] > values[prevIndex]) {
                    counter++;
                }
            }

            System.out.println(counter);
        }
    }
}

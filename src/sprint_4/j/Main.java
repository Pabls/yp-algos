package sprint_4.j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        int value = Integer.parseInt(reader.readLine());

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] values = new int[count];
        for (int i = 0; i < count; i++) {
            values[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(values);

        // Обработка

    }
}

package sprint_3.f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] lines = new int[count];
        for (int i = 0; i < count; i++) {
            lines[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(lines);
        int res = 0;
        boolean resIsReady = false;
        for (int i = lines.length - 1; i >= 2; i--) {
            if (resIsReady) {
                break;
            }
            int c = lines[i];
            for (int j = i - 1; j >= 1; j--) {
                if (resIsReady) {
                    break;
                }
                int a = lines[j];
                for (int k = j - 1; k >= 0; k--) {
                    int b = lines[k];
                    int sumOfTwoLines = a + b;
                    if (c < sumOfTwoLines) {
                        int sum = sumOfTwoLines + c;
                        if (sum > res) {
                            res = sum;
                            resIsReady = true;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }
}

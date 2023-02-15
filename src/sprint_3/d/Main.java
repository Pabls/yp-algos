package sprint_3.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int childrenCount = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] greedFactors = new int[childrenCount];
        for (int i = 0; i < childrenCount; i++) {
            greedFactors[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int cookiesCount = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer2 = new StringTokenizer(reader.readLine());
        int[] cookieSizes = new int[cookiesCount];
        for (int i = 0; i < cookiesCount; i++) {
            cookieSizes[i] = Integer.parseInt(tokenizer2.nextToken());
        }

        Arrays.sort(greedFactors);
        Arrays.sort(cookieSizes);

        int happyChildren = 0;
        int cookieIndex = 0;

        for (int greedFactor : greedFactors) {
            for (int j = cookieIndex; j < cookiesCount; j++) {
                if (cookieSizes[j] >= greedFactor) {
                    happyChildren++;
                    cookieIndex = j + 1;
                    break;
                }
            }
        }
        System.out.println(happyChildren);
    }
}

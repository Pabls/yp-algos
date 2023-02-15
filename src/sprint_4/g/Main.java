package sprint_4.g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int zeroCounter = 0;
        int oneCounter = 0;
        int maxValue = 0;
        for (int i = 0; i < count; i++) {
            String token = tokenizer.nextToken();
            if (token.equals("0")) {
                zeroCounter++;
            } else {
                oneCounter++;
            }
            System.out.println("zeroCounter " + zeroCounter + " , oneCounter " + oneCounter);
            if (zeroCounter == oneCounter) {
                maxValue = i + 1;
                System.out.println("!!!! zeroCounter " + zeroCounter + " , oneCounter " + oneCounter + ", i  " + i);
            }
        }
        System.out.println(maxValue);
    }
}

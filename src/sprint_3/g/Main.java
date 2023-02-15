package sprint_3.g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final String ZERO = "0";
    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int zeroCounter = 0;
        int oneCounter = 0;
        int twoCounter = 0;

        int count = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        for (int i = 0; i < count; i++) {
            switch (tokenizer.nextToken()) {
                case ZERO:
                    zeroCounter++;
                    break;
                case ONE:
                    oneCounter++;
                    break;
                case TWO:
                    twoCounter++;
                    break;
            }
        }
        addValue(ZERO, zeroCounter);
        addValue(ONE, oneCounter);
        addValue(TWO, twoCounter);

        System.out.println(sb);
    }

    private static void addValue(String value, int counter) {
        for (int i = 0; i < counter; i++) {
            sb.append(value).append(" ");
        }
    }
}

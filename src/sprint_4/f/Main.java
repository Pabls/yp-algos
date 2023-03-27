package sprint_4.f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        Map<String, StringBuilder> map = new LinkedHashMap<>();
        for (int i = 0; i < count; i++) {
            String key = getKey(tokenizer.nextToken().toCharArray());
            StringBuilder values = map.get(key);
            if (values == null) {
                values = new StringBuilder();
            }
            values.append(i).append(" ");
            map.put(key, values);
        }

        map.forEach((k, v) -> stringBuilder.append(v).append("\n"));

        System.out.println(stringBuilder);
    }

    private static String getKey(char[] arr) {
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
}

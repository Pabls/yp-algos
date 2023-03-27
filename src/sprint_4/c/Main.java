package sprint_4.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int basis = Integer.parseInt(reader.readLine());
        int module = Integer.parseInt(reader.readLine());
        String value = reader.readLine();
        int count = Integer.parseInt(reader.readLine());
        String[] arr = new String[count];

        for (int i = 0; i < count; i++) {
            arr[i] = reader.readLine();
        }

        StringTokenizer tokenizer;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            tokenizer = new StringTokenizer( arr[i]);
            int startIndex = Integer.parseInt(tokenizer.nextToken()) - 1;
            int endIndex = Integer.parseInt(tokenizer.nextToken());
            long hash = getHash(value.substring(startIndex, endIndex), basis, module);
            sb.append(hash).append("\n");
        }
        System.out.println(sb);
    }

    private static long getHash(String value, int basis, int module) {
        long hash = 0;
        for (int i = 0; i < value.length(); i++) {
            int x = value.charAt(i);
            hash = (hash * basis + x) % module;
        }
        return hash;
    }
}

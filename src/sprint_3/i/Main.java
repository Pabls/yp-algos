package sprint_3.i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] ids = new int[count];
        for (int i = 0; i < count; i++) {
            ids[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int idsCount = Integer.parseInt(reader.readLine());



    }
}

package sprint_1.e_long_word;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int charsCount = Integer.parseInt(reader.readLine());

        SortedMap<Integer, String> map = new TreeMap<>();

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        while (tokenizer.hasMoreElements()) {
            String value = tokenizer.nextToken();
            if (map.containsKey(value.length()))
                continue;
            map.put(value.length(), value);
        }

        System.out.println(map.get(map.lastKey()));
        System.out.println(map.lastKey());
    }
}

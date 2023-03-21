package sprint_3.i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int arrSize = Integer.parseInt(reader.readLine());

        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arrSize; i++) {
            int id = Integer.parseInt(tokenizer.nextToken());
            if (map.containsKey(id)) {
                int value = map.get(id);
                map.put(id, value + 1);
            } else {
                map.put(id, 1);
            }
        }
        int idsCountForShow = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();

        final int[] counter = {0};
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> {
                    if (o1 > o2) {
                        return -1;
                    } else if (o1 < o2) {
                        return 1;
                    } else {
                        return 0;
                    }
                }))
                .forEach(e -> {
                    if (counter[0] < idsCountForShow) {
                        counter[0]++;
                        sb.append(e.getKey()).append(" ");
                    }
                });
        System.out.println(sb);
    }
}

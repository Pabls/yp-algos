package sprint_4.xyz_final_tasks.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int documentsCount = Integer.parseInt(reader.readLine());

        Map<String, Map<Integer, Integer>> documentsMap = new HashMap<>();

        for (int i = 0; i < documentsCount; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            while (tokenizer.hasMoreTokens()) {
                String key = tokenizer.nextToken();
                Map<Integer, Integer> indexes = documentsMap.get(key);
                int docNumberKey = i + 1;
                if (indexes != null) {
                    indexes.merge(docNumberKey, 1, Integer::sum);
                } else {
                    documentsMap.put(key, new HashMap<>() {{
                        put(docNumberKey, 1);
                    }});
                }
            }
        }

        int queriesCount = Integer.parseInt(reader.readLine());

        Map<String, Integer> uniqueWordsFromSearchQuery = new HashMap<>();
        Map<Integer, Integer> currentDocMap = new HashMap<>();
        Comparator<Map.Entry<Integer, Integer>> comparator = createComparator();

        for (int i = 0; i < queriesCount; i++) {
            uniqueWordsFromSearchQuery.clear();
            currentDocMap.clear();
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                if (uniqueWordsFromSearchQuery.get(token) == null && documentsMap.get(token) != null) {
                    documentsMap.get(token).forEach((key, value) -> currentDocMap.merge(key, value, Integer::sum));
                    uniqueWordsFromSearchQuery.put(token, 1);
                }
            }

            currentDocMap.entrySet()
                    .stream()
                    .sorted(comparator)
                    .limit(5)
                    .forEach((o) -> stringBuilder.append(o.getKey()).append(" "));

            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static Comparator<Map.Entry<Integer, Integer>> createComparator() {
        return (o1, o2) -> {
            if (o1.getValue() > o2.getValue()) {
                return -1;
            } else if (o1.getValue() < o2.getValue()) {
                return 1;
            } else {
                return o1.getKey().compareTo(o2.getKey());
            }
        };
    }
}

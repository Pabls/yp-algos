package sprint_4.xyz_final_tasks.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// A. Поисковая система
// https://contest.yandex.ru/contest/24414/problems/A/
// Отчет 84818014
// https://contest.yandex.ru/contest/24414/run-report/84818014/

/*
-- ПРИНЦИП РАБОТЫ И ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ  --
* На вход подается n документов, при считывании документов, информация об отдельных словах в каждом из них заносится
* в documentsMap , где в качестве ключа используется слово а в качестве значения map номеров документов и количества вхождений
* данного слова в них.
* Далее на вход подается m поисковых запросов. При считывании запросов, отдельные слова из них заносятся в map в качестве ключа,
* что помогает в работе с дублирующимеся словами из запроса. Так же при считывании запроса вхождения отдельных слов в документы сразу
* проверяются и инофрмация о них заносится в отдельную map. После считывания информации из 1 запроса из этой map вся информация обрабатывается,
* сортируется и заносится для вывода в stringBuilder.
*
-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
* Доступ к элементу в map в лучшем случае осуществляется за O(1) а в худшем за O(n)
* Временную сложность обработки документов можно представить как O(n)
* Временнную сложность обработки запросов можно представить как O(m)
* В совокупности сложность работы можно предсавить как O(n + m)
-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
* Для хранения слов из документов используется map, которую можно предсавить как занимающая  O(n) памяти
* Также для хранения информации о поисковых запросах кол-во занимаемой памяти можно пердставить как O(m)
* В совокупности занимаемую память можно предсавить как O(n + m)
* */
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

        Set<String> uniqueWordsFromSearchQuery = new HashSet<>();
        Map<Integer, Integer> currentDocMap = new HashMap<>();
        Comparator<Map.Entry<Integer, Integer>> comparator = createComparator();

        for (int i = 0; i < queriesCount; i++) {
            uniqueWordsFromSearchQuery.clear();
            currentDocMap.clear();
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                if (!uniqueWordsFromSearchQuery.contains(token) && documentsMap.get(token) != null) {
                    documentsMap.get(token).forEach((key, value) -> currentDocMap.merge(key, value, Integer::sum));
                    uniqueWordsFromSearchQuery.add(token);
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

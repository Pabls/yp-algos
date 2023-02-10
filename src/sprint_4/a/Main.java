package sprint_4.a;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Map<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            String value = scanner.nextLine();
            if (!map.containsKey(value)) {
                map.put(value, value);
                sb.append(value).append("\n");
            }
        }
        System.out.println(sb);
    }
}


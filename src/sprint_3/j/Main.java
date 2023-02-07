package sprint_3.j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int itemsCount = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] arr = new int[itemsCount];

        for (int i = 0; i < itemsCount; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        bubbleSort(arr, sb);
        if (sb.length() == 0) {
            String value = Arrays.toString(arr).replace("[", "").replaceAll(",", "").replace("]", "");
            sb.append(value).append("\n");
        }
        System.out.println(sb);
    }

    private static void bubbleSort(int[] srcArr, StringBuilder sb) {
        for (int i = 0; i < srcArr.length; i++) {
            boolean stop = true;
            for (int j = 0; j < srcArr.length - 1; j++) {
                int firstItem = srcArr[j];
                int secondItem = srcArr[j + 1];
                if (firstItem > secondItem) {
                    int tmp = firstItem;
                    srcArr[j] = secondItem;
                    srcArr[j + 1] = tmp;
                    stop = false;
                }
            }
            if (stop) {
                break;
            } else {
                String value = Arrays.toString(srcArr).replace("[", "").replaceAll(",", "").replace("]", "");
                sb.append(value).append("\n");
            }
        }
    }
}

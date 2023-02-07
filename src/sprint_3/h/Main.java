package sprint_3.h;

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
        String[] strArr = new String[itemsCount];

        for (int i = 0; i < itemsCount; i++) {
            strArr[i] = tokenizer.nextToken();
        }

        insertionSortWithComparator(strArr);
        System.out.println(
                Arrays.toString(strArr)
                        .replace(" ", "")
                        .replace("[", "")
                        .replaceAll(",", "")
                        .replace("]", "")
        );
    }

    private static void insertionSortWithComparator(String[] array) {
        for (int i = 1; i < array.length; i++) {
            String itemToInsert = array[i];

            int j = i;
            while (j > 0 && compareTwoString(itemToInsert, array[j - 1])) {
                array[j] = array[j - 1];
                j = j - 1;
            }
            array[j] = itemToInsert;
        }
    }

    private static boolean compareTwoString(String first, String second) {
        String a = first + second;
        String b = second + first;
        boolean res = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) > b.charAt(i)) {
                res = true;
                break;
            }
            if (a.charAt(i) < b.charAt(i)) {
                res = false;
                break;
            }
        }
        return res;
    }
}

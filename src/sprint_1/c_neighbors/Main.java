package sprint_1.c_neighbors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static final String SEPARATOR = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(reader.readLine()); // количество строк
        final int m = Integer.parseInt(reader.readLine()); // количество столбцов

        final String[] matrixValues = new String[n];

        for (int i = 0; i < n; i++) {
            matrixValues[i] = reader.readLine();
        }

        final int searchValueN = Integer.parseInt(reader.readLine()); // строка с нужным элементом
        final int searchValueM = Integer.parseInt(reader.readLine()); // столбец с нужным элементом

        // Начало поиска
        String[] stringsWithSearchValue = matrixValues[searchValueN].split(SEPARATOR);
        final List<Integer> result = new ArrayList<>();

        final int topIndex = searchValueN - 1;
        final int bottomIndex = searchValueN + 1;

        int leftIndex = searchValueM - 1;
        int rightIndex = searchValueM + 1;

        if (topIndex >= 0) {
            String topString = matrixValues[topIndex].split(SEPARATOR)[searchValueM];
            result.add(Integer.parseInt(topString));
        }

        if (bottomIndex <= n - 1) {
            String bottomString = matrixValues[bottomIndex].split(SEPARATOR)[searchValueM];
            result.add(Integer.parseInt(bottomString));
        }

        if (leftIndex >= 0) {
            String leftString = stringsWithSearchValue[leftIndex];
            result.add(Integer.parseInt(leftString));
        }

        if (rightIndex <= m - 1) {
            String rightString = stringsWithSearchValue[rightIndex];
            result.add(Integer.parseInt(rightString));
        }

        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) {
                System.out.print(SEPARATOR);
            }
        }
    }
}

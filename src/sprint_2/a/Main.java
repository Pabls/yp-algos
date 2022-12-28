package sprint_2.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rowCount = Integer.parseInt(reader.readLine()); // строки
        int columnCount = Integer.parseInt(reader.readLine()); // столбцы

        String[][] srcRows = new String[rowCount][columnCount];

        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
                srcRows[rowIndex][columnIndex] = tokenizer.nextToken();
            }
        }

        StringBuilder builder = new StringBuilder();

        for (int j = 0; j < columnCount; j++) {
            for (int i = 0; i < rowCount; i++) {
                builder.append(srcRows[i][j]).append(" ");
            }
            builder.append("\n");
        }

        System.out.println(builder);
    }
}

package sprint_1.k_lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String resultString = reader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

        StringBuilder builder = new StringBuilder();
        while (stringTokenizer.hasMoreTokens()) {
            builder.append(stringTokenizer.nextToken());
        }
        String valueForSum = reader.readLine();



        //-----------------------------------
        BigInteger res = new BigInteger(builder.toString()).add(new BigInteger(valueForSum));
        char[] chars = String.valueOf(res).toCharArray();

        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
            if (i < chars.length - 1) {
                System.out.print(" ");
            }
        }
    }
}

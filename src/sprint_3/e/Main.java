package sprint_3.e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String data = reader.readLine();
        String[] dataArr = data.split(" ");
        int pricesCount = Integer.parseInt(dataArr[0]);
        int money = Integer.parseInt(dataArr[1]);

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] prices = new int[pricesCount];
        for (int i = 0; i < pricesCount; i++) {
            prices[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(prices);

        int housesCount = 0;
        for (int i = 0; i < pricesCount; i++) {
            if (prices[i] <= money) {
                money = money - prices[i];
                housesCount++;
            } else if (prices[i] > money) {
                break;
            }
        }
        System.out.println(housesCount);
    }
}

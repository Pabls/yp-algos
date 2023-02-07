package sprint_3.l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int daysCount = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int pricePerOneBicycle = Integer.parseInt(reader.readLine());

        int[] intScore = new int[daysCount];
        for (int i = 0; i < daysCount; i++) {
            intScore[i] = Integer.parseInt(tokenizer.nextToken());
        }


        int pricePerOneBicycleRes = searchIndex(intScore, pricePerOneBicycle, 0, intScore.length, -1);
        if (pricePerOneBicycleRes >= 0) {
            pricePerOneBicycleRes++;
        }

        int pricePerTwoBicyclesRes = searchIndex(intScore, pricePerOneBicycle * 2, 0, intScore.length, -1);
        if (pricePerTwoBicyclesRes >= 0) {
            pricePerTwoBicyclesRes++;
        }
        System.out.println(pricePerOneBicycleRes + " " + pricePerTwoBicyclesRes);
    }

    private static int searchIndex(int[] score, int searchItem, int left, int right, int prevIndex) {
        if (right <= left) {
            return prevIndex;
        }

        int middle = (left + right) / 2;
        if (score[middle] >= searchItem) {
            prevIndex = middle;
            return searchIndex(score, searchItem, left, middle, prevIndex);
        } else {
            return searchIndex(score, searchItem, middle + 1, right, prevIndex);
        }
    }
}


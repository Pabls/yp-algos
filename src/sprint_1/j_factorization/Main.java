package sprint_1.j_factorization;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        List<Integer> factors = new ArrayList<>();

        boolean isNeedToWork = true;
        int currentPrimeNumber = 2;

        while (isNeedToWork) {
            isNeedToWork = num != 1;

            if (num % currentPrimeNumber == 0) {
                factors.add(currentPrimeNumber);
                num = num / currentPrimeNumber;
            } else {
                for (int i = currentPrimeNumber + 1; i <= num; i++) {
                    if (i * i > num) {
                        currentPrimeNumber = num;
                        break;
                    } else if (isPrimeNumber(i)) {
                        currentPrimeNumber = i;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < factors.size(); i++) {
            System.out.print(factors.get(i));
            if (i < factors.size() - 1) {
                System.out.print(" ");
            }
        }
    }

    public static boolean isPrimeNumber(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

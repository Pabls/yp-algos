package sprint_2.l;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        BigInteger bi = fib(n);

        System.out.println(bi.mod(BigInteger.valueOf((long) (Math.pow(10, k)))));
//        long a = 0;
//        long b = 1;
//        long next = 1;
//        // обработка данных
//        if (n == 0 || n == 1) {
//            System.out.println(next);
//        } else {
//            for (long i = 2; i <= n; ++i) {
//                next = a % 10 + b % 10;
//                a = b % 10;
//                b = next;
//                System.out.println("next = " + next + " , next pow 10 " + Math.pow(next, 10));
//
//                System.out.println(next + ((n / 10) * 10));
//            }


        //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711
//
//            long aa = (long) Math.pow(10, k);
//            System.out.println("next is  " + next + " , aa is " + aa + " (next % aa) - " + (next % k));
    }


    static BigInteger fib(int n) {
        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c = BigInteger.valueOf(1);
        for (int j = 2; j <= n; j++) {
            c = a.add(b);
            a = b;
            b = c;
        }

        return (b);
    }
}

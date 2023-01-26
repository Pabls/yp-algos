package sprint_2.l;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        double res = getFibonacci(n);
        System.out.println("res " + res);

        //BigInteger bi = fib(n);

        //System.out.println(bi);
        //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711

        //System.out.println(bi.mod(BigInteger.valueOf((long) (Math.pow(10, k)))));
    }

    public static double getFibonacci(int n) {
        double f1 = Math.pow(((1 + Math.sqrt(5)) / 2.0), n);
        double f2 = Math.pow(((1 - Math.sqrt(5)) / 2.0), n);

        return Math.floor((f1 - f2) / Math.sqrt(5));
    }


    static int fib(int n) {
        int counter = 0;
        int a = 1;
        int b = 1;
        int value = 1;
        for (int j = 2; j <= n; j++) {
            value = a % 10 + b % 10;
            a = b % 10;
            b = value;
            System.out.println(value);
        }
//        BigInteger a = BigInteger.valueOf(1);
//        BigInteger b = BigInteger.valueOf(1);
//        BigInteger c = BigInteger.valueOf(1);
//        for (int j = 2; j <= n; j++) {
//            c = a.add(b);
//            a = b;
//            b = c;
//        }

        return (b);
    }
}

package sprint_2.l;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        long module = (long) Math.pow(10, k);

        long res = fib(n, module);
        long v = res % module;
        System.out.println(v);
    }

    static long fib(int n, long module) {
        long a = 1;
        long b = 1;
        long c = 1;
        for (int j = 2; j <= n; j++) {
            c = (a + b) % module;
            a = b;
            b = c;
        }
        return b;
    }
}

//import java.math.BigInteger;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int k = scanner.nextInt();
//
//        BigInteger bi = fib(n);
//
//        System.out.println(bi.mod(BigInteger.valueOf((long) (Math.pow(10, k)))));
//    }
//
//
//
//    static BigInteger fib(int n) {
//        BigInteger a = BigInteger.valueOf(1);
//        BigInteger b = BigInteger.valueOf(1);
//        BigInteger c = BigInteger.valueOf(1);
//        for (int j = 2; j <= n; j++) {
//            c = a.add(b);
//            a = b;
//            b = c;
//        }
//
//        return (b);
//    }
//}


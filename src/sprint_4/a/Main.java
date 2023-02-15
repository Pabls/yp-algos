package sprint_4.a;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int basis = Integer.parseInt(scanner.nextLine());
        int module = Integer.parseInt(scanner.nextLine());
        String value = scanner.nextLine();
        //long hash = getHash(value, basis, module);
        System.out.println(getHash(value, basis, module));
    }


//    private static BigInteger getHash(String value, int basis, int module) {
//        if (value == null || value.isBlank()) {
//            return BigInteger.ZERO;
//        }
//
//        int lastIndex = value.length() - 1;
//        BigInteger startHash = BigInteger.ZERO;
//        BigInteger bb = BigInteger.valueOf(basis);
//        for (int i = 0; i < value.length() - 1; i++) {
//            startHash = startHash.add(BigInteger.valueOf(value.charAt(i)).multiply(bb.pow(lastIndex)));
//            lastIndex--;
//        }
//        BigInteger lv = BigInteger.valueOf(value.charAt(value.length() - 1));
//        return startHash.add(lv).mod(BigInteger.valueOf(module));
//    }

//    private static long getHash(String value, long basis, long module) {
//        if (value == null || value.isBlank()) {
//            return 0;
//        }
//
//        long lastIndex = value.length() - 1;
//        long startHash = 0;
//        for (int i = 0; i < value.length() - 1; i++) {
//            startHash += (value.charAt(i) * Math.pow(basis, lastIndex)) % module;
//            lastIndex--;
//        }
//        int lastValue = value.charAt(value.length() - 1);
//        return (startHash + (lastValue % module)) % module;
//    }

    private static long getHash(String value, long basis, long module) {
        if (value == null || value.isBlank()) {
            return 0;
        }

        long lastIndex = value.length() - 1;
        long startHash = 0;
        long bm = basis % module;
        for (int i = 0; i < value.length() - 1; i++) {
            long a = (value.charAt(i) % module);
            long b = (long) Math.pow(bm, lastIndex % module) % module;
            long c = (a * b) % module;
            startHash = (startHash + c) % module;
            System.out.println("a " + a + " , b " + b + " , c " + c + " , startHash " + startHash + " , lastIndex " + lastIndex);

            lastIndex--;
        }
        long lastValue = value.charAt(value.length() - 1) % module;
        return (startHash + lastValue) % module;
    }
    //445 305 197
    //421 482 743

//    private static long getHash(String value, long basis, long module) {
//        if (value == null || value.isBlank()) {
//            return 0;
//        }
//
//        long lastIndex = value.length() - 1;
//        long startHash = 0;
//        for (int i = 0; i < value.length() - 1; i++) {
//            startHash += value.charAt(i) * Math.pow(basis, lastIndex);
//            lastIndex--;
//        }
//        int lastValue = value.charAt(value.length() - 1);
//        return (startHash + (lastValue % module)) % module;
//    }

//    private static BigInteger getHash(String value, long basis, long module) {
//        if (value == null || value.isBlank()) {
//            return BigInteger.ZERO;
//        }
//
//        int lastIndex = value.length() - 1;
//        BigInteger startHash = BigInteger.ZERO;
//        BigInteger bimodule = BigInteger.valueOf(module);
//        BigInteger bm = BigInteger.valueOf(basis);
//        for (int i = 0; i < value.length() - 1; i++) {
//            BigInteger a = BigInteger.valueOf(value.charAt(i));
//            BigInteger b = bm.pow(lastIndex);
//            BigInteger c = a.multiply(b);
//            startHash = startHash.add(c);
//            System.out.println("a " + a + " , b " + b + " , c " + c + " , startHash " + startHash);
//            lastIndex--;
//        }
//        BigInteger lastBi = BigInteger.valueOf(value.charAt(value.length() - 1));
//        BigInteger res = startHash.add(lastBi).mod(bimodule);
//        return res;
//    }
}

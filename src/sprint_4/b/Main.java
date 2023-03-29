package sprint_4.b;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int basic = 1000;
        int module = 123987123;
        boolean needToSearchValues = true;

        while (needToSearchValues) {
            String fStr = getRandStr();
            String sStr = getRandStr();
            long firstHash = getHash(fStr, basic, module);
            long secondHash = getHash(sStr, basic, module);

            if (firstHash == secondHash) {
                System.out.println(fStr + " : " + sStr);
                needToSearchValues = false;
            }
        }
    }

    private static long getHash(String value, int basis, int module) {
        long hash = 0;
        for (int i = 0; i < value.length(); i++) {
            int x = value.charAt(i);
            hash = (hash * basis + x) % module;
        }

        return hash;
    }

    private static int leftLimit = 97; // letter 'a'
    private static int rightLimit = 122; // letter 'z'
    private static int targetStringLength = 10;
    private static Random random = new Random();

    private static String getRandStr() {
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}

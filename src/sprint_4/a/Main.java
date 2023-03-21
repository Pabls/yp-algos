package sprint_4.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int basis = Integer.parseInt(reader.readLine());
        int module = Integer.parseInt(reader.readLine());
        String value = reader.readLine();
        System.out.println(getHash(value, basis, module));
    }

    private static long getHash(String value, int basis, int module) {
        long hash = 0;
        for (int i = 0; i < value.length(); i++) {
            int x = value.charAt(i);
            hash = (hash * basis + x) % module;
        }

        return hash;
    }
}

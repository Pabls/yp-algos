package sprint_4.h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String first = reader.readLine();
        String second = reader.readLine();
        if (first.length() != second.length()) {
            System.out.println("NO");
            return;
        }

        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        String res = "YES";
        for (int i = 0; i < first.length(); i++) {
            Character fch = first.charAt(i);
            Character sch = second.charAt(i);
            Character keyChar = map.get(fch);
            Character secondKeyChar = map2.get(sch);

            if (keyChar == null) {
                map.put(fch, sch);
                map2.put(sch, fch);
            } else if (!keyChar.equals(sch) || (secondKeyChar != null && !secondKeyChar.equals(fch))) {
                res = "NO";
                break;
            }
        }
        System.out.println(res);
    }
}

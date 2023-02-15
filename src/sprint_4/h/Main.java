package sprint_4.h;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        if (first.length() != second.length()) {
            System.out.println("NO");
            return;
        }
        Map<Character, Character> map = new HashMap<>();
        String res = "YES";
        for (int i = 0; i < first.length(); i++) {
            Character fch = first.charAt(i);
            Character sch = second.charAt(i);
            Character keyChar = map.get(fch);
            System.out.println("fch " + fch + " , sch " + sch + " keyChar  " + keyChar);
            if (keyChar == null) {
                map.put(fch, sch);
            } else if (!map.get(fch).equals(sch)) {
                res = "NO";
                break;
            }
        }
        System.out.println(res);
    }
}

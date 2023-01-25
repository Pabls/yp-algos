package sprint_2.j;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commandCount = Integer.parseInt(scanner.nextLine());
        String[] commands = new String[commandCount];
        StringBuilder sb = new StringBuilder();
        LinkedQueue lk = new LinkedQueue();

        for (int i = 0; i < commandCount; i++) {
            commands[i] = scanner.nextLine();
        }

        for (int i = 0; i < commandCount; i++) {
            String command = commands[i];
            if (command.equals("get")) {
                sb.append(lk.get()).append("\n");
            } else if (command.equals("size")) {
                sb.append(lk.getSize()).append("\n");
            } else {
                String value = getValueFromCommand(command);
                lk.put(value);
            }
        }

        System.out.println(sb);
    }

    private static String getValueFromCommand(String command) {
        int startIndex = command.indexOf(" ");
        int endIndex = command.length();
        return command.substring(startIndex + 1, endIndex);
    }
}

class LinkedQueue {

    private Node head;
    private Node tail;
    private int itemsCount = 0;


    String get() {
        if (itemsCount == 0) {
            return "error";
        }
        Node n = head;
        String value = n.value;
        head = n.next;
        itemsCount--;
        return value;
    }

    void put(String value) {
        if (head != null) {
            Node n = head;
            boolean hasNext = n.next != null;
            while (n.next != null) {
                n = n.next;
            }
            n.next = new Node(value);
        } else {
            head = new Node(value);
        }
        itemsCount++;
    }

    int getSize() {
        return itemsCount;
    }


    private static class Node {
        private Node next;
        private Node prev;
        private String value;

        public Node(String value) {
            this.value = value;
        }

        public Node(Node prev, String value, Node next) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }
}

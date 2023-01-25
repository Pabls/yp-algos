package sprint_2.j;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commandCount = Integer.parseInt(scanner.nextLine());
        String[] commands = new String[commandCount];

        for (int i = 0; i < commandCount; i++) {
            commands[i] = scanner.nextLine();
        }

        StringBuilder sb = new StringBuilder();
        LinkedQueue lk = new LinkedQueue();

        for (int i = 0; i < commandCount; i++) {
            String command = commands[i];
            System.out.println("command is " + command);
            if (command.equals("get")) {
                sb.append(lk.get()).append("\n");
            } else if (command.equals("size")) {
                sb.append(lk.getSize()).append("\n");
            } else {
                String value = getValueFromCommand(command);
                lk.put(value);
            }
            System.out.println("--------------------");
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


    LinkedQueue() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }


    String get() {
        if (itemsCount == 0) {
            return "error";
        }

        itemsCount--;

        String value = head.value;
        Node next = head.next;
        head = new Node(null, next.value, next.next);
        return value;
    }

    void put(String value) {
        itemsCount++;

        if (head.value == null) {
            head.value = value;
            return;
        }

        if (tail.value == null) {
            tail.value = value;
            return;
        }

        final Node l = tail;
        final Node newNode = new Node(l, value, null);
        tail = newNode;
        l.next = newNode;

//
//        if(tail == null) {
//            tail = new Node()
//        }
//
//        if (head == null) {
//            head = new Node(value);
//        } else if (tail == null) {
//            tail = new Node(value);
//            head.setNext(tail);
//        } else {
//            tail.setNext(new Node(value));
//            tail = tail.getNext();
//            System.out.println("!!!! " + head.next);
//        }
    }

    int getSize() {
        return itemsCount;
    }


    private static class Node {
        private Node next;
        private Node prev;
        private String value;

        public Node() {
        }

        public Node(Node prev, String value, Node next) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }
}

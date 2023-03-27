package sprint_4.xyz_final_tasks.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(reader.readLine());
        CustomHashMap hashTable = new CustomHashMap();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commandCount; i++) {
            handleCommand(reader.readLine(), hashTable, sb);
        }
        System.out.println(sb);
    }

    private static void handleCommand(String command, CustomHashMap hashTable, StringBuilder sb) {
        String[] commandParts = command.split(" ");
        switch (commandParts[0]) {
            case "put":
                hashTable.put(Integer.parseInt(commandParts[1]), Integer.parseInt(commandParts[2]));
                break;
            case "delete":
                Integer deleteValue = hashTable.delete(Integer.parseInt(commandParts[1]));
                sb.append(Objects.requireNonNullElse(deleteValue, "None"));
                sb.append("\n");
                break;
            case "get":
                Integer getValue = hashTable.get(Integer.parseInt(commandParts[1]));
                sb.append(Objects.requireNonNullElse(getValue, "None"));
                sb.append("\n");
                break;
            default: // Do nothing
        }
    }
}


class CustomHashMap {
    private static final int CAPACITY = 509;

    private Node[] buckets;

    CustomHashMap() {
        buckets = new Node[CAPACITY];
    }

    private void putValue(Node node, Integer key, Integer value) {
        if (node.key.equals(key)) {
            node.value = value;
        } else if (node.next == null) {
            Node nextNode = new Node(key, value);
            nextNode.prev = node;
            node.next = nextNode;
        } else {
            putValue(node.next, key, value);
        }
    }

    public void put(Integer key, Integer value) {
        int index = getIndex(key);
        Node node = buckets[index];
        if (node == null) {
            buckets[index] = new Node(key, value);
        } else {
            putValue(node, key, value);
        }
    }

    private Integer getValue(Node node, Integer key) {
        if (node == null) {
            return null;
        } else if (node.key.equals(key)) {
            return node.value;
        } else {
            return getValue(node.next, key);
        }
    }

    public Integer get(Integer key) {
        int index = getIndex(key);
        Node node = buckets[index];
        return getValue(node, key);
    }

    private Integer deleteValue(Node node, Integer key, int index) {
        if (node == null) {
            return null;
        } else if (node.key.equals(key)) {
            Integer value = node.value;
            if (node.prev == null) {
                buckets[index] = node.next;
            } else {
                node.prev.next = node.next;
            }
            node = null;
            return value;
        } else {
            return deleteValue(node.next, key, index);
        }
    }

    public Integer delete(Integer key) {
        int index = getIndex(key);
        Node node = buckets[index];
        return deleteValue(node, key, index);
    }

    private int getIndex(Integer key) {
        if (key == null) {
            return 0;
        }

        return Math.abs(key.hashCode() % CAPACITY);
    }

    private class Node {
        private Integer key;
        private Integer value;

        private Node next;
        private Node prev;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
}

package sprint_4.xyz_final_tasks.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

// B. Хеш-таблица
// https://contest.yandex.ru/contest/24414/problems/B/
// Отчет 84817820
// https://contest.yandex.ru/contest/24414/run-report/84817820/

/*
-- ПРИНЦИП РАБОТЫ И ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ  --
* На вход подаются команды из определенного набора (put, get, delete), каждая команда обрабатывается и в соответствии
* с ней вызывается определенный метод CustomHashMap
* CustomHashMap состоит из массива фиксированной длинны, по условию задачи поддерживать рехеширование и
* масштабирование хеш-таблицы не требуется
* При вызове какого либо метода, на вход подается объект key , путем получения остатака от дедления его hashCode на capacity массива
* вычисляется индекс для опеределения того, с какой ячейкой массива работать. Доступ к ячейке массива выполняется быстро что можно представить как O(1)
* В качестве объектов наполенеия массива выступают объекты типа Node по аналогии с LinkedList,
* что позволяет разрешать коллизии методом цепочек
-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
* При плохом распеределении хешкодов элементы будут распологаться сгруппированно в виде набора элементов Node,
 временную сложность в таком случае можно представить как O(n)
* При хорошем распределении элементы будут распологаться в разных ячейках массива , доступ к ним будет быстрыми и
* временную сложность в таком случае можно представить как O(1)
-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
* Пустая таблица, состящая только из массива будет занимать O(1) , по мере заполенния пространнственную сложность
* можно будет представить как O(n)
* */
public class Main {

    private static final int MIN_CAPACITY = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(reader.readLine());
        CustomHashMap hashTable = new CustomHashMap(getCapacity(commandCount));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commandCount; i++) {
            handleCommand(reader.readLine(), hashTable, sb);
        }
        System.out.println(sb);
    }

    private static int getCapacity(int commandCount) {
        int capacity = commandCount / MIN_CAPACITY;
        if (capacity < MIN_CAPACITY) {
            return MIN_CAPACITY;
        } else {
            return capacity;
        }
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

    private int capacity;
    private Node[] buckets;

    CustomHashMap(int capacity) {
        this.capacity = capacity;
        buckets = new Node[capacity];
    }

    private void putValue(Node node, Integer key, Integer value) {
        if (node.key.equals(key)) {
            node.value = value;
        } else if (node.next == null) {
            Node nextNode = new Node(key, value);
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

    private Integer deleteValue(Node node, Node parentNode, Integer key, int index) {
        if (node == null) {
            return null;
        } else if (node.key.equals(key)) {
            Integer value = node.value;
            if (parentNode == null) {
                buckets[index] = node.next;
            } else {
                parentNode.next = node.next;
            }
            node = null;
            return value;
        } else {
            return deleteValue(node.next, node, key, index);
        }
    }

    public Integer delete(Integer key) {
        int index = getIndex(key);
        Node node = buckets[index];
        return deleteValue(node, null, key, index);
    }

    private int getIndex(Integer key) {
        if (key == null) {
            return 0;
        }

        return Math.abs(key.hashCode() % capacity);
    }

    private class Node {
        private Integer key;
        private Integer value;
        private Node next;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
}

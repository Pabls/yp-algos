package sprint_2.i;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commandCount = Integer.parseInt(scanner.nextLine());
        int queueSize = Integer.parseInt(scanner.nextLine());
        String[] commands = new String[commandCount];
        for (int i = 0; i < commandCount; i++) {
            commands[i] = scanner.nextLine();
        }

        // обработка данных
        MyQueueSized queue = new MyQueueSized(queueSize);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < commandCount; i++) {
            String command = commands[i];
            if (command.equals("peek")) {
                String value = queue.peek();
                sb.append(value).append("\n");
            } else if (command.equals("pop")) {
                String value = queue.pop();
                sb.append(value).append("\n");
            } else if (command.equals("size")) {
                int size = queue.getSize();
                sb.append(size).append("\n");
            } else {
                String value = getValueFromCommand(command);
                boolean isSuccess = queue.push(value);
                if (!isSuccess) {
                    sb.append("error").append("\n");
                }
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

class MyQueueSized {

    private int itemsCount = 0;
    private String[] queue;
    private int head = 0;
    private int tail = 0;

    MyQueueSized(int maxSize) {
        queue = new String[maxSize];
    }

    boolean push(String value) {
        if (itemsCount == queue.length) {
            return false;
        }

        queue[tail] = value;
        tail = (tail + 1) % queue.length;
        itemsCount++;
        return true;
    }

    String pop() {
        if (itemsCount == 0) {
            return "None";
        }

        String value = queue[head];
        queue[head] = null;
        head = (head + 1) % queue.length;
        itemsCount--;
        return value;
    }

    String peek() {
        if (itemsCount == 0) {
            return "None";
        } else {
            return queue[head];
        }
    }

    int getSize() {
        return itemsCount;
    }
}

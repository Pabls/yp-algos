package sprint_2.xyz_final_tasks.a;

import java.util.Scanner;

// A. Дек
// Отчет 81278296
// https://contest.yandex.ru/contest/22781/run-report/81278296/

/*
-- ПРИНЦИП РАБОТЫ --
*
*
-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
*
*
-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
*
*
-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
*
*
* */
public class Main {

    public static void main(String[] args) {
        // Чтение данных
        Scanner scanner = new Scanner(System.in);
        int commandsCount = Integer.parseInt(scanner.nextLine());
        int bufferSize = Integer.parseInt(scanner.nextLine());
        String[] commands = new String[commandsCount];

        for (int i = 0; i < commandsCount; i++) {
            commands[i] = scanner.nextLine();
        }

        // Обработка данных
        CircleBuffer buffer = new CircleBuffer(bufferSize);
        StringBuilder sb = new StringBuilder();

        for (String command : commands) {
            handleCommand(command, buffer, sb);
        }
        System.out.println(sb);
    }

    private static void handleCommand(String command, CircleBuffer buffer, StringBuilder sb) {
        if (command.equals("pop_front")) {
            setResult(buffer.popFront(), sb);
        } else if (command.equals("pop_back")) {
            setResult(buffer.popBack(), sb);
        } else if (command.startsWith("push_front")) {
            boolean isSuccess = buffer.pushFront(getValueFromCommand(command));
            setNegativePushResultIfNeed(isSuccess, sb);
        } else if (command.startsWith("push_back")) {
            boolean isSuccess = buffer.pushBack(getValueFromCommand(command));
            setNegativePushResultIfNeed(isSuccess, sb);
        }
    }

    private static String getValueFromCommand(String command) {
        int startIndex = command.indexOf(" ");
        int endIndex = command.length();
        return command.substring(startIndex + 1, endIndex);
    }

    private static void setResult(String res, StringBuilder sb) {
        if (res == null) {
            sb.append("error");
        } else {
            sb.append(res);
        }
        sb.append("\n");
    }

    private static void setNegativePushResultIfNeed(boolean isSuccess, StringBuilder sb) {
        if (!isSuccess) {
            sb.append("error").append("\n");
        }
    }
}

class CircleBuffer {
    private String[] deque;
    private int head = 0;
    private int tail = 0;
    private int itemsCount = 0;

    CircleBuffer(int size) {
        deque = new String[size];
    }

    boolean pushFront(String value) {
        if (itemsCount == deque.length) {
            return false;
        }

        // Добавляем элемент
        head = (head - 1 + deque.length) % deque.length;
        deque[head] = value;
        itemsCount++;
        return true;
    }

    boolean pushBack(String value) {
        if (itemsCount == deque.length) {
            return false;
        }

        // Добавляем элемент
        deque[tail] = value;
        tail = (tail + 1) % deque.length;
        itemsCount++;
        return true;
    }

    String popFront() {
        if (itemsCount == 0) {
            return null;
        }

        // Ищем элемент
        String res = deque[head];
        deque[head] = null;
        head = (head + 1) % deque.length;
        itemsCount--;
        return res;
    }

    String popBack() {
        if (itemsCount == 0) {
            return null;
        }

        // Ищем элемент
        tail = (tail - 1 + deque.length) % deque.length;
        String res = deque[tail];
        deque[tail] = null;
        itemsCount--;
        return res;
    }
}

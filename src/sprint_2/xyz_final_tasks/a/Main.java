package sprint_2.xyz_final_tasks.a;

import java.util.Scanner;

// A. Дек
// Отчет 81382927
// https://contest.yandex.ru/contest/22781/run-report/81382927/

/*
-- ПРИНЦИП РАБОТЫ --
* Дек реализован на основе кольцевого буфера (так было указано в задаче)
* За основу был взят кольцевой буфер из примера курса: Структура данных очередь. Реализация
* Буфер реализован в виде класса CircleBuffer содержащего массив, длинна массива задается при вводе
* Для удобства контроля кол-ва элементов, CircleBuffer содержит дополнительное поле itemsCount
* Для доступа к первому и последенему элементам дека, CircleBuffer содержит индексы этих элементов head и tail
* В случае запроса на получение элементов из пустой очереди , будет возвращен null, что приведет к сообщению "error"
* В случае попытки добавления нового элемента в заполененную очередь будет возвращен false, что приведет к сообщению "error"
-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
* Дек структура данных позволяющая добавлять и получать элементы с двух сторон(двунаправленная очередь)
* Благодаря тому, что в работе используются индексы head и tail есть возможность получения элементов с обеих сторон очереди
* Благодаря применению массива для храниения элементов, нет необходимости расходовать лишнюю память и
* есть возможность имитации кольцевого буфера без затрат на перестроение элементов и с быстрым доступом к элементам по индексу
-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
* В условии задачи было отмечено что все операции должны выполняться за O(1) , что и реализованно так как доступ к элементу ,
* расположенному в массиве осуществляется за O(1) и нет итераций по элементам массива
* В связи с тем, что для выполнения всех операций ввода нужно обработать каждый элемент,
* общая временная сложность данного решения будет O(n)
*
-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
* При полном заполнении массива элементами в количестве n элементов,
* CircleBuffer  будет занимать O(n) + внутренние элементы (head, tail и itemsCount)
* что в савокупности можно представить как O(n)
*
* */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsCount = Integer.parseInt(scanner.nextLine());
        int bufferSize = Integer.parseInt(scanner.nextLine());

        CircleBuffer<Integer> buffer = new CircleBuffer<>(bufferSize);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < commandsCount; i++) {
            String command = scanner.nextLine();
            handleCommand(command, buffer, sb);
        }

        System.out.println(sb);
    }

    private static void handleCommand(String command, CircleBuffer<Integer> buffer, StringBuilder sb) {
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

    private static Integer getValueFromCommand(String command) {
        int startIndex = command.indexOf(" ");
        int endIndex = command.length();
        return Integer.parseInt(command.substring(startIndex + 1, endIndex));
    }

    private static void setResult(Integer res, StringBuilder sb) {
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

class CircleBuffer<T> {
    private T[] deque;
    private int head = 0;
    private int tail = 0;
    private int itemsCount = 0;

    CircleBuffer(int size) {
        deque = (T[]) new Object[size];
    }

    boolean pushFront(T value) {
        if (itemsCount == deque.length) {
            return false;
        }

        // Добавляем элемент
        head = (head - 1 + deque.length) % deque.length;
        deque[head] = value;
        itemsCount++;
        return true;
    }

    boolean pushBack(T value) {
        if (itemsCount == deque.length) {
            return false;
        }

        // Добавляем элемент
        deque[tail] = value;
        tail = (tail + 1) % deque.length;
        itemsCount++;
        return true;
    }

    T popFront() {
        if (itemsCount == 0) {
            return null;
        }

        // Ищем элемент
        T res = deque[head];
        deque[head] = null;
        head = (head + 1) % deque.length;
        itemsCount--;
        return res;
    }

    T popBack() {
        if (itemsCount == 0) {
            return null;
        }

        // Ищем элемент
        tail = (tail - 1 + deque.length) % deque.length;
        T res = deque[tail];
        deque[tail] = null;
        itemsCount--;
        return res;
    }
}

package sprint_2.f;

import java.util.Scanner;

public class StackMax {

    private static final String NONE_ANSWER = "None";
    private static final String ERROR_ANSWER = "error";

    private static final String COMMAND_PUSH = "push";
    private static final String COMMAND_POP = "pop";
    private static final String COMMAND_GET_MAX = "get_max";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsCount = scanner.nextInt();
        String[] commands = new String[commandsCount];

        for (int i = 0; i < commandsCount; i++) {
            String next = scanner.next();
            if (next.equals(COMMAND_PUSH)) {
                next = scanner.next();
            }
            commands[i] = next;
        }

        StackNode tail = null;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < commandsCount; i++) {
            String command = commands[i];
            switch (command) {
                case COMMAND_GET_MAX:
                    if (tail != null) {
                        builder.append(tail.getMax()).append("\n");
                    } else {
                        builder.append(NONE_ANSWER).append("\n");
                    }
                    break;
                case COMMAND_POP:
                    if (tail != null) {
                        tail = tail.getPrev();
                    } else {
                        builder.append(ERROR_ANSWER).append("\n");
                    }
                    break;
                default:
                    int value = Integer.parseInt(command);
                    if (tail != null) {
                        int max = Math.max(value, tail.getMax());
                        StackNode newNode = new StackNode(value, null, tail, max);
                        tail.setNext(newNode);
                        tail = newNode;
                    } else {
                        tail = new StackNode(value, null, null, value);
                    }
                    break;
            }
        }
        //handleCommand(tail);
        System.out.println(builder);
    }

    private static void handleNode(StackNode tail) {
        if (tail != null) {
            System.out.println(tail);
            if (tail.getPrev() != null) {
                handleNode(tail.getPrev());
            }
        }
    }
}

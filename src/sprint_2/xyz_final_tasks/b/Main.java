package sprint_2.xyz_final_tasks.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// B. Калькулятор
// Отчет 81183357
// https://contest.yandex.ru/contest/22781/run-report/81183357/

/*
-- ПРИНЦИП РАБОТЫ --
* Поданная на вход строка разбивается на подстроки с помощью StringTokenizer
* Каждая подстрока последовательно проверяется на принадлежность или к числу или к операции
* В случае, если подстрока является числом,она помещается в стек (использовал java.util.Stack)
* Если подстрока является операцией, то из стека извлекаются для числа, над ними производится выполнение необходимой операции и результат ложится на вершину стека
* Для корректного округления результата в случае операции деления отрицательного числа на положительное применен  Math.floorDiv
* В случае , когда все подстроки обработаны, результатом всех операций считается число, расположенное на вершине стека
-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
* Стек структура данных работающая по принципу LIFO, что дает возможность быстрого получения двух чисел без их поиска для проведения над ними операции
-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
* Входная строка состоит из n подстрок над каждой из которых выполняется операция опеределения принадлежности и,
*  либо записи в стек, либо выполнения операции, без дополнительных итераций
* В связи с этим временна чсложность будет О(n)
-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
* Входная строка состоит из n подстрок, для хранения чисел используется стек,
* в худшем случае стек будет заполнеи n элементами, что можно представить как О(n)
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        Stack<Integer> digits = new Stack<>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            Integer digit = parseToken(token);
            if (digit != null) {
                digits.push(digit);
            } else {
                performOperation(digits, token);
            }
        }

        System.out.println(digits.pop());
    }

    private static Integer parseToken(String token) {
        Integer result;
        try {
            result = Integer.parseInt(token);
        } catch (NumberFormatException ex) {
            result = null;
        }
        return result;
    }

    private static void performOperation(Stack<Integer> digits, String token) {
        int firstValue = digits.pop();
        int secondValue = digits.pop();
        switch (token) {
            case "+":
                digits.push(secondValue + firstValue);
                break;
            case "-":
                digits.push(secondValue - firstValue);
                break;
            case "*":
                digits.push(secondValue * firstValue);
                break;
            case "/":
                digits.push(Math.floorDiv(secondValue, firstValue));
                break;
            default:
                break;
        }
    }
}

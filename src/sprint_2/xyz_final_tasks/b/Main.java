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

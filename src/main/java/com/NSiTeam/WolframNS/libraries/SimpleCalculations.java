package com.NSiTeam.WolframNS.libraries;

import java.util.Stack;

public class SimpleCalculations {

    public String calculate(String expression) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operations = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                double num = 0;
                int decimal = 0;
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    if (expression.charAt(i) == '.') {
                        decimal = 1;
                    } else {
                        num = num * 10 + (expression.charAt(i) - '0');
                        decimal *= 10;
                    }
                    i++;
                }
                i--;
                numbers.push(num / Math.max(decimal, 1));
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operations.isEmpty() && precedence(c) <= precedence(operations.peek())) {
                    compute(numbers, operations);
                }
                operations.push(c);
            } else if (c == '(') {
                operations.push(c);
            } else if (c == ')') {
                while (operations.peek() != '(') {
                    compute(numbers, operations);
                }
                operations.pop();
            }
        }

        while (!operations.isEmpty()) {
            compute(numbers, operations);
        }

        return numbers.pop().toString();
    }

    private int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    private void compute(Stack<Double> numbers, Stack<Character> operations) {
        double b = numbers.pop();
        double a = numbers.pop();
        switch (operations.pop()) {
            case '+':
                numbers.push(a + b);
                break;
            case '-':
                numbers.push(a - b);
                break;
            case '*':
                numbers.push(a * b);
                break;
            case '/':
                numbers.push(a / b);
                break;
        }
    }
}

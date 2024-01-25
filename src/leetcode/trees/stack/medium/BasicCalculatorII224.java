package leetcode.trees.stack.medium;

import java.util.*;

public class BasicCalculatorII224 {
    public static void main(String[] args) {
        // "0-2147483647"
        System.out.println("\"3-22*2\" should be evaluated to -41: " + calculate("3-22*2"));
        System.out.println("\"22*2 - 3\" should be evaluated to 41: " + calculate("22*2 - 3"));
        System.out.println("\"1-1+1\" should be evaluated to 1: " + calculate("1-1+1"));
        System.out.println("\"0-2147483647\" should be evaluated to -2147483647: " + calculate("0-2147483647"));
        System.out.println("\"108\" should be evaluated to 108: " + calculate("108"));
        System.out.println("\"3+2*2\" should be evaluated to 7: " + calculate("3+2*2"));
        System.out.println("\"3 - 2/2\" should be evaluated to 2: " + calculate("3 - 2 / 2"));

        //System.out.println("\" \" should be evaluated to 0: " + calculate(" "));
    }

    // calculateArray [1,-,1,+,1] doOperation(1,calculateArray[1,+,1],-) doOperation(1,calculateArray[1],+)

    public static int calculateArray(String[] s) {
        if (s.length == 1) {
            return Integer.parseInt(s[0]);
        }
        ;
        return doOperation(Integer.parseInt(s[0]), calculateArray(Arrays.copyOfRange(s, 2, s.length)), s[1]);
    }

    public static int doOperation(Integer param1, Integer param2, String operand) {
        return switch (operand) {
            case "+" -> param1 + param2;
            case "-" -> param1 - param2;
            case "*" -> param1 * param2;
            default -> param1 / param2;
        };
    }

    public static int calculate(String s) {
        ArrayList<String> parsedString = new ArrayList<>();
        int i = 0;
        Integer currentNumber = null;

        while (i < s.length()) {
            char current = s.charAt(i);
            i++;
            if (current == ' ') continue;
            if (!isOperand(current)) {
                currentNumber = currentNumber == null ? valueOf(current) : currentNumber * 10 + valueOf(current);
            } else {
                parsedString.add(String.valueOf(currentNumber));
                currentNumber = null;
                parsedString.add(String.valueOf(current));
            }
        }

        if (currentNumber != null) parsedString.add(String.valueOf(currentNumber));
        ArrayList<String> onlySums = new ArrayList<>();
        boolean nextNegative = false;
        for (int j = 0; j < parsedString.size(); j = j + 2) {
            String param1 = parsedString.get(j); //
            String operand = parsedString.get(j + 1); // *
            if (operand.equals("*") || operand.equals("/")) {
                String param2 = parsedString.get(j + 2);
                j++;
                String result = String.valueOf(doOperation(Integer.parseInt(param1), Integer.parseInt(param2), operand));
                if (nextNegative) {
                    onlySums.add("-" + result);
                    nextNegative =false;
                } else {
                    onlySums.add(result);
                }
            } else if (operand.equals("-")) {
                nextNegative = true;
                onlySums.add(param1);
            } else {
                onlySums.add(param1);
            }
        }
        int result = 0;
        for (String el : onlySums) {
            result += Integer.parseInt(el);
        }
        return result;
    }

    public static boolean isOperand(Character charAt) {
        return charAt == '+' || charAt == '-' || charAt == '*' || charAt == '/';
    }

    public static int valueOf(Character charAt) {
        return Integer.parseInt(String.valueOf(charAt));
    }

    // ----- Somebodies solution that I am not fully able to replicate ----- //
    public static int calculate2(String s) {
        var stack = new ArrayDeque<Integer>();
        var previousNumber = 0;
        var latestOperation = '+';

        for (var c : s.toCharArray()) {
            switch (c) {
                case '+', '-', '*', '/' -> {
                    eval(stack, previousNumber, latestOperation);
                    latestOperation = c;
                    previousNumber = 0;
                }
                case ' ' -> {
                }
                default -> previousNumber = previousNumber * 10 + Integer.parseInt(String.valueOf(c));
            }
        }

        // add last number
        eval(stack, previousNumber, latestOperation);

        var rez = 0;
        while (!stack.isEmpty())
            rez += stack.pop();

        return rez;
    }

    private static void eval(Deque<Integer> stack, int n, char op) {
        switch (op) {
            case '-' -> stack.push(-n);
            case '*' -> stack.push(stack.pop() * n);
            case '/' -> stack.push(stack.pop() / n);
            default -> stack.push(n);
        }
    }
}

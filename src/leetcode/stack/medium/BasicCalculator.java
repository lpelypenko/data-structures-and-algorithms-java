package leetcode.stack.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/basic-calculator-ii/">227. Basic Calculator II</a>
 * Given a string s which represents an expression, evaluate this expression and return its value.
 * The integer division should truncate toward zero. You may assume that the given expression is
 * always valid. All intermediate results will be in the range of [-231, 231 - 1].
 */
public class BasicCalculator {

    /**
     * Evaluate previous operations and execute when High Precedence is encountered.
     *
     * @param operators
     * @param numbers
     */
    private static void evaluatePrevOperator(final Deque<Character> operators, final Deque<Integer> numbers) {

        if(!operators.isEmpty() && (operators.peek() == '*' || operators.peek() == '/')) {
            final int num2 = numbers.pop(); // first to take is the 2nd number
            final int num1 = numbers.pop();

            switch (operators.pop()) {
                case '*':
                    numbers.push(num1 * num2);
                    break;
                case '/':
                    numbers.push(num1 / num2);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Process remaining operations (Low Precedence) from LEFT to RIGHT order.
     *
     * @param operators
     * @param numbers
     * @return
     */
    private static int processRemainingOperators(final Deque<Character> operators, final Deque<Integer> numbers) {
        int result = numbers.pollLast();

        while(!operators.isEmpty()) {
            final int num = numbers.pollLast();

            switch(operators.pollLast()) {
                case '+':
                    result += num;
                    break;
                case '-':
                    result -= num;
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    public static int calculate(final String input) {
        final Deque<Integer> numbers = new ArrayDeque<>();
        final Deque<Character> operators = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();

        for(final char ch: input.toCharArray()) {
            if(ch == ' ') {
                continue;
            }
            if(Character.isDigit(ch)) {
                builder.append(ch);
            }
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                numbers.push(Integer.valueOf(builder.toString()));
                evaluatePrevOperator(operators, numbers);
                operators.push(ch);
                builder = new StringBuilder();
            }
        }
        numbers.push(Integer.valueOf(builder.toString()));
        evaluatePrevOperator(operators, numbers);
        return processRemainingOperators(operators, numbers);
    }

    public static void main(final String[] args) {
        final String s1 = "3+2*2";
        System.out.println("Calculate(" + s1 + "): " + calculate(s1));

        final String s2 = " 3/2 ";
        System.out.println("Calculate(" + s2 + "): " + calculate(s2));

        final String s3 = " 3+5 / 2 ";
        System.out.println("Calculate(" + s3 + "): " + calculate(s3));

        final String s4 = " 3+2 / 2 * 5";
        System.out.println("Calculate(" + s4 + "): " + calculate(s4));

        final String s5 = "1+2*5/3+6/4*2";
        System.out.println("Calculate(" + s5 + "): " + calculate(s5));

        final String s6 = "10 - 5 + 9 - 2";
        System.out.println("Calculate(" + s6 + "): " + calculate(s6));

        final String s7 = "1-1+1";
        System.out.println("Calculate(" + s7 + "): " + calculate(s7));
    }
}
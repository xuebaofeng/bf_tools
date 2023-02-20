package leetcode;

import java.util.Stack;

public class ValidParentheses20 {
    public static void main(String[] args) {
        ValidParentheses20 c = new ValidParentheses20();
        boolean valid = c.isValid("()");
        System.out.println(valid);
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '{') stack.push('}');
            else if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
}

package stackOrQueue;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * @author Kyrie
 * @date 2023/1/13 10:26
 */
public class ValidParentheses_20 {

    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValid(s));
    }

    /**
     * 一共 3 种情况：
     *   1、左括号多：遍历完栈不空
     *   2、右括号多：栈提前空
     *   3、左右括号不匹配：匹配有括号时，栈顶元素不匹配
     * @param s
     * @return
     */
    public static boolean isValid (String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '('){
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        // 左括号多（栈不空）
        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }
}

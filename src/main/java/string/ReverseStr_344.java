package string;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * Constraints:
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 * @author Kyrie
 * @date 2023/1/6 10:11
 */
public class ReverseStr_344 {
    public static void main(String[] args) {
        String s = "hello";
        char[] chars = s.toCharArray();
        reverseStr(chars);
        System.out.println(chars);
    }
    /**
     * Kye 是找准区间，左闭右闭、左闭右开都可，不同的是边界条件以及while循环条件
     * while 循环，想区间满足放进去，不满足跳出来，代入值一试便知
     * @param s[l,r]
     * @param l
     * @param r
     */
    public static void reverseStr(char[] chars){
        int l = 0;
        int r = chars.length - 1;
        while(l < r){
            char temp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = temp;
        }
    }
}

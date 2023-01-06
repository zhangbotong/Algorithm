package string;

/**
 * Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
 * If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.
 * Example 1:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Example 2:
 * Input: s = "abcd", k = 2
 * Output: "bacd"
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of only lowercase English letters.
 * 1 <= k <= 104
 * @author Kyrie
 * @date 2023/1/6 09:37
 */
public class ReserveStr2_541 {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr2k(s, k));
    }

    /**
     * key 是 i = i + 2 * k，每 2k 个字符为一组，而不是无脑 i++;
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr2k(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, chars.length - 1);
            reverseStr(chars, left, right);
        }
        return new String(chars);
    }

        /**
         * @param s[l,r]
         * @param l
         * @param r
         */
    public static void reverseStr(char[] chars, int l, int r){
        while(l < r){
            char temp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = temp;
        }
    }

    /**
     * 不好
     * @param chars[l,r)
     * @param l
     * @param r
     */
    public static void reverseStrOpenSpace (char[] chars, int l, int r){
        while (l < r){
            char temp = chars[l];
            chars[l++] = chars[r - 1];
            chars[--r] = temp;
        }
    }

}

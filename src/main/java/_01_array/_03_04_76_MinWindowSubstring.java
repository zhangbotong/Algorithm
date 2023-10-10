package _01_array;

/**
 * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
 * 限制：S 和 T 中只包含英文字母；1 <= S.length, T.length <= 10^5
 * @author Kyrie
 * @date 2023/9/11 23:03
 */
public class _03_04_76_MinWindowSubstring {
    // 滑动窗口
    // 1. 定义两个指针 l、r，[l,r) 为窗口，内都是包含 T 的子串
    // 2. 定义一个 hashtable，记录 T 中每个字符出现的次数
    // 3. 遍历 S，若 S[r] 在 hashtable 中，则将其出现次数减一，若减一后仍大于等于0，则 count++；若 count == T.length，则说明当前窗口包含 T，记录当前窗口长度，然后将 l 右移，直到不包含 T
    public String minWindow(String s, String t) {
        int[] hashtable = new int[256];
        for (int i = 0; i <t.length(); i++) {
            hashtable[t.charAt(i)]++;
        }
        int l = 0, r = 0;
        int count = 0;
        while (r < s.length()) {
            if (hashtable[s.charAt(r)] > 0) {
                hashtable[s.charAt(r)]--;
                r++;
            }
        }
        return null;
    }
}

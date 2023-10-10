package _01_array;

import org.junit.jupiter.api.Test;

/**
 * 给定一个字符串，找出其中无重复字符的最长子串
 * 限制：0 <= s.length <= 5 * 104；s consists of English letters, digits, symbols and spaces.
 * @author Kyrie
 * @date 2023/9/7 11:31
 */
public class _03_02_3_LongestSubstringWithoutRepeatChar {
    // 滑动窗口
    // 定义一个 hashtable （数组），遇到首次出现字符则将其添加至 hashtable 并 expand window，否则 shrink window
    public int lengthOfLongestSubstring(String s) {
        boolean[] hash = new boolean[256];
        int l = 0, r = 0;
        int res = 0;
        // 循环不变量：[l,r) 为窗口，内都是无重复字符
        // 判断 r，若无重复字符，则 expand window(right++)；否则 shrink window(left++)
        while (l < s.length() && r < s.length()) {
            if (!hash[s.charAt(r)]) {
                hash[s.charAt(r)] = true;
                r++;
            }else {
                hash[s.charAt(l)] = false;
                l++;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }

    @Test
    void test() {
        String s = " ";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}


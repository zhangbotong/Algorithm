package _01_array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 1 <= s.length, p.length <= 3 * 10^4；s 和 p 仅包含小写字母。
 * @author Kyrie
 * @date 2023/8/17 10:39
 */
public class _03_01_FindAllAnagramsInAString_438 {
    /**
     * 滑动窗口：时间复杂度：O(n)，空间复杂度：O(1)。
     * 循环不变量：[left, right) 为当前在 p 中的字母。
     * 当 s.charAt(right) 在 p 中，且 [left, right) 中无此字符时(need[index]>0)时，need[right]--，且 expand window 即 right++;
     * 当 s.charAt(right) 不在 p 中，shrink window 至 left = right + 1。need[left]++，left++
     * 当 s.charAt(right) 在 p 中，且 [left, right) 中有此字符时，shrink window 至 left = right，同时 need[]--
     * 如果 [left, right) 的长度等于 p 的长度，即找到一个 anagram。加入结果集；将 left++，同时 need[]++
     * 终止条件：right == s.length()。
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] need = new int[26];
        for (int i = 0; i < p.length(); i++){
            need[p.charAt(i)  - 'a']++;
        }
        int l = 0, r = 0;
        // 循环不变量：[l,r) 为窗口，内都是 need 字母;
        // 判断 r，若 need，则 expand window(right++)；否则 shrink window(left++)
        while (l < s.length() && r < s.length()) {
            // need, expand window
            if (need[s.charAt(r) - 'a'] > 0) {
                need[s.charAt(r) - 'a']--;
                r++;
            } else {
                // not need, shrink window
                // 可能出现 left > right，相当于借了一个字符，目的是为了还回去让 right++
                //因为 l 每 forward 一步，其对应的 need 就+1。不仅复原p中值，也处理p未出现值。
                need[s.charAt(l) - 'a']++;
                l++;
            }
            // 找到结果，添加结果集（还原初始状态，放在上述逻辑的 shrink window 中）
            if (r - l == p.length()){
                res.add(l);
            }
        }
        return res;
    }

        @Test
    void test() {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> res = findAnagrams(s, p);
        System.out.println(res);
    }
}

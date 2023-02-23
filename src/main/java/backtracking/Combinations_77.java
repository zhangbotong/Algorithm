package backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *  Input: n = 4, k = 2
 *  Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Constraints: 1 <= n <= 20, 1 <= k <= n
 * @author Kyrie
 * @date 2023/1/31 09:51
 */
public class Combinations_77 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    /**
     * startIndex 的思想很重要，它相当于回溯的一个基本条件，是你每次循环的起点，保证不重复
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return res;
    }

    /**
     * 回溯三部曲：
     * 1、参数
     * 2、终止条件
     * 3、单层逻辑
     */
    private void backtracking (int n, int k, int startIndex){
        // 终止条件单拎出来，代码清晰（递归思想与普通面向过程编程的差异之处）
        // 终止条件，只处理结果，好。递归就放心大胆但递，专心做好一件事
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++){
            path.add(i);
            backtracking(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test(){
        System.out.println(combine(4, 2));
    }

    @Deprecated
    private void backtracking2 (int n, int k, int startIndex){
        for (int i = startIndex; i <= n; i++){
            path.add(i);
            // 第一反应是这种代码，不好，面向过程编程太习惯了
            // 相当于把【终止条件】放到【单层逻辑】里面，代码不够清晰，不好
            if (path.size() == k){
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                return;
            }
            backtracking(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }

}

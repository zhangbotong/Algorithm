package backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集
 * 示例: 输入: nums = [1,2,3] 输出: [ [3],   [1],   [2],   [1,2,3],   [1,3],   [2,3],   [1,2],   [] ]
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * @author Kyrie
 * @date 2023/2/17 09:57
 */
public class Subset_78 {
    /**
     * 跟组合问题不同的是，组合问题相当于是定了子集中元素的个数，子集是从 0 ～ n 个元素的组合
     * 说白了，组合问题是子集问题的一个特例，特定子集元素个数为 k
     */
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        backtracking(nums, 0);
        return res;
    }

    /**
     * 回溯三部曲：1、参数；2、终止条件；3、单层逻辑。（深度优先）
     * 平时你的思维是广度优先，[],[1], [2], [3], [1,2], [1,3], [2,3], [1,2,3] 这个顺序
     * 回溯是深度优先，[1], [1,2], [1,2,3], [1,3], [2], [2,3], [3], 这个顺序
     * 平时的思维方式也可以换个角度，试试深度优先（广度优先 = 循环；深度优先 = 递归）
     */
    private void backtracking(int[] nums, int startIndex) {
        if (startIndex == nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            // 最好把 add 和 remove 放一起； add 和 remove 放在同一层
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test() {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    @Deprecated
    private void backtracking2(int[] nums, int startIndex) {
        // add 和 backtracking 和 remove 没放一起，不好
        path.add(nums[startIndex]);
        res.add(new ArrayList<>(path));
        if (startIndex == nums.length - 1) {
            return;
        }
        for (int i = startIndex + 1; i < nums.length; i++) {
            backtracking2(nums, i);
            path.remove(path.size() - 1);
        }
    }
}

package dp;

import org.junit.jupiter.api.Test;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 1 <= nums.length <= 200, 1 <= nums[i] <= 100
 # * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 * @author Kyrie
 * @date 2023/5/11 09:28
 */
public class _09_PartitionEqSubsetSum_416 {
    /**
     * 暴力解法
     * sum/2，然后分别从数据取数，分为：1数和，2数和，3数和，...，n数和，这是最外层循环；
     * 针对 2 数和，排列Cn2，遍历数组，1+2，1+3， ···，1+n，2+3， 2+4，···， 2+n，···，n-1+n，需要 2 层循环。
     * 针对 3 数和，排列Cn3，需要写一个 3 层循环，1+2+3，1+2+4, ... , n-2+n-1+n
     * 针对 4 数和，排列Cn4，需要写一个 4 层循环，···，针对 n 数和，需要写一个 n 层循环
     * 内层循环的层数不固定，考虑使用回溯（DFS）替代循环（BFS）。DFS = recursion, BFS = loop
     * 对于数 1：1, 1+2, 1+3, ..., 1+n, 1+2+3,..., 1+n-1+n,..., 1+2+3+...+n
     * 对于数 2：2, 2+3, 2+4, ..., 2+n, 2+3+4,..., 2+n-1+n,..., 2+3+4+...+n
     * 对于数 3：3, 3+4, 3+5, ..., 3+n, 3+4+5,..., 3+n-1+n,..., 3+4+5+...+n
     * 深度优先，这回整齐了
     * DFS(递归)：每次把一个元素折腾完，然后就相当于去掉这个元素剩下的子集。子集？递归！
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (sum % 2 != 0){
            return false;
        }
        int target = sum / 2;
        return dfs(nums, 0, target);
    }

    /**
     * nums[startIndex, nums.length-1] 是否可以找到和为 target 的子集(whatever how many elements)
     */
    public boolean dfs (int[] nums, int startIndex, int target){
        if (target == nums[startIndex]){
            return true;
        }
        if (target < nums[startIndex]){
            return false;
        }
        for (int i = startIndex; i < nums.length; i++){
            if (dfs(nums, i+1, target - nums[i])){
                return true;
            }
        }
        return false;
    }

    @Test
    void test(){
        int[] nums = {1, 5, 13, 5};
        System.out.println(canPartition(nums));
    }
}

package dp;

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
     * sum/2，然后分别从数据取数，分为：1数和，2数和，3数和，...，n数和；
     * 针对每个如 2数和，遍历数组，数1 + 数2，数1 + 数3， 数1 + 数4， ···，数1 + 数n，数2 + 数3， 数2 + 数4，···， 数2 + 数n，···，数n-1 + 数n
     * 针对 3 数和，需要写一个 3 层循环，针对 4 数和，需要写一个 4 层循环，···，针对 n 数和，需要写一个 n 层循环
     * 这样显然不可取，考虑使用回溯。
     * DFS 就是为解决这种暴力遍历而生。
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
        return false;
    }
}

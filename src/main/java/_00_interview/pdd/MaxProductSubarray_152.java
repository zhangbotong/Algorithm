package _00_interview.pdd;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * eg. 输入: [2,3,-2,4] 输出: 6。解释: 子数组 [2,3] 有最大乘积 6。
 * eg. 输入: [-2,0,-1] 输出: 0。解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * 限制：1 <= nums.length <= 2 * 10^4, -10 <= nums[i] <= 10
 * @author Kyrie
 * @date 2023/10/6 16:20
 */
public class MaxProductSubarray_152 {
    public int maxProduct(int[] nums) {
        // max: 以当前元素结尾的（必须含）最大连续子数组乘积
        // min: 以当前元素结尾的（必须含）最小连续子数组乘积
        // ans: 最大乘积
        int max = nums[0], min = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;  // store the max because before updating min your max will already be updated
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            if (max > ans) {
                ans = max;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxProductSubarray_152 instance = new MaxProductSubarray_152();
        System.out.println(instance.maxProduct(new int[]{2, 3, -2, 4, -1, 3, -3}));
        System.out.println(instance.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(instance.maxProduct(new int[]{-2, 0, -1, 3, 0, -3}));
    }
}

package dp;

import org.junit.jupiter.api.Test;

/**
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 * eg. 1：
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 * eg. 2：
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 *
 * Constraints:
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 * @author Kyrie
 * @date 2023/3/2 10:02
 */
public class _03_MinCostClimbingStairs_746 {
    /**
     * cost[i]表示从第i阶楼梯向上爬需要支付的费用（一阶、二阶费用相同）
     * 楼顶即为 cost.length 阶楼梯
     * DP 五部曲：
     * 1、确定dp数组以及下标的含义：dp[i]表示爬到第i阶楼梯的最小花费
     * 2、确定递推公式：dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
     * 3、dp数组初始化：dp[0] = dp[1] = 0
     * 4、确定遍历顺序：从前往后遍历
     * 5、举例推导dp数组：dp[2] = min(dp[1] + cost[1], dp[0] + cost[0]) = min(0 + 15, 0 + 10) = 10
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = dp[1] = 0;
        // 楼顶：cost.length 阶楼梯
        for (int i = 2; i <= cost.length; i++){
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i -2]);
        }
        return dp[cost.length];
    }

    /**
     * 优化：由于dp[i]只与dp[i - 1]和dp[i - 2]有关，因此可以使用滚动数组优化空间复杂度，O(n) -> O(1)
     */
    public int minCostClimbingStairs2(int[] cost) {
        int dp0 = 0, dp1 = 0;
        for (int i = 2; i <= cost.length; i++){
            int dp2 = Math.min(dp0 + cost[i - 2], dp1 + cost[i - 1]);
            dp0 = dp1;
            dp1 = dp2;
        }
        return dp1;
    }


    @Test
    public void test(){
        int[] cost = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost));
    }
}

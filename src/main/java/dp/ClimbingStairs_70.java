package dp;

import org.junit.jupiter.api.Test;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢
 * 注意：给定 n 是一个正整数，且 1 <= n <= 45
 *
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1 阶 + 1 阶
 * 2 阶
 *
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1 阶 + 1 阶 + 1 阶
 * 1 阶 + 2 阶
 * 2 阶 + 1 阶
 * @author Kyrie
 * @date 2023/2/23 10:27
 */
public class ClimbingStairs_70 {
    /**
     * 此题的关键是将实际问题转换为数学问题，即找到递推公式
     * DP 五部曲：
     * 1、确定dp数组以及下标的含义
     * 2、确定递推公式
     * 3、dp数组初始化
     * 4、确定遍历顺序
     * 5、举例推导dp数组
     * 针对本题：
     * 1、dp[i]表示爬到第i阶楼梯的方法数
     * 2、递推公式，爬到第 n 阶楼梯的方法数 = 爬到第 n-1 阶楼梯的方法数 + 爬到第 n-2 阶楼梯的方法数。即 dp[i] = dp[i-1] + dp[i-2]
     * 3、dp数组初始化，dp[1] = 1, dp[2] = 2
     * 4、遍历顺序：从前往后遍历
     * 5、举例推导dp数组：dp[3] = dp[2] + dp[1] = 2 + 1 = 3
     * 因此，本题转换为数学问题后实质就是个斐波那契数列，属于是斐波那契数列的应用
     */
    public int climbStairs(int n) {
        // 0 阶楼梯不算，从 1 阶开始
        int[] dp = new int[3];
        // dp[i-2]
        dp[1] = 1;
        // dp[i-1]
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int sum = dp[1] + dp[2];// dp[i] = dp[i-1] + dp[i-2]
            dp[1] = dp[2];// dp[i-2] = dp[i-1](相当于 i++)
            dp[2] = sum;// dp[i-1] = dp[i](相当于 i++)
        }
        if (n == 1)
            return dp[1];
        return dp[2];
    }

    @Test
    public void test() {
        System.out.println(climbStairs(3));
    }
}

package dp;

import org.junit.jupiter.api.Test;

/**
 * 斐波那契数
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * 计算 F(n)
 * 0 1 1 2 3 5 8 13
 * @author Kyrie
 * @date 2023/2/23 09:27
 */
public class _01_Fibonacci_509 {
    /**
     * DP 五部曲：
     *  1、确定dp数组以及下标的含义
     *  2、确定递推公式
     *  3、dp数组初始化
     *  4、确定遍历顺序
     *  5、举例推导dp数组
     * 针对本题
     *  1、dp[i]表示第i个斐波那契数
     *  2、递推公式已给出：dp[i] = dp[i-1] + dp[i-2]
     *  3、dp 数组初始化题目已给出：dp[0] = 0, dp[1] = 1
     *  4、遍历顺序：从前往后遍历
     *  5、举例推导dp数组：dp[2] = dp[1] + dp[0] = 1 + 0 = 1
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <=n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 优化空间复杂度 O(n) -> O(1)，因为每次只用到了 dp[i-1] 和 dp[i-2]，所以可以只用两个变量来存储。（左脚踩右脚能上天）
     */
    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <=n; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }

    @Test
    public void test() {
        System.out.println(fib2(5));
    }
}

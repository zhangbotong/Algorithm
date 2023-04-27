package dp;

import org.junit.jupiter.api.Test;

/**
 * 题目：
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 示例 1：
 * 输入：n = 3
 * 输出：5
 */
public class _07_NumTrees_96 {
    /**
     * f(1) = 1
     * f(2) = 2
     * f(3):
     *  1. 1为根节点，2和3为右子树，左子树为空，f(3) = f(0) * f(2)
     *  2. 2为根节点，1为左子树，3为右子树，f(3) = f(1) * f(1)
     *  3. 3为根节点，1和2为左子树，右子树为空，f(3) = f(2) * f(0)
     *  f(3) = f(0) * f(2) + f(1) * f(1) + f(2) * f(0)
     * 可以看出 f(3) 由 f(0)、f(1)、f(2) 求得，因此可以用动态规划求解
     *
     * 递归五部曲：
     * 1、dp 数组及下标含义：dp[i] 表示以 1 ... i 为节点组成的二叉搜索树有多少种
     * 2、递推公式：dp[i] = dp[0] * dp[i - 1] + dp[1] * dp[i - 2] + ... + dp[i - 1] * dp[0]
     * 3、dp 数组初始化：dp[0] = 1
     * 4、确定遍历顺序：从前向后
     * 5、举例推导 dp 数组
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            // j：左子树节点个数（遍历以不同节点为根）
            for (int j = 0; j < i; j++) {
                // i: 节点个数，i - 1: 除去根节点的节点个数
                // 左子树 j 个节点 BST 个数 * 右子树 i - 1 - j 个节点 BST 个数
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        System.out.println(numTrees(3));
    }
}

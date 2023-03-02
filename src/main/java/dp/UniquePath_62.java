package dp;

import org.junit.jupiter.api.Test;

/**
 * 欠图
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 给定 m(row), n(column) 问总共有多少条不同的路径？
 * eg. 1
 * Input: m = 3, n = 7
 * Output: 28
 * eg. 2
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 * @author Kyrie
 * @date 2023/3/2 10:43
 */
public class UniquePath_62 {
    /**
     * 此题 dp 应为二维数组方能用下标 i,j 表示位置 (i, j)，数组值表示路径数（map：位置，路径数）
     * DP 五部曲：
     * 1、确定 dp 数组及下标含义：本题是二维数组，dp[i][j] 表示从起点到 (i, j) 的路径数
     * 2、确定递推公式：down + right。dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
     * 3、dp 数组初始化：用到了 i - 1, j - 1 >= 0，因此 i,j >= 1，初始化第一行、第一列为 1。换个角度，从图中也可知第一行、第一列特殊不满足递推公式，需初始化
     * 4、确定遍历顺序：从左到右，从上到下
     * 5、举例推导 dp 数组
     * 写代码顺序是 1、3、4、2、5
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 优化1：由于 dp[i][j] 只与 dp[i - 1][j] 和 dp[i][j - 1] 有关，因此可将 dp 数组压缩为一维数组
     * 优化2：数论：组合数 C(m + n - 2, m - 1) = (m + n - 2)! / (m - 1)! * (n - 1)!
     */


    @Test
    public void test() {
        System.out.println(uniquePaths(3, 7));
    }
}

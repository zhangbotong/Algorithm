package dp;

import org.junit.jupiter.api.Test;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * eg. 1
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * eg. 2
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 *
 * Constraints:
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] is 0 or 1.
 * @author Kyrie
 * @date 2023/3/2 11:07
 */
public class _5_UniquePath2_63 {
    /**
     * DP 五部曲：
     * 1、确定 dp 数组及下标含义：本题是二维数组，dp[i][j] 表示从起点到 (i, j) 的路径数
     * 2、确定递推公式：如果该点(i,j)是障碍物，则dp[i][j] = 0，表示无法到达，计算下一次时逻辑也是对的;若不是障碍物，则 down + right。dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
     * 3、dp 数组初始化：正常初始化第一行第一列为1，但若遇到障碍物，则该点及其后的点都为0
     * 4、确定遍历顺序：从左到右，从上到下
     * 5、举例推导 dp 数组
     * java 数组初始化默认值为 0
     * 关键是想明白遇到障碍物时 dp[i][j] = 0 表示无法到达，这样也不会影响按递推公式继续往下计算
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1){
                    continue;// 默认值为 0
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    @Test
    public void test() {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(this.uniquePathsWithObstacles(obstacleGrid));
    }
}

package dp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 01 背包
 * 有n件物品和一个最多能背重量为w 的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。
 * 每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大
 * 背包容量 = 4
 *      重量  价值
 * 物品0  1     15
 * 物品1  2     20
 * 物品2  4     30
 */
public class _08_01KnapsackTwoDim {

    /**
     * 01 背包，二维数组解法，先遍历背包容量，再遍历物品，符合自然思维。其中，物品从前往后，背包也从前往后
     */
    public int knapsack01TwoDimBagFirst(int[] w, int[] v, int bagSize) {
        int goodsCount = w.length - 1;
        int[][] dp = new int[goodsCount + 1][bagSize + 1];// 自带初始化第一行、第一列为 0；
        for (int b = 1; b <= bagSize; b++) {
            for (int i = 1; i <= goodsCount; i++) {
                if (b - w[i] < 0) {
                    dp[i][b] = dp[i - 1][b];
                } else {
                    int notPutI = dp[i - 1][b];
                    int putI = v[i] + dp[i - 1][b - w[i]];
                    dp[i][b] = Math.max(notPutI, putI);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp).replace("], ", "]\n"));
        return dp[goodsCount][bagSize];
    }

    /**
     * 01 背包，二维数组解法，先遍历物品，再遍历背包容量，物品从前往后，背包也从前往后
     */
    public int knapsack01TwoDimGoodsFirst(int[] w, int[] v, int bagSize) {
        int goodsCount = w.length - 1;
        int[][] dp = new int[goodsCount + 1][bagSize + 1];// 自带初始化第一行、第一列为 0
        for (int i = 1; i <= goodsCount; i++) {
            for (int b = 1; b <= bagSize; b++) {
                if (b - w[i] < 0) {
                    dp[i][b] = dp[i - 1][b];
                } else {
                    int notPutI = dp[i - 1][b];
                    int putI = v[i] + dp[i - 1][b - w[i]];
                    dp[i][b] = Math.max(notPutI, putI);
                }
            }
        }
        // print dp
        System.out.println(Arrays.deepToString(dp).replace("], ", "]\n"));
        return dp[goodsCount - 1][bagSize];
    }

    /**
     * 01 背包，二维数组解法，先遍历物品，再遍历背包容量，物品从前往后，背包容量从后往前
     */
    public int knapsack01TwoDimGoodsFirstKnapsackInverse (int[] w, int[] v, int bagSize){
        int goodsCount = w.length - 1;
        int[][] dp = new int[goodsCount + 1][bagSize + 1];// 自带初始化第一行、第一列为 0
        for (int i = 1; i <= goodsCount; i++) {
            for (int b = bagSize; b >= 1; b--) {
                if (b - w[i] < 0) {
                    dp[i][b] = dp[i - 1][b];
                } else {
                    int notPutI = dp[i - 1][b];
                    int putI = v[i] + dp[i - 1][b - w[i]];
                    dp[i][b] = Math.max(notPutI, putI);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp).replace("], ", "]\n"));
        return dp[goodsCount][bagSize];
    }

    public int knapsack01OneDim(int[] w, int[] v, int bagSize) {
        int goodsCount = w.length - 1;
        int[] dp = new int[bagSize + 1];
        for (int i = 1; i <= goodsCount; i++) {
            for (int b = bagSize; b >= w[i]; b--) {
                int notPutI = dp[b];// dp[b] = dp[i - 1][b];
                int putI = v[i] + dp[b - w[i]];// dp[b - w[i]] = dp[i - 1][b - w[i]];
                dp[b] = Math.max(notPutI, putI);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[bagSize];
    }

    @Test
    public void test() {
        int[] weight = {0, 1, 2, 4};
        int[] value = {0, 15, 20, 30};
        System.out.println(knapsack01TwoDimGoodsFirstKnapsackInverse(weight, value, 4));
    }
}

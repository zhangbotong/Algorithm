package tree;

import org.junit.jupiter.api.Test;

/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * @author Kyrie
 * @date 2023/7/17 14:29
 */
public class _15_MaxBT_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }

    /**
     * 前序遍历
     * 循环不变量：[leftIndex, rightIndex) 左闭右开。因此，循环中从 leftIndex 开始，i < rightIndex 结束，而不是 <=
     * 1、找到最大值作为root，并记录其下标splitIndex
     * 2、递归构造左右子树
     * 递归终止条件：leftIndex == rightIndex
     */
    private TreeNode buildTree(int[] nums, int leftIndex, int rightIndex){
        if (leftIndex == rightIndex) return null;
        int maxValue = Integer.MIN_VALUE;
        int splitIndex = 0;
        for (int i = leftIndex; i < rightIndex; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                splitIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = buildTree(nums, leftIndex, splitIndex);
        root.right = buildTree(nums, splitIndex + 1, rightIndex);
        return root;
    }

    private TreeNode buildTree3(int[] nums, int startIndex, int length) {
        if (length == 0) return null;
        int maxValue = Integer.MIN_VALUE;
        int splitIndex = 0;
        for (int i = startIndex; i < startIndex + length; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                splitIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        int leftLength = splitIndex - startIndex;
        int rightLength = length - leftLength - 1;
        root.left = buildTree3(nums, startIndex, leftLength);
        root.right = buildTree3(nums, splitIndex + 1, rightLength);
        return root;
    }

    @Test
    void test() throws Exception {
        int[] nums = {3,2,1,6,0,5};
        TreeNode root = constructMaximumBinaryTree(nums);
        System.out.println(root);
    }
}

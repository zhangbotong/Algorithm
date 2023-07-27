package tree;

/**
 * 计算给定二叉树的所有左叶子之和。
 * @author Kyrie
 * @date 2023/6/21 09:21
 */
public class _12_SumOfLeftLeaves_404 {
    // 前序遍历。两个限制：1、左子树；2、叶子节点
    public int sumOfLeftLeaves(TreeNode root) {
        // 递归终止条件
        if (root == null) return 0;
        // 处理逻辑（先序递归）
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null){
            sum += root.left.val;
        }
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
}

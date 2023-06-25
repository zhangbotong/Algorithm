package tree;

/**
 * 给定一个二叉树，判断它是否是平衡二叉树。
 * 平衡二叉树定义为：一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1.
 * 假设根节点高度为1，而不是0
 * @author Kyrie
 * @date 2023/6/19 09:33
 */
public class _10_BalancedBinTree_110 {
    // 思路一：前序遍历判断每个节点是否平衡，O(n^2)。
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // 后序遍历求每个节点高度，O(n)。
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    // 思路二：后序遍历判断平衡，O(n)。
    public boolean isBalanced2(TreeNode root) {
        return getHeightAndCheck(root) >= 0;
    }

    // 求得当前节点高度，同时判断是否平衡。若不平衡返回 -1，平衡返回高度。O(n)
    private int getHeightAndCheck(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeightAndCheck(root.left);
        int rightHeight = getHeightAndCheck(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

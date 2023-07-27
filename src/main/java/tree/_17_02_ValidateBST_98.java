package tree;

import org.junit.jupiter.api.Test;

/**
 * 验证二叉树是否是BST
 * constraints: The number of nodes in the tree is in the range [1, 104].
 * @author Kyrie
 * @date 2023/7/18 09:56
 */
public class _17_02_ValidateBST_98 {
    /**
     * 后序遍历
     * 递归
     * 验证root及其左右子树是否满足BST特性，
     * 递归终止条件：root为空，返回true
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        boolean leftIsBST = isValidBST(root.left, min, root.val);
        boolean rightIsBST = isValidBST(root.right, root.val, max);
        return leftIsBST && rightIsBST;
    }

    @Test
    public void test() {
        // [5,4,6,null,null,3,7]
        TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        System.out.println(isValidBST(root));
    }
}

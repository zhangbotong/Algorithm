package tree;

import org.junit.jupiter.api.Test;

/**
 * 计算完全二叉树节点个数
 * @author Kyrie
 * @date 2023/6/14 13:59
 */
public class _09_CountCompleteTreeNode_222 {
    /**
     * 递归 -- 后序遍历，O(n)
     */
    public int countNodes0(TreeNode root) {
        if (root == null) return 0;
        int leftCount = countNodes0(root.left);
        int rightCount = countNodes0(root.right);
        return leftCount + rightCount + 1;
    }

    /**
     * 递归，利用完全二叉树性质，O(logn * logn)
     * 完全二叉树的子树一定是满二叉树或不满但完全二叉树、完全二叉树节点树为2^h - 1
     * 判断满二叉树
     *      方法1，判断左右子树是否为满二叉树：左右子树高度是否相等。
     *          若等，则左子树一定为满二叉树，再递归右子树；
     *          若不等，则右子树一定比左子树低，且右子树一定是满二叉树。
     *      方法2，判断当前树是否为满二叉树：左子树最左节点高度与右子树最右节点高度是否相等。
     *          若等，则当前树一定为满二叉树，返回2^h - 1；
     *          若不等，则当前树一定不是满二叉树，递归左右子树。
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        // 判断左右子树是否为满二叉树
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == rightHeight) {
            // 左子树一定为满二叉树
            return 1 << leftHeight + countNodes(root.right);
        }
        // 右子树一定为满二叉树
        return 1 << rightHeight + countNodes(root.left);
    }

    // 不是最易理解的写法
    public int countNodes2 (TreeNode root) {
        if (root == null) return 0;
        // 判断当前树是否为满二叉树
        int lHeight = 1;// 根节点为第 1 层
        int rHeight = 1;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        while(leftNode != null) {
            leftNode = leftNode.left;
            lHeight++;
        }
        while(rightNode != null) {
            rightNode = rightNode.right;
            rHeight++;
        }
        if (lHeight == rHeight) {
            // 当前树一定为满二叉树，count = 2^h - 1
            return (1 << lHeight) - 1;
        }
        // 当前树一定不是满二叉树
        return countNodes2(root.left) + countNodes2(root.right) + 1;
    }

    /**
     * 获取完全二叉树高度，利用完全二叉树性质，只要找到最左节点即可.(为计算方便，返回第一层节点高度为 0)
     */
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + getHeight(root.left);
    }

    @Test
    void test() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        System.out.println(countNodes2(root));
    }
}

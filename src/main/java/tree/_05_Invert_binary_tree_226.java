package tree;

import org.junit.jupiter.api.Test;

/**
 * @author Kyrie
 * @date 2023/6/12 11:04
 */
public class _05_Invert_binary_tree_226 {
    /**
     * 前序/后序遍历
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // Preorder
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public void swap (TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    @Test
    void test() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        invertTree(root);
    }
}

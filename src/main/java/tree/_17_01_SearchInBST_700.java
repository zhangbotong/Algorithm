package tree;

import org.junit.jupiter.api.Test;

/**
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * constraints:
 * The number of nodes in the tree is in the range [1, 5000].
 * @author Kyrie
 * @date 2023/7/18 09:42
 */
public class _17_01_SearchInBST_700 {
    /**
     * 前序遍历
     * root为空，返回null；
     * 不为空，比较值，找到返回node，找不到根据大小及BST特性，递归其左子树或右子树
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (val < root.val) return searchBST(root.left, val);
        return searchBST(root.right, val);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
        System.out.println(searchBST(root, 2));
    }
}

package tree;

import org.junit.jupiter.api.Test;

/**
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 * @author Kyrie
 * @date 2023/7/27 20:43
 */
public class _21_InsertIntoBST_701 {
    /**
     * 递归遍历树的一支，找到空节点位置插入即可
     * 递归终止条件：root == null
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 递归终止条件
        if (root == null) return new TreeNode(val);
        // 单层处理逻辑
        if (val > root.val){
            root.right = insertIntoBST(root.right, val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);

        root.left = node2;
        root.right = node7;
        node2.left = node1;
        node2.right = node3;

        TreeNode res = insertIntoBST(root, 5);
        System.out.println(res);
    }
}

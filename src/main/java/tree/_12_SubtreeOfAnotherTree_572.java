package tree;

import org.junit.jupiter.api.Test;

/**
 * @author Kyrie
 * @date 2023/6/20 11:04
 */
public class _12_SubtreeOfAnotherTree_572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) {
            return false;
        }
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null ^ root2 == null) return false;
        if (root1.val != root2.val) return false;
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }

    @Test
    void test() {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(2);
        node1.left = node3;
        node1.right = node4;
        TreeNode node5 = new TreeNode(0);
        node3.left = node5;
        TreeNode subRoot = new TreeNode(4);
        TreeNode subNode1 = new TreeNode(1);
        TreeNode subNode2 = new TreeNode(2);
        subRoot.left = subNode1;
        subRoot.right = subNode2;
        System.out.println(isSubtree(root, subRoot));
    }
}

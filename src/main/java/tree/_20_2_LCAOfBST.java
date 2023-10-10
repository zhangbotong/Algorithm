package tree;

import org.junit.jupiter.api.Test;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先
 * constraints:
 *     树中节点的数目在范围 [2, 10^5] 内
 *     -10^9 <= Node.val <= 10^9
 *     所有 Node.val 互不相同
 *     p != q
 *     p 和 q 均存在于给定的二叉搜索树中
 * @author Kyrie
 * @date 2023/7/27 19:00
 */
public class _20_2_LCAOfBST {
    /**
     * 解体关键：当 p <= cur <= q 时，且是从上至下第一次遇到的满足条件的节点即为最近公共祖先
     * 因为，如果是第二次遇到，可能就不对了
     * 递归终止条件：root == null || p <= root <= q
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    @Test
    void test() {
        TreeNode root = new TreeNode(6);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(5);
        root.left = node1; root.right = node2;
        node1.left = node3; node1.right = node4;
        node2.left = node5; node2.right = node6;
        node4.left = node7; node4.right = node8;
        TreeNode res = lowestCommonAncestor(root, node7, node8);
        System.out.println(res.val);
    }
}

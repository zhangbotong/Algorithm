package tree;

import org.junit.jupiter.api.Test;

/**
 * 合并两个二叉树
 * 合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * @author Kyrie
 * @date 2023/7/17 16:20
 */
public class _16_MergeTwoBT_617 {
    /**
     * 前序
     * 递归终止条件：至少有一个是空树
     * 1、两棵树均null，返回null
     * 2、一棵树为null，返回另一棵树
     * 3、两棵树均不为null，合并，递归
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 ==null) return root1;
        // 两棵树均不为空，单层递归逻辑
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }

    @Test
    public void test() {
        TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode root2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));
        TreeNode merged = mergeTrees(root1, root2);
        System.out.println(merged);
    }
}

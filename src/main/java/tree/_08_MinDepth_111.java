package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最小深度
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 注意：是到叶子节点，对于只有一个孩子的节点他的最小深度不是 0
 * @author Kyrie
 * @date 2023/6/14 10:09
 */
public class _08_MinDepth_111 {
    /**
     * 递归 -- 后序
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 后序，左右中
        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);
        // 叶子节点
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 仅有一个孩子
        if (root.left == null) {
            return rightMinDepth + 1;
        }
        if (root.right == null) {
            return leftMinDepth + 1;
        }
        // 2 个孩子
        return Math.min(leftMinDepth, rightMinDepth) + 1;
    }

    // 层序遍历，迭代（至叶子节点即可）
    public int minDepth2(TreeNode root){
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            depth++;
            int curLevelSize = q.size();
            for(; curLevelSize > 0; curLevelSize--){
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return depth;
    }
}

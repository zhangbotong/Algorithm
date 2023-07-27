package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 * @author Kyrie
 * @date 2023/6/25 10:22
 */
public class _07_01_MaxDepthOfBT_104 {
    // 迭代，层序遍历
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            depth++;
            // 每次处理一层
            int curLevelSize = q.size();
            for(; curLevelSize > 0; curLevelSize--){
                TreeNode node = q.poll();
                // 只入队非空节点
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return depth;
    }
}

package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 在二叉树的每一行中找到最大的值。
 * @author Kyrie
 * @date 2023/6/21 11:26
 */
public class _04_05_FindMaxInEachLevel_515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int curLevelCount = q.size();
            int max = Integer.MIN_VALUE;
            for (; curLevelCount > 0; curLevelCount--){
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(max);
        }
        return res;
    }
}

package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的右视图
 * @author Kyrie
 * @date 2023/6/21 10:37
 */
public class _04_02_RightSideViewForBT_199 {
    // 层序遍历，每层判断最后一个节点
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        // 入队前判空
        q.offer(root);
        while(!q.isEmpty()){
            int curLevelCount = q.size();
            for (; curLevelCount > 0; curLevelCount--){
                TreeNode node = q.poll();
                if (curLevelCount == 1) res.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return res;
    }
}

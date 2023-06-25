package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * @author Kyrie
 * @date 2023/6/21 10:58
 */
public class _04_03_AverageOfLevelsInBT_637 {
    // 层序遍历每层求平均值
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int curLevelCount = q.size();
            double levelSum = 0;
            for (int i = 0; i < curLevelCount; i++){
                TreeNode node = q.poll();
                levelSum += node.val;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(levelSum / curLevelCount);
        }
        return res;
    }
}

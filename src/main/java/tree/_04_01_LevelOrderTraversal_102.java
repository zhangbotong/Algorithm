package tree;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 层序遍历只入队非空节点！！！
 * @author Kyrie
 * @date 2023/6/7 09:43
 */
public class _04_01_LevelOrderTraversal_102 {
    // 迭代法，易理解
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            // 每次进来遍历一层
            List<Integer> curLevelList = new ArrayList<>();
            int curLevelCount = queue.size();
            for (int i = 0; i < curLevelCount; i++){
                TreeNode node = queue.poll();
                curLevelList.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(curLevelList);
        }
        return res;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode left1 = new TreeNode(15);
        TreeNode right1 = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.left = left1;
        right.right = right1;
        List<List<Integer>> res = levelOrder(root);
        System.out.println(res);
    }
}

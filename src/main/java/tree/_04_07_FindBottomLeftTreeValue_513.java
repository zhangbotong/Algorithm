package tree;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * 限制：树非空
 * @author Kyrie
 * @date 2023/6/25 10:48
 */
public class _04_07_FindBottomLeftTreeValue_513 {
    // 打眼一看就是层序遍历，因为提到了最后一行，按行分类的都是层序遍历
    public int findBottomLeftValue(TreeNode root) {
        assert root != null;
        int res =  0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int curLevelCount = q.size();
            // 这里由于要用到每行第一个节点(用到下标序号)，所以不能用 curLevelCount--。
            // 如果是每行最后一个节点，就可以用curLevelCount--，curLevelCount == 1时，就是最后一个节点
            // 同理，如果需要用到每行的总数时，也不能用 curLevelCount--
            for(int i = 0; i < curLevelCount; i++){
                TreeNode node = q.poll();
                if (i == 0) res = node.val;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return res;
    }

    @Test
    void test(){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(findBottomLeftValue(root));
    }
}

package tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * @author Kyrie
 * @date 2023/6/21 11:07
 */
public class _04_04_NAryLevelOrderTraversal_429 {
    // 层序遍历，只不过把有限个（2）节点换成不知道多少个（循环）
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int curLevelCount = q.size();
            List<Integer> curLevelList = new ArrayList<>();
            for(; curLevelCount > 0; curLevelCount--){
                Node node = q.poll();
                curLevelList.add(node.val);
                if (node.children == null || node.children.size() == 0) continue;
                for (Node child : node.children){
                    q.offer(child);
                }
            }
            res.add(curLevelList);
        }
        return res;
    }

    @Test
    void test(){
        List<Integer> list = null;
        for(Integer i : list){
            System.out.println(i);
        }
    }
}

package tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历
 * 尽可能把判空操作下沉到下层，上层就无需考虑太多的空情况
 * @author Kyrie
 * @date 2023/6/6 10:21
 */
public class _02_InorderTraveral_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderRecursion2(root, res);
        return res;
    }

    private void inorderRecursion1(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        // 子情况-左子树为根
        inorderRecursion1(root.left, res);
        res.add(root.val);
        // 子情况-右子树为根
        inorderRecursion1(root.right, res);
    }

    private void inorderRecursion2(TreeNode root, List<Integer> res) {
        // 这里的判空是防止初始化进来的树为空
        // 正常情况下，进入递归前，已经保证了当前节点不为空
        if (root == null) {
            return;
        }
        if (root.left != null){
            inorderRecursion2(root.left, res);
        }
        res.add(root.val);
        if (root.right != null){
            inorderRecursion2(root.right, res);
        }
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        root.right = node1;
        node1.left = node2;

        List<Integer> res = inorderTraversal(root);
        System.out.println(res);
    }
}

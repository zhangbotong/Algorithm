package tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kyrie
 * @date 2023/6/6 10:30
 */
public class _03_PostorderTraveral_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderRecursion2(root, res);
        return res;
    }

    private void postorderRecursion1(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorderRecursion1(root.left, res);
        postorderRecursion1(root.right, res);
        res.add(root.val);
    }

    private void postorderRecursion2(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            postorderRecursion2(root.left, res);
        }
        if (root.right != null) {
            postorderRecursion2(root.right, res);
        }
        res.add(root.val);
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        root.right = node1;
        node1.left = node2;

        List<Integer> res = postorderTraversal(root);
        System.out.println(res);
    }
}

package tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树递归遍历前序
 * 尽可能把判空操作放到下层，上层就无需考虑太多的空情况
 * @author Kyrie
 * @date 2023/6/6 09:57
 */
public class _01_01_PreorderTraveral_144 {
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderRecursion1(root, res);
        return res;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        /**
         * 递归函数里只保证了从递归里进来的非空，但没保证从源头进来不为空；
         * 还是方法1 更简洁，考虑的 null 情况更简洁
         */
        if (root == null) {
            return res;
        }
        preorderRecursion2(root, res);
        return res;
    }

    private void preorderRecursion1(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorderRecursion1(root.left, res);
        preorderRecursion1(root.right, res);
    }

    /**
     *在进入下一层递归前，保证了只有当前节点不为空，所以不需要判断当前节点是否为空
     */
    private void preorderRecursion2(TreeNode root, List<Integer> res) {
        res.add(root.val);
        if(root.left != null){
            preorderRecursion2(root.left, res);
        }
        if (root.right != null){
            preorderRecursion2(root.right, res);
        }
        return;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        root.right = node1;
        TreeNode node2 = new TreeNode(3);
        node1.left = node2;
        System.out.println(preorderTraversal1(root));
    }


}

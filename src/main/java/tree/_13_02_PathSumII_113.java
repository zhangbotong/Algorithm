package tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 注意：与上一题的区别是，这里要求返回所有路径，而不是判断是否存在路径
 * @author Kyrie
 * @date 2023/6/28 09:47
 */
public class _13_02_PathSumII_113 {
    // 先序遍历 -- 递归
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSumHandleNull(root, targetSum, res, path);
        return res;
    }

    // 递归包含空节点
    public void pathSumHandleNull(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
        if (root == null) return;
        targetSum -= root.val;
        path.add(root.val);
        if (isLeaf(root)) {
            if (targetSum == 0){
                res.add(new ArrayList<>(path));
            }
        }
        // 即使是叶节点，再去递归也不会有影响
        pathSumHandleNull(root.left, targetSum, res, path);
        pathSumHandleNull(root.right, targetSum, res, path);
        path.remove(path.size() - 1);
    }

    private boolean isLeaf(TreeNode node){
        return node != null && node.left == null && node.right == null;
    }

    // 递归不包含空节点
    public void pathSumNotHandleNull(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path){
        // caller 控制root不为null
        targetSum -= root.val;
        path.add(root.val);
        // 叶节点，终止条件
        if (isLeaf(root)) {
            if (targetSum == 0){
                res.add(new ArrayList<>(path));
            }
            // 回溯。不管是否满足条件，只要到了叶节点都得回溯
            path.remove(path.size() - 1);
            return;
        }
        // 非叶节点，递归
        if (root.left != null){
            pathSumNotHandleNull(root.left, targetSum, res, path);
        }
        if (root.right != null){
            pathSumNotHandleNull(root.right, targetSum, res, path);
        }
        // 非叶节点回溯
        path.remove(path.size() - 1);
    }

    @Test
    void test(){
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        node2.left = node4;
        node2.right = node5;
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        node3.left = node6;
        node3.right = node7;
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);
        node5.left = node8;
        node5.right = node9;
        List<List<Integer>> res = pathSum(root, 22);
        System.out.println(res);
    }
}

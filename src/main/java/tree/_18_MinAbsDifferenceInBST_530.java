package tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * @author Kyrie
 * @date 2023/7/20 10:10
 */
public class _18_MinAbsDifferenceInBST_530 {
     TreeNode pre;
     Integer minAbsDiff = Integer.MAX_VALUE;

    /**
     * 利用BST中序有序的特点，将其转换为一个有序数组后，再求有序数组的相邻元素的最小绝对差
     */
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return getMinAbsDiff(list);
    }

    // 递归，中序遍历，将BST节点值放入list
    private void inOrder(TreeNode root, List<Integer> list) {
        // 递归终止条件：有null选null
        if (root == null) return;
        // 单层逻辑
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    // 求list相邻元素的最小绝对差
    private int getMinAbsDiff(List<Integer> list) {
        int minAbsDiff = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            minAbsDiff = Math.min(minAbsDiff, Math.abs(list.get(i) - list.get(i - 1)));
        }
        return minAbsDiff;
    }

    // 省略数组空间，直接在中序遍历的时候计算最小绝对差
    public int getMinimumDifference2(TreeNode root) {
        inOrder2(root);
        return minAbsDiff;
    }

    private void inOrder2(TreeNode root) {
        if (root == null) return ;
        // pre必须得是遍历完left出来后变的，不能是原来的，因此要没用返回值接，要么用全局变量
        inOrder2(root.left);
        if (pre != null){
            minAbsDiff = Math.min(minAbsDiff, Math.abs(root.val - pre.val));
        }
        pre = root;// 没处理中节点时，pre一直不变
        inOrder2(root.right);
    }

    @Test
    public void test() {
// [5,4,6,null,null,3,7]
        TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        System.out.println(getMinimumDifference2(root));
    }
}

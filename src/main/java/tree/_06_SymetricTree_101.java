package tree;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class _06_SymetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    // left and right may be null
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;// both of them are null
        if (left == null ^ right == null) return false; // one of them is null
        if (left.val != right.val) return false;// both of them are not null, but left.val != right.val
        // both of them are not null, and left.val == right.val
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    /**
     * 迭代法 -- 队列
     * 整体思路就是找一个容器（队列或栈），每次取两个比较，再将其子节点按正确顺序入队
     * 入队的左右子节点有可能为null
     */
    public boolean isSymmetricByQueue(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        // Order doesn't matter
        queue.offer(root.left);
        queue.offer(root.right);
        // 实际应该判断队列里至少有 2 个，因为是成对入队，所以根据一个也能判断
        while (!queue.isEmpty()){
            // 一次取 2 个，然后比较，然后再分别入队
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;// both of them are null
            if (left == null ^ right == null) return false; // one of them is null
            if (left.val != right.val) return false;// both of them are not null, but left.val != right.val
            // both of them are not null, and left.val == right.val
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    /**
     * 迭代法 -- 栈
     */
    public boolean isSymmetricByStack(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root.left);
        stack.push(root.right);
        // 实际应该判断栈里至少有 2 个，因为是成对入栈，所以根据一个也能判断
        while(!stack.isEmpty()){
            // 左右无所谓，只要是他俩即可
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if (left == null && right == null) continue;// both of them are null
            if (left == null ^ right == null) return false; // one of them is null
            if (left.val != right.val) return false;// both of them are not null, but left.val != right.val
            // both of them are not null, and left.val == right.val
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);

        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node3;
        node1.right = node4;

        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        node2.left = node5;
        node2.right = node6;

        System.out.println(isSymmetricByQueue(root));
    }
}

package _00_interview.xiaomi;

import tree.TreeNode;

/**
 * 从根到叶节点路径，计算所有这些路径上所有节点个数/所有路径数。例如：
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * paths：
 * 1-2-4
 * 1-2-5
 * 1-3
 * (3+3+2)/3 = 8/3
 * @author Kyrie
 * @date 2023/9/14 21:24
 */
public class AvgHeightOfBT {
    int sum = 0;
    int pathCount = 0;
    int count = 0;

    public int avgHeightOfBT(TreeNode root) {
        cal(root);
        return sum / pathCount;
    }
    public void cal (TreeNode cur) {
        count++;
        if (cur.left == null && cur.right == null) {
            pathCount++;
            sum += count;
            return;
        }
        cal(cur.left);
        count--;
        cal(cur.right);
        count--;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        node1.left = node3;
        node1.right = node4;
        AvgHeightOfBT ah = new AvgHeightOfBT();
        System.out.println(ah.avgHeightOfBT(root));
    }
}

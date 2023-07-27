package tree;

import org.junit.jupiter.api.Test;

/**
 * 给定一个 n 叉树，找到其最大深度。
 */
public class _07_02_nAryMaxDepth_559 {
    /**
     * 后序遍历，递归
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int childMaxDepth = 0;
        for (Node child : root.children) {
            int childDepth = maxDepth(child);
            childMaxDepth = Math.max(childMaxDepth, childDepth);
        }
        return childMaxDepth + 1;
    }

    @Test
    public void test() {
        Node root = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);

        Node node4 = new Node(5);
        Node node5 = new Node(6);
        node1.children.add(node4);
        node1.children.add(node5);

        int res = maxDepth(root);
        System.out.println(res);
    }
}

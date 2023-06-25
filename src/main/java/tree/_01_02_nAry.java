package tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树
 * @author Kyrie
 * @date 2023/6/12 11:32
 */
public class _01_02_nAry {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        for (Node child : root.children) {
            res.addAll(preorder(child));
        }
        return res;
    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        for (Node child : root.children) {
            res.addAll(postorder(child));
        }
        res.add(root.val);
        return res;
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

        List<Integer> res = preorder(root);
        System.out.println(res);
    }
}

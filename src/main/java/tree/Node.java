package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树数据结构
 * @author Kyrie
 * @date 2023/6/12 11:30
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
        children = new ArrayList<>();
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

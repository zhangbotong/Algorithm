package tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 遍历二叉树所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * @author Kyrie
 * @date 2023/6/19 11:19
 */
public class _11_BinTreePath_257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        List<String> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        path.add(root.val);
        traversal(root, path, res);
        return res;
    }

    // 前序遍历，外层判断root不为null
    private void traversal(TreeNode root, List<Integer> path, List<String> res){
        if (root.left == null && root.right == null) {
            res.add(path2String(path));
        }
        if (root.left != null){
            // 回溯
            path.add(root.left.val);
            traversal(root.left, path, res);
            path.remove(path.size() - 1);
        }
        if (root.right != null){
            path.add(root.right.val);
            traversal(root.right, path, res);
            path.remove(path.size() - 1);
        }
    }

    private String path2String(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < path.size() - 1; i++){
            sb.append(path.get(i)).append("->");
        }
        sb.append(path.get(path.size() - 1));
        return sb.toString();
    }

    /**
     * 后序遍历，不易理解
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        if (root.left == null && root.right == null){//leaf,递归终止
            res.add(String.valueOf(root.val));
            return res;
        }
        //Bottom
        List<String> leftPaths = binaryTreePaths2(root.left);
        List<String> rightPaths = binaryTreePaths2(root.right);
        //Up
        for (String s: leftPaths){
            res.add(root.val + "->" + s);
        }
        for (String s: rightPaths){
            res.add(root.val + "->" + s);
        }
        return res;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left=left;
        root.right=right;
        TreeNode left1 = new TreeNode(5);
        left.right=left1;
        List<String> res = binaryTreePaths(root);
        System.out.println(res);
    }
}

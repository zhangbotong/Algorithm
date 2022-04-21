import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kyrie
 * @date 2022/4/18 5:11 PM
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TreeOp {
    @Test
    public void run() {
        TreeNode root = this.generateTree();
//        System.out.println("preOrderRecursive：");
//        this.preOrderRecursive(root);
//        System.out.println("inOrderRecursive：");
//        this.inOrderRecursive(root);
//        System.out.println("postOrderRecursive：");
//        this.postOrderRecursive(root);
//        this.invertTree(root);
//        System.out.println(this.isSymmetric(root));
        System.out.println("Max depth: " + this.maxDepth(root));
        System.out.println("levelOrder：");
        this.levelOrder(root);
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode generateTree (){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }

    private TreeNode generateSymmetricTree (){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        return root;
    }

    private void preOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    private void inOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRecursive(root.left);
        System.out.println(root.val);
        inOrderRecursive(root.right);
    }

    private void postOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.println(root.val);
    }

    private void levelOrder (TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            /**
             * 每一层节点的个数
             */
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                System.out.println(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }

    private TreeNode invertTree (TreeNode root) {
        if (root == null) {
            return null;
        }
        this.swapLeftAndRight(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 里面元素会修改（内存），但整体不会修改，因为传进来是引用
     */
    private void swapLeftAndRight (TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    private boolean isSymmetric (TreeNode root) {
        if (root == null) {
            return true;
        }
        return this.isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric (TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        boolean outside = this.isSymmetric(left.left, right.right);
        boolean inside = this.isSymmetric(left.right, right.left);
        return outside && inside;
    }

    private int maxDepth (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = this.maxDepth(root.left);
        int rightDepth = this.maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    private int minDepth (TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return this.minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return this.minDepth(root.left) + 1;
        }
        return Math.min(this.minDepth(root.left), this.minDepth(root.right)) + 1;
    }

    private boolean isBalanced (TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = this.maxDepth(root.left);
        int right = this.maxDepth(root.right);
        return Math.abs(left - right) <= 1 && this.isBalanced(root.left) && this.isBalanced(root.right);
    }

    private boolean hasPathSum (TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        boolean leftHasPathSum = this.hasPathSum(root.left, sum - root.val);
        boolean rightHasPathSum = this.hasPathSum(root.right, sum - root.val);
        return  leftHasPathSum || rightHasPathSum;
    }

}

package tree;

import org.junit.jupiter.api.Test;

/**
 * 106. 根据中序遍历和后序遍历构造二叉树
 * 限制：1. 1 <= inorder.length <= 3000；2. postorder.length == inorder.length；3. -3000 <= inorder[i], postorder[i] <= 3000；4. inorder 和 postorder 均无重复元素；5. inorder 和 postorder 均为有效数组
 * @author Kyrie
 * @date 2023/7/12 09:21
 */
public class _14_01_ConstructBTFromInorderAndPostorder_106 {
    // 首先根据后序最后元素，确定根节点；然后，根据根节点在中序位置，分割中序左右子树；再然后，根据中序左右子树长度，分割后序左右子树；最后，递归处理左右子树
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        // 终止条件
        if (length == 0) return null;

        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        int delimiter = 0;
        for (; delimiter < inorder.length && inorder[delimiter] != rootValue; delimiter++);
        // delimiter是偏移，去掉delimiter后，左子树长度刚好是delimiter
        int[] inorderLeft = new int[delimiter];
        // length - delimiter 是剩余节点数量，再 - 1 去掉 delimiter 节点
        int[] inorderRight = new int[length - delimiter - 1];
        int[] postorderLeft = new int[inorderLeft.length];
        int[] postorderRight = new int[inorderRight.length];
        // 切中序by delimiter
        for (int i = 0; i < length; i++) {
            if (i < delimiter) {
                inorderLeft[i] = inorder[i];
            }
            // i 相对于 delimiter+1 的偏移
            if (i > delimiter) {
                inorderRight[i - delimiter - 1] = inorder[i];
            }
        }
        // 切后序 by 中序左右子树长度
        int newPostLeftIndex = 0, newPostRightIndex = 0;
        for (int i = 0; i < length - 1; i++) {
            if (newPostLeftIndex < inorderLeft.length) {
                postorderLeft[newPostLeftIndex++] = postorder[i];
            }else {
                postorderRight[newPostRightIndex++] = postorder[i];
            }
        }
        root.left = buildTree(inorderLeft, postorderLeft);
        root.right = buildTree(inorderRight, postorderRight);
        return root;
    }

    @Test
    void test() throws Exception {
        int[] inorder = {2,1};
        int[] postorder = {2,1};
        TreeNode root = buildTree(inorder, postorder);
        System.out.println(root);
    }
}

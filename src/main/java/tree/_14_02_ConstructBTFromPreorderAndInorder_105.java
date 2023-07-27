package tree;

import org.junit.jupiter.api.Test;

/**
 * 105. 根据前序遍历和中序遍历构造二叉树
 * 限制：1. 1 <= preorder.length <= 3000；2. inorder.length == preorder.length；3. -3000 <= preorder[i], inorder[i] <= 3000；4. preorder 和 inorder 均无重复元素；5. inorder 和 preorder 均为有效数组
 * @author Kyrie
 * @date 2023/7/14 09:31
 */
public class _14_02_ConstructBTFromPreorderAndInorder_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        // 终止条件
        if(length == 0) return null;
        // 单层递归逻辑
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        // delimiter: 中序遍历中根节点的位置，即划分中序左右子树的下标。
        int delimiter = 0;
        for(; delimiter < length && inorder[delimiter] != rootValue; delimiter++);// 题目限制一定能找到delimiter
        int[] preorderLeft = new int[delimiter];
        int[] preorderRight = new int[length - 1 - delimiter];
        int[] inorderLeft = new int[preorderLeft.length];
        int[] inorderRight = new int[preorderRight.length];
        for (int i = 0; i < length; i++){
            if (i < delimiter) {
                inorderLeft[i] = inorder[i];
            }
            if (i > delimiter) {
                inorderRight[i - delimiter - 1] = inorder[i];
            }
        }
        // preorder 移除第一个元素
        int newLeftIndex = 0;
        int newRightIndex = 0;
        for (int i = 1; i < length; i++) {
            if (newLeftIndex < inorderLeft.length){
                preorderLeft[newLeftIndex++] = preorder[i];
            }else {
                preorderRight[newRightIndex++] = preorder[i];
            }
        }
        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);
        return root;
    }

    @Test
    void test() throws Exception {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root);
    }
}

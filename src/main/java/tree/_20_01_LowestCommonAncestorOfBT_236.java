package tree;

/**
 * 给定一个二叉树，找到该树中两个指定节点的最近公共祖先。
 * @author Kyrie
 * @date 2023/7/25 17:51
 */
public class _20_01_LowestCommonAncestorOfBT_236 {
    /**
     * 后序遍历，递归
     * 递归终止条件
     *      若节点为空，则返回空
     *      若节点等于p或q，则返回节点
     * 单层处理逻辑
     *      若左右子树均不为空，则当前节点为其最近公共祖先，返回当前节点
     *      若左右子树有一个为空，则返回不为空的子树，向上传递
     *      若左右子树均为空，则返回空
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归终止条件
        if (root == null) return null;
        // 包含了root=p且root的子树=q的情况，这种情况下，root就是最近公共祖先，直接返回root
        if (root == p || root == q) return root;
        // 后序遍历
        TreeNode leftRes = lowestCommonAncestor(root.left, p, q);
        TreeNode rightRes = lowestCommonAncestor(root.right, p, q);
        // 处理当前层
        if (leftRes != null && rightRes != null) {
            return root;
        }
        // 用if比else if可读性更好
        if (leftRes != null) {
            return leftRes;
        }
        if (rightRes != null) {
            return rightRes;
        }
        return null;
    }
}

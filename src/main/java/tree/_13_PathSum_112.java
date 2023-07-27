package tree;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 注意：至叶节点，中间节点达咩；空根返回false
 * 提取结论：对于空节点处理，怎么简单怎么来，入不入递归依据逻辑复杂度来定
 * @author Kyrie
 * @date 2023/6/25 11:13
 */
public class _13_PathSum_112 {

    // 先序遍历 -- 递归
    // 空节点入递归简单，但空节点一定返回 false。叶节点的下层空节点不会进来，只有非叶节点的空节点会进来
    public boolean hasPathSum (TreeNode root, int targetSum) {
        // 根节点或非叶节点的空子节点（叶节点的空节点不会进来）
        if (root == null) return false;
        targetSum -= root.val;
        // 叶节点的下层空节点不入递归
        if (root.left == null && root.right == null) return targetSum == 0;
        // root 为非叶节点，左右子树可能一个为空或者全不为空。空节点即使递归进去，也是false，跟下面的写法一样
        boolean leftRes = hasPathSum(root.left, targetSum);
        boolean rightRes = hasPathSum(root.right, targetSum);
        return leftRes || rightRes;
    }

    // 空节点不入递归，但根节点可能为空，写在一起
    public boolean hasPathSum2 (TreeNode root, int targetSum){
        // 只有根节点可能为空，递归子节点不会
        if (root == null) return false;
        targetSum -= root.val;
        // 如果是叶节点，这里已经返回了，不会再进入到下层空节点递归
        if (root.left == null && root.right == null) return targetSum == 0;
        // 空节点不入递归
        boolean leftRes = false;
        boolean rightRes = false;
        if (root.left != null) leftRes = hasPathSum2(root.left, targetSum);
        if (root.right != null) rightRes = hasPathSum2(root.right, targetSum);
        return leftRes || rightRes;
    }

    // 空节点不入递归，但根节点可能为空，需单独判断
    public boolean hasPathSum3(TreeNode root, int targetSum) {
        if (root == null) return false;
        return hasPathSumWithoutNullNode(root, targetSum);
    }

    // 空节点不入递归
    private boolean hasPathSumWithoutNullNode (TreeNode root, int targetSum) {
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        boolean leftRes = false;
        boolean rightRes = false;
        if (root.left != null) {
            leftRes = hasPathSumWithoutNullNode(root.left, targetSum - root.val);
        }
        if (root.right != null) {
            rightRes = hasPathSumWithoutNullNode(root.right, targetSum - root.val);
        }
        return leftRes || rightRes;
    }
}

package tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 假定 BST 有如下定义：
 *      结点左子树中所含结点的值小于等于当前结点的值
 *      结点右子树中所含结点的值大于等于当前结点的值
 *      左子树和右子树都是二叉搜索树
 * 限制：The number of nodes in the tree is in the range [1, 104].
 * @author Kyrie
 * @date 2023/7/25 10:41
 */
public class _19_FindModeInBST_501 {
    /**
     * 思路一：中序遍历放至数组，再遍历数组找众数
     *      1. 中序遍历放至数组
     *      2. 遍历数组找众数
     * 思路二：直接再中序遍历时，找众数
     *      1. 全局变量 pre、curCount、maxCount。
     *      2. 中序遍历时，记录当前元素出现次数，然后与众数出现次数比较
     *          2.1 若 node.val = pre.val，则curCount++，否则 curCount = 1
     *          2.2 若 curCount = maxCount，则将当前元素加入众数数组
     *          2.3 若 curCount > maxCount，则先更新 maxCount，再清空众数数组，再将当前元素加入众数数组
     *          2.4 若 curCount < maxCount，则不做处理
     *
     * 关键点：升序数组中找众数思路：
     *      1. 遍历数组，count记录当前元素当前出现次数，maxCount 记录当前众数出现次数，pre记录上一个元素用来与遍历的当前元素值比较计算当前元素出现次数
     *      2. 计算当前元素出现次数：如果 cur.val == pre.val，则 count++，否则 count = 1
     *      3. 当前元素频率与众数频率比较
     *          若 count = maxCount，则将当前元素加入众数数组
     *          若 count > maxCount，则先更新 maxCount，再清空众数数组，再将当前元素加入众数数组
     *          若 count < maxCount，则不做处理
     *      4. 遍历结束后，返回众数数组
     */
    TreeNode pre = null;
    int curCount = 0;
    int maxCount = 0;
    List<Integer> res = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        findModeRetList(root);
        // list转数组
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void findModeRetList(TreeNode cur) {
        if (cur == null) return;
        findModeRetList(cur.left);
        if (pre != null && cur.val == pre.val) {
            curCount++;
        }else {// pre == null(首个节点) || cur.val != pre.val（与上一节点值不同）
            curCount = 1;
        }
        pre = cur;
        // 比较更新众数
        if (curCount == maxCount) {
            res.add(cur.val);
        }else if (curCount > maxCount) {
            res.clear();
            res.add(cur.val);
            maxCount = curCount;
        }
        findModeRetList(cur.right);
    }

    public int[] findMode2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        // 从升序list中找众数
        int curCount = 0;
        int maxCount = 0;
        int pre = 0;
        for(int cur : list) {
            if (cur == pre) {
                curCount++;
            }else{
                curCount = 1;
            }
            pre = cur;
            if (curCount == maxCount) {
                res.add(cur);
            }else if (curCount > maxCount) {
                res.clear();
                res.add(cur);
                maxCount = curCount;
            }
        }
        // list转数组
        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    // 中序遍历，放至数组
    private void inorder(TreeNode root, List<Integer> list) {
        // 递归终止条件：节点为空
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    @Test
    void test() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(2), null));
        int[] ans = findMode(root);
        for(int i : ans) {
            System.out.println(i);
        }
    }
}

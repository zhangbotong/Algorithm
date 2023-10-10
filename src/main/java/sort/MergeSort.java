package sort;

import bean.ListNode;
import org.junit.jupiter.api.Test;

/**
 * @author Kyrie
 * @date 2023/8/9 11:49
 */
public class MergeSort {
    /**
     * 递归实现
     */
    private ListNode mergeListNodeR(ListNode p, ListNode q)
    {
        if (p == null) return q;
        if (q == null) return p;
        if (p.val < q.val) {
            p.next = mergeListNodeR(p.next, q);
            return p;
        } else {
            q.next = mergeListNodeR(p, q.next);
            return q;
        }
    }

    /**
     * dummy。
     * 当 p、q 均不为 null 时，比较 p、q 的值，将较小的节点接到 dummy 后面。
     * 当 p 为 null 或 q 为 null 时跳出循环，将不为 null 的节点接到 dummy 后面。
     */
    private ListNode mergeListNodeIt(ListNode p, ListNode q) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (p != null && q != null) {
            if (p.val < q.val){
                cur.next = p;
                p = p.next;
            } else {
                cur.next = q;
                q = q.next;
            }
        }
        cur.next = p == null ? q : p;
        return dummy.next;
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort (int[] array, int left, int right) {
        // 递归终止条件
        if (left >= right) return;
        // 单层处理逻辑，先分，再合
        int mid = left + (right - left) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    // 合并 2 个有序数组 [left, mid] 和 [mid + 1, right](入口保证 left <= mid < right)
    private void merge (int[] array, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1;
        for (int k = 0; k <= right - left; k++) {
            // i > mid 说明左边已经合并完了，直接把右边的元素放入 tmp
            if (i > mid){
                tmp[k] = array[j++];
            }else if (j > right) {// j > right 说明右边已经合并完了，直接把左边的元素放入 tmp
                tmp[k] = array[i++];
            }else {// 左右都没合并完，比较大小，小的放入 tmp
                tmp[k] = array[i] < array[j] ? array[i++] : array[j++];
            }
        }
        // 把 tmp 中的元素放回 array
        for (int k = left; k <= right; k++) {
            array[k] = tmp[k - left];
        }
    }

    private void merge2 (int[] array, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while(i <= mid && j <= right) {
            tmp[k++] = array[i] < array[j] ? array[i++] : array[j++];
        }
        // 此时至少一个数组空了，把另一个数组剩余元素放入 tmp
        while (i <= mid) {
            tmp[k++] = array[i++];
        }
        while (j <= right) {
            tmp[k++] = array[j++];
        }
        // 把 tmp 中的元素放回 array
        for (i = left; i <= right; i++) {
            array[i] = tmp[i - left];
        }
    }

        @Test
    void test() {
        int[] nums = new int[]{5,1,1,2,0,0};
        sortArray(nums);
        for (int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}

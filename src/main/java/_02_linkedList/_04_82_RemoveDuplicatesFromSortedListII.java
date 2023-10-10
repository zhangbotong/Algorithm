package _02_linkedList;

import bean.ListNode;
import org.junit.jupiter.api.Test;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 限制：链表中节点的数目在范围 [0, 300] 内；-100 <= Node.val <= 100；题目数据保证链表已经按升序排列。
 * @author Kyrie
 * @date 2023/9/11 23:24
 */
public class _04_82_RemoveDuplicatesFromSortedListII {
    // 重复元素不保留
    // dummy
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-101, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null){
            while (cur.next != null && cur.val ==  cur.next.val) {
                cur  = cur.next;
            }
            // 重复元素
            if (pre.next != cur){
                pre.next = cur.next;
                cur = cur.next;
            } else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    // 重复元素保留一个
    public ListNode deleteDuplicates0(ListNode head) {
        if (head ==null)  return head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    @Test
    void test () {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        ListNode res = deleteDuplicates(head);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}

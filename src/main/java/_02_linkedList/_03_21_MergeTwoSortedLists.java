package _02_linkedList;

import bean.ListNode;
import org.junit.jupiter.api.Test;

/**
 * 21. 合并两个有序链表，返回新链表head
 * 限制：两个链表的节点数量都是 [0, 50]；-100 <= Node.val <= 100；两个链表都是升序排列（可能有重复节点）
 *
 * @author Kyrie
 * @date 2023/8/28 10:23
 */
public class _03_21_MergeTwoSortedLists {
    // 归并排序 merger 函数思想
    // 两种思路：递归、迭代

    // 思路一：递归，
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        // l1, l2 均不为空时
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next  = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // 思路二：迭代
    // 1. 新建一个链表，用于存储合并后的链表
    // 2. 两个链表同时遍历，比较两个链表的节点值，将较小的节点添加到新链表中
    // 3. 遍历结束后，将剩余的链表添加到新链表的尾部
    // 若两个链表都为空，则返回空链表；若其中一个链表为空，则返回另一个链表。用一般情况包含住特殊情况。
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            if (l1 == null){
                cur.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                cur.next = l1;
                l1 = l1.next;
            } else {// l1,l2 均不为空
                if (l1.val <= l2.val){
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    @Test
    public void test () {
        ListNode l1 = new ListNode(1);
        ListNode cur = l1;
        cur.next = new ListNode(2);
        cur.next.next  =  new ListNode(4);
        ListNode l2 = new ListNode(1);
        cur  =  l2;
        cur.next  = new ListNode(3);
        cur.next.next = new ListNode(4);
        mergeTwoLists4(l1, l2);
    }

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists3(l1.next,l2);
            return l1;
        }
        l2.next = mergeTwoLists3(l1,l2.next);
        return l2;
    }

    public ListNode mergeTwoLists4(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val  <= l2.val) {
                cur.next = l1;
                l1  = l1.next;
            } else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 == null){
            cur.next = l2;
        } else if (l2 == null) {
            cur.next = l1;
        }
        return dummy.next;
    }
}

package _02_linkedList;

import bean.ListNode;

/**
 * 206. 反转链表
 * 限制：链表的节点数量为 [0, 5000]；-5000 <= Node.val <= 5000
 * @author Kyrie
 * @date 2023/8/28 09:59
 */
public class _02_206_ReverseLinkedList {
    // 翻转cur链表时：需要记录next节点，否则会丢失；也需要记录pre节点，否则无法向前连接
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        // 到 last 节点时，cur 不为空，next 为 null
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur == null ? null : cur.next;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        // 每次循环开始再移动next，可以避免在循环中判断cur是否为空
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 25、k个元素为一组翻转链表（剩余不足 k 个也翻转）
     * 限制：1 <= k <= n <= 5000
     * pre：上一组最后一个节点(第一组时 pre = dummy)
     * start：本组第一个节点
     * end：本组最后一个节点
     * next：下一组第一个节点
     * 首先找到 4 个指针位置，再翻转，直至
     */
    public ListNode reverseKGroup2 (ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode start = head;
        ListNode end = head;
        ListNode next;
        while (end != null) {
            for(int i = 1; i < k && end.next != null; i++) {
                end = end.next;
            }
            next = end.next;
            // 翻转 [start, end]
            reverse(start, end);
            pre.next = end;
            pre = start;
            start = next;
            end = next;
        }
        return dummy.next;
    }

    // 剩余不足 k 个保持不变
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode start = head;
        ListNode end = head;
        ListNode next;
        int i = 1;
        while (end != null) {
            for(i = 1; i < k && end.next != null; i++) {
                end = end.next;
            }
            if (i < k) {
                pre.next = start;
                break;
            }
            next = end.next;
            // 翻转 [start, end]
            reverse(start, end);
            pre.next = end;
            pre = start;
            start = next;
            end = next;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode pre = null;
        ListNode cur = start;
        ListNode next;
        ListNode endNext = end.next;
        while (cur != endNext) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return end;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5)))));
        _02_206_ReverseLinkedList reverseLinkedList = new _02_206_ReverseLinkedList();
        ListNode listNode = reverseLinkedList.reverseKGroup(head, 3);
        while(listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}

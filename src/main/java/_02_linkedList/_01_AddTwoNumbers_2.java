package _02_linkedList;

import bean.ListNode;

/**
 * 给定两个非空链表表示两个非负整数。位数按照逆序方式存储，每个节点只存储单个数字。加和后，同样按照逆序方式存储。
 * 限制：链表的长度范围为 [1, 100]；0 <= node.val <= 9；题目数据保证列表表示的数字不含前导零。
 * @author Kyrie
 * @date 2023/8/28 09:42
 */
public class _01_AddTwoNumbers_2 {
    // 分别遍历两个链表，逐位相加（进位也加），直至两个链表及进位均遍历完毕。
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy  = new ListNode(-1);
        ListNode cur = dummy;
        int carry= 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum = sum %10;
            cur.next = new ListNode(sum);
            cur = cur.next;
        }
        return dummy.next;
    }
}

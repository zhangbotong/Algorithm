import bean.ListNode;

/**
 * @author Kyrie
 * @date 2023/10/8 11:50
 */
public class InverseListNode {
    // 1 2 3 4 5
    // 3 2 1 4
    private ListNode inverse (ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int count = 1;
        k--;
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            if (count % k > 0) {
                cur.next = pre;
            }
            pre = cur;
            cur = next;
            count++;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));

    }
}

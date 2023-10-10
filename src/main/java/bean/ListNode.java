package bean;

/**
 * 链表数据结构
 * @author Kyrie
 * @date 2023/8/7 09:45
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int x) { val = x; }
    public ListNode(int x, ListNode next) { val = x; this.next = next; }
}

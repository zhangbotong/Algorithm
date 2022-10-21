import java.lang.reflect.Field;

/**
 * @author Kyrie
 * @date 2021/6/28 4:00 下午
 */
public class Link {
    static class Node {
        int val;
        Node next;

        public Node(int i) {
            this.val = i;
        }
        public Node() {}
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        Class c = head1.getClass();
        Link link = new Link();
        Node head = link.generate(new int[]{1,2,3,3, 4,4});
        link.print(head);
        System.out.println("-----------------");
        link.print(link.removeDuplicateKeep1(head));
//        Node afterReverse = link.reverseLink2(head);
//        link.kthDesc(7, head);
//        Node toBeRemovedNode = head;
//        head = test.removeNode(head,toBeRemovedNode);
//        System.out.println(String.format("Remove %s:", toBeRemovedNode.val));
//        test.print(head);
    }

    Node reverseLink (Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node pre = null;
        Node cur = head;
        while (cur != null){
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    Node removeNode (Node head, Node target){// O(1)
        // 关键是找到 待删节点的前节点
        // head=0,1,2, target not exist
        if (head == null || target == null){
            return head;
        }
        if (target.next != null){// 删非尾节点
            Node next = target.next;
            target.val = next.val;
            target.next = next.next;
        } else {// 删尾节点 或 待删节点不存在
            // target is tail
            if (head == target){
                return null;// 就一个节点，也是待删节点
            }
            Node p = head;
            while (p.next != target && p != null){
                p = p.next;
            }
            if (p == null){
                System.out.println(String.format("待删节点不存在：%s", target.val));
            }
            p.next = null;
        }
        return head;
    }

    void kthDesc (int k, Node head){//O(n) 一遍扫描
        // k > head.size, head == null, k <0
        if (k <= 0) {
            System.out.println(String.format("parameter error k=%s", k));
        }
        if (head == null){
            System.out.println("Link is null");
        }
        Node first = head;
        Node second = head;
        for (int i = 0; i < k; i++){
            if (first == null){
                System.out.println(String.format("k is larger than size of link."));
            }
            first = first.next;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
        System.out.println(String.format("kth desc is : %s", second.val));
    }

    void print (Node p){
        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }

    Node generateLink (int length){
        if (length <= 0){
            return null;
        }
        Node head = new Node(1);
        Node p = head;
        for (int i = 2; i <= length; i++){
            p.next = new Node(i);
            p = p.next;
        }
        return head;
    }

    Node generate (int[] array){
        if (array == null || array.length == 0){
            return null;
        }
        Node head = new Node(array[0]);
        Node p = head;
        for (int i = 1; i < array.length; i++){
            p.next = new Node(array[i]);
            p = p.next;}
        return head;
    }

    Node reverseLink2 (Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node pre = null;
        Node cur = head;
        Node next = cur.next;
        // next 在最后就要判断 next 空，因为 cur 可能为空，cur.next 会空指针
        while (next != null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
        }
        cur.next = pre;
        return cur;
    }

    Node reverse3(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node pre = null;
        Node cur = head;
        Node next = null;
        while (cur != null){
            next = cur.next;// 这里必须放在前面，因为cur.next可能为null
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    Node removeNode2 (Node head, Node target){
        if (head == null || target == null){
            return head;
        }
        if (target.next != null){// 非尾
            target.val = target.next.val;
            target.next = target.next.next;
        }else if (head == target){// 尾且头
            return null;
        } else {// 尾非头
            Node p = head;
            while (p.next != target && p != null){
                p = p.next;
            }
            if (p != null){
                p.next = null;
            }else {
                System.out.println(String.format("target not exist: %s", target.val));
            }
        }
        return head;
    }

    Node removeDuplicate (Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        Node pre = dummy;
        Node cur = pre.next;
        while (cur != null && cur.next != null){
            if (cur.val != cur.next.val){
                pre = cur;
                cur = cur.next;
            }else {
                int val = cur.val;
                while (cur != null && cur.val == val){
                    cur = cur.next;
                }
                pre.next = cur;
            }
        }
        return dummy.next;
    }

    Node removeDuplicateKeep1 (Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node cur = head;
        Node next = cur.next;
        while (next != null){
            if (cur.val == next.val){
                while (next != null && cur.val == next.val) {
                    next = next.next;
                }
                cur.next = next;
                if (next != null){
                    cur = next;
                    next = cur.next;
                }
            }else {
                cur = next;
                next = next.next;
            }
        }
        return head;
    }
}

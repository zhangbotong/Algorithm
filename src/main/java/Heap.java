import java.util.PriorityQueue;

/**
 * @author Kyrie
 * @date 2022/3/16 9:50 AM
 */
public class Heap {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        int[] arr = {1, 5, 8, 9, 2, 6, 7, 3, 4, 10};
        for (int e: arr) {
            pq.offer(e);
        }
        System.out.println(pq.peek());
        while (pq.size() > 2) {
            pq.poll();
        }
        System.out.println(pq.peek());
    }
}

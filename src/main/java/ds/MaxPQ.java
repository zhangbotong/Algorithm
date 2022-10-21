package ds;

/**
 * 《算法》大顶堆，数组从 1 开始使用，lchildI: 2i, rchildI: 2i+1
 * @author Kyrie
 * @date 2022/10/21 12:54
 */
public class MaxPQ<E extends Comparable<E>> {
    private E[] pq;
    private int N = 0;
    public MaxPQ (E[] pq){
        this.pq = pq;
    }

    public static void main(String[] args) throws Exception {
        MaxPQ<Character> maxPQ = new MaxPQ(new Character[16]);
        maxPQ.insert('a');
        maxPQ.insert('b');
        maxPQ.insert('c');
        maxPQ.insert('d');
        Character max = maxPQ.delMax();
        max = maxPQ.delMax();
    }

    /**
     * 数组下标 i，上游至正确位置(来了个新人，游到他能力该去的位置)
     * @param i
     */
    private void swim (int i){
        while (i > 1 && more(i, i >> 1)){
            exch(i, i >> 1);
            i  = i >> 1;
        }
    }

    /**
     * 数组下标 i，下沉至正确位置（老大退休，随便补位个人，把他下沉到他能力该去到位置）
     * @param i
     */
    private void sink (int i){
        while (i << 1 <= N){
            int maxChildI = i << 1;
            if ((i << 1) + 1 <= N && more((i << 1) + 1, maxChildI)){
                maxChildI = (i << 1) + 1;
            }
            if (more(i, maxChildI)){
                break;
            }
            exch(maxChildI, i);
            i = maxChildI;
        }
    }

    private void insert (E e){
        pq[++N] = e;
        swim(N);
    }

    private E delMax () throws Exception {
        if (N < 1){
            throw new Exception(String.format("Queue has been empty"));
        }
        E max = pq[1];
        pq[1] = pq[N];
        pq[N--] = null;
        sink(1);
        return max;
    }

    private boolean more (int i, int j){
        return pq[i].compareTo(pq[j]) >= 0;
    }

    private void exch (int i, int j){
        E e = pq[i];
        pq[i] = pq[j];
        pq[j] = e;
    }

}

package ds;

/**
 * 小顶堆，数组从 1 开始，lchild:2i, rchild:2i+1, parent:i>>1
 * @author Kyrie
 * @date 2022/10/21 14:28
 */
public class MinPQ <E extends Comparable<E>>{
    private E[] pq;
    private int N = 0;

    public MinPQ (E[] pq){
        this.pq = pq;
    }

    public static void main(String[] args) throws Exception {
        MinPQ<Character> minPQ = new MinPQ<>(new Character[16]);
        minPQ.insert('d');
        minPQ.insert('c');
        minPQ.insert('b');
        minPQ.insert('a');

        Character min = minPQ.delMin();
        min = minPQ.delMin();
    }

    private void swim (int i){
        while (i > 1 && less(i, i >> 1)){
            exch(i, i >> 1);
            i = i >> 1;
        }
    }

    private void sink (int i){
        while (i << 1 <= N){
            int minChildI = i << 1;
            int rChildI = (i << 1) + 1;
            if (rChildI <= N && less(rChildI, minChildI)){
                minChildI = rChildI;
            }
            if (less(i, minChildI)){
                break;
            }
            exch(i, minChildI);
            i = minChildI;
        }
    }

    private void insert (E e){
        pq[++N] = e;
        swim(N);
    }

    private E delMin () throws Exception{
        if (N <= 0){
            throw new Exception("Queue is empty");
        }
        E min = pq[1];
        pq[1] = pq[N];
        pq[N--] = null;
        sink(1);
        return min;
    }

    private boolean less (int i, int j){
        return pq[i].compareTo(pq[j]) <= 0;
    }

    private void exch (int i, int j){
        E e = pq[i];
        pq[i] = pq[j];
        pq[j] = e;
    }
}

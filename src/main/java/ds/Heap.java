package ds;

import java.util.Arrays;

/**
 * 小顶堆，从数组下表 0 开始：2i+1,2i+2
 * @author Kyrie
 * @date 2022/8/31 10:12
 */
public class Heap<E>{
    private Object[] q = new Object[16];
    private int size = 0;

    public static void main(String[] args) {
        Heap<Integer> h = new Heap();
        h.add(1);
        h.add(5);
        h.add(2);
        h.add(3);
        Integer remove = h.remove();
        System.out.println();
    }

    /**
     * 假设数组不会越界
     * @param e the element to add
     * @return
     */
    public boolean add(E e) {
        if (e == null){
            throw new NullPointerException();
        }
        if (size >= q.length){
            grow(size + 1);
        }
        siftUp(++size, e);
        return true;
    }

    /**
     * 不考虑空数组
     * @return
     */
    public E remove() {
        if (size == 0) {
            return null;
        }
        E result = (E) q[1];
        E x = (E) q[size];
        q[size--] = 0;
        if (size > 0) {
            siftDown(1,x);
        }
        return result;
    }

    public E peek() {
        return size == 0 ? null : (E) q[0];
    }

    /**
     * 在下标 i 处插入元素 e，并上浮
     * @param i
     * @param e
     */
    private void siftUp(int i, E e) {
        Comparable<? super E> cmp = (Comparable<? super E>) e;
        while (i > 1){
            int parentI = i >> 1;
            if (cmp.compareTo((E) q[parentI]) >= 0) {
                break;
            }
            q[i] = q[parentI];
            i = parentI;
        }
        q[i] = e;
    }

    /**
     * 在下标 i 处插入元素 e，并下浮
     * 不考虑数组越界
     * @param i
     * @param e
     */
    private void siftDown (int i, E e) {
        Comparable<? super E> eCmp = (Comparable<? super E>) e;
        while (i <= (size >> 1)) {
            int lChildI = i << 1;
            int rChildI = lChildI + 1;
            int minChildI = lChildI;
            Object minChild = q[lChildI];
            if (rChildI <= size && ((Comparable<? super E>) q[lChildI]).compareTo((E) q[rChildI]) > 0) {
                minChildI = rChildI;
                minChild = q[rChildI];
            }
            if (eCmp.compareTo((E) minChild) <= 0) {
                break;
            }
            q[i] = minChild;
            i = minChildI;
        }
        q[i] = e;
    }

    /**
     * 理论上 newCapacity 可能会越界，但实际在越界前，java heap 就先溢出了
     * @param minCapacity
     */
    private void grow (int minCapacity) {
        int oldCapacity = q.length;
        int newCapacity = oldCapacity + oldCapacity < 64 ? oldCapacity + 2 : oldCapacity >> 1;
        q = Arrays.copyOf(q, newCapacity);
    }
}

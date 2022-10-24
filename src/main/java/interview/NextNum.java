package interview;

import java.util.PriorityQueue;

/**
 * 字节面试题：给定数字数组，找出比他大的最小的数,若本身已是最大，输出最小值即可；
 * eg. {1,2,3,8,7,6} --> {1,2,6,3,7,8}； {3,2,1} --> {1,2,3}
 * 解决思路：从右至左小顶堆，找到 e=nums[i] <= pq.peek()，
 * @author Kyrie
 * @date 2022/10/24 21:36
 */
public class NextNum {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1};
        NextNum nextNum = new NextNum();
        nextNum.next(nums);
        for (int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }

    private void next (int[] nums){
        if (nums.length <= 1){
            return;
        }
        int i = nums.length - 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (; i >= 0; i--){
            int e = nums[i];
            if (pq.isEmpty() || e > pq.peek()){
                pq.offer(e);
            } else {
                nums[i] = pq.poll();
                pq.offer(e);
                break;
            }
        }
        while (!pq.isEmpty()){
            nums[++i] = pq.poll();
        }
    }
}

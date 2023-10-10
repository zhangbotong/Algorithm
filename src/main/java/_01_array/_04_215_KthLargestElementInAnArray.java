package _01_array;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 给定数组和 k，返回第 k 大的数
 * 限制：1 <= n <= nums.length <= 10^5；-10^4 <= nums[i] <= 10^4
 * @author Kyrie
 * @date 2023/9/13 20:23
 */
public class _04_215_KthLargestElementInAnArray {
    // partition 思想，O(n)
    // 循环
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    public int findKthLargest (int[] nums, int l, int r, int k){
        int targetIndex  = nums.length  - k;
        int index = partition(nums, l, r);
        if (targetIndex > index) {
            return findKthLargest(nums, index+1, r, k);
        } else if(targetIndex < index) {
            return findKthLargest(nums, l, index - 1, k);
        }
        return nums[index];
    }

    // 1、处理空边界
    // 2、以第一个元素为基准，用前后两个指针，前指针从前往后遇到 nums[i]<=pivot 则跳过，否则停下来；
    // 后指针从后往前遇到 nums[j]>=pivot 则跳过，否则停下来，交换 nums[i] 和 nums[j]，继续遍历
    private int partition (int[] nums, int l, int r) {
        if (l >= r) return l;
        int pivot = nums[l];
        int startIndex = l;
        while(l < r) {
            while (l < r && nums[r] >= pivot){
                r--;
            }
            while (l < r && nums[l] <= pivot){
                l++;
            }
            if (l < r) {
                swap(nums, l, r);
            }
        }
        swap(nums, startIndex, l);
        return l;
    }

    private void swap (int[] nums, int i, int  j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 方法2：大顶堆
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int res = Integer.MAX_VALUE;
        for (int num : nums) {
            heap.offer(num);
        }
        for (; k > 0; k--) {
            res = heap.poll();
        }
        return res;
    }

    // 方法3：小顶堆
    public int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums){
            if (heap.size() < k) {
                heap.offer(num);
            }else {
                if (num > heap.peek()) {
                    heap.poll();
                    heap.offer(num);
                }
            }
        }
        return heap.poll();
    }

    @Test
    void test(){
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }
}

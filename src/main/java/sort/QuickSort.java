package sort;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Kyrie
 * @date 2023/8/7 10:06
 */
public class QuickSort {
    /**
     * 第一个元素为 pivot。从前往后扫描直到找到第一个大于 pivot 的元素；从后向前扫描直至找到第一个小于 pivot 的元素；
     * 交换这两个元素，重复上述过程，直至 left=right，将 pivot 与 nums[left] 交换，返回 left。
     */
    private int partition (int[] nums, int left, int right) {
        int begin = left;
        int pivot = nums[left];
        while (left < right) {
            // 先右后左，保证最后 left=right 时，nums[left] <= pivot，用于和 begin 交换
            // 加 left < right，防止数组越界
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            if (left < right) swap(nums, left, right);
        }
        swap(nums, begin, right);
        return right;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int partition = partition(nums, left, right);
        quickSort(nums, 0, partition - 1);
        quickSort(nums, partition + 1, right);
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    @Test
    void test() {
        int[] nums = new int[]{5,1,1,2,0,0};
        sortArray(nums);
        for (int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }

    // partition 应用：数组中找第 3 大的数(不含重复项，数组容量 > 3)
    public int thirdMax(int[] nums) {
        return thirdMax(nums, 0, nums.length - 1);
    }

    private int thirdMax(int[] nums, int left, int right) {
        // 递归终止条件
        if (left > right || left < 0 || right > nums.length - 1) return -1;
        // 单层递归逻辑
        int targetIndex = nums.length - 3;
        int partition = partition(nums, left, right);
        if (targetIndex > partition) {
            return thirdMax(nums, partition + 1, right);
        }
        if (targetIndex < partition) {
            return thirdMax(nums, left, partition - 1);
        }
        return nums[targetIndex];
    }

    @Test
    void testThirdMax() {
        int[] nums = new int[]{3, 4, 1, 2, 6};
        System.out.println(maxHeap(nums));
    }

    /**
     * 数组中第 3 大的数 -- 堆排序
     * 优先级队列就是按某一优先级排序的队列，默认排序是最小堆
     * 小顶堆思路：容量为 3 的小顶堆，堆顶元素最小，排除掉最小的 n-3 个元素，剩下的就是前 3 大的元素（堆顶元素是前3大中最小的一个，因此若有比堆顶元素大就将其替换堆顶），时间复杂度 O(nlog3)
     */
    public int thirdMaxByMinHeap(int[] nums) {
        int resut = Integer.MIN_VALUE;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() < 3) {
                minHeap.offer(nums[i]);
            }else {
                if (nums[i] > minHeap.peek()){
                    minHeap.poll();
                    minHeap.offer(nums[i]);
                }
            }
        }
        resut = minHeap.poll();
        return resut;
    }

    // 大顶堆思路：容量为 n 的堆，相当于整体排序后的数组，取第 n-3 个元素。时间复杂度 O(nlogn)
    private int maxHeap (int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
        }
        maxHeap.poll();
        maxHeap.poll();
        return maxHeap.peek();
    }
}

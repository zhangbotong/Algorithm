package _01_array;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度。
 * 限制：1 <= nums.length <= 3 * 104；-100 <= nums[i] <= 100
 * @author Kyrie
 * @date 2023/8/17 08:20
 */
public class _02_01_RemoveDuplicatesFromSortedArray_26 {
    /**
     * 双指针法。时间复杂度：O(n)，空间复杂度：O(1)。
     * [0,s) 是不重复的元素，[s, f) 是重复的元素，[f, len) 是未遍历的元素。
     * 遍历时比较 nums[f] 和 nums[s-1] 是否相等，如果相等则 f++;如果不等则 s++, nums[s] = nums[f], f++。
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - 1]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}

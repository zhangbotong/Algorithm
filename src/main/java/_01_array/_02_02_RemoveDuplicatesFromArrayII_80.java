package _01_array;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素最多出现两次，返回删除后数组的新长度。
 * 限制：1 <= nums.length <= 3 * 104；-10^4 <= nums[i] <= 10^4
 * @author Kyrie
 * @date 2023/8/17 08:42
 */
public class _02_02_RemoveDuplicatesFromArrayII_80 {
    /**
     * 双指针法。时间复杂度：O(n)，空间复杂度：O(1)。
     * [0,s] 是至多两个重复元素，[s+1, f-1] 是废弃元素，[f, len-1] 是未遍历的元素。
     * 比较 nums[f] 和 nums[s-1]。若相等则是废弃元素，f++；若不等则是至多两个重复元素，nums[++s] = nums[f++]。
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3) {
            return nums.length;
        }
        int slow = 1;
        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow-1]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow+1;
    }
}

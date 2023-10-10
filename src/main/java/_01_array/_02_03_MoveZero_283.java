package _01_array;

/**
 * 给你一个数组 nums ，请你原地修改，将数组中所有的 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 限制：1 <= nums.length <= 104；-2^31 <= nums[i] <= 2^31 - 1
 * @author Kyrie
 * @date 2023/8/17 08:59
 */
public class _02_03_MoveZero_283 {
    // 双指针：时间复杂度：O(n)，空间复杂度：O(1)。
    // [0,slow-1] 是非零元素，[slow, fast-1] 是零元素，[fast, len-1] 是未遍历的元素。
    // 遍历时比较 nums[fast] 是否等于0。若相等，则交换 nums[fast] 和 nums[slow]，fast++，slow++；若不等，则只 fast++。
    public void moveZeroes(int[] nums) {
        int slow = 0;
        while(slow < nums.length && nums[slow] != 0){
            slow++;
        }
        for (int fast = slow + 1; fast < nums.length; fast++) {
            if(nums[fast] != 0) {
                swap(nums, slow, fast);
                slow++;
            }
        }
    }

    private void swap (int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}

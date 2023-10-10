package _01_array;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 限制：0 <= nums.length <= 100；0 <= nums[i] <= 50；0 <= val <= 100
 * @author Kyrie
 * @date 2023/8/17 09:30
 */
public class _02_04_RemoveElement_27 {
    // 循环不变量：[0,slow) 是非 val 元素；[slow,fast) 是val 元素；[fast,len) 是未遍历的元素。
    // 比较 nums[fast] 与 val。若相等，则 fast++；若不等，则 nums[slow] = nums[fast], slow++, fast++。
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}

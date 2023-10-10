package _01_array;

import org.junit.jupiter.api.Test;

/**
 * 荷兰国旗问题，给定n个元素的数组 nums，其中只有 0、1、2 三种元素，对其进行排序（in place）
 * 限制：1 <= n <= 300；nums[i] 为 0、1、2 之一
 * @author Kyrie
 * @date 2023/9/11 22:28
 */
public class _03_03_75_SortColors {
    // 思路一：三指针
    // 1. 定义三个指针，p0、p2、cur，分别指向 0、2、当前元素；[0,p0) is 0, [p0,cur) is 1, [cur, p2] is element to be handle, (p2,len) is 2
    // 2. 遍历数组，若 nums[cur] == 0，则交换 nums[cur] 和 nums[p0]，p0++，cur++。此时p0只会是0或1（0对应初始没有1时状态，1对应遍历过1后状态，如果是2早就被换到p2了）
    //    若 nums[cur] == 2，则交换 nums[cur] 和 nums[p2]，p2--；
    //    若 nums[cur] == 1，则 cur++。
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1, cur = 0;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                // 若没有1时，相当于不交换，cur++,p0++ 将 0 放到了正确位置所以 cur 也要++；有1时，将1与0交换，他俩都到了正确的位置，所以cur++,p0++。
                swap(nums, cur++, p0++);
            } else if (nums[cur] == 2) {
                swap(nums, cur, p2--);
            } else {
                cur++;
            }
        }
    }

    private void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] =  tmp;
    }

    @Test
    void test () {
        int[] nums = {0,2,2,0,1,0};
        sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

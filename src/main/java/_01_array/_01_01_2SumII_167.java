package _01_array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kyrie
 * @date 2023/8/15 11:10
 */
public class _01_01_2SumII_167 {
    /**
     * 167. 两数之和 II - 输入有序数组
     * 返回两数之和等于目标值的下标
     * 限制：1. 有序数组 2. 有且仅有一组答案
     * 2 <= numbers.length <= 3 * 10^4；-1000 <= numbers[i] <= 1000；numbers 按递增顺序排列；-1000 <= target <= 1000
     *
     * 思路：双指针
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target){
                return new int[] {left + 1, right + 1};
            }
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    /**
     * 15. 三数之和。
     * 返回所有三数之和等于0的下标（可能有多组），不含重复三元组
     * 限制：3 <= nums.length <= 3000；-10^5 <= nums[i] <= 10^5
     *
     * 思路：时间复杂度肯定高于 O(n*logn)，所以先排序，不增加时间复杂度;
     *     然后遍历数组，每次遍历时，将当前元素作为第一个元素，然后在剩余元素中使用双指针法，找到正确的两个元素。
     *     排除重复三元组：外层遍历时，如果当前元素与前一个元素相同，则跳过。双指针法时，如果指针指向的元素与前一个元素相同，则跳过。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            // 排除重复三元组
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                // 排除重复三元组
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    /**
     * 18. 四数之和
     * 返回所有四数之和等于目标值的下标（可能有多组）;不含重复四元组
     * 限制： 1 <= nums.length <= 200；-10^9 <= nums[i] <= 10^9；-10^9 <= target <= 10^9
     *
     * 思路：同3数之和，多一层循环。
     * TODO: 加和越界问题
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0 ; i < nums.length; i++) {
            // 排除重复四元组
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] * 4 > target) {
                return res;
            }
//            int complement1 = target - nums[i];
            // 3数之和
            for (int j = i + 1; j < nums.length; j++) {
                // 排除重复四元组
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
//                int complement2 = complement1 - nums[j];
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    // 排除重复四元组
                    if (left > j + 1 && nums[left] == nums[left - 1]) {
                        left++;
                        continue;
                    }
                    if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                        right--;
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    }else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
//        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {0,0,0,-1000000000,-1000000000,-1000000000,-1000000000};
        int target = -1000000000;
        List<List<Integer>> res = fourSum(nums, target);
        System.out.println(res);
    }
}

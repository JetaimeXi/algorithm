package _力扣;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author:Tod
 * @Description: 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * <p>
 * 说明：
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * @Date: Create in 19:13 2019/10/17
 * @ModifiedBy:
 */
public class _31寻找重复数 {
    public static void main(String[] args) {
//        System.out.println(findDuplicate3(new int[]{1, 4, 2, 4, 6, 4, 7, 4}));
        System.out.println(findDuplicate3(new int[]{1, 1, 2}));
    }

    /**
     * @param nums
     * @Author: Tod
     * @Date: 2019/10/17
     * @Description:
     * @Implement: 时间复杂度：O(n) 空间复杂度：O(n),原址
     * @Return: int
     */
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return 0;
    }

    /**
     * @param nums
     * @Author: Tod
     * @Date: 2019/10/17
     * @Description:
     * @Implement: 时间复杂度：O(nlogn) 空间复杂度：O(1), 变址
     * @Return: int
     */
    public int findDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return 0;
    }

    public static int findDuplicate3(int[] nums) {
        /**
        * @param nums
        * @Author: Tod
        * @Date: 2019/10/17
        * @Description:
        * @Implement: 二分法
         * 时间复杂度：O(nlogn)
         * 空间复杂度：O(1)
        * @Return: int
        */
        int length = nums.length;
        int end = length - 1;
        int start = 1;
        if (count(nums, start) > start) return start;
        while (end - start > 1) {
            int metric = (start + end) / 2;
            int result = count(nums, metric);
            if (result > metric) end = metric;
            else start = metric;
        }
        return end;
    }

    public static int count(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (num <= target) {
                count++;
            }
        }
        return count;
    }

}

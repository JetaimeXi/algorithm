package _力扣;

import util.Util;

/**
 * @Author:Tod
 * @Description: 给定一个数组 nums，编写一个函数将所有 0
 * 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * @Date: Create in 6:15 2019/10/4
 * @ModifiedBy:
 */
public class _05移动零 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12, 0, 0};
        moveZeroes(nums);
        Util.print(nums);
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int gap = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                gap++;
            } else {
                nums[i - gap] = nums[i];
            }
        }
        for (int i = nums.length - gap; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

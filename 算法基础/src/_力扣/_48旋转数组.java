package _力扣;

import util.Util;

/**
 * @Author:Tod
 * @Description: 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * @Date: Create in 11:18 2019/10/23
 * @ModifiedBy:
 */
public class _48旋转数组 {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] nums = new int[]{-1, -100, 3, 99};
        int k = 2;
        rotate(nums, k);
        Util.print(nums);
    }
    // 暴力破解
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        while (k > 0) {
            int temp = nums[len - 1];
            for (int i = len - 2; i >= 0; i--) {
                nums[i + 1] = nums[i];
            }
            nums[0] = temp;
            k--;
        }
    }
    // 环状替换
    public static void rotate2(int[] nums, int k){
        int temp,i,j;
        i = nums.length-1;

    }

}

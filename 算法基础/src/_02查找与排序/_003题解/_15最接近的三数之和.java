package _02查找与排序._003题解;

import util.Util;

import java.util.Arrays;

/**
 * @Author:Tod
 * @Description: 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * @Date: Create in 1:47 2019/9/29
 * @ModifiedBy:
 */
public class _15最接近的三数之和 {
    public static void main(String[] args) {
        int[] nums = {1,2,4,8,16,32,64,128};
        int target = 82;
        Arrays.sort(nums);
        Util.print(nums);
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
//        Arrays.sort(nums);
        int sum, left, right, rangeMax, rangeMin, res = Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            right = nums.length - 1;
            left = i + 1;
            rangeMax = nums[i] + nums[right] + nums[right - 1];
            rangeMin = nums[i] + nums[left] + nums[left + 1];
            if (target > rangeMax) {  //如果比当前的最大值还要大
                if (min > target - rangeMax) {
                    min = target - rangeMax;
                    res = rangeMax;
                }
            } else if (target < rangeMin) {  //比当前的最小值还要小
                if (min > rangeMin - target) {
                    min = rangeMin - target;
                    res = rangeMin;
                }
            } else {
                while (left < right) {
                    sum = nums[i] + nums[left] + nums[right];
                    int abs = Math.abs(sum - target);
                    if (abs < min) {
                        min = abs;
                        res = sum;
                    }
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        return sum;
                    }
                }
            }
        }
        return res;
    }
}

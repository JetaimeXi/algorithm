package _力扣;

/**
 * @Author:Tod
 * @Description: 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * @Date: Create in 18:35 2019/10/8
 * @ModifiedBy:
 */
public class _15搜索插入位置 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 8};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int leftIndex = 0, rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            int midIndex = leftIndex + ((rightIndex - leftIndex) >> 1);
            if (nums[midIndex] > target) { //左侧
                rightIndex = midIndex - 1;
            } else if (nums[midIndex] < target) {
                leftIndex = midIndex + 1;
            } else {
                return midIndex;
            }
        }
        return leftIndex;
    }
}

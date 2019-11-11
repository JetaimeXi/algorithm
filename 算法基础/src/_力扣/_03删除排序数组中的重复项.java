package _力扣;

/**
 * @Author:Tod
 * @Description: 给定一个排序数组，你需要在原地删除重复出现的元素，
 * 使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组
 * 并在使用 O(1) 额外空间的条件下完成。
 * @Date: Create in 23:52 2019/10/3
 * @ModifiedBy:
 */
public class _03删除排序数组中的重复项 {
    public static void main(String[] args) {
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] nums = {0, 1, 1, 1, 2, 2, 3, 3};
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int preptr = 0, postptr = 1;
        while (postptr < nums.length) {
            if (nums[preptr] == nums[postptr]) {
                postptr++;
            } else {
                preptr++;
                nums[preptr] = nums[postptr];
                postptr++;
            }
        }
        return preptr + 1;
    }
}

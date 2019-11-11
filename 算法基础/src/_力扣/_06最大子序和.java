package _力扣;

/**
 * @Author:Tod
 * @Description: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * @Date: Create in 6:46 2019/10/4
 * @ModifiedBy:
 */
public class _06最大子序和 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, -1, 1, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            if (sum > res) {
                res = sum;
            }
        }
        return res;
    }
}

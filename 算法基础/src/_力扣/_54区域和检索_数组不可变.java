package _力扣;

/**
 * @Author:Tod
 * @Description: 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * 示例：
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 * @Date: Create in 18:54 2019/10/25
 * @ModifiedBy:
 */
public class _54区域和检索_数组不可变 {
    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
class NumArray {

    private int[] dp;

    public NumArray(int[] nums) {
        dp = new int[nums.length + 1];
        for (int j = 0; j < nums.length; j++) {
            dp[j + 1] = nums[j] + dp[j];
        }
    }

    public int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }
}

class NumArray2 {

    private int[] cache;

    private int[] nums;

    public NumArray2(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return;
        }
        this.nums = nums;
        cache = new int[nums.length];
        cache[0] = nums[0];
        for (int i = 1;i<nums.length;i++) {
            cache[i] = cache[i-1]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (null != nums) {
            return cache[j]-cache[i]+nums[i];
        }
        return 0;
    }
}


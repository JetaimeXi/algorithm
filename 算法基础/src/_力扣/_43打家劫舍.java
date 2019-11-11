package _力扣;

import java.util.Arrays;

/**
 * @Author:Tod
 * @Description: 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * @Date: Create in 11:45 2019/10/21
 * @ModifiedBy:
 */
public class _43打家劫舍 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 1, 1, 2}));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        sum[1] = nums[1];
        int max;
        for (int i = 2; i < nums.length; i++) {
            max = 0;
            for (int j = i - 2; j >= 0; j--) {
                max = Math.max(max, sum[j]);
            }
            sum[i] = max + nums[i];
        }
        max = 0;
        for (int i : sum) {
            max = Math.max(max, i);
        }
        return max;
    }

    public int rob2(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        //状态dp[i]：表示前i个数字的最高金额,不拿第i个则为dp[i-1],拿第i个则为dp[i-2]+nums[i]
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < length + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[length];
    }
}

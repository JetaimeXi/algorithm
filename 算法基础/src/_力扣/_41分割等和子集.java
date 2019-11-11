package _力扣;

import util.Util;

import java.util.Arrays;

/**
 * @Author:Tod
 * @Description: 给定一个只包含正整数的非空数组。
 * 是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * <p>
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * <p>
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 * @Date: Create in 14:45 2019/10/20
 * @ModifiedBy:
 */
public class _41分割等和子集 {
    public static void main(String[] args) {
//        int[] nums = new int[]{1,5,11,5};
//        int[] nums = new int[]{1, 2, 3, 5};
//        int[] nums = new int[]{1, 2, 5};
//        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
//        int[] nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 97, 95};
        int[] nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 100};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 0) {
            sum /= 2;
            if (sum < nums[nums.length - 1]) {
                return false;
            }
            int[][] dp = dynamicPlanning_2D(nums, sum);
            Util.printMatrix(dp);
            if (dp[nums.length][sum] != 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * @param nums 数组
     * @param sum  需要凑出的数
     * @Author: Tod
     * @Date: 2019/10/21
     * @Description: 动态规划，得到一个二维的表，通过判断dp[nums.length][sum]是否为0得到是否能凑出sum值
     * @Implement:
     * @Return: int[][]
     */
    private static int[][] dynamicPlanning_2D(int[] nums, int sum) {
        int[][] dp = new int[nums.length + 1][];
        for (int i = 0; i <= nums.length; i++) {
            dp[i] = new int[sum + 1];
        }
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp;
    }

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //若和为奇数，不存在分割等和子集
        if (sum % 2 == 1) {
            return false;
        }
        return partition(nums, nums.length - 1, sum >> 1);
    }

    private boolean partition(int[] nums, int i, int half_sum) {
        //当已有子集之和超过元素之和的一半或放完数字无解返回
        if (half_sum < 0 || i < 0)
            return false;
        //得到正确解答后返回
        if (half_sum == 0)
            return true;
        //优化部分，当某个元素过大（超过所有元素和的一半）时返回
        if (nums[i] > half_sum)
            return false;
        //选择索引为 i 的元素是否放入
        return partition(nums, i - 1, half_sum - nums[i]) || partition(nums, i - 1, half_sum);
    }

    public boolean canPartition3(int[] nums) {
        if (null == nums || nums.length == 0) {
            return true;
        }

        if (nums.length == 1) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int half = sum / 2;
        Arrays.sort(nums);
        int maxPos = nums.length - 1;
        int pos = maxPos;
        return canPart(nums, nums[maxPos], pos, half);
    }

    private static boolean canPart(int[] nums, int total, int pos, int half) {
        if (total > half) {
            return false;
        } else if (total == half) {
            return true;
        }

        for (int i = pos - 1; i >= 0; i--) {
            boolean flag = canPart(nums, total + nums[i], i, half);
            if (flag) {
                return true;
            }
        }
        return false;
    }

}

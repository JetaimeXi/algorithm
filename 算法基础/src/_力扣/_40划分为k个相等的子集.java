package _力扣;

import java.util.Arrays;

/**
 * @Author:Tod
 * @Description: 给定一个整数数组  nums 和一个正整数 k，
 * 找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * 示例 1：
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * 注意:
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 * @Date: Create in 9:20 2019/10/20
 * @ModifiedBy:
 */
public class _40划分为k个相等的子集 {
    public static void main(String[] args) {
//        System.out.println(canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
//        System.out.println(canPartitionKSubsets(new int[]{4, 3, 2, 5, 2, 4, 4, 6}, 5));
//        System.out.println(canPartitionKSubsets(new int[]{10, 10, 10, 7, 7, 7, 7, 7, 7, 6, 6, 6}, 3));
        System.out.println(canPartitionKSubsets(new int[]{18, 20, 39, 73, 96, 99, 101, 111, 114, 190, 207, 295, 471, 649, 700, 1037}, 4));
//        System.out.println(canPartitionKSubsets2(new int[]{18, 20, 39, 73, 96, 99, 101, 111, 114, 190, 207, 295, 471, 649, 700, 1037}, 4));
//        System.out.println(canPartitionKSubsets2(new int[]{5, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3}, 15));
    }

    /**
     * @param nums
     * @param k
     * @Author: Tod
     * @Date: 2019/10/20
     * @Description:
     * @Implement: 暴力破解：回溯法+剪枝操作
     * @Return: boolean
     */
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k == 0) {
            sum = sum / k;
            boolean[] visited = new boolean[nums.length];
            int curSum = 0, cur_k = 0;
            return DFS(0, nums, curSum, sum, cur_k, k, visited);
        }
        return false;
    }

    private static boolean DFS(int index, int[] nums, int curSum, int sum, int cur_k, int k, boolean[] visited) {
        if (cur_k == k) {
            return true;
        }
        boolean isBreak = false;
        for (int i = index; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (curSum + nums[i] < sum) {
                    isBreak = DFS(i + 1, nums, curSum + nums[i], sum, cur_k, k, visited);
                }
                if (curSum + nums[i] == sum) {
                    isBreak = DFS(0, nums, 0, sum, cur_k + 1, k, visited);
                }
                if (isBreak == true || curSum == sum) {
                    return isBreak;
                }
                visited[i] = false;
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return isBreak;
    }

    private static int n, len;

    public static boolean canPartitionKSubsets2(int[] nums, int k) {
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        sum /= k;
        len = sum;
        return dfs(nums.length - 1, sum, nums.length, nums, visited);
    }

    private static boolean dfs(int index, int sum, int length, int[] nums, boolean[] visited) {
        if (length == 0) {
            return true;
        }
        boolean isOK = false;
        for (int i = index; i >= 0; i--) {
            if (!visited[i] && sum >= nums[i]) {
                visited[i] = true;
                isOK = sum != nums[i] ?
                        dfs(i - 1, sum - nums[i], length - 1, nums, visited)
                        :
                        dfs(n - 1, len, length - 1, nums, visited);
                if (isOK || sum == 0) {
                    return isOK;
                }
                visited[i] = false;
                while (i > 0 && nums[i - 1] == nums[i]) {
                    i--;
                }
            }
        }
        return isOK;
    }


}

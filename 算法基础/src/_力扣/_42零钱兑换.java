package _力扣;

import util.Util;

import java.util.Arrays;

/**
 * @Author:Tod
 * @Description: 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * @Date: Create in 0:18 2019/10/21
 * @ModifiedBy:
 */
public class _42零钱兑换 {
    public static void main(String[] args) {
//        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
//        System.out.println(coinChange(new int[]{2}, 3));
//        System.out.println(coinChange(new int[]{1}, 0));
//        System.out.println(coinChange(new int[]{2, 5, 10, 1}, 27));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(coinChange(new int[]{186, 419, 83, 408}, 6249));
//        System.out.println(Util.isPrime(6249));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int[] dp = dynamicProgramming_1D(coins, amount);
        return dp[amount] != Integer.MAX_VALUE - 1 ? dp[amount] : -1;
    }

    private static int[] dynamicProgramming_1D(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp;
    }
}

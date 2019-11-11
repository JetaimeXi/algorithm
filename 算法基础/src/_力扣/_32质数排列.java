package _力扣;

import util.Util;

import java.util.HashMap;

/**
 * @Author:Tod
 * @Description: 请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
 * 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
 * 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
 * <p>
 * 输入：n = 5
 * 输出：12
 * 解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
 * <p>
 * 输入：n = 100
 * 输出：682289015
 * <p>
 * 提示：
 * 1 <= n <= 100
 * @Date: Create in 9:39 2019/10/18
 * @ModifiedBy:
 */
public class _32质数排列 {
    public static void main(String[] args) {
//        System.out.println(isPrime(25));
//        System.out.println(numPrimeArrangements(6));
        System.out.println(numPrimeArrangements(100));
    }

    public static int numPrimeArrangements(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
//        return count;
        return (int) ((factorial(count) * factorial(n - count)) % (1000000000 + 7));
    }

    private static long factorial(int N) {
        long res = 1;
        for (int i = 2; i <= N; i++) {
            res = (res * i) % (1000000000 + 7);
        }
        return res;
    }

    private static boolean isPrime(int n) {
        // 2*3 = 6  6x 6x+1 6x+2 6x+3 6x+4 6x+5 6(x+1) 6(x+1)+1 ...
        //介于6的倍数的两边可能为质数，其他都不可能为质数
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 6 == 1 || n % 6 == 5) {
            int sqrt_n = (int) (Math.sqrt(n));
            for (int i = 5; i <= sqrt_n; i += 6) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}

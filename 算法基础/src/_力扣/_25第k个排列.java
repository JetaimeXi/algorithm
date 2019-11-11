package _力扣;

import java.util.Stack;

/**
 * @Author:Tod
 * @Description: 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * 说明：
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * <p>
 * 示例 1:
 * 输入: n = 3, k = 3
 * 输出: "213"
 * <p>
 * 示例 2:
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * @Date: Create in 18:29 2019/10/15
 * @ModifiedBy:
 */
public class _25第k个排列 {
    public static void main(String[] args) {
//        System.out.println(factorial(4));
        System.out.println(getPermutation(4, 9));
    }

    public static String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        boolean[] used = new boolean[n];
        StringBuilder sb = new StringBuilder();
        permutation(nums, 0, sb, used, k);
        return sb.toString();
    }

    private static void permutation(int[] nums, int curIndex, StringBuilder sb, boolean[] used, int k) {
        if (curIndex == nums.length) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (k > factorial(nums.length - curIndex - 1)) {
                    k = k - factorial(nums.length - curIndex - 1);
                    continue;
                }
                used[i] = true;
                sb.append(nums[i]);
                permutation(nums, curIndex + 1, sb, used, k);
            }
        }
    }

    private static int factorial(int N) {
        int res = 1;
        for (int i = N; i > 0; i--) {
            res *= i;
        }
        return res;
    }

}

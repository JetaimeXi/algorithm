package _力扣;

import util.Util;

/**
 * @Author:Tod
 * @Description: 统计所有小于非负整数 n 的质数的数量。
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * @Date: Create in 20:23 2019/10/19
 * @ModifiedBy:
 */
public class _37计数质数 {
    public static void main(String[] args) {
        System.out.println(countPrimes2(10));
    }

    public static int countPrimes(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (Util.isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public static int countPrimes2(int n) {
        int[] nums = new int[n];
        for (int i = 2; i < n; i++) {
            nums[i] = i;
        }
        for (int i = 2; i < n; i++) {
            if (nums[i] != 0) {
                for (int j = 2; i * j < n; j++) {
                    nums[i * j] = 0;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i]!=0){
                count++;
            }
        }
        return count;
    }

    private int countPrimes3(int n) {
        if (n < 2) return 0;
        int count = 0;
        // 元素设置标记
        boolean[] nums = new boolean[n];
        for (int i = 2; i * i < n; i++){
            // 用 ! 判断，就不用循环遍历设置数组元素都为ture
            if (!nums[i]) {
                for (int j = i * i; j < n; j += i) {
                    // 判断是为了去重(i=2,j=12; i=3,j=12),提高效率
                    if (nums[j])
                        continue;
                    // 这里递增，可以直接得到非质数的数量
                    count++;
                    // 非质数标记清除
                    nums[j] = true;
                }
            }
        }
        // 排除 其自身(-1) 和 1 ，所以要-2
        return n - count - 2;
    }
}

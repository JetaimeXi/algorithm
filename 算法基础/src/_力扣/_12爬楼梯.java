package _力扣;

import java.util.HashMap;

/**
 * @Author:Tod
 * @Description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * @Date: Create in 10:57 2019/10/8
 * @ModifiedBy:
 */
public class _12爬楼梯 {
    public static void main(String[] args) {
//        System.out.println(climbStairs2(44));
        System.out.println(climbStairs3(1));
    }

    public static int climbStairs(int n) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        hash.put(1, 1);
        hash.put(2, 2);
        int i = 3, sum;
        while (i <= n) {
            sum = hash.get(i - 1) + hash.get(i - 2);
            hash.put(i, sum);
            i++;
        }
        return hash.get(n);
    }

    public static int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int n_1 = 1, n_2 = 2;
        int i = 3;
        int sum = 0;
        while (i <= n) {
            sum = n_1 + n_2;
            n_1 = n_2;
            n_2 = sum;
            i++;
        }
        return n_2;
    }

    public static int climbStairs3(int n) {
        double para = Math.sqrt(5);
        n++;
        return (int) ((Math.pow((1 + para) / 2, n) - Math.pow((1 - para) / 2, n))/para + 0.5);
    }
}

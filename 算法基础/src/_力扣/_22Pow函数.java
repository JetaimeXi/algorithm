package _力扣;

/**
 * @Author:Tod
 * @Description: 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * @Date: Create in 16:22 2019/10/14
 * @ModifiedBy:
 */
public class _22Pow函数 {
    public static void main(String[] args) {
//        System.out.println(myPow(2.0, -2));
//        System.out.println(myPow(0.2, -2));
//        System.out.println(myPow(0.00001, 2147483647));
        System.out.println(myPow(10, 11));
    }

    public static double myPow(double x, int n) {
        double res = 1.0;
        // i = 11   5   2   1   0
        //     (1)  (2) 4   (8) 16
        // x^11 = x^1*x^10 = x^1*x^2*x^8
        // i = 20   10  5   2   1   0
        //     1    2   (4) 8   (16) 32
        // x^20 = x^4*x^16
        // i = 50   25  12  6   3   1   0
        //     1    2   4   8   16  32  64
        // x^50 = x^2*x^16*x^32
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }

    public static double myPow2(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        // n = 11       5       2
        //     x^10*x   x^4*x   x^2
        // n = -11       -5       -2
        //     x^10*(-x)   x^4*(-x)   x^2
        double half = myPow2(x, n / 2);
        double rest = myPow2(x, n % 2);
        return half * half * rest;
    }

}

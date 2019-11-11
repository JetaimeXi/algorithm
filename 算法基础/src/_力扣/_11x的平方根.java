package _力扣;

/**
 * @Author:Tod
 * @Description: 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * @Date: Create in 13:02 2019/10/7
 * @ModifiedBy:
 */
public class _11x的平方根 {
    public static void main(String[] args) {
//        System.out.println(mySqrt2(2147395599));
//        System.out.println(mySqrt2(9));
        System.out.println(mySqrt2(3));
    }

    //  二分逼近法
    public static int mySqrt(int x) {
        double start = 0;
        double end = x > 1 ? x : 1;
        while (Math.abs(end - start) > 1E-5) {
            double mid = (start + end) / 2;
            double res = f(mid, x);
            if (res > 0) {    //在mid的左侧
                end = mid;
            } else if (res < 0) {
                start = mid;
            } else {
                return (int) mid;
            }
        }
        return (int) end;
    }

    /*牛顿迭代法
     * y = f(x)的切线
     * f(x) = f(x0) + f'(x0)(x - x0) 令f(x) = 0 得 x1 = x0 - f(x0)/f'(x0)
     * 同理的 xn+1 = xn - f(xn)/f'(xn)
     * f(x) = x^2 - m
     * x 属于(0,m)
     * xn+1 = xn - f(xn)/f'(xn) = xn - f(xn)/(2 * xn)
     *      = xn - (x^2 - m)/(2 * xn)
     *      = (xn^2 + m) / (2 * xn)
     *      = 0.5*(xn + m/xn)
     * */
    public static int mySqrt2(int x) {
        double res = x;  //     f(x) = x^2 - m
        double res_before = 0;
        while (Math.abs(res - res_before) > 1E-1) {
            res_before = res;
            res = 0.5 * (res + x / res);
        }
        return (int) res;
    }

    public static double f(double x, double m) {
        return x * x - m;
    }

}

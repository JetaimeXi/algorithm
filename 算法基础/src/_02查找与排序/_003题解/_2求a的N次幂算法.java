package _02查找与排序._003题解;

/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 20:13 2019/9/18
 * @ModifiedBy:
 */
public class _2求a的N次幂算法 {
    public static void main(String[] args) {
//        System.out.println(pow(2, 31));
//        System.out.println(pow01(2, 31));
        System.out.println(pow02(2, 10));

    }

    /**
     * @param a 底数
     * @param N 幂
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 求a的N次幂高效算法
     * @Implement: 用a的2、4、8...指数接近于N，在循环中倍乘，然后递归调用余数(N-最接近指数)
     * 出口:  ①当N=1时 return a;(可以省略)   ②当N=0时，return 1;
     * 缺点：当阶数过大时，可能导致数的溢出，如double类型的0.00001
     * @Returin: int    返回a的N次幂的值
     */
    public static int pow(int a, int N) {
        if (N == 0) {
            return 1;
        }
        // a^20   ex = 2、4、8、16 res = a*a*a*a = a^16
        // a^4    ex = 2、4       res = a*a = a^4
        int res = a;
        int ex = 1;
        while ((ex << 1) <= N) {
            res *= res;
            ex = ex << 1;
        }
        return res * pow(a, N - ex);
    }

    /**
     * @param a 底数
     * @param N 幂
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 求a的N次幂高效算法     总体而言，第一个方法性能更快
     * @Implement: a^15=a*a^14=a*(a^7)^2=a*(a*a^6)^2=a*(a*(a^3)^2)^2=a*(a*(a*a^2)^2)^2
     * 出口:  ①当N=1时 return a;   ②当N=0时，return 1;
     * @Returin: int    返回a的N次幂的值
     */
    public static int pow01(int a, int N) {
        if (N == 1) {
            return a;
        }
        if (N == 0) {
            return 1;
        }
        int d = pow(a, N >> 1);    //如果是15     7       3       1
        d *= d;
        if ((N & 1) == 1) {     //当前的N为奇数时
            d *= a;
        }
        return d;
    }

    /**
     * @param a 底数
     * @param N 幂
     * @Author: Tod
     * @Date: 2019/9/19
     * @Description: 求a的N次幂高效算法
     * @Implement: 将N转换为二进制数，循环二进制数位次，每次都翻倍，当该位为1时，乘以a
     * @Returin: int    返回a的N次幂的值
     */
    public static int pow02(int a, int N) {

        String str_N = Integer.toString(N, 2);
        int res = 1;
        for (int i = 0; i < str_N.length(); i++) {
            res = res * res;
            if (str_N.charAt(i) == '1') {
                res = a * res;
            }
        }
        return res;
    }

}

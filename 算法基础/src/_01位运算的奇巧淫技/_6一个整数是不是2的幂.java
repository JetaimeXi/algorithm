package _01位运算的奇巧淫技;

/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 23:24 2019/9/17
 * @ModifiedBy:
 */
public class _6一个整数是不是2的幂 {
    public static void main(String[] args) {
        System.out.println(isPowerOf2(8));
    }

    public static boolean isPowerOf2(int N) {
        /**
        * @Author: Tod
        * @Date: 2019/9/17
        * @Description: 判断一个整数是不是2的幂
        * @Implement:   N&(N-1)消除二进制数最低位的1，验证是否只有一个1即可
        * @Returin: boolean
        * @Params:
         * @param N 是否是2的幂
        */
        return (N & (N - 1)) == 0 ? true : false;
    }

}

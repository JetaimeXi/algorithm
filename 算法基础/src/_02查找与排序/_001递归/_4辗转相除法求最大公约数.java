package _02查找与排序._001递归;

/**
 * @Author:Tod
 * @Description: 辗转相除法求最大公约数
 * @Date: Create in 8:53 2019/9/18
 * @ModifiedBy:
 */
public class _4辗转相除法求最大公约数 {
    public static void main(String[] args) {
        System.out.println(getGCD(42, 12));
    }

    /**
     * @param M
     * @param N
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 利用辗转相除法求N与M的最大公约数
     * @Implement: 将较大值%较小值=k,再将较小值%k，依次重复直至余数为0，返回当前的除数
     * a = k1 * i + a1
     * b = k2 * i + b2
     * (a + b) % i = (k1 + k2) + (a1 + b2)%i
     * @Returin: int 最大公约数
     */
    public static int getGCD(int M, int N) {
        return M > N ? GCD(M, N) : GCD(N, M);
    }

    private static int GCD(int M, int N) {
        if (N == 0) {  //当余数为0
            return M;
        }
        return GCD(N, M % N);
    }

}

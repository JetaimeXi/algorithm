package _01位运算的奇巧淫技;

public class _1判断一个整数的奇偶性 {
    public static void main(String[] args) {
        System.out.println(JudgeOdd(21));
        System.out.println(JudgeEven(20));
    }

    public static boolean JudgeOdd(int N) {
        /**
         * @创建人: Tod
         * @创建时间: 2019/9/17
         * @描述: 当N为奇数返回true
         * @返回值: boolean
         * @参数注释:
         * @param N
         */
        return ((N & 1) == 1) ? true : false;
    }

    public static boolean JudgeEven(int N) {
        /**
         * @创建人: Tod
         * @创建时间: 2019/9/17
         * @描述: 当N为偶数返回true
         * @返回值: boolean
         * @参数注释:
         * @param N
         */
        return ((N & 1) == 0) ? true : false;
    }
}

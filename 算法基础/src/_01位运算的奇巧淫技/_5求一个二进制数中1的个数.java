package _01位运算的奇巧淫技;

/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 22:46 2019/9/17
 * @ModifiedBy:
 */
public class _5求一个二进制数中1的个数 {
    public static void main(String[] args) {
        System.out.println(theNumberOf1InBinary(255));
        System.out.println(theNumberOf1InBinary01(9));
        System.out.println(theNumberOf1InBinary02(2));
    }

    /**
     * @param N 待判断的整型数
     * @Author: Tod
     * @Date: 2019/9/17
     * @Description: 求整数N化为二进制数中1的个数
     * @Implement: 通过N&(N-1)消掉最低位的1，循环至N为0，记录循环次数即为1的个数
     * @Returin: int
     */
    public static int theNumberOf1InBinary(int N) {
        int count = 0;
        while (N != 0) {
            N = (N&(N-1));
            count++;
        }
        return count;
    }

    /**
     * @param N 待判断的整型数
     * @Author: Tod
     * @Date: 2019/9/17
     * @Description: 求整数N化为二进制数中1的个数
     * @Implement: 用1左移int32位与N进行比较，通过判断已汇移回原位的结果是否为1，记录1的个数即可
     * @Returin: int
     */
    public static int theNumberOf1InBinary01(int N) {
        int count = 0;  //记录1的个数
        for (int i = 0; i < 32; i++) {
            if ((N & (1 << i)) == (1 << i))
                count++;
        }
        return count;
    }

    /**
     * @param N 待判断的整型数
     * @Author: Tod
     * @Date: 2019/9/17
     * @Description: 求整数N化为二进制数中1的个数
     * @Implement: 参数N右移int32位，&1记录1的个数
     * @Returin: int
     */
    public static int theNumberOf1InBinary02(int N) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((N >> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }


}

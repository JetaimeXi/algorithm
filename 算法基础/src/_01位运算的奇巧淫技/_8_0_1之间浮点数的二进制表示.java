package _01位运算的奇巧淫技;

/**
 * @Author:Tod
 * @Description: 将0~1之间的浮点数转换为二进制表示
 * @Date: Create in 0:59 2019/9/18
 * @ModifiedBy:
 */
public class _8_0_1之间浮点数的二进制表示 {
    public static void main(String[] args) {
        System.out.println(floatNumberToBinary(0.5));
    }

    /**
     * @param M 介于0~1之间的浮点数
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 将0~1之间的浮点数转换为二进制表示
     * @Implement: 乘2挪整法
     * @Returin: java.lang.String   二进制字符串0._
     */
    public static String floatNumberToBinary(double M) {
        String b_str = "0.";
        while (M > 0) {
            double r = M * 2;
            if (r >= 1) {
                b_str += "1";
                M = r - 1;
            } else {
                b_str += "0";
                M = r;
            }
        }
        return b_str;
    }
}

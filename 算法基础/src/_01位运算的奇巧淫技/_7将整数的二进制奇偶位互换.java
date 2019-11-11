package _01位运算的奇巧淫技;

/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 23:31 2019/9/17
 * @ModifiedBy:
 */
public class _7将整数的二进制奇偶位互换 {
    public static void main(String[] args) {
        System.out.println(interchangedOddAndEvenBit(256));
        System.out.println(interchangedOddAndEvenBit01(256));
    }

    /**
     * @param N 将N的二进制奇偶位互换
     * @Author: Tod
     * @Date: 2019/9/17
     * @Description: 将32位整数的二进制奇偶位互换
     * @Implement: xyxyxyxy&01010101(0x55555555)=0y0y0y0y左移一位^xyxyxyxy&10101010(0xaaaaaaaa)=x0x0x0x0右移一位
     * @Returin: int
     */
    public static int interchangedOddAndEvenBit(int N) {
        int odd = (N & (0xaaaaaaaa));
        int even = (N & (0x55555555));
        return (even << 1) ^ (odd >> 1);
    }
    /**
     * @param N 将N的二进制奇偶位互换
     * @Author: Tod
     * @Date: 2019/9/17
     * @Description: 将32位整数的二进制奇偶位互换
     * @Implement: 将N转换为二进制字符串，通过步长为2调换位置
     * @Returin: int
     */
    public static int interchangedOddAndEvenBit01(int N){
        String str_N = Integer.toString(N, 2);
        // 补齐32位字符串
        /*
        * String a = "abc";
        * String b = MessageFormat.format("{0}{1}", String.format("%03d", 0), a);
        * */
        str_N = String.format("%32s", str_N);   //补齐空格
        str_N = str_N.replaceAll(" ", "0");   //将空格置换为0
//        System.out.println(str_N);
        String str = new String();
        for (int i = 0; i < str_N.length(); i = i + 2) {
            str += str_N.charAt(i+1);
            str += str_N.charAt(i);
        }
//        System.out.println(str);
        // 将32位字符串转换为十进制整数
        return Integer.parseInt(str,2);
    }

}

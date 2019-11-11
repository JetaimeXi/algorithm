package _05字符串处理._01题解;

/**
 * @Author:Tod
 * @Descriptioni: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 输入: 123
 * 输出: 321
 * 输入: -123
 * 输出: -321
 * 输入: 120
 * 输出: 21
 * 假设我们的环境只能存储得下 32 位的有符号整数，
 * 则其数值范围为 [−2^31,  2^31 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @Date: Create in 15:21 2019/9/29
 * @ModifiedBy:
 */
public class _1整数反转 {
    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        String str = "2147483648";
//        StringBuilder sb = new StringBuilder("123");
//        sb.insert(0, '-');
//        System.out.println(sb.toString());
//        System.out.println(Integer.parseInt(str));
        System.out.println(reverse2(-14748363));
    }

    public static int reverse(int x) {
        String str = Integer.toString(x);
        StringBuilder sb = new StringBuilder();
        int index = str.length() - 1;
        char ch;
        int res;
        // 判断末尾是否存在多个零
        while (index > 0 && str.charAt(index) == '0') {
            index--;
        }
        // 反转字符串
        while (index > 0) {
            ch = str.charAt(index);
            sb.append(ch);
            index--;
        }
        // 判断是否含有负号
        if (str.charAt(0) == '-') {
            sb.insert(0, '-');
        } else {
            sb.append(str.charAt(0));
        }
        // 判断是否超过范围
        try {
            res = Integer.parseInt(sb.toString());
        } catch (Exception e) {
            return 0;
        }
        return res;
    }


    public static int reverse2(int x) {
        long rs = 0;
        while (x != 0) {
            rs = rs * 10 + x % 10;
            x /= 10;
        }
        return (rs < Integer.MIN_VALUE || rs > Integer.MAX_VALUE) ? 0 : (int) rs;
    }
}

package _力扣;

/**
 * @Author:Tod
 * @Description: 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * @Date: Create in 12:44 2019/10/6
 * @ModifiedBy:
 */
public class _10二进制求和 {
    public static void main(String[] args) {
//        String a = "11",b = "1";
//        String a = "1010", b = "1011";
//        String a = "1", b = "111";
//        String a = "10", b = "110010";
        String a = "1111", b = "1111";
        System.out.println(addBinary2(a, b));
    }

    public static String addBinary(String a, String b) {
        int a_len = a.length() - 1;
        int b_len = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        boolean sign = false;
        while (a_len >= 0 && b_len >= 0) {
            if (a.charAt(a_len) == '0' && b.charAt(b_len) == '0' && sign) {
                sb.insert(0, '1');
                sign = false;
            } else if (a.charAt(a_len) == '0' && b.charAt(b_len) == '0') {
                sb.insert(0, '0');
            } else if ((a.charAt(a_len) == '1' && b.charAt(b_len) == '0' || a.charAt(a_len) == '0' && b.charAt(b_len) == '1') && sign) {
                sb.insert(0, '0');
                sign = true;
            } else if (a.charAt(a_len) == '1' && b.charAt(b_len) == '0' || a.charAt(a_len) == '0' && b.charAt(b_len) == '1') {
                sb.insert(0, '1');
            } else if (a.charAt(a_len) == '1' && b.charAt(b_len) == '1' && sign) {
                sb.insert(0, '1');
                sign = true;
            } else if (a.charAt(a_len) == '1' && b.charAt(b_len) == '1') {
                sb.insert(0, '0');
                sign = true;
            }
            a_len--;
            b_len--;
        }
        while (a_len >= 0) {
            if (sign) {
                if (a.charAt(a_len) == '0') {
                    sb.insert(0, '1');
                    sign = false;
                } else {
                    sb.insert(0, '0');
                    sign = true;
                }
            } else {
                sb.insert(0, a.charAt(a_len));
            }
            a_len--;
        }
        while (b_len >= 0) {
            if (sign) {
                if (b.charAt(b_len) == '0') {
                    sb.insert(0, '1');
                    sign = false;
                } else {
                    sb.insert(0, '0');
                    sign = true;
                }
            } else {
                sb.insert(0, b.charAt(b_len));
            }
            b_len--;
        }
        if (sign) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }

    public static String addBinary2(String a, String b) {
        int car = 0; //进位
        int cur = 0;    //当前位
        StringBuilder sb_a = new StringBuilder(a);
        StringBuilder sb_b = new StringBuilder(b);
        if (sb_a.length() > sb_b.length()) {
            int temp = sb_a.length() - sb_b.length();
            for (int i = 0; i < temp; i++) {
                sb_b.insert(0, "0");
            }
        } else {
            int temp = sb_b.length() - sb_a.length();
            for (int i = 0; i < temp; i++) {
                sb_a.insert(0, "0");
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = sb_a.length() - 1;
        while (i >= 0) {
            cur = (sb_a.charAt(i) - '0') ^ (sb_b.charAt(i) - '0') ^ car;
            if ((sb_a.charAt(i) - '0') + (sb_b.charAt(i) - '0') + car >= 2) {
                car = 1;
            } else {
                car = 0;
            }
            sb.insert(0, (char)(cur + '0'));
            i--;
        }
        if (car == 1) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }
}

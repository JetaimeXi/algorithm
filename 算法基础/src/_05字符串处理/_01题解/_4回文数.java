package _05字符串处理._01题解;

/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 9:51 2019/10/3
 * @ModifiedBy:
 */
public class _4回文数 {
    public static void main(String[] args) {
        System.out.println(isPalindrome3(123321));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] ch = Integer.toString(x).toCharArray();
        int ch_length = ch.length;
        for (int i = 0; i < (ch_length >> 1); i++) {
            if (((ch[i] - '0') ^ (ch[ch_length - 1 - i] - '0')) != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x;
        int res = 0;
        while (temp != 0) {
            try {
                res *= 10;
                res += temp % 10;
                temp /= 10;
            } catch (Exception e) {
                return false;
            }
        }
        return x == res;
    }

    public static boolean isPalindrome3(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        int res = 0;
        // 1235321
        while (x > res) {
            res *= 10;
            res += x % 10;
            x /= 10;
        }
        // res = 1235 x = 123
        if (res > x) {
            res /= 10;
            return res == x;
        }
        return x == res ? true : false;
    }
}

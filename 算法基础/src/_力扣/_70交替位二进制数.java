package _力扣;

/**
 * @Author:Tod
 * @Description: 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 * 示例 1:
 * 输入: 5
 * 输出: True
 * 解释:
 * 5的二进制数是: 101
 * 示例 2:
 * 输入: 7
 * 输出: False
 * 解释:
 * 7的二进制数是: 111
 * 示例 3:
 * 输入: 11
 * 输出: False
 * 解释:
 * 11的二进制数是: 1011
 * 示例 4:
 * 输入: 10
 * 输出: True
 * 解释:
 * 10的二进制数是: 1010
 * @Date: Create in 0:59 2019/10/30
 * @ModifiedBy:
 */
public class _70交替位二进制数 {
    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits(7));
        System.out.println(hasAlternatingBits(11));
        System.out.println(hasAlternatingBits(10));
        System.out.println(hasAlternatingBits(22));
    }

    public static boolean hasAlternatingBits(int n) {
        while (n != 0) {
            if (((n & 1) ^ ((n & 2) >> 1)) == 1) {
                n >>= 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean hasAlternatingBits2(int n) {
        n ^= (n >>> 1);
        return (n & (n + 1)) == 0;
    }
}

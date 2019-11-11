package _力扣;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author:Tod
 * @Description: 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 *
 * 分享个字母大小写转换的方法：
 *
 *     统一转成大写：ch & 0b11011111 简写：ch & 0xDF
 *     统一转成小写：ch | 0b00100000 简写：ch | 0x20
 *
 * 比较的时候注意加上小括号哦，因为位运算优先级比较低。
 *
 * 使用示例：
 *
 * if((s.charAt(i ++) & 0xDF) != (s.charAt(j --) & 0xDF)) return false;
 *
 * @Date: Create in 9:46 2019/10/22
 * @ModifiedBy:
 */
public class _45验证回文串 {
    public static void main(String[] args) {
        System.out.println((int) '1');
        System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome2("race a car"));
    }

    public static boolean isPalindrome(String s) {
        char[] chars = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase().toCharArray();
        for (int i = 0; i < (chars.length >> 1); i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    private static char[] c = new char[256];

    static {
        for (int i = 0; i < 10; i++) {
            c[i + '0'] = (char) (i + 1);
        }
        for (int i = 0; i < 26; i++) {
            c[i + 'a'] = c[i + 'A'] = (char) (i + 11);
        }
    }

    public static boolean isPalindrome2(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char c1 = c[chars[i]];
            char c2 = c[chars[j]];
            if (c1 != 0 && c2 != 0) {
                if (c1 != c2) {
                    return false;
                }
                i++;
                j--;
            } else {
                if (c1 == 0) {
                    i++;
                }
                if (c2 == 0)
                    j--;
            }
        }
        return true;
    }
}

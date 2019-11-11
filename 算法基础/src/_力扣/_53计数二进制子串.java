package _力扣;

/**
 * @Author:Tod
 * @Description: 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * <p>
 * 重复出现的子串要计算它们出现的次数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 * <p>
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * <p>
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * <p>
 * 示例 2 :
 * <p>
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 * <p>
 * 注意：
 * <p>
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 * @Date: Create in 23:13 2019/10/24
 * @ModifiedBy:
 */
public class _53计数二进制子串 {
    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
        System.out.println(countBinarySubstrings("10101"));
        System.out.println(countBinarySubstrings("1"));
        System.out.println(countBinarySubstrings("10"));
        System.out.println(countBinarySubstrings("1010"));
        System.out.println(countBinarySubstrings("00100"));
    }

    public static int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        int curCount = 1, preCount = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                count += Math.min(curCount, preCount);
                preCount = curCount;
                curCount = 1;
            } else {
                curCount++;
            }
        }
        return count + Math.min(preCount, curCount);
    }
    public int countBinarySubstrings2(String s) {
        int[] groups = new int[s.length()];
        int t = 0;
        groups[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                groups[++t] = 1;
            } else {
                groups[t]++;
            }
        }

        int ans = 0;
        for (int i = 1; i <= t; i++) {
            ans += Math.min(groups[i-1], groups[i]);
        }
        return ans;
    }
}

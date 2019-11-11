package _力扣;

/**
 * @Author:Tod
 * @Description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * @Date: Create in 15:07 2019/10/22
 * @ModifiedBy:
 */
public class _46最长回文子串 {
    public static void main(String[] args) {
//        System.out.println(longestPalindrome("cbbbd"));
//        System.out.println(longestPalindrome("babad"));
//        System.out.println(longestPalindrome("babababcbabababb"));
//        System.out.println(longestPalindrome("a"));
//        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("abacab"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        boolean[][] dp = DPBooleanTable_2D(s);
        int max = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (dp[i][j] && j - i > max) {
                    max = j - i;
                    index = i;
                }
            }
        }
        return s.substring(index, index + max + 1);
    }

    private static boolean[][] DPBooleanTable_2D(String s) {
        boolean[][] booleanTabel = new boolean[s.length()][];
        for (int i = 0; i < s.length(); i++) {
            booleanTabel[i] = new boolean[s.length()];
        }
        for (int i = 0; i < s.length(); i++) {   //初始化
            booleanTabel[i][i] = true;
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                booleanTabel[i][i + 1] = true;
            }
        }
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(j) == s.charAt(i) && !booleanTabel[i][j]) {
                    booleanTabel[i][j] = booleanTabel[i + 1][j - 1];
                }
            }
        }
        return booleanTabel;
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        //step1:从中间算起
        //step2:找到被扩散的区间
        //step3:扩散\
        int[] result = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            i = findNext(str, i, result);
        }
        return s.substring(result[0], result[1] + 1);
    }

    int findNext(char[] str, int from, int[] result) {
        int to = from;
        while (to < str.length - 1 && str[to + 1] == str[from]) to++;
        int re = to;
        while (from > 0 && to < str.length - 1 && str[from - 1] == str[to + 1]) {
            from--;
            to++;
        }

        if (to - from > result[1] - result[0]) {
            result[1] = to;
            result[0] = from;
        }
        return re;
    }
}

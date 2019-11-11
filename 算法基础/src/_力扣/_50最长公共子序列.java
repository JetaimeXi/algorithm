package _力扣;

/**
 * @Author:Tod
 * @Description: 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
 * 一个字符串的 子序列 是指这样一个新的字符串：-
 * 它是由原字符串在不改变字符的相对顺序的情况下
 * 删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * 若这两个字符串没有公共子序列，则返回 0。
 * 示例 1:
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 * 提示:
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符。
 * @Date: Create in 20:23 2019/10/23
 * @ModifiedBy:
 */
public class _50最长公共子序列 {
    public static void main(String[] args) {
//        String text1 = "abc", text2 = "def";
        String text1 = "pmjghexybyrgzczy", text2 = "hafcdqbgncrcbihkd";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

    public static int longestCommonSubsequence2(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        if (text1.charAt(0) == text2.charAt(0)) {
            return longestCommonSubsequence(text1.substring(1), text2.substring(1)) + 1;
        } else {
            return Math.max(longestCommonSubsequence(text1, text2.substring(1)),
                    longestCommonSubsequence(text1.substring(1), text2));
        }
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = DynamicProgrammingLCS_2D(text1, text2);
        return dp[text1.length()][text2.length()];
    }

    private static int[][] DynamicProgrammingLCS_2D(String text1, String text2) {
        int[][] LCSTable = new int[text1.length() + 1][];
        for (int i = 0; i <= text1.length(); i++) {
            LCSTable[i] = new int[text2.length() + 1];
        }
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    LCSTable[i + 1][j + 1] = LCSTable[i][j] + 1;
                } else {
                    LCSTable[i + 1][j + 1] = Math.max(LCSTable[i][j + 1], LCSTable[i + 1][j]);
                }
            }
        }
        return LCSTable;
    }
}

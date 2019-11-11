package _力扣;

/**
 * @Author:Tod
 * @Description: 把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以 s 看起来是这样的："...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * 现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个唯一的 p 的非空子串，尤其是当你的输入是字符串 p ，你需要输出字符串 s 中 p 的不同的非空子串的数目。
 * 注意: p 仅由小写的英文字母组成，p 的大小可能超过 10000。
 * <p>
 * 输入: "a"
 * 输出: 1
 * 解释: 字符串 S 中只有一个"a"子字符。
 * <p>
 * 输入: "cac"
 * 输出: 2
 * 解释: 字符串 S 中的字符串“cac”只有两个子串“a”、“c”。.
 * <p>
 * 输入: "zab"
 * 输出: 6
 * 解释: 在字符串 S 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。.
 * @Date: Create in 9:33 2019/10/16
 * @ModifiedBy:
 */
public class _26环绕字符串中唯一的子字符串 {
    public static void main(String[] args) {
//        System.out.println(findSubstringInWraproundString("cac"));
        System.out.println(findSubstringInWraproundString("zabca"));
    }

    public static int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        char[] ch = p.toCharArray();
        int count = 1, sum = 0;
        for (int i = 0; i < ch.length; i++) {
            if (i > 0 && ((ch[i - 1] - 'a' + 1) % 26 == (ch[i] - 'a') % 26)) {
                count++;
            } else {
                count = 1;
            }
            dp[ch[i] - 'a'] = Math.max(count, dp[ch[i] - 'a']);
        }
        for (int i = 0; i < dp.length; i++) {
            sum += dp[i];
        }
        return sum;
    }
}

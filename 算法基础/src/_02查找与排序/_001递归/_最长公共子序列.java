package _02查找与排序._001递归;

/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 19:07 2019/10/23
 * @ModifiedBy:
 */
public class _最长公共子序列 {
    public static void main(String[] args) {
        System.out.println(countLCS("ABCDDDDEF", "BCDFEF"));
    }

    public static int countLCS(String s, String p) {
        if (s.length() == 0 || p.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == p.charAt(0)) {
            return countLCS(s.substring(1), p.substring(1)) + 1;
        } else {
            return Math.max(countLCS(s.substring(1), p), countLCS(s, p.substring(1)));
        }

    }
}

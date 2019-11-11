package _05字符串处理._02字符串算法;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 0:10 2019/10/22
 * @ModifiedBy:
 */
public class _RabinKarp算法 {
    final static long hashseed = 31;

    public static void main(String[] args) {
        System.out.println(RabinKarp("ABABABA", "ABA"));
    }

    public static List<Integer> RabinKarp(String s, String p) {
        long hash_p = hashSubString(p);
        long[] hash_s = hashString(s, p.length());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < hash_s.length; i++) {
            if (hash_p == hash_s[i]) {
                list.add(i);
            }
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int gap = it.next();
            int p_index = 0;
            while (p_index < p.length() && p.charAt(p_index) == s.charAt(p_index + gap)) {
                p_index++;
            }
            if (p_index != p.length()) {
                list.remove(gap);
            }
        }
        return list;
    }

    /**
     * @param s
     * @param n
     * @Author: Tod
     * @Date: 2019/10/22
     * @Description: 滚动哈希
     * @Implement:
     * @Return: long[]
     */
    private static long[] hashString(final String s, final int n) {
        char[] chars = s.toCharArray();
        long[] res = new long[s.length() - n + 1];
        res[0] = hashSubString(s.substring(0, n));
        for (int i = n; i < chars.length; i++) {
            char oldChar = chars[i - n];
            char newChar = chars[i];
            res[i - n + 1] = (res[i - n] * hashseed - oldChar * (long) Math.pow((double) hashseed, (double) n) + newChar) % Integer.MAX_VALUE;
        }
        return res;
    }

    private static long hashSubString(final String p) {
        char[] chars = p.toCharArray();
        long res = chars[0];
        for (int i = 1; i < chars.length; i++) {
            res = (res * hashseed + chars[i]) % Integer.MAX_VALUE;
        }
        return res;
    }

}

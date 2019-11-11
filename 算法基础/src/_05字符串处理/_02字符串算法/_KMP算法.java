package _05字符串处理._02字符串算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 12:55 2019/10/22
 * @ModifiedBy:
 */
public class _KMP算法 {
    public static void main(String[] args) {
        System.out.println(KMP("babababcbabababb", "bab"));
    }

    public static List<Integer> KMP(String s, String p) {
        int[] next = getNext(s);
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < s.length()) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            if (j == p.length()) {
                list.add(i - j);
                i--;
                j = next[j - 1];
            }
        }
        return list;
    }

    private static int[] getNext(String p) {
        int[] next = new int[p.length()];
        next[0] = -1;
        next[1] = 0;
        for (int i = 1; i < p.length() - 1; i++) {
            int k = next[i];
            while (k != -1) {
                if (p.charAt(i) == p.charAt(k)) {
                    break;
                } else {
                    k = next[k];
                }
            }
            next[i + 1] = k + 1;
        }
        return next;
    }

}

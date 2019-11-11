package _力扣;

/**
 * @Author:Tod
 * @Description: 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * @Date: Create in 17:01 2019/10/11
 * @ModifiedBy:
 */
public class _21实现strStr {
    public static void main(String[] args) {
//        String haystack = "hello";
//        String needle = "ll";
        String haystack = "mississippi";
        String needle = "issip";

//        String haystack = "a";
//        String needle = "a";
        System.out.println(strStr2(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            int start = 0;
            int index = i;
            while (i < haystack.length() && start < needle.length() && haystack.charAt(i) == needle.charAt(start)) {
                i++;
                start++;
            }
            if (start == needle.length()) {
                return index;
            }
            i = index;
        }
        return -1;
    }

    public static int strStr2(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }
        if (needle.length() == 1) {
            for (int i = 0; i < haystack.length(); i++) {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    return i;
                }
            }
            return -1;
        }
        int[] next = getNext(needle);
        int i = 0, j = 0;
        while (i < haystack.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            if (j == needle.length()) {
                return i - j;
            }
        }
        return j;
    }

    private static int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        next[0] = -1;
        next[1] = 0;
        for (int i = 1; i < needle.length() - 1; i++) {
            int k = next[i];
            while (k != -1) {
                if (needle.charAt(i) == needle.charAt(k)) {
                    break;
                }
                k = next[k];
            }
            next[i + 1] = k + 1;
        }
        return next;
    }
}

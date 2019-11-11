package _02查找与排序._003题解;

import java.util.Arrays;

/**
 * @Author:Tod
 * @Description: 输入字符串str1和str2，判断str1中的所有字符串是否都存在于str2中
 * @Date: Create in 21:18 2019/9/26
 * @ModifiedBy:
 */
public class _12字符串是否包含另一字符串 {
    public static void main(String[] args) {
        String str1 = "bca";
        String str2 = "xyabaa";
        System.out.println(isInStr2(str1, str2));
    }

    /**
     * @param str1
     * @param str2
     * @Author: Tod
     * @Date: 2019/9/26
     * @Description: 输入字符串str1(M)和str2(N)，判断str1中的所有字符串是否都存在于str2中
     * @Implement: 将str2转化为char[]数组，然后对其进行排序，通过二分查找str1.charAt(i)的位置，时间复杂度从M*N降低为M*lg(N)
     * @Returin: boolean
     */
    public static boolean isInStr2(String str1, String str2) {
        char[] s2 = str2.toCharArray();
        Arrays.sort(s2);
        for (int i = 0; i < str1.length(); i++) {
            int index = Arrays.binarySearch(s2, str1.charAt(i));
            if (index < 0) {
                return false;
            }
        }
        return true;
    }
}

package _02查找与排序._001递归;

/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 8:35 2019/9/18
 * @ModifiedBy:
 */
public class _2字符串翻转 {
    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(stringReverse(str, str.length()-1));
    }

    /**
     * @param str         带翻转的字符串
     * @param indexOfLast 当前字符串的位置(从后向前) str.length()-1
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 递归形式将字符串翻转
     * @Implement: str.charAt(indexOfLast)+stringReverse(str, indexOfLast-1)
     * @Returin: String 翻转后的字符串
     */
    public static String stringReverse(String str, int indexOfLast) {
        if (indexOfLast == 0)
            return "" + str.charAt(0);
        return str.charAt(indexOfLast) + stringReverse(str, indexOfLast - 1);
    }
}

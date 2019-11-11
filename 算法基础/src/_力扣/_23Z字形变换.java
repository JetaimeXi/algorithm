package _力扣;

/**
 * @Author:Tod
 * @Description: 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * @Date: Create in 19:21 2019/10/14
 * @ModifiedBy:
 */
public class _23Z字形变换 {
    public static void main(String[] args) {
//        String s = "LEETCODEISHIRING";
        String s = "A";
        int numRows = 1;
//        int numRows = 3;
//        int numRows = 4;
//        int numRows = 5;
//        int numRows = 6;
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        int gap = (numRows << 1) - 2, preIndex, postIndex, len = s.length();
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                int index = i;
                while (index < len) {
                    res.append(s.charAt(index));
                    index += gap;
                }
            } else {
                preIndex = i;
                postIndex = gap - i;
                while (true) {
                    if (preIndex < len) {
                        res.append(s.charAt(preIndex));
                        preIndex += gap;
                    } else {
                        break;
                    }
                    if (postIndex < len) {
                        res.append(s.charAt(postIndex));
                        postIndex += gap;
                    } else {
                        break;
                    }
                }
            }
        }
        return res.toString();
    }

    public static String convert2(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}

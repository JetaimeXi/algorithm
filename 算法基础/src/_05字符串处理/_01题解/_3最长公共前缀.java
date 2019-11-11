package _05字符串处理._01题解;


/**
 * @Author:Tod
 * @Description: 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * @Date: Create in 21:41 2019/9/29
 * @ModifiedBy:
 */
public class _3最长公共前缀 {
    public static void main(String[] args) {
//        String[] strs = {
//                "flower", "flow", "flight"
//        };
//        String[] strs = {
//                "dog", "racecar", "car"
//        };
//        String[] strs = {
//                "c","acc","ccc"
//        };
//        String[] strs = {
//                "a", "aca", "accb", "b"
//        };
        String[] strs = {
                "aaa", "aa", "aaa"
        };
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (strs.length < 2) {
            if (strs.length == 1) {
                return strs[0];
            }
            return "";
        }
        String first_Str = strs[0];
        String second_Str = strs[1];
        int index = 0;
        while (index < first_Str.length() && index < second_Str.length()) {
            if (first_Str.charAt(index) == second_Str.charAt(index)) {
                index++;
            } else {
                break;
            }
        }
        if (index == 0) {
            return "";
        }
        for (int i = 2; i < strs.length; i++) {
            int count = 0;
            for (int j = 0; j < first_Str.length() && j < strs[i].length() && j <= index; j++) {
                if (first_Str.charAt(j) == strs[i].charAt(j)) {
                    count++;
                }
            }
            if (index > count) {
                index = count;
            }
        }
        if (index == 0) {
            return "";
        }
        return first_Str.substring(0, index);
    }

    public String longestCommonPrefix2(String[] strs) {
        // 如果strs没有数据则返回""
        if (strs.length == 0) {
            return "";
        }

        // 获取最短字符串的长度值
        int minLength = strs[0].length();
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        // 二维数组的遍历，调整内外循环先后顺序即可得到不同的效果
        for (int j = 0; j < minLength; j++) {
            for (String str : strs) {
                // 遍历，只需要和第一个字符串strs[0]的比较即可,不用一一对比
                if (strs[0].charAt(j) != str.charAt(j)) {
                    return strs[0].substring(0, j);
                }

            }
        }
        // 如果遍历过后没有找到遍历结束出口，则表示最短的字符串就是公共前缀
        return strs[0].substring(0, minLength);
    }
}

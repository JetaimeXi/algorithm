package _力扣;

/**
 * @Author:Tod
 * @Description: 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * @Date: Create in 15:46 2019/10/5
 * @ModifiedBy:
 */
public class _09最后一个单词的长度 {
    public static void main(String[] args) {
//        String s = "a ";
//        String s = "        ";
        String s = "Hello World ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        int count = 0;
        int len = s.length() - 1;
        while (len >= 0 && s.charAt(len) == ' ') {
            len--;
        }
        for (int i = len; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return count;
            }
            count++;
        }
        return count;
    }
}

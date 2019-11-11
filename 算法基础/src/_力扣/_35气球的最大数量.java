package _力扣;

import java.util.HashMap;

/**
 * @Author:Tod
 * @Description: 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * <p>
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 * <p>
 * 输入：text = "nlaebolko"
 * 输出：1
 * <p>
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * <p>
 * 输入：text = "leetcode"
 * 输出：0
 * <p>
 * 提示：
 * 1 <= text.length <= 10^4
 * text 全部由小写英文字母组成
 * @Date: Create in 10:13 2019/10/19
 * @ModifiedBy:
 */
public class _35气球的最大数量 {
    public static void main(String[] args) {
//        System.out.println(maxNumberOfBalloons("nlaebolko"));
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(maxNumberOfBalloons("leetcode"));
    }

    public static int maxNumberOfBalloons(String text) {
        char[] chars = new char[]{'b', 'a', 'l', 'l', 'o', 'o', 'n'};
        HashMap<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            hash.put(chars[i], 0);
        }
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (hash.containsKey(c)) {
                Integer val = hash.get(c);
                val++;
                hash.put(c, val);
            }
        }
        int count = 0;
        boolean sign = true;
        while (sign) {
            for (int i = 0; i < chars.length; i++) {
                Integer val = hash.get(chars[i]);
                if (val == 0) {
                    sign = false;
                    break;
                }
                val--;
                hash.put(chars[i], val);
            }
            if (!sign) {
                break;
            }
            count++;
        }
        return count;
    }
    public static int maxNumberOfBalloons2(String text) {
        int[] letters = new int[26];
        for(char ch :text.toCharArray()){
            letters[ch - 97] ++;
        }
        letters['l' - 97] /= 2;
        letters['o' - 97] /= 2;
        int min = Integer.MAX_VALUE;
        for(char ch : "balon".toCharArray()){
            if(letters[ch - 97] < min){
                min = letters[ch - 97];
            }
        }
        return min;
    }
}

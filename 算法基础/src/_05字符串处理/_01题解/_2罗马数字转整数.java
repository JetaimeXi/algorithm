package _05字符串处理._01题解;

import java.util.HashMap;

/**
 * @Author:Tod
 * @Description: 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * <p>
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * 输入: "III"
 * 输出: 3
 * 输入: "IV"
 * 输出: 4
 * 输入: "IX"
 * 输出: 9
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * @Date: Create in 20:02 2019/9/29
 * @ModifiedBy:
 */
public class _2罗马数字转整数 {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> hash = new HashMap<>();
        hash.put('I', 1);
        hash.put('V', 5);
        hash.put('X', 10);
        hash.put('L', 50);
        hash.put('C', 100);
        hash.put('D', 500);
        hash.put('M', 1000);
        char pre, post;
        int sum = 0;
        int i;
        for (i = 0; i < s.length() - 1; i++) {
            pre = s.charAt(i);
            post = s.charAt(i + 1);
            // 一次取出前后两个字符，判断是否符合六种情况中的一种
            if ((pre == 'I' && post == 'V') || (pre == 'I' && post == 'X')
                    || (pre == 'X' && post == 'L') || (pre == 'X' && post == 'C')
                    || (pre == 'C' && post == 'D') || (pre == 'C' && post == 'M')) {
                sum += hash.get(post) - hash.get(pre);
                i++;
            }else {
                sum+=hash.get(pre);
            }
        }
        if (i<s.length()){
            sum+=hash.get(s.charAt(i));
        }
        return sum;
//        int ans = 0;
//        for(int i = 0;i < s.length();) {
//            if(i + 1 < s.length() && map.containsKey(s.substring(i, i+2))) {
//                ans += map.get(s.substring(i, i+2));
//                i += 2;
//            } else {
//                ans += map.get(s.substring(i, i+1));
//                i ++;
//            }
//        }
//        return ans;
    }
}

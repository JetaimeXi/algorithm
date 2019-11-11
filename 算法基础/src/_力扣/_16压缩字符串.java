package _力扣;

import util.Util;

import java.util.ArrayList;

/**
 * @Author:Tod
 * @Description: 给定一组字符，使用原地算法将其压缩。
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * 在完成原地修改输入数组后，返回数组的新长度。
 * @Date: Create in 10:30 2019/10/9
 * @ModifiedBy:
 */
public class _16压缩字符串 {
    public static void main(String[] args) {
//        char[] chars = new char[]{'a','a','b','b','c','c','c'};
//        char[] chars = new char[]{'a','a','a','b','b','a','a'};
//        char[] chars = new char[]{'a','a','b','c','c','c'};
        char[] chars = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(compress(chars));
        Util.print(chars);
    }

    public static int compress(char[] chars) {
        int count, index = 0;
        for (int i = 0; i < chars.length; i++) {
            count = 1;
            while (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }
            if (count != 1) {
//                ArrayList<Integer> arrlist = new ArrayList<Integer>();
//                while (count != 0) {
//                    arrlist.add(count % 10);
//                    count /= 10;
//                }
//                for (int j = arrlist.size()-1; j >= 0; j--) {
//                    index++;
//                    chars[index] = (char) (arrlist.get(j) + '0');
//                }
                char[] arr = String.valueOf(count).toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    index++;
                    chars[index] = arr[j];
                }
            }
            index++;
            if (i+1<chars.length){
                chars[index] = chars[i+1];
            }
        }
        return index;
    }
}

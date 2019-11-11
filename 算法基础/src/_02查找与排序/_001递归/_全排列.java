package _02查找与排序._001递归;

import util.Util;

/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 18:54 2019/10/23
 * @ModifiedBy:
 */
public class _全排列 {
    public static void main(String[] args) {
        printPermutation("ABC".toCharArray(),0);
    }
    public static void printPermutation(char[] chars,int k){
        if (k==chars.length){
            System.out.println(chars);
        }
        // k前进， i交换
        for (int i = k; i < chars.length; i++) {
            Util.swap(chars,i,k);
            printPermutation(chars,k+1);
            Util.swap(chars,i,k);
        }
    }


}

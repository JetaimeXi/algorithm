package _01位运算的奇巧淫技;

import util.Util;

/**
 * @Author:Tod
 * @Description: 一个数组中只有一个数出现了1次，其他的数都出现了K次，找出出现1次的这个数
 * @Date: Create in 1:13 2019/9/18
 * @ModifiedBy:
 */
public class _9求只出现一次的值 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 8, 7, 7, 3, 3};
        System.out.println(theSingleNumberOfKTime(arr, 2));;
    }

    /**
     * @param arr 有出现K次的若干值及出现一次的值组成的数组
     * @param K   出现了K次
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 一个数组中只有一个数出现了1次，其他的数都出现了K次，找出出现1次的这个数
     * @Implement: K个相同的K进制数做不进制加法结果为0，不进制加法通过%K来实现
     * @Returin: int 返回出现一次的值
     */
    public static int theSingleNumberOfKTime(int[] arr, int K) {
        // 记录最长字符串
        int maxLen = 0;
        // 将arr[i]中的元素转换为K进制字符串并反向保存
        char[][] kRadix = new char[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            String str = Integer.toString(arr[i], K);
            if (str.length() > maxLen)
                maxLen = str.length();
            kRadix[i] = new StringBuffer(str).reverse().toString().toCharArray();
        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(kRadix[i]);
//            System.out.println(" ");
//        }
//        System.out.println(maxLen);
        int[] resArr = new int[maxLen];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < maxLen; j++) {
                // 控制位数
                if (j >= kRadix[i].length) {
                    resArr[j] += 0;
                } else {
                    resArr[j] += (kRadix[i][j] - '0');
                }
            }
        }
//        Util.print(resArr);
        int res = 0;
        for (int i = 0; i < maxLen; i++) {
            // 不进位加法
            res += (resArr[i]%K)*(int)(Math.pow(K,i));
        }
        return res;
    }
}



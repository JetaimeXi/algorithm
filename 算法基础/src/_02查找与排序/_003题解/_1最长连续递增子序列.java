package _02查找与排序._003题解;

import util.Util;

/**
 * @Author:Tod
 * @Description: 在(1, 9, 2, 5, 7, 3, 4, 6, 8, 0)中查找出最长连续递增子序列(3, 4, 6, 8)
 * @Date: Create in 15:19 2019/9/18
 * @ModifiedBy:
 */
public class _1最长连续递增子序列 {
    public static void main(String[] args) {
        int[] arr = {1, 9, 2, 5, 7, 3, 7, 6, 8, 5};
        Util.print(theLongestSubsequence(arr));
    }

    /**
     * @param arr 待查找的整型数组
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 在乱序的整型数组中找出最长连续递增子序列，如(1,9,2,5,7,3,4,6,8,0)中的(3,4,6,8)
     * @Implement: 双指针方式，头指针查找连续递增序列，尾指针记录起始下标，同时增加count来记录当前个数，MAX来记录最大值
     * @Returin: int[]   返回一个二元组，第一个表示起始下标，第二个表示数组长度
     */
    public static int[] theLongestSubsequence(int[] arr) {
        int hPtr = 0;
        int tPtr = 0;
        int count = 1;
        int Max = 0;
        for (int i = 1; i < arr.length; i++) {
            while (i < arr.length && arr[i - 1] < arr[i]) {
                count++;
                i++;
            }
            if (count > Max) {
                tPtr = hPtr;
                Max = count;

            }
            hPtr = i;
            count = 1;
        }
        return new int[]{tPtr, Max};
    }
}

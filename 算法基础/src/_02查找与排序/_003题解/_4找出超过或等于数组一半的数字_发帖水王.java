package _02查找与排序._003题解;

import util.Util;

/**
 * @Author:Tod
 * @Description: "发帖水王"，在整型数组中，找出元素个数超过或等于数组一半的数值
 * @Date: Create in 20:16 2019/9/19
 * @ModifiedBy:
 */
public class _4找出超过或等于数组一半的数字_发帖水王 {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 4, 2, 4, 1, 2};
        int[] res = selectMajority(arr);
        Util.print(res);
    }

    public static int[] selectMajority(int[] arr) {
        /**
         * @param arr    整型数组
         * @Author: Tod
         * @Date: 2019/9/19
         * @Description: 在整型数组中，找出元素个数超过或等于数组一半的数值
         * @Implement: 在数组中去除两个不同的元素后，超过数组一半的数在数组中仍超过一半，
         * 当恰好是数组的一半时，则总数必为偶数，最终一定会nTimes消减为0，则在最后两个数中必有一个数出现的次数恰好是数组的一半，
         * 通过记录最后一个值出现的次数，判断是否等于arr.length的一半即可
         * @Returin: int[]   返回超过或等于数组一半的数字及其出现的次数，当返回-1及次数0时，表示不存在超过或等于数组一半的数字
         */
        int candidate = arr[0];
        int nTimes = 1;
        int countOfLast = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[arr.length - 1]) {
                countOfLast++;
            }
            if (nTimes == 0) {
                candidate = arr[i];
                nTimes = 1;
                continue;   //跳出此次循环
            }
            if (arr[i] == candidate) {
                nTimes++;
            } else {
                nTimes--;
            }
        }
        nTimes = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == candidate) {
                nTimes++;
            }
        }
        if (nTimes >= (arr.length >> 1)) {
            return new int[]{candidate, nTimes};
        } else if (countOfLast == (arr.length >> 1)) {
            return new int[]{arr[arr.length - 1], countOfLast};
        } else {
            return new int[]{-1, 0};
        }
    }

}

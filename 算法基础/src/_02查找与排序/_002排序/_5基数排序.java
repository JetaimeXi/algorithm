package _02查找与排序._002排序;

import util.Util;

import java.util.ArrayList;

/**
 * @Author:Tod
 * @Description: 适用于十进制数的排序，十个桶
 * @Date: Create in 19:39 2019/9/22
 * @ModifiedBy:
 */
public class _5基数排序 {
    private static ArrayList[] bucket = new ArrayList[10];

    // 初始化桶
    static {
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList();
        }
    }

    /**
     * @param arr 待排序数组
     * @Author: Tod
     * @Date: 2019/9/22
     * @Description: 基数排序
     * @Implement: 可实现负数排序
     * @Returin: void
     */
    public static void radixSort(int[] arr) {
        int min = Util.getMinOfArr(arr);
        int gap = 0;
        if (min < 0) {
            gap = Math.abs(min);
            for (int i = 0; i < arr.length; i++) {
                arr[i] += gap;
            }
        }
        int max = Util.getMaxOfArr(arr);
        int dNum = 0;
        //  获取最大值的位数
        while (max > 0) {
            max /= 10;
            dNum++;
        }
        radixSort(arr, dNum);
        if (gap > 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] -= gap;
            }
        }
    }

    private static void radixSort(int[] arr, int dNum) {
        for (int i = 1; i <= dNum; i++) {
            for (int j = 0; j < arr.length; j++) {
                // 将每一位上的值入桶
                putInBucket(arr[j], Util.getDigitOn(arr[j], i));
            }
            int index = 0;
            //  将每一位上的值出桶
            for (int j = 0; j < bucket.length; j++) {
                for (Object m : bucket[j]) {
                    arr[index++] = (Integer) m;
                }
            }
            // 清空桶中的值
            for (ArrayList b : bucket) {
                b.clear();
            }
        }

    }

    private static void putInBucket(int data, int digitOn) {
        switch (digitOn) {
            case 0:
                bucket[0].add(data);
                break;
            case 1:
                bucket[1].add(data);
                break;
            case 2:
                bucket[2].add(data);
                break;
            case 3:
                bucket[3].add(data);
                break;
            case 4:
                bucket[4].add(data);
                break;
            case 5:
                bucket[5].add(data);
                break;
            case 6:
                bucket[6].add(data);
                break;
            case 7:
                bucket[7].add(data);
                break;
            case 8:
                bucket[8].add(data);
                break;
            case 9:
                bucket[9].add(data);
                break;
        }
    }

    public static void main(String[] args) {
//        int[] arr = {-10, 20, 3, 65, 29};
        int[] arr = Util.randomArr(10, 100);
        Util.print(arr);
        radixSort(arr);
        Util.print(arr);
    }
}

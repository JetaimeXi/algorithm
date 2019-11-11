package _02查找与排序._002排序._基础排序;

import util.Util;

/**
 * @Author:Tod
 * @Description: 递归希尔排序
 * @Date: Create in 10:22 2019/9/18
 * @ModifiedBy:
 */
public class _1希尔排序 {
    public static void main(String[] args) {
        int[] arr = {8,4,9,6,7,5,2,3,11,5,12,48,13};
        recursionOfShellSort(arr);
        Util.print(arr);
    }

    /**
     * @param arr
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 希尔排序的递归形式，缩小增量的插入排序
     * @Implement: 通过interval(arr.length > > 1每次缩小一半至1)控制外层循环，内部循环利用插入排序进行
     * @Returin: void
     */
    public static void recursionOfShellSort(int[] arr) {
        for (int interval = (arr.length >> 1); interval > 0; interval = (interval >> 1)) {
            // 步长为interval
            for (int i = interval; i < arr.length; i++) {
                int target = arr[i];
                int j = i - interval;
                while (j > -1 && target < arr[j]) {
                    arr[j + interval] = arr[j];
                    j -= interval;
                }
                arr[j + interval] = target;
            }
        }
    }
}

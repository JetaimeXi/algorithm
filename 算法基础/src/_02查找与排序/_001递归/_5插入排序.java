package _02查找与排序._001递归;

import util.Util;

/**
 * @Author:Tod
 * @Description: 这是插入排序的递归算法
 * @Date: Create in 9:10 2019/9/18
 * @ModifiedBy:
 */
public class _5插入排序 {
    public static void main(String[] args) {
        int[] arr = {1,4,3,2,9,6,8,5,7};
        recursionOfInsertSort(arr, arr.length-1);
        Util.print(arr);
    }

    /**
     * @param arr         待排序的数组
     * @param indexOfLast 当前数组的最后一个下标,arr.length-1
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 插入排序的递归算法
     * @Implement: ①数组的0~indexOfLast-1个元素这部分有序     ②将indexOfLast这个元素插入到有序数组中
     * @Returin: void
     */
    public static void recursionOfInsertSort(int[] arr, int indexOfLast) {
        if (indexOfLast > 0) {
            recursionOfInsertSort(arr, indexOfLast - 1);
            // 插入排序算法
            int x = arr[indexOfLast];
            int index = indexOfLast - 1;
            while (index > -1 && x < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = x;
        }


    }
}

package _02查找与排序._002排序;

import util.Util;

/**
 * @Author:Tod
 * @Description:    大顶堆：数组中最大元素位于数组的第一个位置，其输出的排序为升序
 * @Date: Create in 16:32 2019/9/22
 * @ModifiedBy:
 */
public class _3大顶堆升序排序 {
    public static void main(String[] args) {
        int[] arr = {30, 73, 26, 69, 11, 21, 40, 7, 23, 53};
        Util.print(arr);
        makeMaxHeap(arr);
        Util.print(arr);
        maxHeapSort(arr);
        Util.print(arr);
    }

    public static void maxHeapSort(int[] arr) {
        //  先对数组进行大顶堆堆化
        makeMaxHeap(arr);
        //  将数组的0号元素与当前的最后一个元素交换，并且将最后一个元素排除进行堆调整
        for (int i = arr.length - 1; i >= 0; i--) {
            Util.swap(arr, 0, i);
            maxHeapFixDown(arr, 0, i - 1);
        }
    }

    private static void makeMaxHeap(int[] arr) {
        // 根节点i 0求左(2*i+1)右(2*i+2)结点
        // 子节点 length 求根节点(j/2) - 1    j -> (j-1)/2
        for (int i = (arr.length >> 1) - 1; i >= 0; i--) {
            maxHeapFixDown(arr, i, arr.length-1);
        }
    }

    private static void maxHeapFixDown(int[] arr, int i, int length) {
        int j = (i << 1) + 1;
        if (j >= length) {
            return;
        }
        if (j + 1 <= length && arr[j] < arr[j + 1]) {   //取出左右子节点较大值
            j++;
        }
        //  arr[i]已经是最大值
        if (arr[i] >= arr[j]) {
            return;
        }
        // 交换二者的值
        Util.swap(arr, i, j);
        //  递归进入下一层
        maxHeapFixDown(arr, j, length);
    }

}

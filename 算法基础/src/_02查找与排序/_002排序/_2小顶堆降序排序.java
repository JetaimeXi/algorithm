package _02查找与排序._002排序;

import util.Util;

/**
 * @Author:Tod
 * @Description: 这是小顶堆的降序排序
 * @Date: Create in 21:30 2019/9/21
 * @ModifiedBy:
 */
public class _2小顶堆降序排序 {
    public static void main(String[] args) {
//        int[] arr = Util.randomArr(10, 100);
        int[] arr = {99, 0, 47, 27, 32, 62, 62, 53, 89, 85};
        Util.print(arr);
        makeMinHeap(arr);
        Util.print(arr);
        minHeapSort(arr);

        Util.print(arr);
    }

    /**
     * @param arr 待排序的数组
     * @Author: Tod
     * @Date: 2019/9/22
     * @Description: 小顶堆的降序排序
     * @Implement: 先将数组堆化，然后将第一个元素与当前最后的元素交换，忽略当前最后的元素，进行堆的调整
     * @Returin: void
     */
    public static void minHeapSort(int[] arr) {
        //  先对数组进行堆化
        makeMinHeap(arr);
        //  把堆顶0号元素和最后元素对调
        for (int i = arr.length - 1; i >= 0; i--) {
            Util.swap(arr, 0, i);
            //  缩小堆的范围，对堆顶元素进行向下调整
            minHeapFixDown(arr, 0, i - 1);
        }
    }

    /**
     * @param arr 待堆化的数组
     * @Author: Tod
     * @Date: 2019/9/22
     * @Description: 将数组进行堆化，得到一个小顶堆的数组
     * @Implement: 从最后一个元素的父节点开始进行堆的调整，知道根节点
     * @Returin: void
     */
    public static void makeMinHeap(int[] arr) {
        for (int i = (arr.length >> 1) - 1; i >= 0; i--) {
            minHeapFixDown(arr, i, arr.length - 1);
        }
    }

    /**
     * @param arr    待调整的数组
     * @param i      当前开始调整的结点
     * @param length 最大数组下标
     * @Author: Tod
     * @Date: 2019/9/22
     * @Description: 从当前arr[i]开始，直到length下标的数进行堆调整
     * @Implement: 在小于length的情况下，找到i的左右子节点的最小值下标j，调换i与j的位置，然后递归进入j结点进行调整
     * @Returin: void
     */
    public static void minHeapFixDown(int[] arr, int i, int length) {
        int j = (i << 1) + 1;
        if (j > length) {
            return;
        }
        if (j + 1 <= length && arr[j + 1] < arr[j])
            j++;

        if (arr[j] > arr[i]) {
            return;
        }
        Util.swap(arr, i, j);
        minHeapFixDown(arr, j, length);
    }
}

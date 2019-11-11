package _02查找与排序._003题解;

import util.Util;


import static _02查找与排序._002排序._2小顶堆降序排序.makeMinHeap;
import static _02查找与排序._002排序._2小顶堆降序排序.minHeapFixDown;

/**
 * @Author:Tod
 * @Description: 用户输入K，表示要求得到topK个数，用户每输入一个数据回车获得这个数据，当输入-1表示输入终止，输出topK个数
 * @Date: Create in 17:04 2019/9/26
 * @ModifiedBy:
 */
public class _9topK问题 {
    public static void main(String[] args) {
        topK();
    }

    /**
     * @param
     * @Author: Tod
     * @Date: 2019/9/26
     * @Description: 这是一个以降序排列的topK问题，堆更适用于海量数据流
     * @Implement: 利用一个数组存入K个数据，在K个数据存放后进行最小堆堆化，
     * 后续的数据通过与arr[0]比较，如果比arr[0]大则应将此数据与arr[0]进行交换，同时从0到K-1位置进行堆调整，直到输入完毕
     * 通过小顶堆输出降序序列的性质，将第0个位置与当前i(i from K-1 to 1)位置交换，并且对0到i-1个元素进行堆调整，输出arr即为topK
     * @Returin: void
     */
    public static void topK() {
        int K = Util.scannerInt();
        int[] arr = new int[K];
        int N = Util.scannerInt();
        int index = 0;
        while (N != -1) {
            if (index < K) {
                arr[index] = N;
                index++;
            }
            if (index == K) {
                // 堆化成最小堆
                makeMinHeap(arr);
                index++;
            }
            if (index > K) {
                // 当大于最小值，说明是要保留的值
                if (N > arr[0]) {
                    arr[0] = N;
                    minHeapFixDown(arr, 0, K - 1);
                }
            }
            N = Util.scannerInt();
        }
        for (int i = K - 1; i > 0; i--) {
            Util.swap(arr, i, 0);
            minHeapFixDown(arr, 0, i - 1);
        }
        Util.print(arr);
    }

}

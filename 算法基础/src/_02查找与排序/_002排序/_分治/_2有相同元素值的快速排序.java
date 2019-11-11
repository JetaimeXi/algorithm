package _02查找与排序._002排序._分治;

import util.Util;

/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 22:52 2019/9/18
 * @ModifiedBy:
 */
public class _2有相同元素值的快速排序 {
    public static void main(String[] args) {
        int[] arr = {8, 9, 2, 7, 6, 8, 2, 8, 5, 4};
        Util.print(partition(arr, 0,arr.length-1));
//        quickSort(arr, 0, arr.length - 1);
        Util.print(arr);
    }

    /**
     * @param arr   整型数组
     * @param left  左边界，初始值为0
     * @param right 右边界，初始值为arr.length-1
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 这是快速排序的外层结构
     * @Implement: 通过递归调用，先排左半部分，再排右半部分
     * @Returin: void
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int[] midIndex = partition(arr, left, right);
            quickSort(arr, left, midIndex[0] - 1);
            quickSort(arr, midIndex[1] + 1, right);
        }
    }

    /**
     * @param arr   整型数组
     * @param left  左边界，初始值为0
     * @param right 右边界，初始值为arr.length-1
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 存在多个相同元素值的划分方法
     * @Implement: s为扫描指针，e为相同元素最左侧的值，bigger为最大值的最右指针
     * ①将e初始化指向主元pivot下标
     * ②在s扫描的过程中，如果出现arr[s]<pivot，将swap(arr, s, e)，同时s++指向下一扫描元素，e++指向交换后的新位置
     * ③当arr[s]>pivot时，将swap(arr, s, bigger)，同时将bigger--，注意并不将s++，为下一层循环进入步骤②
     * ④当arr[s]==pivot时，此时arr[s]左侧也为主元，故只更改s++，使其扫描下一元素即可
     * 总体而言，交换的次数更加，但是相对于递归中相同元素的比较，效率还是提高了
     * @Returin: int[] 返回出现相同元素的起始位置及终止位置
     */
    private static int[] partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int e = left;
        int bigger = right;
        int s = left + 1;
        while (s <= bigger) {
            if (arr[s] < pivot) {
                Util.swap(arr, e, s);
                s++;
                e++;
            } else if (arr[s] > pivot) {
                Util.swap(arr, s, bigger);
                bigger--;
            } else {
                s++;
            }
        }
        return new int[]{e, bigger};
    }
}

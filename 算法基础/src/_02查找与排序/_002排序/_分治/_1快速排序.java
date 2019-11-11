package _02查找与排序._002排序._分治;

import util.Util;

/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 20:46 2019/9/18
 * @ModifiedBy:
 */
public class _1快速排序 {
    public static void main(String[] args) {
        int[] arr = Util.randomArr(10, 100);
        Util.print(arr);
        System.out.println(partition(arr, 0, arr.length - 1));
//        quickSort(arr,0,arr.length-1);
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
            int midIndex = partition(arr, left, right);
            quickSort(arr, left, midIndex - 1);
            quickSort(arr, midIndex + 1, right);
        }
    }

    /**
     * @param arr   整型数组
     * @param left  左边界
     * @param right 右边界
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 这是快速排序的划分函数:一遍单向扫描法
     * @Implement: 以arr[left]作为基准值，从left到right单向扫描，当遇到比基准值大的值，调用swap与bigger交换，同时bigger--,否则sp++,
     * 当sp>bigger时，将基准值与arr[bigger]交换
     * @Returin: int    返回bigger的值
     */
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];      //基准值
//        int pivot = threePointMedianMethod(arr, left, right);
//        System.out.println(pivot);
        int sp = left + 1;
        int bigger = right;
        while (sp <= bigger) {
            if (arr[sp] <= pivot) {    //小于基准值
                sp++;
            } else {
                Util.swap(arr, sp, bigger);
                bigger--;
            }
        }
        Util.swap(arr, left, bigger);
        return bigger;
    }

    /**
     * @param arr   整型数组
     * @param left  左边界
     * @param right 右边界
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 这是快速排序的划分函数:双向扫描法
     * @Implement: 用l记录左侧指针，r记录右侧指针，在arr[l]<=pivot和arr[r]>=pivot分别l++,r--
     * 在l<r的条件下swap(arr,l,r)，跳出循环后将基准值与arr[r]交换
     * @Returin: int    返回r的值
     */
    private static int partition01(int[] arr, int left, int right) {
        int pivot = arr[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            while (l <= r && arr[l] <= pivot) {
                l++;
            }
            while (l <= r && arr[r] >= pivot) {
                r--;
            }
            if (l < r) {
                Util.swap(arr, l, r);
            }
        }
        Util.swap(arr, left, r);
        return r;
    }

    /**
     * @param arr   无序整型数组
     * @param left  左边界
     * @param right 右边界
     * @Author: Tod
     * @Date: 2019/9/19
     * @Description: 这是工程快排中的优化手段之一，三点取中法
     * @Implement: 计算lef、midIndex、right三点的中间值，将left的值与中间值交换，并将中间值返回
     * @Returin: int 三个点中的中间值，也是arr[left]的值
     */
    private static int threePointMedianMethod(int[] arr, int left, int right) {
        int midIndex = left + ((right - left) >> 1);
        int midValue = Util.getMidInThreeElement(arr[left], arr[midIndex], arr[right]);
        System.out.println(arr[left] + " " + arr[midIndex] + " " + arr[right]);
        if (midValue == arr[midIndex]) {
            Util.swap(arr, left, midIndex);
        } else if (midValue == arr[right]) {
            Util.swap(arr, left, right);
        }
        return arr[left];
    }
}

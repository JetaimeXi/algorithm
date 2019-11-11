package _02查找与排序._002排序._分治;

import util.Util;

/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 11:16 2019/9/19
 * @ModifiedBy:
 */
public class _5归并排序 {
    public static void main(String[] args) {
        int[] arr = Util.randomArr(10, 100);
        Util.print(arr);
        mergeSort(arr, 0, arr.length - 1);
        Util.print(arr);
    }

    public static void mergeSort(int[] arr, int left, int right) {

        if (left < right) {
            int mid = left + ((right - left) >> 1);
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right, new int[right-left+1]);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] helper) {
        int l = left-left;
        int r = mid + 1-left;
        int cur = left;
        Util.copyArr(arr, left, helper, left-left, right-left+1);
//        Util.print(helper);
        while (l <= mid-left && r <= right-left) {
            if (helper[l] < helper[r]) {   //左侧小
                arr[cur] = helper[l];
                l++;
            } else {
                arr[cur] = helper[r];
                r++;
            }
            cur++;
        }
        while (l<=mid-left){    //右侧已经排好
            arr[cur++]=helper[l++];
        }
        while (r<=right-left){  //左侧已经排好
            arr[cur++]=helper[r++];
        }
//        Util.print(arr);
    }
}

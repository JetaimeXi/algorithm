package _02查找与排序._003题解;

import util.Util;

/**
 * @Author:Tod
 * @Description: 一个数列中，如果右边的数大于左边的数，则称这两个数为一个逆序对，{2,5,1,3,4}的逆序对为1+3=4
 * @Date: Create in 9:38 2019/9/20
 * @ModifiedBy:
 */
public class _6求数组逆序对的个数 {
    public static void main(String[] args) {
        int[] arr = Util.randomArr(10,100);
        Util.print(arr);
        int[] count = new int[1];
        InversionPair(arr,0,arr.length-1,count);
        Util.print(arr);
        System.out.println(count[0]);
    }

    public static void InversionPair(int[] arr, int left, int right, int[] count) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            InversionPair(arr, left, mid, count);
            InversionPair(arr, mid + 1, right, count);
            theCountOfInversionPair(arr, left, mid, right, count);
        }

    }

    private static void theCountOfInversionPair(int[] arr, int left, int mid, int right, int[] count) {
        int[] helper = new int[right - left + 1];
        Util.copyArr(arr, left, helper, 0, right - left + 1);
        int l = 0;
        int r = mid - left + 1;
        int cur = left;
        while (l <= mid - left && r <= right - left) {
            if (helper[l] <= helper[r]) {   //左侧小
                arr[cur] = helper[l];
                l++;
            } else {
                arr[cur] = helper[r];
                count[0] += mid - left + 1 - l;
                r++;
            }
            cur++;
        }
        while (l<=mid-left){    //右侧已经排好
            arr[cur] = helper[l];
            cur++;
            l++;
        }
        while (r<=right-left){  //左侧已经排好
            arr[cur]=helper[r];
            cur++;
            r++;
        }
    }
}

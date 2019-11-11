package _02查找与排序._003题解;

import util.Util;

/**
 * @Author:Tod
 * @Description: 调整数组顺序使所有奇数位于偶数前面
 * @Date: Create in 20:00 2019/9/19
 * @ModifiedBy:
 */
public class _3奇数在前偶数在后 {
    public static void main(String[] args) {
        int[] arr = Util.randomArr(10,100);
        Util.print(arr);
        alterArr(arr);
        Util.print(arr);
    }

    public static void alterArr(int[] arr) {
        /**
        * @param arr    无序整型数组
        * @Author: Tod
        * @Date: 2019/9/19
        * @Description: 调整数组顺序使所有奇数位于偶数前面
        * @Implement:   修改partition双向指针算法，从左往右扫偶数，从右往左扫奇数，交换二者的位置即可，算法复杂度O(n)
        * @Returin: void
        */
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (left < right && (arr[left] & 1) == 1) {  //arr[left]是奇数则跳过
                left++;
            }
            while (left < right && (arr[right] & 1) == 0) { //arr[right]是偶数则天国
                right--;
            }
            if (left < right) {
                Util.swap(arr, left, right);
            }
        }
    }
}

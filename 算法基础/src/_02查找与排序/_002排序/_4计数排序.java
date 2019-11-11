package _02查找与排序._002排序;

import util.Util;

/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 18:35 2019/9/22
 * @ModifiedBy:
 */
public class _4计数排序 {
    public static void main(String[] args) {
//        int[] arr = Util.randomArr(10,100);
        int[] arr = {49, -10, -5, 23, 82, 18, 73, 18, 62, 78, 23};
        Util.print(arr);
        countSort(arr);
        Util.print(arr);
    }

    /**
     * @param arr 待排序的数组
     * @Author: Tod
     * @Date: 2019/9/22
     * @Description: 通过统计元素出现的次数及出现的位置来排序，适用于元素属于小范围排序
     * @Implement: 获取最大值，建立一个辅助数组用来计数，然后将辅助数组的下标填入到原数组中完成排序
     * @Returin: void
     */
    public static void countSort(int[] arr) {
        int max = Util.getMaxOfArr(arr);
        int min = Util.getMinOfArr(arr);    //获取最小元素，实现负数同样能够排序
        int gap = 0;
        if (min < 0) {     //对于数组中有负数
            gap = Math.abs(min);
        }
        int[] auxArr = new int[max + gap + 1];
        for (int i = 0; i < arr.length; i++) {
            auxArr[arr[i] + gap]++;
        }
        int index = 0;
        for (int i = 0; i < max + gap + 1; i++) {
            while (auxArr[i] > 0) {    //实现重复元素计数
                arr[index] = i - gap;
                auxArr[i]--;
                index++;
            }
        }
    }

}

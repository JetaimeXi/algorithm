package _02查找与排序._001递归;

/**
 * @Author:Tod
 * @Description: 有序数组从某个下标开始翻转，就是一个旋转数组，如{1，2，3，4，5，6}的一个旋转数组为{4，5，6，1，2，3}，找出其最小值
 * @Date: Create in 11:28 2019/9/18
 * @ModifiedBy:
 */
public class _9旋转数组的最小数字 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 3};
        System.out.println(theMinOfRotateArr(arr, 0, arr.length - 1));
    }

    /**
     * @param arr   旋转数组
     * @param left  左边界，初始为0
     * @param right 右边界，初始为arr.length-1
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 旋转数组为{4，5，1，2，3}，找出其最小值
     * @Implement: 改造二分查找算法，在中点处将其划分成两半，一侧有序，一侧无序，最小值必在无序的一端，且当只剩两个值时最终位于右侧
     * @Returin: int 数组中最小值
     */
    public static int theMinOfRotateArr(int[] arr, int left, int right) {
        if (right - left > 1) {
            int midIndex = left + ((right - left) >> 1);
            if (arr[midIndex] < arr[right]) {  //右侧有序
                return theMinOfRotateArr(arr, left, midIndex);
            } else if (arr[midIndex] > arr[left]) {  //左侧有序
                return theMinOfRotateArr(arr, midIndex, right);
            }
        }
        return arr[right];
    }
}

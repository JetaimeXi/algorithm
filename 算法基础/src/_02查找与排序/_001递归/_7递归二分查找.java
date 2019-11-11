package _02查找与排序._001递归;

/**
 * @Author:Tod
 * @Description: 递归二分查找算法
 * @Date: Create in 9:45 2019/9/18
 * @ModifiedBy:
 */
public class _7递归二分查找 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(arr, 0,arr.length-1, 3));
    }

    /**
     * @param arr   有序整型数组
     * @param left  左边界下标0
     * @param right 右边界下标arr.length-1
     * @param key   待查找的值
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 递归二分查找算法
     * @Implement: 将arr[left+(left+right)>>1]与key的值进行比较，选择左右方向，出口为left>right
     * @Returin: int    返回key在arr数组中的下标(如果有多个值，返回第一个值的下标)，未找到返回-1
     */
    public static int binarySearch(int[] arr, int left, int right, int key) {
        if (left > right) {
            return -1;
        }
        int midIndex = left + ((right - left) >> 1);
        if (arr[midIndex] > key) {
            return binarySearch(arr, left, midIndex - 1, key);
        } else if (arr[midIndex] < key) {
            return binarySearch(arr, midIndex + 1, right, key);
        } else
            return midIndex;
    }
}

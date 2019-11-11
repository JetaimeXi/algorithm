package _02查找与排序._003题解;

/**
 * @Author:Tod
 * @Description: 在一个无序数组中，求出需要排序的最短子数组长度
 * arr={2,3,7,5,4,6}    {7,5,4,6}返回4
 * @Date: Create in 19:02 2019/9/24
 * @ModifiedBy:
 */
public class _8需要排序的子数组 {
    public static void main(String[] args) {
//        int[] arr = {2, 3, 7, 5, 4, 6};
//        System.out.println(theShortestSortSubArr(arr));
//        int[] arr = {1, 4, 6, 5, 9, 10};
//        System.out.println(theShortestSortSubArr(arr));
        int[] arr = {1, 5, 3, 4, 2, 6, 7, 6};
        System.out.println(theShortestSortSubArr(arr));
//        int[] arr = {2, 3, 7, 5, 4, 6};
//        System.out.println(theShortestSortSubArr(arr));
//        int[] arr = {3, 2, 5, 6, 7, 8, 9};
//        System.out.println(theShortestSortSubArr(arr));
//        int[] arr = {2, 8, 7, 10, 9};
//        System.out.println(theShortestSortSubArr(arr));
    }

    /**
     * @param arr
     * @Author: Tod
     * @Date: 2019/9/26
     * @Description: 在一个无序数组中，求出需要排序的最短子数组长度
     * @Implement: 需要排序的子数组必定是当前升序的折点，而不必排序的子数组必定是在折点后都比折点要大，且升序没有另外折点的数组
     * @Returin: int    返回需要排序的最短子数组的个数
     */
    public static int theShortestSortSubArr(int[] arr) {
        int p1 = -1, p2 = -1;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1 && arr[i] > arr[i + 1] && p1 == -1) {
                p1 = i;
            }
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < max) {
                p2 = i;
            }
        }
        for (int i = p1; i <= p2; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return p2 - p1 + 1;
    }
}

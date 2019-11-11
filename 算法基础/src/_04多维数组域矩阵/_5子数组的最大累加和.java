package _04多维数组域矩阵;

/**
 * @Author:Tod
 * @Description: 给定一个数组arr, 返回子数组(连续)的最大累加和
 * @Date: Create in 18:57 2019/9/27
 * @ModifiedBy:
 */
public class _5子数组的最大累加和 {
    public static void main(String[] args) {
        int[] arr = {-5, 7, 3, -5, 2, 6, -2};
        System.out.println(theMaxSumOfSubArr(arr));
    }

    /**
     * @param arr
     * @Author: Tod
     * @Date: 2019/9/27
     * @Description: 给定一个数组arr, 返回子数组(连续)的最大累加和
     * @Implement: 单趟扫描数组，遇到sum(前一趟的值)值小于0则将其丢弃，重新记录当前数，
     * 同时应该保证left是满足前一趟的值为负数的情况下是最大的值的下标，实现负数数组也能保证其正确性
     * @Returin: int    返回连续子数组的最大累加和
     */
    public static int theMaxSumOfSubArr(int[] arr) {
        int sum = 0;
        int left = 0;
        int right = 0;
        int max = arr[0];
        int other = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (sum >= 0) {
                sum += arr[i];
            } else {
                //  other记录在sum为负数中更大的值及下标left
                if (arr[i] > other) {
                    left = i;
                    other = arr[i];
                }
                sum = arr[i];
            }
            if (sum > max) {
                max = sum;
                right = i;
            }
        }
        System.out.println(left + " " + right);
        return max;
    }

}

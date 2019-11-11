package _02查找与排序._002排序._分治;

import util.Util;

/**
 * @Author:Tod
 * @Description: N个整型元素的数组中arr[1...N], N为2的幂，查找出arr中的最大及最小值
 * @Date: Create in 1:25 2019/9/19
 * @ModifiedBy:
 */
public class _3查找数组中的最大及最小值 {
    public static void main(String[] args) {
        int[] arr = Util.randomArr(10, 100);
        Util.print(arr);
        Util.print(theMinAndMax(arr, 0, arr.length - 1));
    }

    /**
     * @param arr   待查找最大值及最小值的数组，注意arr.length必须是2的幂(已克服)
     * @param left  左边界，初始化为0
     * @param right 右边界，初始化为arr.length-1
     * @Author: Tod
     * @Date: 2019/9/19
     * @Description: 运用分治法同时求出数组中的最大及最小值 C(n)=2C(n/2)+2
     * @Implement: 将arr.length=8递归为4、2比较出最大最小值后返回，侧重于合并的步骤
     * 由于其出口的特殊性(返回值)导致数组个数必须是2的幂
     * @Returin: int[]  返回[Min, Max]
     */
    public static int[] theMinAndMax(int[] arr, int left, int right) {
        if (right - left == 1) {
            if (arr[left] < arr[right])
                return new int[]{arr[left], arr[right]};
            else
                return new int[]{arr[right], arr[left]};
        } else if (right == left) {
            return new int[]{arr[left], arr[right]};
        } else {
            int mid = left + ((right - left) >> 1);
            int[] arr1 = theMinAndMax(arr, left, mid);
            int[] arr2 = theMinAndMax(arr, mid + 1, right);
            int Min = Util.getMinOfArr(new int[]{arr1[0], arr2[0]});
            int Max = Util.getMaxOfArr(new int[]{arr1[1], arr2[1]});
            return new int[]{Min, Max};
        }
    }
}

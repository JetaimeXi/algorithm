package _02查找与排序._002排序._分治;

import util.Util;

/**
 * @Author:Tod
 * @Description:    在一个整型数组中，在O(n)时间内找到第K小元素
 * @Date: Create in 9:50 2019/9/19
 * @ModifiedBy:
 */
public class _4第K小元素 {
    public static void main(String[] args) {
        int[] arr = Util.randomArr(10,100);
        Util.print(arr);
        System.out.println(selectKInArr(arr,0,arr.length-1,1));
    }
    /**
     * @param arr    无序整型数组
     * @param left  左边界，初始化为0
     * @param right 右边界，初始化为arr.length-1
     * @param K 待查找的第K小的值，介于[1...arr.length]之间
     * @Author: Tod
     * @Date: 2019/9/19
     * @Description: 在一个整型数组中，在O(n)时间内找到第K小元素
     * @Implement:   通过快速排序中的划分函数partition进行划分，每次固定好主元的位置，判断now_K与K之间的大小，进行递归
     * 由于K是介于[1...arr.length]，而midIndex是介于[0...arr.length-1]，故now_K=midIndex-left+1
     * 缺点:会修改原址数组的值
     * @Returin: int 返回第K小元素的值
     */
    private static int selectKInArr(int[] arr, int left, int right, int K){
        int midIndex = Util.partition(arr,left, right);
        int now_K = midIndex-left+1;
        if (now_K==K){
            return arr[midIndex];
        }else if (now_K>K){
            return selectKInArr(arr,left,midIndex-1,K);
        }
        else {
            return selectKInArr(arr,midIndex+1,right,K-now_K);
        }
    }

}

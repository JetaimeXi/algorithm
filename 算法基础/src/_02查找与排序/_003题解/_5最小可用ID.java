package _02查找与排序._003题解;

import util.Util;

/**
 * @Author:Tod
 * @Description: 在非负数组(乱序不可重复)中找到最小可分配的ID(从1开始编号)，如{5,1,2,4,9,6,7,8,12,15,16}中的3即为最小可用ID，数据量大于100000000
 * @Date: Create in 20:54 2019/9/19
 * @ModifiedBy:
 */
public class _5最小可用ID {
    public static void main(String[] args) {
        int[] arr = Util.randomArrOnce(10, 15, 1);
        Util.print(arr);

        System.out.println(theMinAvaliableID(arr, 0, arr.length - 1));
        Util.print(arr);
        Util.sort(arr);
        Util.print(arr);
    }

    /**
     * @param arr   整型数组
     * @param left  左边界，初始值为0
     * @param right 右边界，初始值为arr.length-1
     * @Author: Tod
     * @Date: 2019/9/20
     * @Description: 在非负数组(乱序不可重复)中找到最小可分配的ID(从1开始编号)，如{5,1,2,4,9,6,7,8,12,15,16}中的3即为最小可用ID，数据量大于100000000
     * @Implement: 二分查找算法思想，通过调用selectKInArr函数，返回当前第数组范围一半小元素，与自身所在数组下标进行比较，
     * 判断左侧的稀疏、紧密程度进行递归
     * @Returin: int 返回最小可分配的ID
     */
    public static int theMinAvaliableID(int[] arr, int left, int right) {
        if (left <= right) {
            int midIndex = left + ((right - left) >> 1);
            int r = Util.selectKInArr(arr, left, right, ((right - left) >> 1) + 1);  //实际值
            int e = midIndex + 1;   //预测值
            if (r == e) {  //左侧紧密，即没有最小可分配ID出现，同时意味着不能出现重复元素
                return theMinAvaliableID(arr, midIndex + 1, right);     //向右侧寻找
            } else {    //左侧稀疏
                return theMinAvaliableID(arr, left, midIndex - 1);
            }
        }
        return left + 1;
    }

}

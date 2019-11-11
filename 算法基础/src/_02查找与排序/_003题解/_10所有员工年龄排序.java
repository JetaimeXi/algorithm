package _02查找与排序._003题解;

import util.Util;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author:Tod
 * @Description: 为n个年龄介于1~99岁的员工的年龄进行排序(1<=n<=1000000)
 * @Date: Create in 19:55 2019/9/26
 * @ModifiedBy:
 */
public class _10所有员工年龄排序 {
    public static void main(String[] args) {
        int[] arr = Util.randomArr(10000000, 100);
//        Util.print(arr);
        long start = new Date().getTime();
        Arrays.sort(arr);
        long stop1 = new Date().getTime();
        sortOfAge(arr);
        long stop2 = new Date().getTime();
        System.out.println(stop1 - start);
        System.out.println(stop2 - stop1);
    }

    /**
     * @param arr 员工年龄数组
     * @Author: Tod
     * @Date: 2019/9/26
     * @Description: 为n个年龄介于1~99岁的员工的年龄进行排序(1<=n<=1000000)
     * @Implement: 因为年龄是小范围，故使用计数排序能将效率提升到O(N)级别
     * @Returin: void
     */
    public static void sortOfAge(int[] arr) {
        int[] helper = new int[100];
        for (int i = 0; i < arr.length; i++) {
            helper[arr[i]]++;
        }
        for (int i = 1; i < 100; i++) {
            while (helper[i] > 0) {
//                System.out.print(i+" ");
                helper[i]--;
            }
        }
    }
}

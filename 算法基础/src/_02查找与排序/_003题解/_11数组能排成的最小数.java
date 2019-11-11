package _02查找与排序._003题解;

import util.Util;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author:Tod
 * @Description: 输入正整数数组，把所有整数拼成一个数，打印最小的一个
 * @Date: Create in 20:12 2019/9/26
 * @ModifiedBy:
 */
public class _11数组能排成的最小数 {
    public static void main(String[] args) {
        Integer[] arr = {3, 32, 211, 64, 5,2};
        System.out.println(printMinNumJointByArr(arr));
    }

    /**
     * @param arr
     * @Author: Tod
     * @Date: 2019/9/26
     * @Description: 输入正整数数组，把所有整数拼成一个数，打印最小的一个
     * @Implement: 自定义比较器，因为sort为升序排序，当s1(3,32)>s2(32,3)时，会将o2(32)放在前面，o1(3)放在后面
     * 当s1(64,5)>s2(5,64)时，5在前，64在后
     * 此时，排好序的值在拼成的值中是最小的，用StringBuilder将其串起来
     * @Returin: int 返回最小拼成的值
     */
    public static int printMinNumJointByArr(Integer[] arr) {
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });
        Util.print(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return Integer.parseInt(sb.toString());
    }
}

package _01位运算的奇巧淫技;

/**
 * @Author:Tod
 * @Description: 找出数组中出某个只出现一次的数，其他的数出现两次
 * @Date: Create in 20:10 2019/9/17
 * @ModifiedBy:
 */
public class _3找出落单的数 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 4, 6, 6, 5, 2, 8, 8, 10, 10};
        System.out.println(theSingleNumber(arr));
    }
    /**
     * @创建人: Tod
     * @创建时间: 2019/9/17
     * @描述: A^B^A = B
     * @返回值: int
     * @参数注释:
     * @param arr 整型数组
     */
    public static int theSingleNumber(int[] arr) {

        int singleNumber = arr[0];
        for (int i = 1; i < arr.length; i++) {
            singleNumber = (singleNumber ^ arr[i]);
        }
        return singleNumber;
    }
}


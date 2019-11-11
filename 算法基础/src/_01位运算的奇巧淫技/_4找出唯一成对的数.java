

import util.Util;

import java.util.Random;

/**
 * @Author:Tod
 * @Description: 将1~1000放在一个数组[1...1001]中，在不使用辅助空间的情况下找出唯一成对的那个数
 * @Date: Create in 20:33 2019/9/17
 * @ModifiedBy:
 */
public class _4找出唯一成对的数 {
    public static void main(String[] args) {
        int N = 1000;
        int[] arr = new int[N];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = i + 1;
        }
        int randomIndex = new Random().nextInt(N);
        arr[arr.length - 1] = new Random().nextInt(N);
        Util.swap(arr, randomIndex, arr.length - 1);
        Util.print(arr);
        System.out.println(theUniqueNumbers(arr));
    }

    /**
     * @param arr
     * @创建人: Tod
     * @创建时间: 2019/9/17
     * @描述: A[1...1001]^(1^...^1000) = k^k^k = k 因为其范围已知，可以通过异或求出
     * @返回值: int
     * @参数注释:
     */
    public static int theUniqueNumbers(int[] arr) {
        int x = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            x = x ^ (i + 1);   // (1^...^1000)
        }
        for (int i = 0; i < arr.length; i++) {
            x = x ^ arr[i];
        }
        return x;
    }
}

package _02查找与排序._003题解;

/**
 * @Author:Tod
 * @Description: 给定已排序的数组arr和k，
 * 不重复打印arr中所有相加和为k的不降序二元组
 * 如输入 arr={-8,-4,-3,0,2,4,5,8,9,10} k=10
 * 输出   (0,10),(2,8)
 * @Date: Create in 21:52 2019/9/23
 * @ModifiedBy:
 */
public class _7排序数组中找和的因子 {
    public static void main(String[] args) {
        int[] arr = {-7, -4, -3, 0, 2, 4, 5, 8, 9, 10};
//        int[] arr = {-4, -1, -1, 0, 1, 2};
        int k = 10;
        theTwoNumOfSumEqualK(arr, k);
        theThreeNumOfSumEqualK(arr, k);
    }

    /**
     * @param arr 整型数组
     * @param k   两个数组值和为k
     * @Author: Tod
     * @Date: 2019/9/24
     * @Description: 给定已排序的数组arr和k，
     * 不重复打印arr中所有相加和为k的不降序二元组
     * 如输入 arr={-8,-4,-3,0,2,4,5,8,9,10} k=10
     * 输出   (0,10),(2,8)
     * @Implement: 前后指针left和right, 当arr[left]+arr[right]<k时，说明值更小，left右移增大，反之right左移减小
     * @Returin: void
     */
    public static void theTwoNumOfSumEqualK(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < k) {
                left++;
            } else if (arr[left] + arr[right] > k) {
                right--;
            } else {
                System.out.println("(" + arr[left] + "," + arr[right] + ")");
                left++;
                right--;
            }
        }
    }

    /**
     * @param arr 整型数组
     * @param k   三个数组值和为k
     * @Author: Tod
     * @Date: 2019/9/24
     * @Description: 给定已排序的数组arr和k，
     * 不重复打印arr中所有相加和为k的不降序二元组
     * 如输入 arr={-8,-4,-3,0,2,4,5,8,9,10} k=10
     * 输出   (-8,8,10)
     * (-4,4,10)
     * (-3,4,9)
     * (0,2,8)
     * @Implement: 左右指针left和right, 前后指针preptr和postptr,
     * 两倍arr[left]和arr[right]都大于k说明值太大，右侧指针right--,反之左侧指针left++
     * 左指针固定，前后指针与左指针的值小于k，则前指针preptr向前找更大的值
     * 当前后指针与左指针的值大于k，则后指针postptr向后找更小的值
     * 当前后指针与左指针的值等于k，输出，同时说明前指针preptr后面的值都不可能等于k，故将左指针left++,arr[left]增大
     * 而arr[postptr]后面的值更大不可能与arr[left]和arr[preptr]的和等于k，故将right=postptr
     * 同时控制preptr与postptr，当二者重叠时，说明已不存在arr[left]+arr[preptr]+arr[postptr]==k了
     * @Returin: void
     */
    public static void theThreeNumOfSumEqualK(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        int preptr = left + 1;
        int postptr = right;
        while (left < right) {
            if (((arr[left]) << 1) + arr[right] > k) {
                right--;
                postptr = right;
            } else if (arr[left] + ((arr[right]) << 1) < k) {
                left++;
                preptr = left + 1;
            } else {
                if (preptr < postptr) {
                    if (arr[left] + arr[preptr] + arr[postptr] < k) {
                        preptr++;
                    } else if (arr[left] + arr[preptr] + arr[postptr] > k) {
                        postptr--;
                    } else {
                        System.out.println("(" + arr[left] + "," + arr[preptr] + "," + arr[postptr] + ")");
                        right = postptr;
                        left++;
                        preptr = left + 1;
                    }
                } else {
                    left++;
                    preptr = left + 1;
                }

            }
        }
    }
}

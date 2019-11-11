package _力扣;

import java.util.Arrays;

/**
 * @Author:Tod
 * @Description: 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。
 * 每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 * 示例:
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * 说明:
 * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 * @Date: Create in 23:48 2019/10/25
 * @ModifiedBy:
 */
public class _57数据流中的第K大元素 {
    public static void main(String[] args) {
//        int[] nums = new int[]{4, 5, 8, 2};
//        KthLargest kthLargest = new KthLargest(3, nums);
//        int[] nums = new int[]{5,-1};
//        KthLargest kthLargest = new KthLargest(3, nums);
//        System.out.println(kthLargest.add(3));   // returns 4
//        System.out.println(kthLargest.add(5));   // returns 5
//        System.out.println(kthLargest.add(10));  // returns 5
//        System.out.println(kthLargest.add(9));   // returns 8
//        System.out.println(kthLargest.add(4));   // returns 8
        int[] nums = new int[]{-2};
        KthLargest kthLargest = new KthLargest(1, nums);
        System.out.println(kthLargest.add(-3));   // returns 8
        System.out.println(kthLargest.add(0));   // returns 8
        System.out.println(kthLargest.add(2));   // returns 8
        System.out.println(kthLargest.add(-1));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8


    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
class KthLargest {
    private int[] minHeap;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new int[k];
        for (int i = 0; i < k; i++) {
            minHeap[i] = Integer.MIN_VALUE;
        }
        if (nums.length > 0) {
            if (nums.length < k) {
                for (int i = 0; i < nums.length; i++) {
                    minHeap[i] = nums[i];
                }
            } else {
                Arrays.sort(nums);
                for (int i = 0; i < k; i++) {
                    minHeap[i] = nums[nums.length - i - 1];
                }
            }

            for (int i = (k >> 1) - 1; i >= 0; i--) {
                fixedDown(minHeap, i, k);
            }
        }
    }

    private void fixedDown(int[] minHeap, int i, int k) {
        int j = (i << 1) + 1;
        if (j >= k) {
            return;
        }
        if (j + 1 < k && minHeap[j + 1] < minHeap[j]) {
            j++;
        }
        if (minHeap[j] > minHeap[i]) {
            return;
        }
        swap(minHeap, i, j);
        fixedDown(minHeap, j, k);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int add(int val) {
        if (val > minHeap[0]) {
            minHeap[0] = val;
            fixedDown(minHeap, 0, minHeap.length);
        }
        return minHeap[0];
    }
}


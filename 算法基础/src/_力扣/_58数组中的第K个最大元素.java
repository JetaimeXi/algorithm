package _力扣;

import util.Util;

import static util.Util.swap;

/**
 * @Author:Tod
 * @Description: 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * @Date: Create in 13:22 2019/10/26
 * @ModifiedBy:
 */
public class _58数组中的第K个最大元素 {
    public static void main(String[] args) {
//        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
//        int[] nums = ;
////        int k = 7;
//        int k = 1;

        System.out.println(findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 5));
//        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 9));
        System.out.println(findKthLargest(new int[]{2, 1}, 1));
        System.out.println(findKthLargest(new int[]{1, 2}, 1));
    }

    public static int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    private static int findKthLargest(int[] nums, int left, int right, int k) {
        int candidate_index = partition(nums, left, right);
        int curK = candidate_index - left + 1;
        if (curK == k) {
            return nums[candidate_index];
        } else if (curK > k) {
            return findKthLargest(nums, left, candidate_index - 1, k);
        } else {
            return findKthLargest(nums, candidate_index + 1, right, k - curK);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int candidate = nums[left];
        int candidate_index = left;
        left++;
        while (left <= right) {
            if (nums[left] > candidate) {
                left++;
            } else {
                swap(nums, left, right);
                right--;
            }
        }
        swap(nums, right, candidate_index);
        return right;
    }

    public int findKthLargest2(int[] nums, int k) {
        int res = partition2(nums,k,0,nums.length - 1);
        return nums[res];
    }

    public void swap2(int i, int j,int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public int partition2(int[] nums, int k,int l,int r) {
        if(l >= r)
            return l;
        int mid = l + (r - l) / 2;
        int v = nums[mid];
        swap2(l, mid, nums);
        int lt = l + 1,gt = r;
        while(true){
            while(gt >= l && nums[gt] > v) gt--;
            while(lt <= r && nums[lt] < v) lt++;
            if(lt > gt){
                break;
            }
            swap2(lt,gt,nums);
            lt++;
            gt--;
        }
        int len = nums.length;
        swap2(l,gt,nums);
        if(len - k == gt)
            return gt;
        else if(len - k > gt){
            return partition2(nums,k,gt + 1,r);
        }else{
            return partition2(nums,k,l,gt - 1);
        }
    }
}

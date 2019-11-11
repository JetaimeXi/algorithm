package _02查找与排序._003题解;

import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Author:Tod
 * @Description: 给定一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * @Date: Create in 20:47 2019/9/28
 * @ModifiedBy:
 */
public class _14三数之和 {
    public static void main(String[] args) {
        int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
//        Arrays.sort(nums);
//        Util.print(nums);
//        System.out.println(theIndexOfSearchNum(nums, 0, nums.length - 1, -1));
        // 二重迭代器写法
        List<List<Integer>> lists = threeSum(nums);
        Iterator<List<Integer>> it = lists.iterator();
        while (it.hasNext()) {
            it.next().forEach((x) -> System.out.print(x + " "));
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Util.print(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        int sum;
        int left;
        int right;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                sum = 0 - nums[i];
                left = i + 1;
                right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] > sum) {    //right向左侧寻找更小的值
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                        right--;
                    } else if (nums[left] + nums[right] < sum) {  //left向右侧寻找更大的值
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        left++;
                    } else {
                        List<Integer> list = Arrays.asList(
                                nums[i],
                                nums[left],
                                nums[right]
                        );
//                    if (!lists.contains(list)) {
//                        lists.add(list);
//                    }
                        lists.add(list);
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                        right--;
                        left++;
                    }
                }
            }
        }
        return lists;
    }
}


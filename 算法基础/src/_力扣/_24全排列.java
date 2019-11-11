package _力扣;

import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author:Tod
 * @Description: 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * @Date: Create in 8:54 2019/10/15
 * @ModifiedBy:
 */
public class _24全排列 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        permute2(nums);
//        permuteUnique(new int[]{1, 1, 2, 3, 3});
        permuteUnique2(new int[]{1, 1, 2});
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        permute(nums, 0, lists);
        return lists;
    }

    private static void permute(int[] nums, int index, List<List<Integer>> lists) {
        if (index == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            lists.add(list);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            Util.swap(nums, i, index);
            permute(nums, index + 1, lists);
            Util.swap(nums, i, index);
        }
    }

    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        boolean[] used = new boolean[nums.length];  //标记
        Stack<Integer> stack = new Stack<>();   //占位
        permute2(nums, 0, stack, used, lists);
        return lists;
    }

    private static void permute2(int[] nums, int curIndex, Stack<Integer> stack, boolean[] used, List<List<Integer>> lists) {
        if (curIndex == nums.length) {
            lists.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                stack.push(nums[i]);
                permute2(nums, curIndex + 1, stack, used, lists);
                stack.pop();
                used[i] = false;
            }
        }
    }

    /**
     * @param nums
     * @Author: Tod
     * @Date: 2019/10/15
     * @Description: 给定一个可包含重复数字的序列，返回所有不重复的全排列。
     * 输入: [1,1,2]
     * 输出:
     * [
     * [1,1,2],
     * [1,2,1],
     * [2,1,1]
     * ]
     * @Implement:
     * @Return: java.util.List<java.util.List < java.lang.Integer>>
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 1) {
            return result;
        }
        Arrays.sort(nums);
        permuteDFS(nums, 0, result);
        return result;
    }

    public static void permuteDFS(int[] nums, int start, List<List<Integer>> res) {
        if (start == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int i : nums) {
                list.add(i);
            }
            res.add(list);
        }
        for (int i = start; i < nums.length; ++i) {
            int j = i - 1;
            // 剪枝操作
            while (j >= start && nums[j] != nums[i])
                --j;
            if (j != start - 1)
                continue;

            Util.swap(nums, start, i);
            permuteDFS(nums, start + 1, res);
            Util.swap(nums, start, i);
        }
    }

    public static List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 1) {
            return result;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        Stack<Integer> stack = new Stack<>();
        permuteUnique2(nums, 0, stack, used, result);
        return result;
    }

    private static void permuteUnique2(int[] nums, int curIndex, Stack<Integer> stack, boolean[] used, List<List<Integer>> result) {
        if (curIndex == nums.length) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {  //剪枝操作
                    // !used[i-1]表示nums[i-1]回溯到其根节点时，used[i-1]已经被置为false，后剪枝
                    // used[i-1]表示先剪枝
                    continue;
                }
                used[i] = true;
                stack.push(nums[i]);
                permuteUnique2(nums, curIndex + 1, stack, used, result);
                stack.pop();
                used[i] = false;
            }

        }
    }
}

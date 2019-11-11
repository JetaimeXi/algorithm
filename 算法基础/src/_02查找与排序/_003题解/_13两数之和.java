package _02查找与排序._003题解;

import util.Util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @Author:Tod
 * @Description: 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @Date: Create in 19:30 2019/9/28
 * @ModifiedBy:
 */
public class _13两数之和 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4,3,5,1};
        int target = 6;
        Util.print(twoSum(nums, target));
        Util.print(twoSum2(nums,target));
    }

    public static int[] twoSum(int[] nums, int target) {
        /**
         * @param nums
         * @param target
         * @Author: Tod
         * @Date: 2019/9/28
         * @Description:
         * @Implement:
         *

        题解思路：将无序数组变成有序，前后指针相加与target值比较。

        自定义数组类，自定义比较器较麻烦些

        算法复杂度O(nlgn)
         * @Returin: int[]
         */
        MyIntArr[] myInArr = new MyIntArr[nums.length];
        for (int i = 0; i < nums.length; i++) {
            myInArr[i] = new MyIntArr(nums[i], i);
        }
        Arrays.sort(myInArr, new Comparator<MyIntArr>() {
            @Override
            public int compare(MyIntArr o1, MyIntArr o2) {  //升序
                return o1.getNum() - o2.getNum();
            }
        });
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (myInArr[left].getNum() + myInArr[right].getNum() > target) {
                right--;
            } else if (myInArr[left].getNum() + myInArr[right].getNum() < target) {
                left++;
            } else {
                return new int[]{myInArr[left].getIndex(), myInArr[right].getIndex()};
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * @param nums
     * @param target
     * @Author: Tod
     * @Date: 2019/9/28
     * @Description:
     * @Implement: 建立哈希映射，如果3不在哈希表中，则在哈希表中加入key:6-3=3 value:0
     * 如果2不在哈希表中，则在表中加入key:6-2=4 value:1
     * 而4在表中，故返回当前下标 及 在表中的value值及2的下标
     * 时间复杂度 O(1)
     * @Returin: int[]
     */
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                return new int[]{hash.get(nums[i]), i};
            } else {
                hash.put(target - nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}

class MyIntArr {
    int num;
    int index;

    public MyIntArr(int num, int index) {
        this.num = num;
        this.index = index;
    }

    public int getNum() {
        return num;
    }

    public int getIndex() {
        return index;
    }

    public String toString() {
        return "num:" + num + ", index:" + index;
    }

}

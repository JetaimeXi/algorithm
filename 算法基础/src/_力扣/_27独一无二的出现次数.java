package _力扣;

/**
 * @Author:Tod
 * @Description: 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * <p>
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * <p>
 * 输入：arr = [1,2]
 * 输出：false
 * <p>
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 * <p>
 * 提示：
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 * @Date: Create in 20:13 2019/10/16
 * @ModifiedBy:
 */
public class _27独一无二的出现次数 {
    public static void main(String[] args) {
        System.out.println(uniqueOccurrences2(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println(uniqueOccurrences2(new int[]{1, 2}));
        System.out.println(uniqueOccurrences2(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
        System.out.println(uniqueOccurrences2(new int[]{4, 0, 2, -5, -4}));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        int[] range = new int[2001];
        for (int i = 0; i < arr.length; i++) {
            range[arr[i] + 1000]++;
        }
        int[] count = new int[1001];
        for (int i = 0; i < range.length; i++) {
            count[range[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            if (count[i] > 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean uniqueOccurrences2(int[] arr) {
        int[] range = new int[2001];
        for (int i = 0; i < arr.length; i++) {
            range[arr[i] + 1000]++;
        }
        int[] count = new int[1001];
        for (int i = 0; i < range.length; i++) {
            if (range[i] > 0) {
                if (count[range[i]] > 0) {
                    return false;
                } else {
                    count[range[i]] = 1;
                }
            }
        }
        return true;
    }
}

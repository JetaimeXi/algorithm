package _力扣;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:Tod
 * @Description: 给你个整数数组 arr，其中每个元素都 不相同。
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * <p>
 * 示例 1：
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * <p>
 * 示例 2：
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * <p>
 * 示例 3：
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 * <p>
 * 提示：
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 * @Date: Create in 15:03 2019/10/18
 * @ModifiedBy:
 */
public class _34最小绝对差 {
    public static void main(String[] args) {
        minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27});
        minimumAbsDifference(new int[]{4, 2, 1, 3});
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = arr[1] - arr[0];
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] <= min) {
                if (arr[i] - arr[i - 1] < min) {
                    lists.clear();
                    min = arr[i] - arr[i - 1];
                }
                List<Integer> list = new ArrayList<>(2);
                list.add(arr[i - 1]);
                list.add(arr[i]);
                lists.add(list);
            }
        }
        return lists;
    }
}

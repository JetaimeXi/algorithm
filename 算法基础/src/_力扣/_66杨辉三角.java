package _力扣;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Tod
 * @Description: 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * @Date: Create in 0:36 2019/10/29
 * @ModifiedBy:
 */
public class _66杨辉三角 {
    public static void main(String[] args) {
        System.out.println(generate(8));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            if (i == 0) {
                lists.add(list);
                continue;
            }
            List<Integer> temp = lists.get(i - 1);
            for (int j = 1; j < temp.size(); j++) {
                list.add(temp.get(j-1)+temp.get(j));
            }
            list.add(1);
            lists.add(list);
        }
        return lists;
    }
}

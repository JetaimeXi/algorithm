package _力扣;

/**
 * @Author:Tod
 * @Description: 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 示例 1:
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 * @Date: Create in 20:01 2019/10/25
 * @ModifiedBy:
 */
public class _55阶乘后的零 {
    public static void main(String[] args) {
//        System.out.println(trailingZeroes(100));
        System.out.println(trailingZeroes(1808548329));
    }

    // 关键在于5的倍数的个数，5、10、15、20、25=5*5、30、35、40、45、50=5*10、55、60、65、70、75=5*15
    //1~9   1   10~14   2   15~19   3
    //20~24 4   25~29   6
    public static int trailingZeroes(int n) {
        long x = 5;
        int count = 0;
        while (x <= n) {
            count += n / x;
            x *= 5;
        }
        return count;
    }
}

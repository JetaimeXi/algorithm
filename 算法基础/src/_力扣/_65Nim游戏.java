package _力扣;

/**
 * @Author:Tod
 * @Description: 你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，
 * 每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
 * 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
 * 示例:
 * 输入: 4
 * 输出: false
 * 解释: 如果堆中有 4 块石头，那么你永远不会赢得比赛；
 * 因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
 * @Date: Create in 23:46 2019/10/28
 * @ModifiedBy:
 */
public class _65Nim游戏 {
    public static void main(String[] args) {
        System.out.println(canWinNim(10));
        System.out.println(canWinNim2(10));
    }

    public static boolean canWinNim(int n) {
        if (n == 1 || n == 2 || n == 3) {
            return true;
        }
        for (int i = 1; i <= 3; i++) {
            if (canWinNim(n - i)) {
                continue;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean canWinNim2(int n) {
        if (n % 4 == 0) {
            return false;
        } else {
            return true;
        }
    }

}

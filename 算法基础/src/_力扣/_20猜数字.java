package _力扣;

/**
 * @Author:Tod
 * @Description: 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小A 猜对了几次？
 * 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
 * <p>
 * 输入：guess = [1,2,3], answer = [1,2,3]
 * 输出：3
 * 解释：小A 每次都猜对了。
 * <p>
 * 输入：guess = [2,2,3], answer = [3,2,1]
 * 输出：1
 * 解释：小A 只猜对了第一次。
 * @Date: Create in 19:59 2019/10/10
 * @ModifiedBy:
 */
public class _20猜数字 {
    public static void main(String[] args) {
//        int[] guess = {1,2,3};
//        int[] answer = {1,2,3};
        int[] guess = {2, 2, 3};
        int[] answer = {3, 2, 1};
        System.out.println(game2(guess, answer));
    }

    public static int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }

    public static int game2(int[] guess, int[] answer) {
        return ((guess[0] == answer[0]) ? 1 : 0) + ((guess[1] == answer[1]) ? 1 : 0) + ((guess[2] == answer[2]) ? 1 : 0);
    }
}

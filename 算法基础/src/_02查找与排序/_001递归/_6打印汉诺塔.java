package _02查找与排序._001递归;

/**
 * @Author:Tod
 * @Description: 打印汉诺塔
 * @Date: Create in 9:28 2019/9/18
 * @ModifiedBy:
 */
public class _6打印汉诺塔 {
    public static void main(String[] args) {
        printHanoiTower(3,"A","B","C");
    }

    /**
     * @param N    总共有N个盘子
     * @param from 源柱子
     * @param to   目标柱子
     * @param help 辅助柱子
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 打印汉诺塔
     * @Implement: 将1~N从from移动到to，help作为辅助(角色变换)
     * ①将1~N-1从from移动到help，to作为辅助
     * ②把N从from移动到to(打印输出)，此时可以将to柱子当成空柱子
     * ③将1~N-1从help移动to，from作为辅助
     * 出口:当N==1时，将N从from移动到to(打印输出)
     * @Returin: void
     */
    public static void printHanoiTower(int N, String from, String to, String help) {
        if (N == 1) {
            System.out.println("move " + N + " from " + from + " to " + to);
            return;
        }
        printHanoiTower(N - 1, from, help, to);
        System.out.println("move " + N + " from " + from + " to " + to);
        printHanoiTower(N - 1, help, to, from);
    }
}

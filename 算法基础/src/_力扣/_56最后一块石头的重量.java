package _力扣;

/**
 * @Author:Tod
 * @Description: 有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * 提示：
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 * @Date: Create in 20:59 2019/10/25
 * @ModifiedBy:
 */
public class _56最后一块石头的重量 {
    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{30, 60, 80, 50, 45, 49, 65, 70, 69}));
    }

    public static int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        if (stones.length == 2) {
            return stones[0] != stones[1] ? Math.abs(stones[0] - stones[1]) : 0;
        }
        for (int i = ((stones.length >> 1) - 1); i >= 0; i--) {
            fixedDown(stones, i, stones.length);
        }
        int secMax = Math.max(stones[1], stones[2]);
        while (secMax != 0) {
            stones[0] -= secMax;
            if (stones[1] > stones[2]) {
                stones[1] = 0;
            } else {
                stones[2] = 0;
            }
            for (int i = 2; i >= 0; i--) {
                fixedDown(stones, i, stones.length);
            }
            secMax = Math.max(stones[1], stones[2]);
        }

        return stones[0];
    }

    private static void fixedDown(int[] stones, int i, int length) {
        int j = (i << 1) + 1;
        if (j >= length) {
            return;
        }
        if (j + 1 < length && stones[j + 1] > stones[j]) {
            j++;
        }
        if (stones[j] < stones[i]) {
            return;
        }
        swap(stones, i, j);
        fixedDown(stones, j, length);
    }

    private static void swap(int[] stones, int i, int j) {
        stones[i] = stones[i] + stones[j];
        stones[j] = stones[i] - stones[j];
        stones[i] = stones[i] - stones[j];
    }
}

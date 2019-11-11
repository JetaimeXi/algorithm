package _力扣;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author:Tod
 * @Description: 编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * @Date: Create in 20:44 2019/10/16
 * @ModifiedBy:
 */
public class _28快乐数 {
    public static void main(String[] args) {
        System.out.println(isHappy(21));
        System.out.println(isHappy2(21));
    }

    public static boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(n);
        int res, sum;
        while (n != 1) {
            sum = 0;
            while (n > 0) {
                res = n % 10;
                sum += res * res;
                n /= 10;
            }
            if (list.contains(sum)) {
                System.out.println("环长为：" + (list.indexOf(sum) + 1));
                return false;
            } else {
                list.add(sum);
                n = sum;
            }
        }
        return true;
    }

    public static boolean isHappy2(int n) {
        int slow = n, fast = calc(n);
        int count = 1;
        while (slow != fast) {
            slow = calc(slow);
            fast = calc(calc(fast));
            count++;
        }
        System.out.println("环长为：" + count);
        return slow == 1;
    }

    private static int calc(int n) {
        int sum = 0, res;
        while (n > 0) {
            res = n % 10;
            sum += res * res;
            n /= 10;
        }
        return sum;
    }
}

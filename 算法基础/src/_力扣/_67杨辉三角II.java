package _力扣;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 19:21 2019/10/29
 * @ModifiedBy:
 */
public class _67杨辉三角II {
    public static void main(String[] args) {
//        System.out.println(getRow(6));
        System.out.println(getRow(18));
        System.out.println(getRow(30));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        long a = 1;
        for (int i = 1; i <= (rowIndex >> 1); i++) {
            for (int j = i - 1; j < i; j++) {
                a *= rowIndex - j;
                a /= j + 1;
            }
            list.add((int) a);
        }
        int i = ((rowIndex - 1) >> 1);
        while (i >= 0) {
            int temp = list.get(i);
            list.add(temp);
            i--;
        }
        return list;
    }
}

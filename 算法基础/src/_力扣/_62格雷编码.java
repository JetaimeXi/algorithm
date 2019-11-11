package _力扣;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 17:04 2019/10/28
 * @ModifiedBy:
 */
public class _62格雷编码 {
    public static void main(String[] args) {
        System.out.println(grayCode(2));
        System.out.println(grayCode(3));
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            list.add((i ^ (i >> 1)));
        }
        return list;
    }
}

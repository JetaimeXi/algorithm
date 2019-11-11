package _力扣竞赛;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Tod
 * @Description: 给你两个整数 n 和 start。你的任务是返回任意 (0,1,2,,...,2^n-1) 的排列 p，并且满足：
 * p[0] = start
 * p[i] 和 p[i+1] 的二进制表示形式只有一位不同
 * p[0] 和 p[2^n -1] 的二进制表示形式也只有一位不同
 * 示例 1：
 * 输入：n = 2, start = 3
 * 输出：[3,2,0,1]
 * 解释：这个排列的二进制表示是 (11,10,00,01)
 * 所有的相邻元素都有一位是不同的，另一个有效的排列是 [3,1,0,2]
 * 示例 2：
 * 输出：n = 3, start = 2
 * 输出：[2,6,7,5,4,0,1,3]
 * 解释：这个排列的二进制表示是 (010,110,111,101,100,000,001,011)
 * 提示：
 * 1 <= n <= 16
 * 0 <= start < 2^n
 * @Date: Create in 11:02 2019/10/27
 * @ModifiedBy:
 */
public class _5239循环码排列 {
    public static void main(String[] args) {
        System.out.println(getGrayCode(20));
        System.out.println(getBinaryCode(getGrayCode(20)));
        System.out.println(circularPermutation(3, 2));
        System.out.println(circularPermutation(2, 3));
    }

    // 二进制转格雷码
    // Bn Bn-1 ... B0
    // Gn = Bn
    // Gn-1 = Bn^Bn-1
    // ...
    // G0 = B1^B0
    // 格雷码转二进制
    // Gn Gn-1 ... G0
    // Bn = Gn
    // Bn-1 = Bn^Gn-1
    // ...
    // B0 = B1^G0
    /*
    * class Solution {
        public:
            vector<int> circularPermutation(int n, int start) {
                vector<int> ans;
                for (int i = 1, t = start; i <= (1 << n); i++) {
                    ans.push_back(t);
                    int u = 1;
                    while (!(i & u))
                        u <<= 1;
                    t ^= u;
                }
                return ans;
            }
       };*/
    public static List<Integer> circularPermutation(int n, int start) {
        List<Integer> list = new ArrayList<>();
        list.add(start);
        for (int i = 1; i < (1 << n); i++) {
            //将start转为二进制
            start = getBinaryCode(start);
            //加一操作后转为格雷码
            start = (start + 1) % (1 << n);
            start = getGrayCode(start);
            list.add(start);
        }
        return list;
    }

    private static int getBinaryCode(int grayCode) {
        int binaryCode = grayCode;
        grayCode >>= 1;
        while (grayCode != 0) {
            binaryCode ^= grayCode;
            grayCode >>= 1;
        }
        return binaryCode;
    }

    private static int getGrayCode(int binaryCode) {
        return binaryCode ^ (binaryCode >> 1);
    }

}

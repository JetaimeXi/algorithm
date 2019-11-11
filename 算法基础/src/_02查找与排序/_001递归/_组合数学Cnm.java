package _02查找与排序._001递归;

/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 18:11 2019/10/23
 * @ModifiedBy:
 */
public class _组合数学Cnm {
    public static void main(String[] args) {
        System.out.println(countCnm(5, 4));
    }

    /**
     * @param n
     * @param m
     * @Author: Tod
     * @Date: 2019/10/23
     * @Description: 在n个球中取出m个(不重复)，总共有多少种求法
     * @Implement: 在n个球中任意取出一个球x，判断x是否属于m或者不属于m的情况
     * @Return: int
     */
    public static int countCnm(int n, int m) {
        if (n == m) {  //从n个球取m个球，当n==m时，只有一种取法
            return 1;
        }
        if (n < m) {   //从2个球中取3个球，不存在
            return 0;
        }
        if (m == 0) {  //从n个球中取出0个球，只有一种取法
            return 1;
        }
        //               属于                         不属于
        return countCnm(n - 1, m - 1) + countCnm(n - 1, m);
    }

}

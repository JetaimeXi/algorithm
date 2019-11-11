package _02查找与排序._001递归;

/**
 * @Author:Tod
 * @Description: 这是递归描述
 * ①找重复
 * ②找变化     变化的量应该作为参数
 * ③找边界     出口
 * @Date: Create in 8:27 2019/9/18
 * @ModifiedBy:
 */
public class _1求N的阶乘 {
    public static void main(String[] args) {
        System.out.println(factorialOfN(5));
    }

    /**
     * @param N N的阶乘
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 求N的阶乘
     * @Implement: f(n)=n*f(n-1)
     * @Returin: int 返回阶乘的值
     */
    public static int factorialOfN(int N) {
        if(N==1)
            return 1;
        return N*factorialOfN(N-1);
    }
}

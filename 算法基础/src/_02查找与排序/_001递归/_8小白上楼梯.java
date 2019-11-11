package _02查找与排序._001递归;

/**
 * @Author:Tod
 * @Description: 有N阶楼梯，小白可以上1阶、2阶或3阶，问有多少种方法走完楼梯
 * @Date: Create in 10:57 2019/9/18
 * @ModifiedBy:
 */
public class _8小白上楼梯 {
    public static void main(String[] args) {
        System.out.println(theMethodOfClimb(4));
    }
    /**
     * @param N  楼梯的阶数
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 有N阶楼梯，小白可以上1阶、2阶或3阶，问有多少种方法走完楼梯
     * @Implement:   f(N)=f(N-1)+f(N-2)+f(N-3)
     * 出口:当N=3时，①N=2  return 1;②N=1 return 1;③N=0   return 1;
     * @Returin: int 上楼梯的方法数
     */
    public static int theMethodOfClimb(int N){
        if (N==2)
            return 2;
        if (N==1)
            return 1;
        if (N==0)
            return 1;
        return theMethodOfClimb(N-1)+theMethodOfClimb(N-2)+theMethodOfClimb(N-3);
    }
}

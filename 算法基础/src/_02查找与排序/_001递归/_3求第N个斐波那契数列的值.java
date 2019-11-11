package _02查找与排序._001递归;

/**
 * @Author:Tod
 * @Description:    求第N个斐波那契数列的值
 * @Date: Create in 8:46 2019/9/18
 * @ModifiedBy:
 */
public class _3求第N个斐波那契数列的值 {
    public static void main(String[] args) {
        System.out.println(theNOfFibonacci(7));
    }
    /**
     * @param N  第N个斐波那契数列
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 求第N个斐波那契数列的值
     * @Implement:   f(N)=f(N-1)+f(N-2)
     * @Returin: int 第N个斐波那契数列的值
     */
    public static int theNOfFibonacci(int N){
        if(N==1||N==2){  //当N=3时
            return 1;
        }
        return theNOfFibonacci(N-1)+theNOfFibonacci(N-2);
    }
}

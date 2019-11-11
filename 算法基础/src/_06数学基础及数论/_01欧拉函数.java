package _06数学基础及数论;

/**
 * @Author:Tod
 * @Description:
 * 欧拉函数是小于或等于n的正整数中与n互质的数的数目
 * 例如φ(8)=4，因为1,3,5,7均和8互质
 *
 * ψ（10）=10×（1－1/2）×（1－1/5）=4；
 * ψ（30）=30×（1－1/2）×（1－1/3）×（1－1/5）=8；
 * ψ（49）=49×（1－1/7）=42。
 *
 * 特性 :
 * 1.若a为质数,phi[a]=a-1;
 * 2.若a为质数,b mod a=0,phi[a*b]=phi[b]*a
 * 3.若a,b互质,phi[a*b]=phi[a]*phi[b](当a为质数时,if b mod a!=0 ,phi[a*b]=phi[a]*phi[b])
 *
 * C++
 * int m[n],phi[n],p[n],nump;
 * //m[i]标记i是否为素数,0为素数,1不为素数;p是存放素数的数组;nump是当前素数个数;phi[i]为欧拉函数
 * int main()
 * {
 *         phi[1]=1;
 *     for (int i=2;i<=n;i++)
 *     {
 *         if (!m[i])//i为素数
 *         {
 *             p[++nump]=i;//将i加入素数数组p中
 *             phi[i]=i-1;//因为i是素数,由特性得知
 *         }
 *         for (int j=1;j<=nump&&p[j]*i<=n;j++)  //用当前已得到的素数数组p筛,筛去p[j]*i
 *         {
 *             m[p[j]*i]=1;//可以确定i*p[j]不是素数
 *             if (i%p[j]==0) //看p[j]是否是i的约数,因为素数p[j],等于判断i和p[j]是否互质
 *             {
 *                 phi[p[j]*i]=phi[i]*p[j]; //特性2
 *                 break;
 *             }
 *             else phi[p[j]*i]=phi[i]*(p[j]-1); //互质,特性3其,p[j]-1就是phi[p[j]]
 *         }
 *     }
 * }
 * @Date: Create in 9:14 2019/10/23
 * @ModifiedBy:
 */
public class _01欧拉函数 {
}

package _04多维数组域矩阵;

import static _04多维数组域矩阵._5子数组的最大累加和.theMaxSumOfSubArr;

/**
 * @Author:Tod
 * @Description: 在一个有正、有负、有零的N*N二维矩阵中找出其子矩阵最大的累加和
 * @Date: Create in 21:15 2019/9/27
 * @ModifiedBy:
 */
public class _6子矩阵的最大累加和 {
    public static void main(String[] args) {
        int[][] martix = {
                {-1, 1, -1, -2},
                {1, -2, 2, 5},
                {1, -1, 2, 3},
                {-1, 2, -1, 2}
        };
        System.out.println(theMaxSumOfSubMatrix(martix));
    }

    public static int theMaxSumOfSubMatrix(int[][] martix) {
        /**
        * @param martix
        * @Author: Tod
        * @Date: 2019/9/28
        * @Description: 在一个有正、有负、有零的N*N二维矩阵中找出其子矩阵最大的累加和
        * @Implement:   i层控制行数，j层控制列数，k控制多行合并成一行进行子数组的最大累加和
         * helper数组将matrix转化为一维进行子数组的最大累加和
         * 注意每次循环将helper置为0，将sum置为0
        * @Returin: int 返回子矩阵的最大累加和
        */
        int max = martix[0][0];
        int N = martix.length;
        int[] helper = new int[N];
        int upRow = 0, downRow = 0, leftCol = 0, rightCol = 0, temp = 0;
        //  O(N)
        for (int i = 0; i < N; i++) {
            //  O(N)
            for (int k = 0; k < N - i; k++) {
                //  O(N)
                for (int j = 0; j < N; j++) {
                    helper[j] += martix[i + k][j];
                }
                int other = helper[0];
                int sum = 0;
                temp = 0;
                for (int j = 0; j < N; j++) {
                    if (sum >= 0) {
                        sum += helper[j];
                    } else {
                        if (helper[j] > other) {
                            temp = j;
                            other = helper[j];
                        }
                        sum = helper[j];
                    }
                    if (sum >= max) {
                        max = sum;
                        leftCol = temp;
                        rightCol = j;
                        upRow = i;
                        downRow = i + k;
                    }
                }
            }
            for (int j = 0; j < N; j++) {
                helper[j] = 0;
            }
        }
        System.out.println(upRow + ", " + leftCol);
        System.out.println(downRow + ", " + rightCol);
        return max;
    }


}

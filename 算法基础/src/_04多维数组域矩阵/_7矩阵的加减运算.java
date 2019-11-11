package _04多维数组域矩阵;

import util.Util;

/**
 * @Author:Tod
 * @Description: 求矩阵运算 A + 2X = B
 * A = {
 * {3,-1,2},
 * {1,5,7},
 * {2,4,5}
 * }
 * B = {
 * {7,5,-2},
 * {5,1,9},
 * {4,2,1}
 * }
 * 求 X
 * @Date: Create in 0:49 2019/9/28
 * @ModifiedBy:
 */

public class _7矩阵的加减运算 {
    public static void main(String[] args) {
        int[][] A = {
                {3, -1, 2},
                {1, 5, 7},
                {2, 4, 5}
        };
        int[][] B = {
                {7, 5, -2},
                {5, 1, 9},
                {4, 2, 1}
        };
        Util.printMatrix(getResOfMatrixArith(A, B, 2));
    }

    /**
     * @param A      加数矩阵
     * @param B      结果矩阵
     * @param factor 常数因子
     * @Author: Tod
     * @Date: 2019/9/28
     * @Description: 求解A + factorX = B中的X
     * @Implement: X = 1/fator * (B - A)
     * @Returin: int[][]
     */
    public static int[][] getResOfMatrixArith(int[][] A, int[][] B, int factor) {
        int row = A.length;
        int col = A[0].length;
        int[][] X = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 忽略小数
                X[i][j] = (B[i][j] - A[i][j]) / factor;
            }
        }
        return X;
    }
}

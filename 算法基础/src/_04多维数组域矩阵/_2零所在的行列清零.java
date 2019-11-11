package _04多维数组域矩阵;

import util.Util;

/**
 * @Author:Tod
 * @Description: 将二维矩阵中0所在的行列清零
 * @Date: Create in 22:59 2019/9/26
 * @ModifiedBy:
 */
public class _2零所在的行列清零 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 0, 18, 0, 20},
                {21, 22, 23, 24, 25}
        };
        Util.printMatrix(matrix);
        eliminateZero(matrix);
        Util.printMatrix(matrix);
    }

    /**
     * @param matrix
     * @Author: Tod
     * @Date: 2019/9/26
     * @Description: 将二维矩阵中0所在的行列清零
     * @Implement: 用两个一维数组记录二维数组中0的行列位置，置为1，通过查找两个一维数组中的1将二维矩阵中对应行列全部修改为0即可
     * @Returin: void
     */
    public static void eliminateZero(int[][] matrix) {
        int[] rowRecord = new int[matrix.length];
        int[] colRecord = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowRecord[i] = 1;
                    colRecord[j] = 1;
                }
            }
        }
        for (int i = 0; i < rowRecord.length; i++) {
            if (rowRecord[i] == 1) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < colRecord.length; j++) {
            if (colRecord[j] == 1) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

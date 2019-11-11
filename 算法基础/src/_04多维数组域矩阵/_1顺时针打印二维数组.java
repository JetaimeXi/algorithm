package _04多维数组域矩阵;

/**
 * @Author:Tod
 * @Description: 输入：
 * {1,2,3,4}
 * {5,6,7,8}
 * {9,10,11,12}
 * {13,14,15,16}
 * 输出：
 * {1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10}
 * @Date: Create in 21:40 2019/9/26
 * @ModifiedBy:
 */
public class _1顺时针打印二维数组 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
        };
//        int[][] matrix = {
//                {1, 2, 3, 4, 5},
//                {6, 7, 8, 9, 10},
//                {11, 12, 13, 14, 15},
//                {16, 17, 18, 19, 20},
//                {21, 22, 23, 24, 25}
//        };
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        int leftUpRow = 0, leftUpCol = 0, rightDownRow = matrix.length - 1, rightDownCol = matrix[0].length - 1;

        while (leftUpCol <= rightDownCol && leftUpRow <= rightDownRow) {
            int r = leftUpRow;
            int c = leftUpCol;
            while (c <= rightDownCol) {
                System.out.print(matrix[leftUpRow][c++] + " ");
            }
            c--;
            r++;
            while (r <= rightDownRow) {
                System.out.print(matrix[r++][rightDownCol] + " ");
            }
            r--;
            c--;
            while (c >= leftUpCol) {
                System.out.print(matrix[rightDownRow][c--] + " ");
            }
            c++;
            r--;
            while (r > leftUpRow) {
                System.out.print(matrix[r--][leftUpCol] + " ");
            }
            leftUpCol++;
            leftUpRow++;
            rightDownCol--;
            rightDownRow--;
        }
    }
}

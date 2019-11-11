package _04多维数组域矩阵;

import util.Util;

import java.util.Date;

/**
 * @Author:Tod
 * @Description: 输入一个只有0和1的方阵，求出其边界全为1的最大子方阵，返回其阶数
 * 输入：
 * {0,1,1,1,1}
 * {0,1,0,0,1}
 * {0,1,0,0,1}
 * {0,1,1,1,1}
 * {0,1,0,1,1}
 * 输出：
 * 4
 * @Date: Create in 0:35 2019/9/27
 * @ModifiedBy:
 */
public class _4边界为1的最大子方阵 {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {0, 1, 1, 1, 1},
//                {0, 1, 0, 1, 1},
//                {0, 1, 0, 1, 1},
//                {0, 1, 1, 1, 1},
//                {0, 1, 0, 1, 1}
//        };
        int N = 2000;
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            int[] arr = Util.randomArr(N, 2);
            for (int j = 0; j < N; j++) {
                matrix[i][j] = arr[j];
            }
        }
//        Util.print(arr);
//        Util.printMatrix(matrix);
        long now = new Date().getTime();
        System.out.println(optMaxMatrixWithBound1(matrix));
        long pause1 = new Date().getTime();
        System.out.println(pause1 - now);
        System.out.println(maxMatrixWithBound1(matrix));
        long pause2 = new Date().getTime();
        System.out.println(pause2 - pause1);
    }

    /**
     * @param matrix
     * @Author: Tod
     * @Date: 2019/9/27
     * @Description: 输入一个只有0和1的方阵，求出其边界全为1的最大子方阵，返回其阶数
     * 输入：
     * {0,1,1,1,1}
     * {0,1,0,0,1}
     * {0,1,0,0,1}
     * {0,1,1,1,1}
     * {0,1,0,1,1}
     * 输出：
     * 4
     * @Implement: N表示矩阵的阶数，k表示最大方阵阶数，i表示行数，j表示列数
     * 寻找最大的k，在行数和列数中只需查找N-k+1次是否符合条件，因为比N-k+1大，说明已经越界
     * 每趟内层循环forj中都是一次顺时针查找，当matrix[r][c]==0时，就可以跳到下一列数检测
     * 时间复杂度：O(n*n*n*n)
     * @Returin: int 返回最大方阵阶数k
     */
    public static int maxMatrixWithBound1(int[][] matrix) {
        int N = matrix.length;
        //  k:阶数
        //  O(N)
        for (int k = N; k > 0; k--) {
            //  O(N)
            for (int i = 0; i < (N - k + 1); i++) {
                l3:
                for (int j = 0; j < (N - k + 1); j++) { //O(N)
                    int r = i;
                    int c = j;  //探测指针
                    while (c < k + j) {  //右    O(N)
                        if (matrix[r][c] == 0) {
                            continue l3;
                        }
                        c++;
                    }
                    c--;    //恢复
                    while (r < k + i) {  //下
                        if (matrix[r][c] == 0) {
                            continue l3;
                        }
                        r++;
                    }
                    r--;
                    while (c > j - 1) {  //左
                        if (matrix[r][c] == 0) {
                            continue l3;
                        }
                        c--;
                    }
                    c++;
                    while (r > i) {    //上
                        if (matrix[r][c] == 0) {
                            continue l3;
                        }
                        r--;
                    }
                    return k;
                }
            }
        }
        return 0;
    }

    /**
     * @param matrix
     * @Author: Tod
     * @Date: 2019/9/27
     * @Description: 输入一个只有0和1的方阵，求出其边界全为1的最大子方阵，返回其阶数
     * 输入：
     * {0,1,1,1,1}
     * {0,1,0,0,1}
     * {0,1,0,0,1}
     * {0,1,1,1,1}
     * {0,1,0,1,1}
     * 输出：
     * 4
     * @Implement: 动态规划思想从底向上打表，记录(右,下)的三维数组进行优化
     * 时间复杂度：O(N*N*N)
     * @Returin: int
     */
    public static int optMaxMatrixWithBound1(int[][] matrix) {
        int N = matrix.length;
        //三维数组打表: helper[0]表示右，helper[1]表示下
        int[][][] helper = new int[N + 1][N + 1][2];
        // O(n*n)
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    // 右
                    helper[i][j][0] = helper[i][j + 1][0] + 1;
                    // 下
                    helper[i][j][1] = helper[i + 1][j][1] + 1;
                }
            }
        }
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(helper[i][j][0]+","+helper[i][j][1]+"\t");
//            }
//            System.out.println();
//        }
        //  O(N)
        for (int k = N; k > 0; k--) {
            //  O(N)
            for (int i = 0; i < (N - k + 1); i++) {
                l3:
                for (int j = 0; j < (N - k + 1); j++) { //O(N)
                    if (helper[i][j][0] >= k && helper[i][j][1] >= k && helper[i][j + k - 1][1] >= k && helper[i + k - 1][j][0] >= k) {    //O(1)
                        return k;
                    } else {
                        continue l3;
                    }
                }
            }
        }
        return 0;
    }
}


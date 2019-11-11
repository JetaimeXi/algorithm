package _04多维数组域矩阵;

/**
 * @Author:Tod
 * @Description: 输入：
 * {1，2，3，4}
 * {5，6，7，8}
 * {9，10，11，12}
 * 输出：
 * {1,2,5,9,6,3,4,7,10,11,8,12}
 * @Date: Create in 23:50 2019/9/26
 * @ModifiedBy:
 */
public class _3Z形打印 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
        };
        printZ(matrix);
    }

    public static void printZ(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int r = 0;
        int c = 0;
        boolean ld2ru = true;
        for (int i = 0; i < row * col; i++) {
            if (ld2ru) {
                System.out.print(matrix[r][c] + "\t");
                //上坡:从左下到右上
                if (r == 0 && c < col - 1) {  //顶部
                    ld2ru = !ld2ru;   //改变方向
                    c++;
                } else if (r > 0 && c == col - 1) {  //右侧
                    ld2ru = !ld2ru;
                    r++;
                } else {
                    r--;
                    c++;
                }
            } else {
                System.out.print(matrix[r][c] + "\t");
                //下坡:从右上到左下
                if (r == row - 1 && c < col - 1) {   //底部
                    ld2ru = !ld2ru;
                    c++;
                } else if (r > 0 && c == 0) { //左侧
                    ld2ru = !ld2ru;
                    r++;
                } else {
                    r++;
                    c--;
                }
            }
        }


    }
}

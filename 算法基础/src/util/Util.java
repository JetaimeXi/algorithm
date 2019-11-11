package util;

import java.util.*;

/**
 * @Author:Tod
 * @Description: 这是一个工具类
 * @Date: Create in 20:59 2019/9/17
 * @ModifiedBy:
 */
public class Util {
    public static void main(String[] args) {

//        int[] arr = {8, 4, 9, 10, 4, 5, 7, 15};
//        swap(arr, 0, 3);
//        System.out.println(Arrays.toString(arr));
//        String str = "abcdefg";
//        System.out.println(stringReverse(str));
//        int i = scannerInt();
//        System.out.println(i);
//        String s = scannerStr();
//        System.out.println(s);
//        sort(arr);
//        print(arr);
//        System.out.println(getMaxOfArr(arr));
//        System.out.println(getMinOfArr(arr));
//        print(randomArr(10, 10));
//        print(randomArr(10));
//        System.out.println(getMidInThreeElement(25, 12, 15));
//        int[] arr1 = randomArrOnce(10, 13, 1);
//        int[] arr2 = randomArr(10, 100);
//        print(arr1);
//        print(arr2);
//        System.out.println(copyArr(arr1, 5, arr2, 2, 6));
//        print(arr1);
//        print(arr2);
//        System.out.println(getDigitOn(1024159, 6));
//        int[][] matrix = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16}
//        };
//        printMatrix(matrix);
//        int[][] A = {
//                {1, 2},
//                {1, -1}
//        };
//        int[][] B = {
//                {1, 2, -3},
//                {-1, 1, 2}
//        };
//        printMatrix(getMatrixMultiply(A, B));
//        System.out.println(add(-8, 4));
//        System.out.println(negtive(-1));
//        System.out.println(subtract(5, 5));
//        System.out.println(getSign(-8));
//        System.out.println(multiply(20, -10));
//        System.out.println(divide(-10, 3));
        System.out.println(factorial(26));
//        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        print(arr);
//        Integer[] intArr = new Integer[]{2, 5, 3, 4, 7};
////        System.out.println(intArr);
//        print(intArr);
////        double[] doubelarr = new double[]{2.2, 0.2, 1.3, 4.5};
////        print(doubelarr);
//        System.out.println(QKpower(2, 7));

    }

    /**
     * @param N
     * @Author: Tod
     * @Date: 2019/10/20
     * @Description: 求阶乘N！
     * @Implement: 大数记录法，倒序模拟乘法，在倒序输出
     * @Return: java.util.List<java.lang.Integer>
     */
    public static List<Integer> factorial(int N) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int carry = 0, sum;
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < list.size(); j++) {
                sum = list.get(j) * i + carry;
                list.set(j, sum % 10);
                carry = sum / 10;
            }
            while (carry > 0) {
                list.add(carry % 10);
                carry /= 10;
            }
        }
        int temp, len = list.size();
        for (int i = 0; i < (len >> 1); i++) {
            temp = list.get(i);
            list.set(i, list.get(len - i - 1));
            list.set(len - i - 1, temp);
        }
        return list;
    }


    /**
     * @param a 加数1
     * @param b 加数2
     * @Author: Tod
     * @Date: 2019/10/10
     * @Description: 用二进制实现加法运算
     * @Implement: 异或运算实现和，与运算实现进位
     * @Returin: int 返回二者的和
     */
    public static int add(int a, int b) {
        int xor, and;
        while (b != 0) {
            xor = a ^ b;
            and = a & b;
            a = xor;
            b = and << 1;
        }
        return a;
    }

    /**
     * @param x 待取反的值
     * @Author: Tod
     * @Date: 2019/10/11
     * @Description: 位运算将x取反
     * @Implement: 将x按位取反，包括符号位 加一
     * @Return: int  返回x取反后的值
     */
    public static int negtive(int x) {
        int negation = ~x;
        return negation + 1;
    }

    /**
     * @param a 被减数
     * @param b 减数
     * @Author: Tod
     * @Date: 2019/10/11
     * @Description: 位运算实现a-b
     * @Implement: a-b = (a-b)补 = (a)补 - (b)补 = (a)补 + (-b)补
     * 将b取反的到-b，在进行加法运算
     * @Return: int  返回a-b的值
     */
    public static int subtract(int a, int b) {
        int neg_b = negtive(b);
        return add(a, neg_b);
    }

    /**
     * @param x
     * @Author: Tod
     * @Date: 2019/10/11
     * @Description: 判断x的正负，正数为0，负数为1
     * @Implement: x右移31位判断
     * @Return: int 返回x符号位
     */
    public static int getSign(int x) {
        return (x >> 31) == 0 ? 0 : 1;
    }

    /**
     * @param a
     * @param b
     * @Author: Tod
     * @Date: 2019/10/11
     * @Description: 二进制实现a*b
     * @Implement: 符号单独处理，将a、b换为正数，a左移增大，b右移减小，当b的末尾为1，说明应该将res += a
     * 算法复杂度为O(logN)
     * @Return: int
     */
    public static int multiply(int a, int b) {
        boolean sign = false;
        if ((getSign(a) ^ getSign(b)) == 1) {
            sign = true;
        }
        if (getSign(a) == 1) {
            a = negtive(a);
        }
        if (getSign(b) == 1) {
            b = negtive(b);
        }
        int res = 0;
        while (b != 0) {
            if ((b & 1) == 1) {
                res = add(res, a);
            }
            a = (a << 1);
            b = (b >> 1);
        }
        if (sign) {
            res = negtive(res);
        }
        return res;
    }

    /**
     * @param dividend 被除数
     * @param divisor  除数
     * @Author: Tod
     * @Date: 2019/10/11
     * @Description: 二进制实现dividend/divisor
     * @Implement: 符号位单独处理，将a、b置为正数，依据二进制除法，跳出循环时，res为商，dividend为余数
     * @Return: int  返回商的值
     */
    public static int divide(int dividend, int divisor) {
        boolean sign = false;
        if ((getSign(dividend) ^ getSign(divisor)) == 1) {
            sign = true;
        }
        if (getSign(dividend) == 1) {
            dividend = negtive(dividend);
        }
        if (getSign(divisor) == 1) {
            divisor = negtive(divisor);
        }
        int res = 0;
        int i = 31;
        while (i >= 0) {
            if ((dividend >> i) >= divisor) {
                res = add(res, (1 << i));
                //  dividend 为余数
                dividend = subtract(dividend, (divisor << i));
            }
            i = subtract(i, 1);
        }
        if (sign) {
            res = negtive(res);
        }
        return res;
    }


    /**
     * @param srcArr     源数组
     * @param src_start  源数组的起始位置
     * @param destArr    目标数组
     * @param dest_start 源数组的起始位置
     * @param length     要复制的长度、个数
     * @Author: Tod
     * @Date: 2019/9/19
     * @Description: 将srcArr从src_start开始复制length个元素到destArr的dest_start的length个元素中去
     * @Implement: 逐个遍历赋值
     * @Returin: boolean 当数组不越界时返回true,否则返回false
     */
    public static boolean copyArr(int[] srcArr, int src_start, int[] destArr, int dest_start, int length) {
        if (srcArr.length < length + src_start || destArr.length < dest_start + length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            destArr[dest_start + i] = srcArr[src_start + i];
        }
        return true;
    }

    /**
     * @param size  数组的大小，整型
     * @param bound 值的范围，[0,bound)
     * @Author: Tod
     * @Date: 2019/9/19
     * @Description: 产生一个规模为size的数组，数的范围介于[0,bound)之间
     * @Implement: 调用Random().nextInt(bound)
     * @Returin: int[]   返回一个数组的引用
     */
    public static int[] randomArr(int size, int bound) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = new Random().nextInt(bound);
        }
        return arr;
    }


    /**
     * @param size 数组的大小，整型
     * @Author: Tod
     * @Date: 2019/9/19
     * @Description: 产生一个规模为size的数组，数的范围介于int范围(有正负)之间
     * @Implement: 调用Random().nextInt()
     * @Returin: int[]   返回一个数组的引用
     */
    public static int[] randomArr(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = new Random().nextInt();
        }
        return arr;
    }

    /**
     * @param size  数组规模及数组元素的个数
     * @param bound 随机值的范围，产生介于[0,bound)的随机值，注意bound>=size
     * @Author: Tod
     * @Date: 2019/9/20
     * @Description: 产生一个规模为size, 随机值只出现一次的数组，
     * 随机值范围介于0~bound之间
     * @Implement: 开辟一个记录数组boolean[]，判断与startNumber的大小
     * @Returin: int[]
     */
    public static int[] randomArrOnce(int size, int bound) {
        boolean[] countArr = new boolean[bound];
        int[] arr = new int[size];
        int count = 0;
        while (count < size) {
            int randNum = new Random().nextInt(bound);
            if (!countArr[randNum]) {
                arr[count] = randNum;
                countArr[randNum] = true;
                count++;
            }
        }
        return arr;
    }

    /**
     * @param size        数组规模及数组元素的个数
     * @param bound       随机值的范围，产生介于[startNumber,bound)的随机值，注意bound>=startNumber+size
     * @param startNumber 随机值>=startNumber
     * @Author: Tod
     * @Date: 2019/9/20
     * @Description: 产生一个规模为size, 随机值只出现一次的数组，
     * 同时数组的范围从startNumber开始，
     * 随机值范围介于startNumber~bound之间
     * @Implement: 开辟一个记录数组boolean[]，判断与startNumber的大小
     * @Returin: int[]  返回{-1}表示bound<startNumber+size
     */
    public static int[] randomArrOnce(int size, int bound, int startNumber) {
        if (bound < startNumber + size) {
            return new int[]{-1};
        }
        boolean[] countArr = new boolean[bound];
        int[] arr = new int[size];
        int count = 0;
        while (count < size) {
            int randNum = new Random().nextInt(bound);
            if ((!countArr[randNum]) && randNum >= startNumber) {
                arr[count] = randNum;
                countArr[randNum] = true;
                count++;
            }
        }
        return arr;
    }


    /**
     * @param arr   待查找最大值及最小值的数组，注意arr.length必须是2的幂(已克服)
     * @param left  左边界，初始化为0
     * @param right 右边界，初始化为arr.length-1
     * @Author: Tod
     * @Date: 2019/9/19
     * @Description: 运用分治法同时求出数组中的最大及最小值 C(n)=2C(n/2)+2
     * @Implement: 侧重于合并的步骤，递归调用最终会出现两种情况(①right-left==1②right==left)，即在出口的设计上
     * ①当right-left==1时，比较二者的大小，一同返回
     * ②当right==left时，将其自身返回
     * 在合并的过程中继续保持最大及最小即可
     * @Returin: int[]  返回[Min, Max]
     */
    public static int[] theMinAndMax(int[] arr, int left, int right) {
        if (right - left == 1) {
            if (arr[left] < arr[right])
                return new int[]{arr[left], arr[right]};
            else
                return new int[]{arr[right], arr[left]};
        } else if (right == left) {
            return new int[]{arr[left], arr[right]};
        } else {
            int mid = left + ((right - left) >> 1);
            int[] arr1 = theMinAndMax(arr, left, mid);
            int[] arr2 = theMinAndMax(arr, mid + 1, right);
            int Min = getMinOfArr(new int[]{arr1[0], arr2[0]});
            int Max = getMaxOfArr(new int[]{arr1[1], arr2[1]});
            return new int[]{Min, Max};
        }
    }

    /**
     * @param arr 整型数组
     * @Author: Tod
     * @Date: 2019/9/19
     * @Description: 获得数组中的最大值
     * @Implement: 遍历数组
     * @Returin: int 返回最大值，非下标
     */
    public static int getMaxOfArr(int[] arr) {
        int Max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > Max) {
                Max = arr[i];
            }
        }
        return Max;
    }

    /**
     * @param arr 整型数组
     * @Author: Tod
     * @Date: 2019/9/19
     * @Description: 获得数组中的最小值
     * @Implement: 遍历数组
     * @Returin: int 返回最小值，非下标
     */
    public static int getMinOfArr(int[] arr) {
        int Min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < Min) {
                Min = arr[i];
            }
        }
        return Min;
    }

    /**
     * @param number
     * @param digit  第digit位, 从1开始算起
     * @Author: Tod
     * @Date: 2019/9/22
     * @Description: 获取number第digit位上的值, 如果digit超过number的最高位则返回0
     * @Implement: front用于取余得到余数，behind用于取商得到digit位的值
     * @Returin: int 如果digit超过number的最高位则返回0
     */
    public static int getDigitOn(int number, int digit) {
        int front = 1;
        int behind = 1;
        for (int i = 0; i < digit; i++) {
            behind = front;
            front = 10 * behind;
        }
        return number % front / behind;
    }

    /**
     * @param A 整型数
     * @param B 整型数
     * @param C 整型数
     * @Author: Tod
     * @Date: 2019/9/19
     * @Description: 获取三个元素中的中间值
     * @Implement: 通过分支语句实现
     * @Returin: int 返回三个元素的中间值
     */
    public static int getMidInThreeElement(int A, int B, int C) {
        if ((C > A && A > B) || (B > A && A > C))
            return A;
        else if ((A > B && B > C) || (C > B && B > A))
            return B;
        else
            return C;
    }


    /**
     * @param arr    整形数组
     * @param source arr[source]
     * @param dest   arr[dest]
     * @Author: Tod
     * @Date: 2019/9/17
     * @Description: 将整形数组arr中的source下标的值与dest下标的值交换
     * @Returin: void
     */
    public static void swap(int[] arr, int source, int dest) {
        if (source == dest) //当传入的source下标与dest下标一致时，arr[source]^arr[dest]导致arr[source] = arr[dest] = 0,最终原值修改为0
            return;
        arr[source] = arr[source] ^ arr[dest];
        arr[dest] = arr[source] ^ arr[dest];
        arr[source] = arr[source] ^ arr[dest];
    }
    public static void swap(char[] chars,int srcIndex, int destIndex){
        char temp = chars[srcIndex];
        chars[srcIndex] = chars[destIndex];
        chars[destIndex] = temp;
    }


    /**
     * @param a
     * @param b
     * @Author: Tod
     * @Date: 2019/10/23
     * @Description: 求a和b的最大公约数
     * @Implement: 辗转相除法
     * @Return: int
     */
    public static int GCD(int a, int b) {
        // 45 12 ->  12 9 -> 9 3 -> 3 0 -> return 3
        // 47 12 -> 12 11 -> 11 1 -> 1 1 -> 1 0 -> return 1
        // 60 120 -> 120 60 -> 60 0 -> return 60
        if (a < b) {   //将a和b中较大的数字放在a中，此条件只会在一开始是判断
            a = a + b;
            b = a - b;
            a = a - b;
        }
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

    /**
     * @param arr 整型数组
     * @Author: Tod
     * @Date: 2019/9/17
     * @Description: 将数组arr输出
     * @Implement: 调用java.util.Arrays中的toString()
     * @Returin: void
     */
    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static void print(char[] chars) {
        for (char c : chars) {
            System.out.print(c + ", ");
        }
        System.out.println();
    }

    /**
     * @param arr 引用类型数组
     * @Author: Tod
     * @Date: 2019/10/20
     * @Description: 打印引用类型数组
     * @Implement: 泛型实现
     * @Return: void
     */
    public static <E> void print(E[] arr) {
        for (E e : arr) {
            System.out.print(e + ", ");
        }
        System.out.println();
    }


    /**
     * @param arr 待排序的整型数组
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 将整型数组原址排序
     * @Implement: 调用Arrays.sort方法
     * @Returin: void
     */
    public static void sort(int[] arr) {
        Arrays.sort(arr);
    }


    /**
     * @param str 待翻转的字符串
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 将字符串翻转并返回String
     * @Implement: 利用StringBuffer.toString()及.reverse()函数
     * @Returin: java.lang.String
     */
    public static String stringReverse(String str) {
        return new StringBuffer(str).reverse().toString();
    }

    /**
     * @param
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 从键盘接收一个整型数并返回
     * @Implement: 调用Scanner.nextInt方法
     * @Returin: int 获取整型数
     */
    public static int scannerInt() {
        return new Scanner(System.in).nextInt();
    }

    /**
     * @param
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 从键盘接收一串字符串并返回
     * @Implement: 调用Scanner.next方法
     * @Returin: java.lang.String 获取字符串
     */
    public static String scannerStr() {
        return new Scanner(System.in).next();
    }

    /**
     * @param arr   整型数组
     * @param left  左边界
     * @param right 右边界
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 这是快速排序的划分函数:一遍单向扫描法
     * @Implement: 以arr[left]作为基准值，从left到right单向扫描，当遇到比基准值大的值，调用swap与bigger交换，同时bigger--,否则sp++,
     * 当sp>bigger时，将基准值与arr[bigger]交换
     * @Returin: int    返回bigger的值
     */
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];      //基准值
        int sp = left + 1;
        int bigger = right;
        while (sp <= bigger) {
            if (arr[sp] <= pivot) {    //小于基准值
                sp++;
            } else {
                swap(arr, sp, bigger);
                bigger--;
            }
        }
        swap(arr, left, bigger);
        return bigger;
    }

    /**
     * @param arr   无序整型数组
     * @param left  左边界，初始化为0
     * @param right 右边界，初始化为arr.length-1
     * @param K     待查找的第K小的值，介于[1...arr.length]之间
     * @Author: Tod
     * @Date: 2019/9/19
     * @Description: 在一个整型数组中，在O(n)时间内找到第K小元素
     * @Implement: 通过快速排序中的划分函数partition进行划分，每次固定好主元的位置，判断now_K与K之间的大小，进行递归
     * 由于K是介于[1...arr.length]，而midIndex是介于[0...arr.length-1]，故now_K=midIndex-left+1
     * 缺点:会修改原址数组的值
     * @Returin: int 返回第K小元素的值
     */
    public static int selectKInArr(int[] arr, int left, int right, int K) {
        int midIndex = partition(arr, left, right);
        int now_K = midIndex - left + 1;
        if (now_K == K) {
            return arr[midIndex];
        } else if (now_K > K) {
            return selectKInArr(arr, left, midIndex - 1, K);
        } else {
            return selectKInArr(arr, midIndex + 1, right, K - now_K);
        }
    }

    /**
     * @param matrix 待打印的二维矩阵
     * @Author: Tod
     * @Date: 2019/9/26
     * @Description: 打印二维矩阵
     * @Implement: 二重循环输出打印
     * @Returin: void
     */
    public static void printMatrix(int[][] matrix) {
        System.out.println("------------------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("------------------");
    }

    /**
     * @param matrixA _*N矩阵
     * @param matrixB N*_矩阵
     * @Author: Tod
     * @Date: 2019/9/28
     * @Description: 求两个矩阵的乘法运算
     * @Implement: 三重循环    O(_*N*_)
     * @Returin: int[][] _*_矩阵
     */
    public static int[][] getMatrixMultiply(int[][] matrixA, int[][] matrixB) {
        int row = matrixA.length;
        int col = matrixB[0].length;
        int[][] Res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < matrixB.length; k++) {
                    Res[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return Res;
    }

    /**
     * @param n
     * @Author: Tod
     * @Date: 2019/10/19
     * @Description: 判断n是否为质数
     * @Implement: 平方根后减低为logn, 每层循环以6倍叠加
     * @Return: boolean
     */
    public static boolean isPrime(int n) {
        // 2*3 = 6  6x 6x+1 6x+2 6x+3 6x+4 6x+5 6(x+1) 6(x+1)+1 ...
        //介于6的倍数的两边可能为质数，其他都不可能为质数
        if (n == 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 6 == 1 || n % 6 == 5) {
            int sqrt_n = (int) (Math.sqrt(n));
            for (int i = 5; i <= sqrt_n; i += 6) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * @param n
     * @Author: Tod
     * @Date: 2019/10/19
     * @Description: 统计小于n的质数的个数
     * @Implement: 运用厄拉多塞筛法及平方根
     * @Return: int
     */
    public static int countPrimes(int n) {
        if (n < 2) return 0;
        int count = 0;
        // 元素设置标记
        boolean[] nums = new boolean[n];
        for (int i = 2; i * i < n; i++) {
            // 用 ! 判断，就不用循环遍历设置数组元素都为ture
            if (!nums[i]) {
                for (int j = i * i; j < n; j += i) {
                    // 判断是为了去重(i=2,j=12; i=3,j=12),提高效率
                    if (nums[j])
                        continue;
                    // 这里递增，可以直接得到非质数的数量
                    count++;
                    // 非质数标记清除
                    nums[j] = true;
                }
            }
        }
        // 排除 其自身(-1) 和 1 ，所以要-2
        return n - count - 2;
    }

    public static int QKpower(int a, int n) {
        /**
        * @param a  底数
         * @param n 阶数
        * @Author: Tod
        * @Date: 2019/10/23
        * @Description: 实现a^n的非递归快速乘方
        * @Implement:   二分法
        * @Return: int
        */
        int ans = 1, temp = a;
        while (n != 0) {
            if (n % 2 == 1) {
                ans = ans * temp;
            }
            temp = temp * temp;
            n /= 2;
        }
        return ans;
    }
}

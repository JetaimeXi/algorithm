package _01位运算的奇巧淫技;

public class _2交换两个整数变量的值 {
    public static void main(String[] args) {
        int A = 10;
        int B = 20;
        System.out.println("A:" + A + " B:" + B);
        System.out.println();
        int[] swap = swap(A, B);
        A = swap[0];
        B = swap[1];
        System.out.println("A:" + A + " B:" + B);
        MyInteger a = new MyInteger(10);
        MyInteger b = new MyInteger(20);
        System.out.println("a.getValue():" + a.getValue() + " b.getValue():" + b.getValue());
        swap(a, b);
        System.out.println("a.getValue():" + a.getValue() + " b.getValue():" + b.getValue());
    }
    /**
     * @创建人: Tod
     * @创建时间: 2019/9/17
     * @描述: 将A与B的值调换，并返回一个数组
     * @返回值: int[]
     * @参数注释:
     * @param A
     * @param B
     */
    public static int[] swap(int A, int B) {
        A = A ^ B;
        B = A ^ B;
        A = A ^ B;
//        System.out.println("A:"+A+" B:"+B);
        return new int[]{A, B};
    }
    /**
     * @创建人: Tod
     * @创建时间: 2019/9/17
     * @描述: 自定义MyInteger类型实现swap函数
     * @返回值: void
     * @参数注释:
     * @param A
     * @param B
     */
    public static void swap(MyInteger A, MyInteger B) {
        A.setValue(A.getValue() ^ B.getValue());
        B.setValue(A.getValue() ^ B.getValue());
        A.setValue(A.getValue() ^ B.getValue());
        System.out.println("A.getValue():" + A.getValue() + " B.getValue():" + B.getValue());
    }
}


class MyInteger {
    private int x;

    public MyInteger(int xInt) {
        x = xInt;
    }

    public int getValue() {
        return x;
    }

    public void setValue(int xInt) {
        x = xInt;
    }

}
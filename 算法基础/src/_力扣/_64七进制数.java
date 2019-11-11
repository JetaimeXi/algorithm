package _力扣;

/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 23:38 2019/10/28
 * @ModifiedBy:
 */
public class _64七进制数 {
    public static void main(String[] args) {
        System.out.println(convertToBase7(23));
        System.out.println(convertToBase7(-8));
    }

    public static String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if (num<0){
            flag=true;
            num = -num;
        }
        while (num != 0) {
            sb.insert(0, num % 7);
            num /= 7;
        }
        if (flag){
            sb.insert(0,"-");
        }
        return sb.toString();
    }
}

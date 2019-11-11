package _力扣;

/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 11:54 2019/10/28
 * @ModifiedBy:
 */
public class _61_1比特与2比特字符 {
    public static void main(String[] args) {
        System.out.println(isOneBitCharacter(new int[]{1, 0, 0}));
        System.out.println(isOneBitCharacter(new int[]{1, 1, 1, 0}));
        System.out.println(isOneBitCharacter(new int[]{1, 1, 1, 0, 0}));
        System.out.println(isOneBitCharacter(new int[]{1, 1, 1, 1, 0, 1, 0}));
    }

    public static boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if (i == bits.length - 2 && bits[i] == 1) {
                return false;
            }
            if (bits[i] == 1) {
                i++;
            }
        }
        return true;
    }

    public boolean isOneBitCharacter2(int[] bits) {
        for (int i = bits.length - 2; i >= 0; i--) {
            if (bits[i] == 0)
                return (bits.length - i) % 2 == 0;
        }
        return (bits.length - 1) % 2 == 0;
    }
}

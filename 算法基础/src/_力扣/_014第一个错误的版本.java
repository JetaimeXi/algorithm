package _力扣;

/**
 * @Author:Tod
 * @Description: 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * @Date: Create in 19:56 2019/10/8
 * @ModifiedBy:
 */
public class _014第一个错误的版本 {
    public static void main(String[] args) {
//        System.out.println(firstBadVersion(1));
//        System.out.println(firstBadVersion(100));
//        System.out.println(firstBadVersion(5));
        System.out.println(firstBadVersion2(2147483647));
//        System.out.println(firstBadVersion2(5));
//        System.out.println(firstBadVersion2(1));
//        System.out.println(firstBadVersion2(3));
    }

    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    public static int firstBadVersion(int n) {
        if (isBadVersion(n) && !isBadVersion(n - 1)) {
            return n;
        }
        while (isBadVersion(n)) {
            n = n >> 1;
        }
        long N = (n + 1) << 1;   //N为左边界
        while (n < N) {
            N = n + ((N - n) >> 1);     //中间值
            if ((int) N >= 0 && !isBadVersion((int) N)) {  //在右侧
                long temp = N;
                N = (long) (n + 1) << 1;
                n = (int) (temp + 1);
            }
        }
        return n;
    }

    public static int firstBadVersion2(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (!isBadVersion(mid)) {    //在右侧
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static boolean isBadVersion(int version) {
//        int n = 1;
//        int n = 2;
//        int n = 9;
        int n = 4;
//        int n = 2147483647;
        if (version >= n) {
            return true;
        } else {
            return false;
        }
    }
}

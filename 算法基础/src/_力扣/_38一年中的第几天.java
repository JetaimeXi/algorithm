package _力扣;

/**
 * @Author:Tod
 * @Description: 给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 * <p>
 * 输入：date = "2019-01-09"
 * 输出：9
 * <p>
 * 输入：date = "2019-02-10"
 * 输出：41
 * <p>
 * 输入：date = "2003-03-01"
 * 输出：60
 * <p>
 * 输入：date = "2004-03-01"
 * 输出：61
 * <p>
 * 提示：
 * date.length == 10
 * date[4] == date[7] == '-'，其他的 date[i] 都是数字。
 * date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日。
 * @Date: Create in 0:11 2019/10/20
 * @ModifiedBy:
 */
public class _38一年中的第几天 {
    public static void main(String[] args) {
        System.out.println(dayOfYear("2004-03-01"));
        System.out.println(dayOfYear("2019-01-09"));
        System.out.println(dayOfYear("2016-02-29"));
    }

    public static int dayOfYear(String date) {
        int[] dates = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        String[] str = date.split("-");
        int year = Integer.parseInt(str[0]);
        int month = Integer.parseInt(str[1]);
        int day = Integer.parseInt(str[2]);
        return dates[month - 1] + day + (isLeapYear(year) && month > 2 ? 1 : 0);
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }
}

package _02查找与排序._001递归;

/**
 * @Author:Tod
 * @Description: 在有空字符串的有序字符串数组中查找某字符串
 * @Date: Create in 14:49 2019/9/18
 * @ModifiedBy:
 */
public class _10有空字符串的有序数组中查找字符串 {
    public static void main(String[] args) {
        String[] arr = {"a","","ac","","ad","b","","ba"};
        System.out.println(indexOfStringArr(arr,0,arr.length-1,"a"));
    }

    /**
     * @param arr   有序的字符串数组
     * @param left  左边界，初始为0
     * @param right 右边界，初始为arr.length-1
     * @param p     待查找的字符串
     * @Author: Tod
     * @Date: 2019/9/18
     * @Description: 在有空字符串的有序字符串数组中查找某字符串，如{"a","","ac","","ad","b","","ba"}查找"ac"
     * @Implement: 改造二分查找算法，利用String中的compareTo及equals函数来比较及判断空字符串
     * @Returin: int    将查找到的字符串在字符串数组的下标返回，如果不存在则返回-1
     */
    public static int indexOfStringArr(String[] arr, int left, int right, String p) {

        while (left <= right) {
            int midIndex = left + ((right - left) >> 1);
            if (arr[midIndex].equals("")) {
                midIndex++;
            }
            if (arr[midIndex].compareTo(p) > 0) {  //在左侧
                return indexOfStringArr(arr, left, midIndex - 1, p);
            } else if (arr[midIndex].compareTo(p) < 0) { //在右侧
                return indexOfStringArr(arr, midIndex + 1, right, p);
            }
            else{
                return midIndex;
            }
        }
        return -1;
    }
}

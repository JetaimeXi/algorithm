//package _力扣竞赛;
//
//import java.util.List;
//
///**
// * @Author:Tod
// * @Description:
// *
//给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
//请返回所有可行解 s 中最长长度。
//示例 1：
//输入：arr = ["un","iq","ue"]
//输出：4
//解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
//示例 2：
//输入：arr = ["cha","r","act","ers"]
//输出：6
//解释：可能的解答有 "chaers" 和 "acters"。
//示例 3：
//输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
//输出：26
//提示：
//1 <= arr.length <= 16
//1 <= arr[i].length <= 26
//arr[i] 中只含有小写英文字母
// * @Date: Create in 11:39 2019/10/27
// * @ModifiedBy:
// */
//public class _5240串联字符串的最大长度 {
//    public static void main(String[] args) {
//
//    }
//    public static int maxLength(List<String> arr) {
//
////        int n = getDiffChar(str);
//        int gap = 0;
//        for (int i = 0; i < arr.size(); i++) {
//            String s = arr.get(i);
//            for (int j = i+gap; j < arr.size(); j+=gap) {
//                s = arr.get(j);
//            }
//            gap++;
//        }
//    }
//    private static boolean isDiffChar(String s){
//        char[] chars = s.toCharArray();
//        int n = 0;
//        int[] count = new int[26];
//        for (int i = 0; i < chars.length; i++) {
//            count[chars[i]-'a']++;
//        }
//        for (int i : count) {
//            if (i>1){
//                return false;
//            }
//        }
//        return true;
//    }
//}

package _力扣;

import java.util.Stack;

/**
 * @Author:Tod
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，
 * 判断字符串是否有效。
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 * @Date: Create in 8:20 2019/10/3
 * @ModifiedBy:
 */
public class _01有效的括号 {
    public static void main(String[] args) {
        System.out.println(isValid("]"));
//        System.out.println(isValid("){"));
//        System.out.println(isValid("[])"));
    }
    public static boolean isValid(String s) {
//        if (s.length()<2||s.charAt(0)==')'||s.charAt(0)=='}'||s.charAt(0)==']'){
//            return false;
//        }
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
           if (ch[i]=='('||ch[i]=='{'||ch[i]=='['){
               stack.push(ch[i]);
           }else {
               if (stack.empty()){
                   return false;
               }
               char temp = stack.peek();
               if ((ch[i]==')'&&temp=='(') || (ch[i]=='}'&&temp=='{') || (ch[i]==']'&&temp=='[')){
                   stack.pop();
               }else {
                   return false;
               }
           }
        }
        if (stack.empty()){
            return true;
        }
        return false;
    }
}

package _力扣;

import java.util.ArrayList;

/**
 * @Author:Tod
 * @Description: 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @Date: Create in 15:23 2019/10/9
 * @ModifiedBy:
 */
public class _17两数相加 {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(5);
        ListNode l1 = new ListNode(0);
//        ListNode l2 = new ListNode(5);
        ListNode l2 = new ListNode(0);
        int[] l1_list = new int[]{0};
        int[] l2_list = new int[]{7, 3};
        ListNode ptr = l2;
        for (int i = 0; i < l2_list.length; i++) {
            ListNode temp = new ListNode(l2_list[i]);
            ptr.next = temp;
            ptr = ptr.next;
        }
        ptr = l1;
        for (int i = 0; i < l1_list.length; i++) {
            ListNode temp = new ListNode(l1_list[i]);
            ptr.next = temp;
            ptr = ptr.next;
        }
        ListNode ln = addTwoNumbers(l1.next, l2.next);

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> arrList1 = new ArrayList<Integer>();
        ArrayList<Integer> arrList2 = new ArrayList<Integer>();
        ListNode ln = new ListNode(0);
        ListNode ptr = ln;
        while (l1 != null) {
            arrList1.add((Integer) l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            arrList2.add((Integer) l2.val);
            l2 = l2.next;
        }
        int len1 = arrList1.size(), len2 = arrList2.size(), sum;
        if (len1 < len2) {   //将长的放在l1
            ArrayList<Integer> temp = new ArrayList<Integer>(arrList1);
            arrList1 = arrList2;
            arrList2 = temp;
            len1 = arrList1.size();
            len2 = arrList2.size();
        }
        boolean sign = false;
        int i = 0;
        while (i < len1) {   //l2先走完
            if (i < len2) {
                sum = arrList1.get(i) + arrList2.get(i);
            } else {
                sum = arrList1.get(i);
            }
            if (sign) {
                sum++;
            }
            if (sum >= 10) {
                sign = true;
                sum -= 10;
            } else {
                sign = false;
            }
            ListNode ln_new = new ListNode(sum);
            ptr.next = ln_new;
            ptr = ptr.next;
            i++;
        }
        if (sign) {
            ListNode ln_new = new ListNode(1);
            ptr.next = ln_new;
            ptr = ptr.next;
        }
        return ln.next;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        int temp = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int val = val1 + val2 + temp;
            temp = val / 10;
            val = val % 10;
            result.next = new ListNode(val);
            result = result.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (temp > 0) {
            result.next = new ListNode(temp);
        }
        return head.next;
    }
}

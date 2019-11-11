package _力扣;

/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 23:02 2019/10/3
 * @ModifiedBy:
 */
public class _02合并两个有序链表 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0);
        ListNode cur = list;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if (l1==null){
            cur.next=l1;
        }else {
            cur.next=l2;
        }
        return list.next;
    }
}

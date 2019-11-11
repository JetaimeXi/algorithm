package _力扣;

/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 16:37 2019/10/17
 * @ModifiedBy:
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static ListNode makeListNode(int[] arr, int pos) {
        ListNode head = new ListNode(arr[0]);
        ListNode ptr = head;
        for (int i = 1; i < arr.length; i++) {
            ptr.next = new ListNode(arr[i]);
            ptr = ptr.next;
        }
        if (pos != -1) {
            ListNode p = head;
            for (int i = 0; i < pos; i++) {
                p = p.next;
            }
            ptr.next = p;
        }
        return head;
    }
}

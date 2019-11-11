package _力扣;


/**
 * @Author:Tod
 * @Description: 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * @Date: Create in 16:35 2019/10/17
 * @ModifiedBy:
 */
public class _29环形链表 {
    public static void main(String[] args) {
//        ListNode list = ListNode.makeListNode(new int[]{3,2,0,-4},1);
//        ListNode list = ListNode.makeListNode(new int[]{1, 2}, 0);
        ListNode list = ListNode.makeListNode(new int[]{1, 2}, -1);
        System.out.println(hasCycle(list));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            slow = slow.next;
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            fast = fast.next.next;
        }
        return true;
    }

    public static boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {

                return true;
            }
        }
        return false;
    }
}

package _力扣;

/**
 * @Author:Tod
 * @Description: 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 * @Date: Create in 17:13 2019/10/17
 * @ModifiedBy:
 */
public class _30环形链表II {
    public static void main(String[] args) {
//        ListNode list = ListNode.makeListNode(new int[]{3, 2, 0, -4}, 1);
        ListNode list = ListNode.makeListNode(new int[]{1,2}, 0);
        ListNode.printListNode(detectCycle(list));
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return new ListNode(ptr.val);
            }
        }
        return null;
    }
}

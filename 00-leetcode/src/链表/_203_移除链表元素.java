package 链表;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class _203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {

        if (head == null) return null;

        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode pre = tmp;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            }else {
                pre = pre.next;
            }
        }
        return tmp.next;
    }
}

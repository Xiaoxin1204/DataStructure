package 链表算法题练习;


/**
 * :给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class _删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 哑结点，哑结点用来简化某些极端情况，例如列表中只含有一个结点，或需要删除列表的头部
        ListNode dummy = new ListNode(0);
        // 哑结点指向头结点
        dummy.next = head;
        // 保存链表长度
        int length = 0;
        ListNode len = head;
        while (len != null) {
            length++;
            len = len.next;
        }
        length = length - n;
        ListNode target = dummy;
        // 找到 L-n 位置的节点
        while (length > 0) {
            target = target.next;
            length--;
        }
        // 把第 (L - n)个结点的 next 指针重新链接至第 (L - n + 2)个结点
        target.next = target.next.next;
        return dummy.next;
    }
}


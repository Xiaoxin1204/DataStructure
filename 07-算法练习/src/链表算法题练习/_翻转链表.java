package 链表算法题练习;


public class _翻转链表 {
     class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * :输入一个链表，反转链表后，输出链表的所有元素。
     * @param head
     * @return
     */

    public ListNode ReverseList(ListNode head) {

        ListNode next = null;
        ListNode pre = null;

        while (head != null) {
            // 保存要反转到头的那个节点
            next = head.next;
            // 要反转的那个节点指向已经反转的上一个节点(备注:第一次反转的时候会指向null)
            head.next = pre;
            // 上一个已经反转到头部的节点
            pre = head;
            // 一直向链表尾走
            head = next;
        }
        return pre;
    }

}



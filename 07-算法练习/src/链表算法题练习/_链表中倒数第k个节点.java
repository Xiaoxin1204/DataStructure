package 链表算法题练习;


public class _链表中倒数第k个节点 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode FindKthToTail(ListNode head, int k) {
        // 如果链表为空或者k小于等于0
        if (head == null || k <= 0) {
            return null;
        }
        // 声明两个指向头结点的节点
        ListNode node1 = head, node2 = head;
        // 记录节点的个数
        int count = 0;
        // 记录k值，后面要使用
        int index = k;
        // p指针先跑，并且记录节点数，当node1节点跑了k-1个节点后，node2节点开始跑，
        // 当node1节点跑到最后时，node2节点所指的节点就是倒数第k个节点
        while (node1 != null) {
            node1 = node1.next;
            count++;
            if (k < 1) {
                node2 = node2.next;
            }
            k--;
        }
        // 如果节点个数小于所求的倒数第k个节点，则返回空
        if (count < index)
            return null;
        return node2;

    }
}

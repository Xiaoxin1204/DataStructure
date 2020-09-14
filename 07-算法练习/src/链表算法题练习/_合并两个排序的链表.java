package 链表算法题练习;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 我们可以这样分析:
 * <p>
 * 假设我们有两个链表 A,B；
 * A的头节点A1的值与B的头结点B1的值比较，假设A1小，则A1为头节点；
 * A2再和B1比较，假设B1小,则，A1指向B1；
 * A2再和B2比较 就这样循环往复就行了，应该还算好理解。
 * 考虑通过递归的方式实现！
 */
public class _合并两个排序的链表 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }
}

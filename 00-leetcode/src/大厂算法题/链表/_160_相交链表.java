package 大厂算法题.链表;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @author rnang0
 * @date 2020/9/10
 **/
public class _160_相交链表 {

    /**
     * 将两个链表通分处理，则尾部就会相交
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode curA = headA;
        ListNode curB = headB;
        // 到尾后，拼接到一起
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
}

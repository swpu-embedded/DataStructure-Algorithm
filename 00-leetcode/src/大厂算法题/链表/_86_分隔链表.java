package 大厂算法题.链表;

/**
 * https://leetcode-cn.com/problems/partition-list/
 * @author rnang0
 * @date 2020/9/10
 **/
public class _86_分隔链表 {

    /**
     * 使用双指针来串起两个链表，一个链表都小于x，一个链表都大于x
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode leftHead = new ListNode(0);
        ListNode leftTail = leftHead;

        ListNode rightHead = new ListNode(0);
        ListNode rightTail = rightHead;

        while (head != null) {
            if (head.val < x) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        leftTail.next = rightHead.next;
        rightTail.next = null;
        return leftHead.next;
    }
}

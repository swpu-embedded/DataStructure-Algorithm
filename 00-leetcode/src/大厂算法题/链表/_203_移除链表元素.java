package 大厂算法题.链表;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @author rnang0
 * @date 2020/9/9
 **/
public class _203_移除链表元素 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 虚拟头结点，head作为遍历节点
        ListNode newHead = new ListNode(0);
        // 新链表的最后一个节点
        ListNode newTail = newHead;

        while (head != null) {
            if (head.val != val) {
               newTail.next = head;
               newTail = head;
            }
            head = head.next;
        }

        // 让最后指向null
        newTail.next = null;
        return newHead.next;
    }
}

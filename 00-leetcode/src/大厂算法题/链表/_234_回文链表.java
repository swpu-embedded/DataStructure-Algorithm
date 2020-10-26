package 大厂算法题.链表;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * @author rnang0
 * @date 2020/9/10
 **/
public class _234_回文链表 {

    /**
     * 由于链表无索引，无法头尾一起遍历
     * 则可以从 中间节点 开始 反转链表，比较左右链表，相等则为回文链表
     * 由于是对称性质，也可以考虑使用栈来解决
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode leftHead = head;
        // 1.求中间节点
        ListNode midNode = midList(head);
        // 2.反转后边的链表，判断值是否相等
        ListNode rightHead = reverseList(midNode.next);

        while (rightHead != null) {
            if (rightHead.val != leftHead.val) {
                return false;
            }
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }
        return true;
    }

    /**
     * 求链表的中间节点
     * @param head
     * @return
     */
    private ListNode midList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}

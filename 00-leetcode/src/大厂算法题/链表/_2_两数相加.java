package 大厂算法题.链表;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @author rnang0
 * @date 2020/9/10
 **/
public class _2_两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;

        // 进位标志
        int carry = 0;
        while (l1 != null || l2 != null) {
            // 空指针异常
//            int v1 = l1 == null ? 0 : l1.val;
//            int v2 = l2 == null ? 0 : l2.val;
//            l1 = l1.next;
//            l2 = l2.next;
            int v1 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }

            int v2 = 0;
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }

            int sum = v1 + v2 + carry;
            carry = sum / 10;

            // 新建节点存储sum % 10
            newTail.next = new ListNode(sum % 10);
            newTail = newTail.next;
        }
        // 如果加超了
        if (carry != 0) {
            newTail.next = new ListNode(carry);
            newTail = newTail.next;
        }
        return newHead.next;
    }
}

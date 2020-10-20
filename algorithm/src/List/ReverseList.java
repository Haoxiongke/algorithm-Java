package List;

import util.ListNode;

/**
 * 反转链表
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(8);
        head.next.next = new ListNode(7);
        ListNode reverseHead = reverseList(head);
        while (reverseHead != null) {
            System.out.println(reverseHead.val);
            reverseHead = reverseHead.next;
        }
    }

    /**
     * 利用pre，next指针进行链表的反转
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null, next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 利用递归实现链表的反转（思想假设reverseList已经实现了链表的反转，并且返回除head外的新链表头。将返回新链表的尾部指向head）
     *
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newNode = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

}

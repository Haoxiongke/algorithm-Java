package LeetCode;

import util.ListNode;

/**
 * L021_mergeTwoLists
 *
 * @author kehaoxiong
 * @date 2020/11/18
 */
public class L21_mergeTwoLists {
    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(head1, head2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    // 创建一个新的链头，一个个的去防止元素
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode dummyNode = new ListNode();
        ListNode cur = dummyNode;
        while (l1 != null && l2 != null)
            if (l1.val <= l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }

        if (l1 != null)
            cur.next = l1;
        if (l2 != null)
            cur.next = l2;

        return dummyNode.next;
    }

    // 利用递归解决  把mergeTwoLists2当作一个黑盒，返回两个链表合并的链表头
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val <= l2.val){
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}

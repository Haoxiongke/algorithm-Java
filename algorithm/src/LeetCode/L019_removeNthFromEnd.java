package LeetCode;

import util.ListNode;

/**
 * L019_removeNthFromEnd
 *
 * @author kehaoxiong
 * @date 2020/11/18
 */
public class L019_removeNthFromEnd {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = removeNthFromEnd(head, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 利用哨兵节点，也就是创建一个空节点
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        // 创建快慢指针
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;

        // 快指针跳过间隔为n的节点
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // 同时移动快慢指针，当快指针为空，说明慢指针的下一个节点为要删除的元素
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummyHead.next;

    }
}

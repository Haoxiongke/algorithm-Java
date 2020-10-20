package CodingInterviews;

import util.ListNode;

import java.util.Stack;

public class JZ36 {

    public static void main(String[] args) {

        ListNode nodeCom = new ListNode(4);
        nodeCom.next = new ListNode(5);
        nodeCom.next.next = new ListNode(6);

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
//        head1.next.next.next = nodeCom;

        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(3);
//        head2.next.next.next.next = nodeCom;

        ListNode listNode = FindFirstCommonNode1(head1, head2);
        System.out.println(listNode.val);


    }

    /**
     * 通过栈保存两个链表的节点，然后依次出栈，找到不同的点，前一个即为共同点
     *
     * @param pHead1 链表一
     * @param pHead2 链表二
     * @return 公共节点
     */
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null)
            return null;

        Stack<ListNode> nodes1 = new Stack<>();
        Stack<ListNode> nodes2 = new Stack<>();

        while (pHead1 != null) {
            nodes1.push(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null) {
            nodes2.push(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode nodeCom = null;

        while (!nodes1.empty() && !nodes2.empty()) {
            if (nodes1.peek() != nodes2.peek()) {
                break;
            }
            nodeCom = nodes1.peek();
            nodes1.pop();
            nodes2.pop();
        }

        return nodeCom;
    }

    /**
     * 通过遍历两次链表，找到公共节点。当两条链表没有公共节点，就是null，在程序里面也可以直接返回null
     *
     * @param pHead1 链表一
     * @param pHead2 链表二
     * @return 公共节点
     */
    public static ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;

            if (p1 != p2) {  // 加上过滤条件，当两个链表没有交点，防止无限死循环
                if (p1 == null)
                    p1 = pHead2;
                if (p2 == null)
                    p2 = pHead1;
            }
        }

        return p1;

    }
}

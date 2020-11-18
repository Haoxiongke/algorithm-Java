package LeetCode;

import util.ListNode;

import java.util.HashSet;

/**
 * L141_hasCycle
 *
 * @author kehaoxiong
 * @date 2020/11/18
 */
public class L141_hasCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;

        System.out.println(hasCycle2(head));
    }

    // 利用快慢指针
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    // 利用集合
    public static boolean hasCycle2(ListNode head) {

        HashSet<ListNode> nodes = new HashSet<>();
        while (head != null){
            if (nodes.contains(head))
                return true;
            nodes.add(head);
            head = head.next;
        }
        return false;
    }
}

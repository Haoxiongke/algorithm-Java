package LeetCode;

import util.ListNode;

public class L002_addTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);
//        l1.next.next = new util.ListNode(3);
        ListNode l2 = new ListNode(1);
//        l2.next = new util.ListNode(9);
//        l2.next.next = new util.ListNode(4);
        ListNode listNode = addTwoNumbers1(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode currNode = new ListNode(0);
        ListNode initHead = currNode;
        int div_num = 0;
        int sum;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + div_num;
            div_num = sum / 10;
            int remainder_num = sum % 10;
            currNode.next = new ListNode(remainder_num);
            currNode = currNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = div_num + l1.val;
            div_num = sum / 10;
            currNode.next = new ListNode(sum % 10);
            currNode = currNode.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            sum = div_num + l2.val;
            div_num = sum / 10;
            currNode.next = new ListNode(sum % 10);
            currNode = currNode.next;
            l2 = l2.next;
        }

        if (div_num != 0)
            currNode.next = new ListNode(div_num);

        return initHead.next;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode(0);
        ListNode head = curr;
        int div = 0, sum = 0;
        int remainder = 0;
        int l1Val = 0, l2Val = 0;

        // 利用｜｜判断，然后在方法里面对l1,l2进行判断，可以避免对l1、l2单独处理
        while (l1 != null || l2 != null) {
            l1Val = (l1 != null) ? l1.val : 0;
            l2Val = (l2 != null) ? l2.val : 0;
            sum = l1Val + l2Val + div;
            div = sum / 10;
            remainder = sum % 10;
            curr.next = new ListNode(remainder);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (div > 0)
            curr.next = new ListNode(remainder);


        return head.next;
    }
}



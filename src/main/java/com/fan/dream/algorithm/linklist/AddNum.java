package com.fan.dream.algorithm.linklist;

public class AddNum {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        AddNum an = new AddNum();
        String s = "2323";
        an.addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, pre = null;
        int jinwei = 0;
        while (l1 != null && l2 != null) {
            int temp = l1.val + l2.val + jinwei;
            jinwei = 0;
            if (temp >= 10) {
                jinwei = 1;
                temp = temp % 10;
            }
            ListNode node = new ListNode(temp);

            if (head == null) {
                head = node;
                pre = node;
            }
            if (pre != null) {
                pre.next = node;
                pre = node;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode suffix = l1 == null ? l2 : l1;
        while (suffix != null) {
            int temp = suffix.val + jinwei;
            jinwei = 0;
            if (temp >= 10) {
                jinwei = 1;
                temp = temp % 10;
            }
            ListNode node = new ListNode(temp);
            pre.next = node;
            pre = node;
            suffix = suffix.next;
        }
        if (jinwei == 1) {
            ListNode node = new ListNode(1);
            pre.next = node;
        }
        return head;
    }
}

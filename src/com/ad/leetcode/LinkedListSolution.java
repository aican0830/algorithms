package com.ad.leetcode;

public class LinkedListSolution {

    /**
     * 19. 删除链表的倒数第 N 个结点
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn2925/
     * @param head
     * @param n
     * @return ListNode
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        if (head == null) {
            return pre;
        }

        //声明快慢指针
        pre.next = head;
        ListNode slow = pre;
        ListNode fast = pre;

        //使快指针先移动n个位置
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        //这时候快慢指针开始一起移动，当快指针结束则找到要删除的结点
        while(fast.next != null) {

            fast = fast.next;
            slow = slow.next;
        }

        //直接把当前结点的next指向下一个结点，即为删除n位置的结点
        slow.next = slow.next.next;
        return pre.next;
    }

    /**
     * 21. 合并两个有序链表
     * https://leetcode-cn.com/problems/merge-two-sorted-lists/
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        return null;
    }


    /**
     * 传入头结点打印链表
     *
     * @param head
     * @return String
     */
    public String printer(ListNode head) {

        if (head == null) return null;

        StringBuilder s = new StringBuilder();
        ListNode node = head;

        s.append("[");
        while(node != null) {

            s.append(node.val + " ---> ");
            node = node.next;
        }

        s.append("null");
        s.append("]");

        return s.toString();
    }
}

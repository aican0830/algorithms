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

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next =mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代方法解决
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;

        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return preHead.next;
    }

    /**
     * 203. 移除链表元素
     * https://leetcode-cn.com/problems/remove-linked-list-elements/
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {

        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode cur = preHead;

        while(cur.next != null) {

            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return preHead.next;
    }


    /**
     * 206. 反转链表
     * https://leetcode-cn.com/problems/reverse-linked-list/
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
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

        String res = s.toString();
        System.out.println(""+res);
        return res;
    }
}

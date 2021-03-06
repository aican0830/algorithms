package src.com.ad.linkedlist;

import java.util.*;

public class LinkedListSolution {

    /**
     * 2. 两数相加
     * https://leetcode-cn.com/problems/add-two-numbers/
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode head = null, tail = null;

        while (l1 != null || l2 != null) {
            int n = l1 != null ? l1.val : 0;
            int m = l2 != null ? l2.val :0;
            int sum = n+m+carry;

            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0)  {
            tail.next = new ListNode(carry);
        }

        return head;
    }

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
     * 61. 旋转链表
     * https://leetcode-cn.com/problems/rotate-list/
     * 题解： 先将链表转成环形，在找位置
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {

        // 移动0个位置，空链表，或只有一个元素，直接返回
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        //计算链表长度
        ListNode cur = head;
        int n = 1;
        while(cur.next != null) {
            cur = cur.next;
            n++;
        }
        //计算移动多少个元素(n-1) - (k % n)
        int mov = n - k % n;
        //如果移动长度等于n，返回原链表
        if (mov == n) return head;

        //设置链表为环形
        cur.next = head;

        while(mov-- > 0) {
            cur = cur.next;
        }

        //找到了断开的位置，设置新链表
        ListNode ret = cur.next;

        //断开链表
        cur.next = null;

        return ret;
    }

    /**
     * 83. 删除排序链表中的重复元素
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
     * 题解： 链表是排好序的，重复的元素在链表中是相邻的。判断当前节点是否和下一个节点相等则为重复，让当前节点跳过下一个节点往后走
     *
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) return head;
        ListNode cur = head;

        while(cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    /**
     * 86. 分割链表
     * https://leetcode-cn.com/problems/partition-list/
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {

        ListNode small = new ListNode(-1), large = new ListNode(-1);
        ListNode smallHead = small, largeHead = large;

        while(head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;

        return smallHead.next;
    }

    /**
     * 142.环形链表 II
     * https://leetcode-cn.com/problems/linked-list-cycle-ii/
     * 哈希表解法
     * 类似解法题目：217. 存在重复元素
     * 题解：类似数组[1,2,3,1], 在链表中，数组的第五个值，可以理解为，3的下一个指针是1 [1->2->3->1]
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        HashSet<ListNode> hashSet = new HashSet<>();
        while(head != null) {

            if (hashSet.contains(head)) {
                return head;
            }
            hashSet.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     * 解法2，使用快慢指针
     *
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {

        return null;
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

    /**
     * 234. 回文链表
     * https://leetcode-cn.com/problems/palindrome-linked-list/
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        if (head == null) return false;
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        int l = 0;
        int r = list.size()-1;
        while(l < r) {
            if (list.get(l).val != list.get(r).val) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    /**
     * 237. 删除链表中的节点
     * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 328. 奇偶链表
     * https://leetcode-cn.com/problems/odd-even-linked-list/
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {

       if (head == null) return head;
       //保存偶数
        ListNode evenHead = head.next;
        ListNode odd =  head; //指向奇数节点
        ListNode even = evenHead; //指向偶数节点

        while (even != null && even.next != null) {
            odd.next = even.next; // 奇数节点指向偶数的下一个
            odd = odd.next;  // odd 变成even 下一个节点
            even.next = odd.next; // 偶数节点指向奇数的下一个
            even = even.next; // even 变成odd 下一个节点
        }

        odd.next = evenHead;
        return head;
    }
}

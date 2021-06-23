package com.ad.test;

import com.ad.leetcode.LinkedListSolution;
import com.ad.leetcode.ListNode;

public class Main {
    public static void main(String[] args) {


        LinkedListSolution linkedList = new LinkedListSolution();

        ListNode  five = new ListNode(5, null);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode second = new ListNode(2, three);
        ListNode first = new ListNode(1, second);
        ListNode result = linkedList.removeNthFromEnd(first, 2);

        String output = linkedList.printer(result);
        System.out.printf(output);
    }
}

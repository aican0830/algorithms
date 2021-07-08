package com.ad.leetcode;

import java.util.List;

public class TreeTestMain {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9, null, null);
        root.right = new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null));


        TreeSolution ts = new TreeSolution();
        List<List<Integer>> res = ts.levelOrderBottom(root);
        int i = 0;
        for (List<Integer> r : res) {

            System.err.println("" + r.get(i));
        }

    }
}

package com.ad.leetcode;

import java.util.*;

public class LC77 {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {

        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (begin > n-k+1) return;

        dfs(n, k, begin+1, path, res);
        path.addLast(begin);
        dfs(n, k-1, begin+1, path, res);
        path.removeLast();
    }

    public int nxn(int n) {
        if (n <= 1)
            return 1;
        else
            return n * nxn(n - 1);
    }

    public static void main(String[] args) {

        List<List<Integer>> integers = new LC77().combine(3, 3);
        System.out.println(integers);
        //System.out.println(new LC77().nxn(3));
    }


}

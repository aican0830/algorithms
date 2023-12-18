package com.ad.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC78 {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) return ans;
        dfs(ans, nums, new ArrayList<Integer>(), 0);
        return ans;
    }

    protected void dfs(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {
        //terminator
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        dfs(ans, nums, list, index + 1);
        list.add(nums[index]);
        dfs(ans, nums, list, index + 1);
        //reverse state
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {

        System.out.println(new LC78().subsets(new int[]{1,2,3,4}));
    }
}

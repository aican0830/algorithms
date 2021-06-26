package com.ad.arraylist;

import java.util.List;

public class TestMain {

    public static void main(String[] args) {

        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        ArrayListSolution solution = new ArrayListSolution();
        List<Integer> ans = solution.findDisappearedNumbers(nums);

        for (int i = 0; i < ans.size(); i++) {

            System.out.printf("" + ans.get(i));
        }
    }
}

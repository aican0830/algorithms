package com.ad.arraylist;

import com.ad.utils.PrintUtils;

import java.util.List;

public class TestMain {

    public static void main(String[] args) {

        int[][] nums = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        ArrayListSolution solution = new ArrayListSolution();

        int[] prices = new int[]{7,6,4,3,1};

        int profit = solution.maxProfit(prices);

        System.out.printf(""+ profit);

//        boolean res = solution.searchMatrix(nums, 100);
//        System.out.printf("" + res);
    }
}

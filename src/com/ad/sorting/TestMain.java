package com.ad.sorting;

import com.ad.utils.PrintUtils;

import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) {

        int[] nums = new int[]{4,1,2,3};


//        MergeSort mergeSort = new MergeSort();
//        mergeSort.sort(nums);

        Sorts s = new Sorts();
        s.quickSort(nums);

        String res = PrintUtils.printArray(nums);
        System.out.printf("" + res);
    }
}
